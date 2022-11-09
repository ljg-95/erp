package sjht.erp.expendInformation.service;

import sjht.erp.expendInformation.dto.InsertParameterEIDto;
import sjht.erp.expendInformation.dto.SelectParameterEIDto;
import sjht.erp.expendInformation.dto.SelectResultEIDto;
import sjht.erp.expendInformation.dto.UpdateParameterEIDto;
import sjht.erp.login.dto.EmployeeDto;

import java.util.HashMap;
import java.util.List;


public interface ExpendInformationService {

    // 지출 결의 조건에 맞는 리스트 select 메소드
    List<SelectResultEIDto> selectEIByCondition(SelectParameterEIDto selectParameterEIDto);

    // 결의 번호에 따른 상세 내역 select 메소드
    List<SelectResultEIDto> selectEIByDvno(String dvno);

    // 승인 반려에 따른 update 메소드
    void updateEI(HashMap<String, String> map, EmployeeDto employeeDto);

    // 승인 처리한 한 건에 대한 insert 메소드
    void insertEH(InsertParameterEIDto insertParameterEIDto);

    //결의 조건 검증 메소드
    SelectParameterEIDto checkParam(HashMap<String,String> map);
}
