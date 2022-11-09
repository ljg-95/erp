package sjht.erp.board.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardResponse {

    private int bno;
    private int empno;
    private String title;
    private String content;
    private String name;
    private LocalDateTime createtime;
    private LocalDateTime modifiedtime;
    private String boardtype;
    private int boardcount;

}
