package sjht.erp.expendInformation.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class UpdateParameterEIDto {
    private String dvno;            //결의번호
    private LocalDate dvappdate;    //승인날짜
    private String dvappname;       //승인자
    private String dvappyn;         //승인여부
}
