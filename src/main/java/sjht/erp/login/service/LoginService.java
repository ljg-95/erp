package sjht.erp.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjht.erp.exception.DuplicatedUsernameException;
import sjht.erp.login.configure.JwtTokenProvider;
import sjht.erp.exception.LoginFailedException;
import sjht.erp.exception.UserNotFoundException;
import sjht.erp.login.dto.LoginDto;
import sjht.erp.login.dto.EmployeeDto;
import sjht.erp.login.repository.UserMapper;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class LoginService {

    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public void join(EmployeeDto employeeDto){
        if(userMapper.findUserByEmpno(employeeDto.getEmpno()).isPresent()){
            throw new DuplicatedUsernameException("이미 가입된 유저입니다.");
        }

        employeeDto.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        System.out.println(employeeDto.getName());
        userMapper.save(employeeDto);
        System.out.println(employeeDto.getPassword());


    }

    public String login(LoginDto loginDto){
        EmployeeDto employeeDto = userMapper.findUserByEmpno(loginDto.getEmpno())
                .orElseThrow(() -> new LoginFailedException("잘못된 아이디입니다."));

        if(!passwordEncoder.matches(loginDto.getPassword(), employeeDto.getPassword())){
            throw new LoginFailedException("잘못된 비밀번호 입니다.");
        }

        return jwtTokenProvider.createToken(employeeDto.getEmpno(), Collections.singletonList(employeeDto.getUsertype()));

    }

    public EmployeeDto findByUserId(int userId){
        return userMapper.findUserByEmpno(userId)
                .orElseThrow(() -> new UserNotFoundException("없는 유저입니다."));
    }
}
