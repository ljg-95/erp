package sjht.erp.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.HandlerInterceptor;
import sjht.erp.login.dto.EmployeeDto;
import sjht.erp.login.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;
    /*
     preHandle : configure에서 설정한 메서드 컨트롤러 실행 전 수행
     request 에서 EmployeeDto 추출
    */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getAttribute("auth")!=null){
            Authentication authentication = (Authentication) request.getAttribute("auth");
            int userId = ((EmployeeDto) authentication.getPrincipal()).getEmpno();
            EmployeeDto empNo = loginService.findByUserId(userId);

            request.setAttribute("empNo", empNo);
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
