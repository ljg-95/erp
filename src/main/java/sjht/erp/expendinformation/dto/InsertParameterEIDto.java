package sjht.erp.expendInformation.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 승인 시 회계 전표 (expendHistory) insert parameter
 * eno auto increment
 * paysequence 급여 관리 쪽
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class InsertParameterEIDto {
    private int empno;
    private int dvamt;
    private LocalDate dvappdate;
    private String dvno;
    private String divcd;
}
