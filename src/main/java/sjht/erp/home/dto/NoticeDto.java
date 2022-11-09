package sjht.erp.home.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sjht.erp.common.vo.BoardVO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDto {

    private int bno;
    private String title;
    private String regdate;
    public NoticeDto(BoardVO boardVO) {
        this.bno = boardVO.getBno();
        this.title = boardVO.getTitle();
        this.regdate = boardVO.getCreatetime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }

}
