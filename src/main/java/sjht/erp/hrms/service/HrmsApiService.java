package sjht.erp.hrms.service;

import sjht.erp.hrms.dto.SelectDto;
import sjht.erp.hrms.dto.UpdateDto;

import java.util.List;

public interface HrmsApiService {

    /* 사원 리스트 */
    List<SelectDto> getEmpList();

    /* 사원 등록 (회계,총무) */
    void registEmp(UpdateDto updateDto);

    /* 사원 등록 시 사번 보여주기 */
    int getEmpno();

    /* 사원 정보 업데이트 */
    void updateEmp(UpdateDto updateDto);

    /* 부서 리스트 */
    List<SelectDto> getDepartmentList();

    /* 직급 리스트 */
    List<SelectDto> getGradeList();

    /* 은행 리스트 */
    List<SelectDto> getBankList();

    /* 권한 리스트 */
    List<SelectDto> getUserMasterList();
}
