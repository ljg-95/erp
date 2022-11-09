package sjht.erp.workinfo.dto.request;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class UpdateMyHolidayRequestDto {
    private LocalDate startdate;
    private LocalDate enddate;
    private String reasonholiday;
    private int tano;
}
