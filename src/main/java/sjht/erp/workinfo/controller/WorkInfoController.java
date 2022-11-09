package sjht.erp.workinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class WorkInfoController {
    @GetMapping("/workList")
    public String workTimeInfo(HttpServletRequest request) {
        request.getAttribute("empNo");
        return "workList/list";
    }
}
