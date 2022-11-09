package sjht.erp.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sjht.erp.common.vo.MenuMasterVO;
import sjht.erp.common.vo.UserMasterVO;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private Long menuid;
    private UserMasterVO usertype;
    private String menuname;
    private String menuurl;
    private Long groupnumber;
    private Long odr;
    private Long level;

    public MenuDto(MenuMasterVO vo){
        this.menuid = vo.getMenuid();
        this.menuname = vo.getMenuname();
        this.menuurl = vo.getMenuurl();
        this.groupnumber = vo.getGroupnumber();
        this.odr = vo.getOdr();
        this.level = vo.getLevel();
        this.usertype = vo.getUsertype();
    }
}
