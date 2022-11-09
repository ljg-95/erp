package sjht.erp.detailexpend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileRequestDto {
    private String filename;
    private String physicalpath;
    private int filesize;
    private int empno;
    private int kind; // 지출결의서 영수증
    private String relatedpath;
    private int dno;
}
