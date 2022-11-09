package sjht.erp.workinfo.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HolidayRequestDto {
    private int empno;
    private LocalDate startdate;
    private LocalDate enddate;
    private String reasonholiday;
    private String approveryn = "w";
    private LocalDateTime registdate;

    public HolidayRequestDto(int empno, LocalDate startdate, LocalDate enddate, String reasonholiday) {
        this.empno = empno;
        this.startdate = startdate;
        this.enddate = enddate;
        this.reasonholiday = reasonholiday;
    }
}
