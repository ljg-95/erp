package sjht.erp.paymanage.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.paymanage.dto.PayEmpDto;

import java.util.List;

@Mapper
public interface PayManageMapper {
    List<PayEmpDto> getPayEmpList();

    void paySalary(List<PayEmpDto> payEmpDtoList);

    void paySalaryHistory(List<PayEmpDto> payEmpDtoList);
}
