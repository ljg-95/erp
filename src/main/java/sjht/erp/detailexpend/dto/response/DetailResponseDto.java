package sjht.erp.detailexpend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailResponseDto {
    private String dvno;
    private LocalDate dvusedate;
    private int price;
    private String dememo;
    private String divcd;
    private String briefs;
    private String detailuse;
    private int dno;
}
