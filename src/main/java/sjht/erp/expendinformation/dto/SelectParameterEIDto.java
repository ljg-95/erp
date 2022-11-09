package sjht.erp.expendInformation.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class SelectParameterEIDto {
    private LocalDate startDvRegDate;       //검색 시작 날짜
    private LocalDate endDvRegDate;         //검색 끝 날짜
    private String dvappyn;                 //승인 여부
    private int empno;                      //사번
    private String name;                    //사원 이름
    private String divcd;                   //계정 과목

    public SelectParameterEIDto() {
        this.startDvRegDate = LocalDate.now();
        this.endDvRegDate = LocalDate.now();
        this.dvappyn = "w";
        this.empno = 0;
        this.divcd = null;
        this.name = null;
    }

    //map -> dto
    public SelectParameterEIDto(HashMap<String, String> map) {
        if (!map.get("empno").isEmpty())
            this.empno = Integer.parseInt(map.get("empno"));

        this.startDvRegDate = LocalDate.parse(map.get("startDvRegDate"), DateTimeFormatter.ISO_DATE);
        this.endDvRegDate = LocalDate.parse(map.get("endDvRegDate"), DateTimeFormatter.ISO_DATE);
        this.dvappyn = map.get("dvappyn");

        if (!map.get("divcd").isEmpty())
            this.divcd = map.get("divcd");
        if (!map.get("empname").isEmpty())
            this.name = map.get("empname");
    }

}
