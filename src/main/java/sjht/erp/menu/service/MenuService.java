package sjht.erp.menu.service;

import sjht.erp.menu.dto.MenuDto;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    List<List<MenuDto>> getMenuList(String usertype);
}
