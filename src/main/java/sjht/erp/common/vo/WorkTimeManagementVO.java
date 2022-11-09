package sjht.erp.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkTimeManagementVO {

    private int tano; // PK
    private EmployeeVO empno; // 사원번호
    private LocalDateTime approvedate; // 승인 일자
    private String approver; // 승인자
    private String approveryn; // 승인 여부
    private LocalDateTime registdate; // 등록일자
    private String reasonholiday; // 휴가사유
    private LocalDateTime startdate; // 휴가 시작일
    private LocalDateTime enddate; // 휴가 종료일

}
