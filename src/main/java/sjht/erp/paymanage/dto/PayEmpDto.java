package sjht.erp.paymanage.dto;

import lombok.*;
import sjht.erp.common.vo.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PayEmpDto {
        /*  Employee */
        private int empno; // 사원번호
        private String name; // 사원이름
        private int salary; // 월급
        private String restyn; // 휴직여부
        private Date paymentst; // 마지막 지급 날짜

        private int expend; // 지출 금액
        private int privateinsurance; // 공제 금액

        /* DepartmentCode */
        private String departmentname; //부서먕

        /* GradeCode */
        private String gradename; // 직급명


}
