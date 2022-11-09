package sjht.erp.detailexpend.dto.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateMyDetailExpendRequestDto {
    private LocalDate dvusedate;
    private String divcd;
    private String briefs;
    private String detailuse;
    private int price;
    private String dvmemo;
    private int dno;
}
