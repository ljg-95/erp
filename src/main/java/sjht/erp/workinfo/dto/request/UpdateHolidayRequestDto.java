package sjht.erp.workinfo.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateHolidayRequestDto {
    private String approveryn;
    private String approver;
    private int tano;
}
