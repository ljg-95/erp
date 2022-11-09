package sjht.erp.expendHistory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sjht.erp.expendHistory.dto.SelectParameterEHDto;
import sjht.erp.expendHistory.dto.SelectResultEHDto;
import sjht.erp.expendHistory.repository.ExpendHistoryMapper;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpendHistoryServiceImpl implements ExpendHistoryService{

    private final ExpendHistoryMapper mapper;

    @Override
    public List<SelectResultEHDto> selectByCondition(HashMap<String, String> map) {
        SelectParameterEHDto selectParameterEHDto = new SelectParameterEHDto(map);
        List<SelectResultEHDto> result = mapper.selectExpendHistory(selectParameterEHDto);
        return result;
    }

    @Override
    public List<SelectResultEHDto> selectEHByEno(String eno) {
        List<SelectResultEHDto> result = mapper.selectExpendHistoryByEno(Integer.parseInt(eno));
        return result;
    }

    @Override
    public List<SelectResultEHDto> selectSummary(HashMap<String, String> map) {
        SelectParameterEHDto selectParameterEHDto = new SelectParameterEHDto(map);
        List<SelectResultEHDto> result = mapper.selectExpendHistoryByTotalPrice(selectParameterEHDto);
        return result;
    }
}
