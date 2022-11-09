package sjht.erp.menu.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.common.vo.MenuMasterVO;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MenuMapper {

    List<MenuMasterVO> getMenuList(String usertype);
}
