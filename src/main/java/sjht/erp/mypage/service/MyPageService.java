package sjht.erp.mypage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sjht.erp.common.vo.EmployeeVO;
import sjht.erp.common.vo.FileVO;
import sjht.erp.hrms.dto.SelectDto;
import sjht.erp.hrms.repository.HrmsMapper;
import sjht.erp.mypage.dto.MyPageUpdateDto;
import sjht.erp.mypage.repository.MyPageMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MyPageMapper myPageMapper;
    private final HrmsMapper hrmsMapper;
    private final PasswordEncoder passwordEncoder;

    // 내 정보 수정
    public void updateEmpData(MyPageUpdateDto dto) {
        System.out.println(dto.getPassword());
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        myPageMapper.updateEmpData(dto);
    }


    public SelectDto getMyInfo(int empno) {

        SelectDto result;

        //사원 데이터 가져오기
        EmployeeVO evo = hrmsMapper.getEmpList().get(empno-1);

        //파일 데이터 가져오기
        FileVO fvo = hrmsMapper.getIdPicture().get(empno-1);

        //dto -> vo 변환
        result = new SelectDto(evo, fvo);

        return result;
    }
}
