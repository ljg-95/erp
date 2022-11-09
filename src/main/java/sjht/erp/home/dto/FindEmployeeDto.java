package sjht.erp.home.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sjht.erp.common.vo.EmployeeVO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindEmployeeDto {

    private int empno;
    private String name;
    private String mail;
    private String department;
    private String telnumber;
    private String grade;

    public FindEmployeeDto(EmployeeVO employeeVO) {

        this.empno = employeeVO.getEmpno();
        this.name = employeeVO.getName();
        this.mail = employeeVO.getMail();
        if(employeeVO.getDepartmentcd() != null){
            this.department = employeeVO.getDepartmentcd().getDepartmentname();
        }else{
            this.department = "";
        }
        this.telnumber = employeeVO.getTel();
        if(employeeVO.getGradecd() != null){
            this.grade = employeeVO.getGradecd().getGradename();
        }else{
            this.grade = "";
        }
    }

}
