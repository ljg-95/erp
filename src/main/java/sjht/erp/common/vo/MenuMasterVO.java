package sjht.erp.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuMasterVO {
    private Long menuid; // PK
    private UserMasterVO usertype; // 유저 권한
    private String menuname; // 메뉴 이름
    private String menuurl; // 메뉴 url
    private Long groupnumber; // 메뉴 그룹
    private Long odr; // 순서
    private Long level; // 메뉴 층(대메뉴 소메뉴)
}
