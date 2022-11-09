package sjht.erp.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sjht.erp.login.dto.EmployeeDto;
import sjht.erp.login.repository.UserMapper;
import sjht.erp.exception.UserNotFoundException;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userMapper.findUserByEmpno(Integer.valueOf(userId))
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException(userId + ">찾을 수 없습니다."));
    }

    private EmployeeDto addAuthorities(EmployeeDto employeeDto){
        employeeDto.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(employeeDto.getUsertype())));

        return employeeDto;
    }
}
