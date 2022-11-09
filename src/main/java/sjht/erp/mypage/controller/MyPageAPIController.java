package sjht.erp.mypage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjht.erp.hrms.dto.SelectDto;
import sjht.erp.hrms.service.HrmsApiService;
import sjht.erp.login.dto.EmployeeDto;
import sjht.erp.mypage.dto.MyPageUpdateDto;
import sjht.erp.mypage.service.MyPageService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class MyPageAPIController {

    final MyPageService myPageService;

    @PostMapping("/api/mypage/update")
    public void update(@RequestBody MyPageUpdateDto dto, HttpServletRequest request){
        System.out.println("컨트롤러");
        // 내 정보 수정
        myPageService.updateEmpData(dto);

    }

    @PostMapping("/api/mypage")
    public ResponseEntity<SelectDto> getMyInfo(HttpServletRequest request){
        // 접근권한 및 아이디 참조
        EmployeeDto emp = (EmployeeDto)request.getAttribute("empNo");
        // 직원 정보 불러오기
        SelectDto empDto = myPageService.getMyInfo(emp.getEmpno());
        // 직원 정보 반환
        return ResponseEntity.status(HttpStatus.OK).body(empDto);
    }
}
