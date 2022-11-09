package sjht.erp.home.service;

import sjht.erp.common.vo.BoardVO;
import sjht.erp.home.dto.FindEmployeeDto;
import sjht.erp.home.dto.HrmsSignDto;
import sjht.erp.home.dto.NoticeDto;

import java.util.ArrayList;
import java.util.List;

public interface HomeService {
    public List<NoticeDto> getNoticeList();

    List<List<HrmsSignDto>> getHrmsSignDtoList(int empno);

    List<FindEmployeeDto> getEmployeeList();
}
