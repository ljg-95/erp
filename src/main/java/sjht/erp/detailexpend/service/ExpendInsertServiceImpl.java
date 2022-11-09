package sjht.erp.detailexpend.service;

import org.codehaus.groovy.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sjht.erp.detailexpend.dto.request.*;
import sjht.erp.detailexpend.dto.response.DetailResponseDto;
import sjht.erp.detailexpend.dto.response.FileResponseDto;
import sjht.erp.detailexpend.dto.response.MyExpendListResponseDto;
import sjht.erp.detailexpend.repository.ExpendInsertMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class ExpendInsertServiceImpl implements ExpendInsertService {
    @Autowired
    ExpendInsertMapper expendInsertMapper;

    public String makeDVNO() {
        String thisYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        String year = thisYear.substring(2, 4);
        int i = 1;
        String dvno = "S" + year + "-" + i;
        if (!expendInsertMapper.selectAll().isEmpty()) {
            String[] str = expendInsertMapper.selectLastOne().split("-", 2);
            i = Integer.parseInt(str[1]) + 1;
            dvno = "S" + year + "-" + i;
        }
        return dvno;
    }

    @Transactional
    @Override
    public String inputExpend() {
        String dvno = makeDVNO();
        if (expendInsertMapper.insertDvno(dvno) != 0) {
            return dvno;
        }
        return null;
    }

    @Override
    public List<DetailResponseDto> selectDetailExpend(String dvno) {
        List<DetailResponseDto> detailResponseDtoList = expendInsertMapper.selectDetailExpend(dvno);
        if (!detailResponseDtoList.isEmpty()) {
            return detailResponseDtoList;
        }
        return null;
    }

    @Transactional
    @Override
    public boolean updateExpend(int empno, String dvno) {
        UpdateRequestDto updateRequestDto = new UpdateRequestDto();
        SelectEmployeeDto selectEmployeeDto = expendInsertMapper.selectOneEmployee(empno);
        List<DetailResponseDto> detailResponseDtoList = expendInsertMapper.selectDetailExpend(dvno);
        int dvamt = 0;
        boolean isUpdate = false;
        if (!detailResponseDtoList.isEmpty()) {
            for (DetailResponseDto requestDto : detailResponseDtoList) {
                dvamt += requestDto.getPrice();
            }
            updateRequestDto.setDvamt(dvamt);
            updateRequestDto.setEmpno(selectEmployeeDto.getEmpno());
            updateRequestDto.setDepartmentcd(selectEmployeeDto.getDepartmentcd());
            updateRequestDto.setDvregdate(LocalDate.now());
            updateRequestDto.setDvno(dvno);
            isUpdate = expendInsertMapper.updateExpendInformation(updateRequestDto) != 0;
        }
        return isUpdate;
    }

    @Transactional
    @Override
    public boolean deleteDetailData(String dvno) {
        return expendInsertMapper.deleteDetailExpend(dvno) != 0;
    }

    @Override
    public boolean deleteData(String dvno) {
        return expendInsertMapper.deleteExpendInformation(dvno) != 0;
    }

    @Override
    public String getDepartment(int empno) {
        String departmentcd = expendInsertMapper.selectOneEmployee(empno).getDepartmentcd();
        return expendInsertMapper.selectOneDepartmentName(departmentcd);
    }

    public List<MyExpendListResponseDto> selectExpendInfo(int empno) {

        return expendInsertMapper.findExpendInformationsByEmpnoAndApproveryn(empno);
    }

    @Override
    @Transactional
    public boolean deleteOneData(int dno) {
        return expendInsertMapper.deleteDetailExpendInteger(dno) != 0;
    }

    @Override
    public DetailResponseDto chooseDetailExpend(int dno) {
        return expendInsertMapper.selectMyDetailExpend(dno);
    }

    @Override
    public boolean updateMyDetailExpend(UpdateMyDetailExpendRequestDto updateMyDetailExpendRequestDto) {
        return expendInsertMapper.updateMyDetailExpend(updateMyDetailExpendRequestDto) != 0;
    }

    @Transactional
    @Override
    public boolean inputDetail(InsertRequestDto insertRequestDto) {
        int i = expendInsertMapper.insertExpend(insertRequestDto);

        return i != 0;
    }

    @Override
    @Transactional
    public boolean fileInput(MultipartFile multipartFile, int empno, String dvno,Path targetPath){
        int dno = expendInsertMapper.selectDetailExpendDnoOne(dvno);

        FileRequestDto fileRequestDto = new FileRequestDto(
                multipartFile.getOriginalFilename(),
                targetPath.toString(),
                Math.toIntExact(multipartFile.getSize()),
                empno,
                1,
                "/erp/file/expend/",    // 상대경로 사용하지 않음
                dno
        );
        return expendInsertMapper.insertFile(fileRequestDto) != 0;
    }

    @Override
    public List<FileResponseDto> selectFile(String dvno){
        return expendInsertMapper.findFilesByDvno(dvno);
    }
}
