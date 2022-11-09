package sjht.erp.expendHistory.dto;

import lombok.*;
import org.springframework.stereotype.Service;
import sjht.erp.expendInformation.dto.SelectParameterEIDto;

import java.time.LocalDate;
import java.util.HashMap;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class SelectParameterEHDto {
    private LocalDate start;
    private LocalDate end;
    private int empno;
    private String dvappname;

    public SelectParameterEHDto(HashMap<String, String> map) {
        if (!map.get("formEmpno").isEmpty()) {
            this.empno = Integer.parseInt(map.get("formEmpno"));
        }

        if (!map.get("formEmpname").isEmpty()) {
            this.dvappname = map.get("formEmpname");
        }

        if (!map.get("formStartDvRegDate").isEmpty()) {
            this.start = LocalDate.parse(map.get("formStartDvRegDate"));
        } else {
            this.start = LocalDate.now();
        }

        if (!map.get("formEndDvRegDate").isEmpty()) {
            this.end = LocalDate.parse(map.get("formEndDvRegDate"));
        } else {
            this.end = LocalDate.now();
        }

    }
}
