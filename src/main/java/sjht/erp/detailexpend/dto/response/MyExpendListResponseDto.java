package sjht.erp.detailexpend.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class MyExpendListResponseDto {
    private String dvno;
    private int empno;
    private String name;
    private String departmentname;
    private LocalDate dvregdate;
    private int dvamt;
    private String dvappyn;
}
