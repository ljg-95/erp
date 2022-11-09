package sjht.erp.expendInformation.repository;

import sjht.erp.expendInformation.dto.InsertParameterEIDto;
import sjht.erp.expendInformation.dto.SelectParameterEIDto;
import sjht.erp.expendInformation.dto.SelectResultEIDto;
import org.apache.ibatis.annotations.Mapper;
import sjht.erp.expendInformation.dto.UpdateParameterEIDto;

import java.util.List;

@Mapper
public interface ExpendInformationMapper {

    // 지출결의 조건 검색
    List<SelectResultEIDto> selectExpendInformation(SelectParameterEIDto selectParameterEIDto);

    // 지출결의 dvno에 따른 데이터 상세내역 검색
    List<SelectResultEIDto> selectExpendInformationOne(String dvno);

    // 승인 반려에 따른 update
    void updateExpendInformation(UpdateParameterEIDto updateParameterEIDto);

    // 승인 처리한 한 건에 대한 insert
    void insertExpendHistory(InsertParameterEIDto insertParameterEIDto);

}
