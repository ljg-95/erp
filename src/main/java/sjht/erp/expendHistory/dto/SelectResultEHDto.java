package sjht.erp.expendHistory.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectResultEHDto {
    private int eno;                    // 전표 번호
    private String dvno;                // 회계전표
    private int empno;                  // 담당자 사번
    private String dvappname;           // 담당자
    private LocalDate dvappdate;        // 승인 날짜
    private int dvamt;                  // 총 금액
    private String divname;             // 계정과목
    private String briefs;               // 적요
    private int price;                  // 지출액
    private int total_divcd_price;      // 계정과목 별 총 금액
}
