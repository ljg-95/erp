package sjht.erp.login.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.login.dto.EmployeeDto;

import java.util.Optional;

@Mapper
public interface UserMapper{
        Optional<EmployeeDto> findUserByEmpno(int empno);
        void save(EmployeeDto employeeDto);
}
