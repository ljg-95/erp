package sjht.erp.menu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sjht.erp.common.vo.MenuMasterVO;
import sjht.erp.menu.dto.MenuDto;
import sjht.erp.menu.repository.MenuMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuMapper menuMapper;

    //메뉴 리스트 불러오기
    public List<List<MenuDto>> getMenuList(String usertype) {


        //메뉴VO 불러오기 및 UpdateDto 변환
        List<MenuMasterVO> menuVo = menuMapper.getMenuList(usertype);
        List<MenuDto> menuDto = new ArrayList();

        for(int i=0; i<menuVo.size(); i++){
            menuDto.add(new MenuDto(menuVo.get(i)));
        }

        //필요 변수 선언
        List<MenuDto> mainmenu = new ArrayList();
        List<MenuDto> submenu = new ArrayList();
        List<List<MenuDto>> result = new ArrayList<>();

        // main/sub menu 분리
        for(MenuDto dto : menuDto){
            if(dto.getLevel()==1){
                mainmenu.add(dto);
            }else {
                submenu.add(dto);
            }
        }

        result.add(mainmenu);
        result.add(submenu);

        return result;
    }
}