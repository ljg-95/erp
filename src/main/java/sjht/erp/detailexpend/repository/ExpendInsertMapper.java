package sjht.erp.detailexpend.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.detailexpend.dto.request.*;
import sjht.erp.detailexpend.dto.response.DetailResponseDto;
import sjht.erp.detailexpend.dto.response.FileResponseDto;
import sjht.erp.detailexpend.dto.response.MyExpendListResponseDto;

import java.io.File;
import java.util.List;

@Mapper
public interface ExpendInsertMapper {

    SelectEmployeeDto selectOneEmployee(int empno);

    String selectLastOne();

    List<String> selectAll();

    int insertDvno(String dvno);

    int insertExpend(InsertRequestDto insertRequestDto);

    int insertFile(FileRequestDto fileRequestDto);

    int updateExpendInformation(UpdateRequestDto updateRequestDto);

    List<DetailResponseDto> selectDetailExpend(String dvno);

    int deleteDetailExpendInteger(int dno);

    int sumPrice(String dvno);

    int deleteDetailExpend(String dvno);

    int deleteExpendInformation(String dvno);

    int updateDetailDVNO(UpdateDvnoRequestDto updateDvnoRequestDtoList);

    String selectOneDepartmentName(String departmentcd);

    List<MyExpendListResponseDto> findExpendInformationsByEmpnoAndApproveryn(int empno);

    DetailResponseDto selectMyDetailExpend(int dno);

    int updateMyDetailExpend(UpdateMyDetailExpendRequestDto updateMyDetailExpendRequestDto);

    Integer selectDetailExpendDnoOne(String dvno);

    List<FileResponseDto> findFilesByDvno(String dvno);
}
