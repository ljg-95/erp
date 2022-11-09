package sjht.erp.expendHistory.service;

 import sjht.erp.expendHistory.dto.SelectResultEHDto;

import java.util.HashMap;
import java.util.List;

public interface ExpendHistoryService {

    // 조건 검색에 따른 회계 전표
    List<SelectResultEHDto> selectByCondition(HashMap<String,String> map);

    // 회계 전표에 따른 상세 내역 select 메소드
    List<SelectResultEHDto> selectEHByEno(String eno);

    List<SelectResultEHDto> selectSummary(HashMap<String, String> map);
}
