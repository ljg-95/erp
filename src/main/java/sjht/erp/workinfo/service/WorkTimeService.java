package sjht.erp.workinfo.service;

import sjht.erp.workinfo.dto.request.WorkInfoRequestDto;
import sjht.erp.workinfo.dto.response.WorkInfoResponseDto;

import java.util.List;

public interface WorkTimeService {

    List<WorkInfoResponseDto> selectWhereWorkInfo(WorkInfoRequestDto workInfoRequestDto);
    List<WorkInfoResponseDto> myWorkTimeList(int empno);
    public WorkInfoResponseDto selectOne(int tano);
}
