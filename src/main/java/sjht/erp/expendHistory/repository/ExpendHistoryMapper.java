package sjht.erp.expendHistory.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.expendHistory.dto.SelectParameterEHDto;
import sjht.erp.expendHistory.dto.SelectResultEHDto;
import java.util.List;

@Mapper
public interface ExpendHistoryMapper {

   List<SelectResultEHDto> selectExpendHistory(SelectParameterEHDto selectParameterEHDto);

   List<SelectResultEHDto> selectExpendHistoryByEno(int eno);

   List<SelectResultEHDto> selectExpendHistoryByTotalPrice(SelectParameterEHDto selectParameterEHDto);
}
