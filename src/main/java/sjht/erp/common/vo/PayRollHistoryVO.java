package sjht.erp.common.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PayRollHistoryVO {
    private int paysequence;
    private EmployeeVO empno;
    private int privateinsurance;
    private int netpay; // 공제금액
    private LocalDateTime paymentdate;
    private int yearsalary;
    private int pay; // 원천징수
}
