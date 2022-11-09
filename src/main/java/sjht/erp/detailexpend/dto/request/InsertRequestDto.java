package sjht.erp.detailexpend.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class InsertRequestDto {
    private int dno;
    private String dvno;
    private LocalDate dvusedate;
    private int price;
    private String dvmemo;
    private String divcd;
    private String briefs;
    private String detailuse;
}
