package sjht.erp.common.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {

    private int empno; // 사원번호
    private String password; // 비밀번호
    private BankCodeVO bankcd; // fk 은행코드
    private DepartmentCodeVO departmentcd; // fk 부서코드
    private GradeCodeVO gradecd; // fk 직급코드
    private UserMasterVO usertype; // fk 권한코드
    private String name; // 사원이름
    private String gender; // 성별
    private String mail; // 이메일
    private String tel; // 전화번호
    private String zipcode; // 우편번호
    private String addr; // 주소
    private String addrdetail; // 상세주소
    private String regno; // 주민등록번호
    private String school; // 학력
    private LocalDateTime entrydate; // 입사일자
    private LocalDateTime retiredate; // 퇴사일자
    private int yearsalary; // 연봉
    private int salary; // 월급
    private int retirementpay; // 퇴직금
    private String account; // 계좌번호
    private String memo; // 비고
    private String retireyn; // 퇴직여부 -- y -> 퇴직 n -> 퇴직x
    private String restyn; // 휴직여부
    private int privateinsurance; // 사대보험
    private Date paymentst; // 마지막 지급 날짜
    private int totalal; // 총연차
    private int useal; // 사용연차
    private String retirenote; // 퇴사사유
}
