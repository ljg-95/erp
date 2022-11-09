package sjht.erp.workinfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjht.erp.login.dto.EmployeeDto;
import sjht.erp.workinfo.dto.request.WorkInfoRequestDto;
import sjht.erp.workinfo.dto.response.WorkInfoResponseDto;
import sjht.erp.workinfo.service.WorkTimeService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class WorkInfoApiController {

    private final WorkTimeService workTimeService;

    // 전체 사원의 휴가 신청 리스트를 조회하는 컨트롤러
    @PostMapping("/api/workList")
    public List<WorkInfoResponseDto> workTimeInfo(HttpServletRequest request, @RequestBody WorkInfoRequestDto workInfoRequestDto) {
        EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("empNo");
        // 리턴 리스폰스 디티오 타입 서비스 로직
        System.out.println(workInfoRequestDto.toString());
        return workTimeService.selectWhereWorkInfo(workInfoRequestDto);
    }

    // 로그인한 대상의 휴가신청리스트를 조회하는 컨트롤러
    @PostMapping("api/getMyWorkTime")
    public List<WorkInfoResponseDto> getMyWorkTime(HttpServletRequest request) {
        EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("empNo");
        return workTimeService.myWorkTimeList(employeeDto.getEmpno());
    }

    // 로그인한 대상의 유저타입을 출력해주는 컨트롤러
    @PostMapping("api/getROLE")
    public String getRole(HttpServletRequest request) {
        EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("empNo");
        return employeeDto.getUsertype();
    }

    // 로그인한 대상의 사원이름을 출력해주는 컨트롤러
    @PostMapping("api/getName")
    public String getName(HttpServletRequest request) {
        EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("empNo");
        return employeeDto.getName();
    }

    // 휴가신청 리스트를 중 하나의 데이터를 상세보기 하기 위한 컨트롤러
    @PostMapping("api/getOne")
    public WorkInfoResponseDto getOne(HttpServletRequest request, @RequestBody HashMap<String, String> map) {
        request.getAttribute("empNo");
        int tano = Integer.parseInt(map.get("tanos"));
        System.out.println(tano);
        WorkInfoResponseDto workInfoResponseDto = workTimeService.selectOne(tano);
        System.out.println(workInfoResponseDto);
        return workInfoResponseDto;
    }

    // 로그인한 대상의 empno를 확인하기 위한 컨트롤러
    @PostMapping("api/checkMyId")
    public int checkMyEmpno(HttpServletRequest request) {
        EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("empNo");
        return employeeDto.getEmpno();
    }
}
