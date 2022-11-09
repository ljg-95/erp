package sjht.erp.common.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReviewVO {
    private BoardVO bno;
    private EmployeeVO empno;
    private String name;
    private String review;
    private LocalDateTime reviewdate;
}
