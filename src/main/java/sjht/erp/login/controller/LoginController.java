package sjht.erp.login.controller;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sjht.erp.exception.LoginFailedException;
import sjht.erp.login.dto.LoginDto;
import sjht.erp.login.dto.Response.BaseResponse;
import sjht.erp.login.dto.Response.SingleDataResponse;
import sjht.erp.login.dto.EmployeeDto;
import sjht.erp.login.service.LoginService;
import sjht.erp.login.service.ResponseService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Arrays;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final ResponseService responseService;
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String main(HttpServletRequest request){
        Cookie[] cookie = request.getCookies();

        if(cookie==null )return "/login/login";

        if(Arrays.stream(cookie).filter(c -> c.getName().equals("token")).findAny().isPresent()){
            return "/menu/home";
        }
        return "login/login";
    }

    @GetMapping("/api/join")
    public String join(){
            return "login/signup";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute EmployeeDto employeeDto){
        loginService.join(employeeDto);
        return "redirect:/";
    }

    @SneakyThrows
    @RequestMapping("/api/login")
    public String login(@ModelAttribute LoginDto loginDto, Model model, HttpServletResponse respon,HttpServletRequest request){
        ResponseEntity responseEntity = null;

        try{


            String token = loginService.login(loginDto);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authoriztion","Bearer "+token);

            SingleDataResponse<String> response = responseService.getSingleDataResponse(true,"로그인 성공", token);

            responseEntity = ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);

            Cookie cookie = new Cookie("token", URLEncoder.encode("Bearer "+ token,"UTF-8"));
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24);
            respon.addCookie(cookie);

            return "redirect:/";
        }catch(LoginFailedException exception){
            logger.debug(exception.getMessage());
            BaseResponse response = responseService.getBaseResponse(false, exception.getMessage());

            Cookie[] cookie = request.getCookies();
            if(cookie!=null && Arrays.stream(cookie).filter(c -> c.getName().equals("token")).findAny().isPresent()){
                return "redirect:/";
            }

            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            return "/login/loginfail";
        }



    }
}
