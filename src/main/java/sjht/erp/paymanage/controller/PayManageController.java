package sjht.erp.paymanage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class PayManageController {

    @GetMapping("/hrms/paymanage")
    public String payManage(){
        return "/paymanage/paymanage";
    }
}
