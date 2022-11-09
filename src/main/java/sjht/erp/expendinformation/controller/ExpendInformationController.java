package sjht.erp.expendInformation.controller;

import sjht.erp.expendInformation.service.ExpendInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class ExpendInformationController {

    private final ExpendInformationService service;

    @RequestMapping("/expend")
    public String expend(){
            System.out.println("Controller expend");
        return "expendInformation/expendAxios";
    }


}
