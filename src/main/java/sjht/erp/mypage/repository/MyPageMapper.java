package sjht.erp.mypage.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.hrms.dto.SelectDto;
import sjht.erp.mypage.dto.MyPageUpdateDto;

@Mapper
public interface MyPageMapper {
    public void updateEmpData(MyPageUpdateDto dto);


}
