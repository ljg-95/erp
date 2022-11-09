package sjht.erp.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sjht.erp.home.dto.FindEmployeeDto;
import sjht.erp.home.dto.HrmsSignDto;
import sjht.erp.home.dto.NoticeDto;
import sjht.erp.home.service.HomeServiceImpl;
import sjht.erp.login.dto.EmployeeDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeApiController {

    private final HomeServiceImpl homeServiceImpl;

    // home dashboard(notice)에 표시할 공지사항 불러오기
    @PostMapping("/api/home/notice")
    public ResponseEntity<List<NoticeDto>> getNotice(){

        //공지사항 요약 불러오기
        List<NoticeDto> noticeDto = homeServiceImpl.getNoticeList();

        return ResponseEntity.status(HttpStatus.OK).body(noticeDto);
    }

    //hrms dashboard에 표시할 결재내역 불러오기
    @PostMapping("/api/home/hrms")
    public ResponseEntity<List<List<HrmsSignDto>>> getHrmsSign(HttpServletRequest request) {

        EmployeeDto emp = (EmployeeDto)request.getAttribute("empNo");

        //결제 내역 불러오기
        List<List<HrmsSignDto>> hrmsSignDtoList = homeServiceImpl.getHrmsSignDtoList(emp.getEmpno());

        return ResponseEntity.status(HttpStatus.OK).body(hrmsSignDtoList);
    }

    //hrms dashboard 사람 찾기
    @PostMapping("api/home/find")
    public ResponseEntity<List<FindEmployeeDto>> getEmployeeList(){

        //직원 목륵 불러오기(사번, 이름, 부서, 직급, 번호)
        List<FindEmployeeDto> empList = homeServiceImpl.getEmployeeList();

        return ResponseEntity.status(HttpStatus.OK).body(empList);
    }

}



