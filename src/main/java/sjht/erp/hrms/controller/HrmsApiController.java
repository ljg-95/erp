package sjht.erp.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sjht.erp.hrms.dto.SelectDto;
import sjht.erp.hrms.dto.UpdateDto;
import sjht.erp.hrms.service.HrmsApiService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HrmsApiController {

    private final HrmsApiService hrmsApiService;

    /* 사원 리스트 */
    @PostMapping("/api/hrms")
    public ResponseEntity<List<SelectDto>> getEmpList () {
        // 사원 리스트 불러오기
        List<SelectDto> empList = hrmsApiService.getEmpList();
        // 반환
        return ResponseEntity.status(HttpStatus.OK).body(empList);
    }

    /* 사원 등록 */
    @PostMapping("/api/hrms/regist")
    public void registEmp (@RequestBody UpdateDto updateDto) {
        // 폼 데이터 등록 요청
        hrmsApiService.registEmp(updateDto);
    }

    /* 사원 등록 시 사번 보여주기 */
    @PostMapping("/api/hrms/empno")
    public ResponseEntity<Integer> getEmpno() {
        // 등록할 사원의 사번 요청
        Integer empno = hrmsApiService.getEmpno();
        // 반환
        return ResponseEntity.status(HttpStatus.OK).body(empno);
    }

    /* 사원 정보 수정 */
    @PatchMapping("/api/hrms/{empno}")
    public void updateEmp (@RequestBody UpdateDto updateDto) {
        // 폼 데이터 수정 요청
        hrmsApiService.updateEmp(updateDto);
    }

    /* 부서 리스트 */
    @PostMapping("/api/hrms/departmentList")
    public ResponseEntity<List<SelectDto>> getDepartmentList () {
        // 부서 리스트 불러오기
        List<SelectDto> departmentList = hrmsApiService.getDepartmentList();
        // 반환
        return ResponseEntity.status(HttpStatus.OK).body(departmentList);
    }

    /* 직급 리스트 */
    @PostMapping("/api/hrms/gradeList")
    public ResponseEntity<List<SelectDto>> getGradeList () {
        // 직급 리스트 불러오기
        List<SelectDto> gradeList = hrmsApiService.getGradeList();
        // 반환
        return ResponseEntity.status(HttpStatus.OK).body(gradeList);

    }

    /* 은행 리스트 */
    @PostMapping("/api/hrms/bankList")
    public ResponseEntity<List<SelectDto>> getBankList() {
        // 뱅크 코드 불러오기
        List<SelectDto> bankList = hrmsApiService.getBankList();
        // 반환
        return ResponseEntity.status(HttpStatus.OK).body(bankList);
    }

    /* 권한 리스트 */
    @PostMapping("/api/hrms/usermasterList")
    public ResponseEntity<List<SelectDto>> getUserMasterList() {
        // 권한 리스트 불러오기
        List<SelectDto> userMasterList = hrmsApiService.getUserMasterList();
        // 반환
        return ResponseEntity.status(HttpStatus.OK).body(userMasterList);
    }




    /* 퇴사 처리 */













}




