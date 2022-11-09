package sjht.erp.mypage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sjht.erp.common.vo.*;

import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyPageUpdateDto {

    /*  Employee */
    private int empno; // 사원번호
    private String password;
    private String mail; // 이메일
    private String tel; // 전화번호
    private String zipcode; // 우편번호
    private String addr; // 주소
    private String addrdetail; // 상세주소
    private String account; // 계좌번호
    private String bankcd;

}
