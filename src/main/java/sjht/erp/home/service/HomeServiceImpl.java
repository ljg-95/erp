package sjht.erp.home.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sjht.erp.common.vo.BoardVO;
import sjht.erp.common.vo.EmployeeVO;
import sjht.erp.common.vo.ExpendInformationVO;
import sjht.erp.common.vo.WorkTimeManagementVO;
import sjht.erp.home.Mapper.HomeMapper;
import sjht.erp.home.dto.FindEmployeeDto;
import sjht.erp.home.dto.HrmsSignDto;
import sjht.erp.home.dto.NoticeDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeMapper homeMapper;

    public List<NoticeDto> getNoticeList() {

        //BoardVO 불러오기 및 Dto 변환
        List<BoardVO> noticeVo = homeMapper.getNoticeList();
        List<NoticeDto> noticeDto = new ArrayList();

        if (noticeVo.size() > 6) {
            for (int i = 0; i < 6; i++) {
                noticeDto.add(new NoticeDto(noticeVo.get(i)));
            }
        } else {
            for (BoardVO board : noticeVo) {
                noticeDto.add(new NoticeDto(board));
            }
        }

        return noticeDto;
    }

    @Override
    public List<List<HrmsSignDto>> getHrmsSignDtoList(int empno) {


        List<List<HrmsSignDto>> result = new ArrayList();

        List<HrmsSignDto> receiveList = new ArrayList<>();
        List<HrmsSignDto> doneList = new ArrayList<>();

        //필요한 데이터 가져오기
        List<ExpendInformationVO> evo = homeMapper.getExpandInformationList(empno);
        List<WorkTimeManagementVO> wvo = homeMapper.getWorkTimeManagementList(empno);

        //Vo를 Dto로 변환
        HrmsSignDto dto = new HrmsSignDto();

        for (int i = 0; i < evo.size(); i++) {
            if(evo.get(i).getDvappyn().equals("w")){
                receiveList.add(new HrmsSignDto(evo.get(i)));
            }else {
                doneList.add(new HrmsSignDto(evo.get(i)));
            }
        }

        for (int i = 0; i < wvo.size(); i++) {
            if(wvo.get(i).getApproveryn().equals("w")){
                receiveList.add(new HrmsSignDto(wvo.get(i)));
            }else {
                doneList.add(new HrmsSignDto(wvo.get(i)));
            }
        }

        result.add(receiveList);
        result.add(doneList);

        return result;
    }

    @Override
    public List<FindEmployeeDto> getEmployeeList() {

        //사원 리스트 가져오기
        List<EmployeeVO> empList = homeMapper.getEmployeeList();

        //VO->Dto 변환
        List<FindEmployeeDto> result = empList.stream().map(FindEmployeeDto::new).collect(Collectors.toList());

        //데이터 반환
        return result;
    }
}


