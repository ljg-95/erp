package sjht.erp.workinfo.dto.response;

import lombok.*;
import sjht.erp.common.vo.WorkTimeManagementVO;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class WorkInfoResponseDto {
    private int tano;
    private int empno;
    private String name;
    private String departmentcode;
    private String departmentname;
    private LocalDate registdate;
    private LocalDate startdate;
    private LocalDate enddate;
    private LocalDate approverdate;
    private String approver;
    private String approveryn;
    private String reasonholiday;

    // VO -> DTO
    public WorkInfoResponseDto(WorkTimeManagementVO workTimeManagementVO) {
        this.tano = workTimeManagementVO.getTano();
        this.empno = workTimeManagementVO.getEmpno().getEmpno();
        this.approverdate = LocalDate.from(workTimeManagementVO.getApprovedate());
        this.name = workTimeManagementVO.getEmpno().getName();
        this.departmentcode = workTimeManagementVO.getEmpno().getDepartmentcd().getDepartmentcd();
        this.departmentname = workTimeManagementVO.getEmpno().getDepartmentcd().getDepartmentname();
        this.registdate = LocalDate.from(workTimeManagementVO.getRegistdate());
        this.startdate = LocalDate.from(workTimeManagementVO.getStartdate());
        this.enddate = LocalDate.from(workTimeManagementVO.getEnddate());
        this.approver = workTimeManagementVO.getApprover();
        this.approveryn = workTimeManagementVO.getApproveryn();
    }
}
