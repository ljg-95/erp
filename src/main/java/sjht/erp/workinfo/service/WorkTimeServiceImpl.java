package sjht.erp.workinfo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sjht.erp.workinfo.dto.request.WorkInfoRequestDto;
import sjht.erp.workinfo.dto.response.WorkInfoResponseDto;
import sjht.erp.workinfo.repository.WorkTimeManagerMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WorkTimeServiceImpl implements WorkTimeService {

    final WorkTimeManagerMapper workTimeManagerMapper;

    @Override
    public List<WorkInfoResponseDto> selectWhereWorkInfo(WorkInfoRequestDto workInfoRequestDto) {

        if (workTimeManagerMapper.findWorkTimeInfo(workInfoRequestDto)!=null) {
            return workTimeManagerMapper.findWorkTimeInfo(workInfoRequestDto);
        }
        return null;
    }
    public List<WorkInfoResponseDto> myWorkTimeList(int empno){
        return workTimeManagerMapper.selectMyWorkTime(empno);
    }

    public WorkInfoResponseDto selectOne(int tano){
        return workTimeManagerMapper.selectWorkTimeByTano(tano);
    }
}
