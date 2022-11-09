package sjht.erp.detailexpend.service;

import org.springframework.web.multipart.MultipartFile;
import sjht.erp.detailexpend.dto.request.InsertRequestDto;
import sjht.erp.detailexpend.dto.request.UpdateMyDetailExpendRequestDto;
import sjht.erp.detailexpend.dto.response.DetailResponseDto;
import sjht.erp.detailexpend.dto.response.FileResponseDto;
import sjht.erp.detailexpend.dto.response.MyExpendListResponseDto;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface ExpendInsertService {
    String inputExpend();

    boolean inputDetail(InsertRequestDto insertRequestDto/*,MultipartFile multipartFile*/);

    List<DetailResponseDto> selectDetailExpend(String dvno);

    boolean updateExpend(int empno, String dvno);

    boolean deleteDetailData(String dvno);

    boolean deleteData(String dvno);

    String getDepartment(int empno);

    List<MyExpendListResponseDto> selectExpendInfo(int empno);

    boolean deleteOneData(int dno);

    DetailResponseDto chooseDetailExpend(int dno);

    boolean updateMyDetailExpend(UpdateMyDetailExpendRequestDto updateMyDetailExpendRequestDto);

    boolean fileInput(MultipartFile multipartFile, int empno, String dvno, Path targetPath) throws IOException;
    List<FileResponseDto> selectFile(String dvno);
}
