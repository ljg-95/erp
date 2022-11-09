package sjht.erp.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sjht.erp.hrms.service.HrmsService;

@Controller
@RequiredArgsConstructor
public class HrmsController {

    private final HrmsService hrmsService;

    @GetMapping("/hrms/list")
    public String getEmplists () {
        // 사원 리스트 불러오기 및 반환
        return "/hrms/list";
    }
}


