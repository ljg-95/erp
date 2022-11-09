package sjht.erp.home.Mapper;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.common.vo.BoardVO;
import sjht.erp.common.vo.EmployeeVO;
import sjht.erp.common.vo.ExpendInformationVO;
import sjht.erp.common.vo.WorkTimeManagementVO;

import java.util.List;

@Mapper
public interface HomeMapper {
    public List<BoardVO> getNoticeList();

    List<ExpendInformationVO> getExpandInformationList(int empno);

    List<WorkTimeManagementVO> getWorkTimeManagementList(int empno);

    List<EmployeeVO> getEmployeeList();
}
