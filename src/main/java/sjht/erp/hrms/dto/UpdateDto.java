package sjht.erp.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDto {

    /* Employee */
    private int empno;
    private String password;
    private String bankcd; // fk
    private String departmentcd; // fk
    private String gradecd; // fk
    private String usertype; // fk
    private String name;
    private String gender;
    private String mail;
    private String tel;
    private String zipcode;
    private String addr;
    private String addrdetail;
    private String regno;
    private String school;
    private String entrydate;
    private String retiredate;
    private int yearsalary;
    private int salary;
    private int retirementpay;
    private String account;
    private String memo;
    private String retireyn; // 퇴직여부 -- y -> 퇴직 n -> 퇴직x
    private String restyn; // 휴직여부
    private int privateinsurance; // 보험
    private Date paymentst; // 월급 지급 여부
    private int totalal; // 총연차
    private int useal; // 사용연차
    private String retirenote; // 퇴사사유

    /* File */
    private int fileno; // pk 파일번호
    private String filename; // 파일이름
    private String physicalpath; // 물리경로
    private String relatedpath; // 상대경로
    private int filesize; // 파일사이즈
    // private int empno; // fk 사원번호
    private String kind; // 파일종류
    private int dno; // 결제번호

}
