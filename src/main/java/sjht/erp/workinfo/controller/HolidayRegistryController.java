package sjht.erp.workinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HolidayRegistryController {

    @GetMapping("/insert")
    public String holidayReg(){
        return "/workList/list";
    }
}
