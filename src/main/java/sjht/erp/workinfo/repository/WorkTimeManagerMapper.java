package sjht.erp.workinfo.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.workinfo.dto.request.WorkInfoRequestDto;
import sjht.erp.workinfo.dto.response.WorkInfoResponseDto;

import java.util.List;

@Mapper
public interface WorkTimeManagerMapper {
    List<WorkInfoResponseDto> findWorkTimeInfo(WorkInfoRequestDto workInfoRequestDto);

    List<WorkInfoResponseDto> selectMyWorkTime(int empno);

    WorkInfoResponseDto selectWorkTimeByTano(int tano);
}
