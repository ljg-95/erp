package sjht.erp.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sjht.erp.common.vo.EmployeeVO;
import sjht.erp.common.vo.FileVO;
import sjht.erp.hrms.dto.SelectDto;
import sjht.erp.hrms.dto.UpdateDto;
import sjht.erp.hrms.repository.HrmsMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HrmsApiServiceImpl implements HrmsApiService {

    private final HrmsMapper hrmsMapper;
    private final PasswordEncoder passwordEncoder;

    /* 사원 리스트 */
    @Override
    public List<SelectDto> getEmpList() {
        // 사원 리스트 VO로 가져오기
        // VO -> DTO
//        List<SelectDto> selectDtoList = hrmsMapper.getEmpList()
//                .stream()
//                .map(employeeVOList -> new SelectDto(employeeVOList))
//                .collect(Collectors.toList());
//        // 반환
//        return selectDtoList;






//        // 사원 리스트 VO로 가져오기
//        List<EmployeeVO> employeeVOList = hrmsMapper.getEmpList();
//        // 사원 사진 VO로 가져오기
//        List<FileVO> fileVOList = hrmsMapper.getIdPicture();
//        // empno이 같은 자료 추출하기
//        // VO -> DTO
//        List<SelectDto> selectDtoList =  employeeVOList.stream().filter(emp -> fileVOList.stream().anyMatch(file -> emp.getEmpno() == file.getEmpno() ))
//                .map( (employeeVO, fileVO) -> new SelectDto(employeeVO, fileVO))
//                .collect(Collectors.toList());
//        // 반환
//        return selectDtoList;




        // 사원 리스트 VO로 가져오기
        List<EmployeeVO> employeeVOList = hrmsMapper.getEmpList();

        // 사원 사진 VO로 가져오기
        List<FileVO> fileVOList = hrmsMapper.getIdPicture();
        // empno가 같은 자료 추출하기
        // VO -> DTO
        List<SelectDto> selectDtoList = new ArrayList<SelectDto>();

        for (int i=0; i<employeeVOList.size(); i++) {
           if ( employeeVOList.get(i).getEmpno() == fileVOList.get(i).getEmpno() ) {
               selectDtoList.add(new SelectDto(employeeVOList.get(i), fileVOList.get(i)));
           }
        }
        // 반환
        return selectDtoList;
    }

    /* 사원 등록 (회계,총무) */
    @Override
    public void registEmp(UpdateDto updateDto) {
        // 비밀 번호 등록시 인코딩
        updateDto.setPassword(passwordEncoder.encode(updateDto.getPassword()));





        // 퇴직날짜 null로 셋팅 ???????????? 꼮 해줘야 널 로 들어가나? 안해줘도 널로 들어가나? /

        // Vo로 바꿔서 저장할까?


        updateDto.setRetiredate(null);
        // DB로 저장
        hrmsMapper.registEmp(updateDto);
    }

    /* 사원 등록 시 사번 보여주기 */
    public int getEmpno() {
        // 사번 요청 및 반환
        return hrmsMapper.getEmpno();
    }

    /* 사원 정보 수정 */
    @Override
    public void updateEmp(UpdateDto updateDto) {



        // DB로 갱신
        hrmsMapper.updateEmp(updateDto);
    }

    /* 부서 리스트 */
    @Override
    public List<SelectDto> getDepartmentList() {
        // 부서 리스트 불러오기
        // VO -> DTO
        List<SelectDto> selectDtoList = hrmsMapper.getDepartmentList()
                .stream()
                .map(departmentList -> new SelectDto(departmentList))
                .collect(Collectors.toList());
        // 반환
        return selectDtoList;
    }

    /* 직급 리스트 */
    @Override
    public List<SelectDto> getGradeList() {
        // 직급 리스트 불러오기
        // VO -> DTO
        List<SelectDto> selectDtoList = hrmsMapper.getGradeList()
                .stream()
                .map(gradeList -> new SelectDto(gradeList))
                .collect(Collectors.toList());
        // 반환
        return selectDtoList;
    }

    /* 은행 리스트 */
    @Override
    public List<SelectDto> getBankList() {
        // 은행 리스트 불러오기
        // VO -> DTO
        List<SelectDto> selectDtoList = hrmsMapper.getBankList()
                .stream()
                .map(bankList -> new SelectDto(bankList))
                .collect(Collectors.toList());
        // 반환
        return selectDtoList;
    }

    /* 권한 리스트 */
    @Override
    public List<SelectDto> getUserMasterList() {
        // 권한 리스트 불러오기
        // VO -> DTO
        List<SelectDto> selectDtoList = hrmsMapper.getUserMasterList()
                .stream()
                .map(userMasterList -> new SelectDto(userMasterList))
                .collect(Collectors.toList());
        // 반환
        return selectDtoList;
    }




}
