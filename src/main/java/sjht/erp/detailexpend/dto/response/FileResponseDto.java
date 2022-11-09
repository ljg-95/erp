package sjht.erp.detailexpend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileResponseDto {
    private int dno;
    private String filename;
    private int kind; // 지출결의서 영수증
    private int empno;
    private String physicalpath;
    private String relatedpath;
    private int filesize;
    private int fileno;
}
