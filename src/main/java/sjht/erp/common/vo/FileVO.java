package sjht.erp.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {

    private int fileno; // pk 파일번호
    private String filename; // 파일이름
    private String physicalpath; // 물리경로
    private String relatedpath; // 상대경로
    private int filesize; // 파일사이즈
    private int empno; // fk 사원번호
    private String kind; // 파일종류
    private int dno; // 결제번호
}
