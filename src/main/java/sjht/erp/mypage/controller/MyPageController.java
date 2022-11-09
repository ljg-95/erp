package sjht.erp.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyPageController {

    @GetMapping("/mypage")
    public String Mapping(){
        return "mypage/mypage";
    }

}
