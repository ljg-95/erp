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
public class ExpendInformationVO {

    private String dvno; // PK
    private EmployeeVO empno; // 사원번호
    private AccountCodeVO divcd; // 계정과목코드

    private LocalDateTime dvregdate; // 등록일자
    private LocalDateTime dvusedate; // 사용일자
    private int dvamt; // 사용 금액
    private String dvappyn; //승인여부
    private LocalDateTime dvappdate; // 결제일자
    private String dvappname; //승인자
    private String dvmemo; //비고
}
