package sjht.erp.hrms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sjht.erp.common.vo.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SelectDto {

    /*  Employee */
    private int empno; // 사원번호
    private String password;
    private String name; // 사원이름
    private String gender; // 성별
    private String mail; // 이메일
    private String tel; // 전화번호
    private String zipcode; // 우편번호
    private String addr; // 주소
    private String addrdetail; // 상세주소
    private String regno; // 주민번호
    private String school; // 학력
    private String entrydate; // 입사일자
    private String retiredate; // 퇴사일자
    private int yearsalary; // 연봉
    private int salary; // 월급
    private int retirementpay; // 퇴직금
    private String account; // 계좌번호
    private String memo; // 비고
    private String retireyn; // 퇴직여부 -- y -> 퇴직 n -> 퇴직x
    private String restyn; // 휴직여부
    private int privateinsurance; // 사대보험
    private Date paymentst; // 지급여부
    private int totalal; // 총연차
    private int useal; // 사용연차
    private String retirenote; // 퇴사사유

    /* BankCode */
    private String bankcd;
    private String bankname;

    /* DepartmentCode */
    private String departmentcd;
    private String departmentname;

    /* GradeCode */
    private String gradecd;
    private String gradename;

    /* UserMaster */
    private String usertype;
    private String username;

    /* File */
    private int fileno; // pk 파일번호
    private String filename; // 파일이름
    private String physicalpath; // 물리경로
    private String relatedpath; // 상대경로
    private int filesize; // 파일사이즈
    //private int empno; // fk 사원번호
    private String kind; // 파일종류
    private int dno; //

    /* employeeVO, fileVO -> SelectDto */
    public SelectDto(EmployeeVO employeeVO, FileVO fileVO) {

        this.empno = employeeVO.getEmpno();
        this.password = employeeVO.getPassword();
        this.name = employeeVO.getName();
        this.gender = employeeVO.getGender();
        this.mail = employeeVO.getMail();
        this.tel = employeeVO.getTel();
        this.zipcode = employeeVO.getZipcode();
        this.addr = employeeVO.getAddr();
        this.addrdetail = employeeVO.getAddrdetail();
        this.regno = employeeVO.getRegno();
        this.school = employeeVO.getSchool();
        this.yearsalary = employeeVO.getYearsalary();
        this.salary = employeeVO.getSalary();
        this.retirementpay = employeeVO.getRetirementpay();
        this.account = employeeVO.getAccount();
        this.memo = employeeVO.getMemo();
        this.retireyn = employeeVO.getRetireyn();
        this.restyn = employeeVO.getRestyn();
        this.privateinsurance = employeeVO.getPrivateinsurance();
        this.paymentst = employeeVO.getPaymentst();
        this.totalal = employeeVO.getTotalal();
        this.useal = employeeVO.getUseal();
        this.retirenote = employeeVO.getRetirenote();

        // entrydate 초기화 시 null 체크
        if (employeeVO.getEntrydate() == null) {
            this.entrydate = "";
        } else {
            this.entrydate = employeeVO.getEntrydate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        }

        // retiredate 초기화 시 null 체크
        if (employeeVO.getRetiredate() == null) {
            this.retiredate = "";
        } else {
            this.retiredate = employeeVO.getRetiredate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        }

        // Bank 초기화 시 null 체크
        if (employeeVO.getBankcd() == null) {
            this.bankcd = "";
            this.bankname = "";
        } else {
            this.bankcd = employeeVO.getBankcd().getBankcd();
            this.bankname = employeeVO.getBankcd().getBankname();
        }

        // Department 초기화 시 null 체크
        if (employeeVO.getDepartmentcd() == null) {
            this.departmentcd = "";
            this.departmentname = "";
        } else {
            this.departmentcd = employeeVO.getDepartmentcd().getDepartmentcd();
            this.departmentname = employeeVO.getDepartmentcd().getDepartmentname();
        }

        // Grade 초기화 시 null 체크
        if (employeeVO.getGradecd() == null) {
            this.gradecd = "";
            this.gradename = "";
        } else {
            this.gradecd = employeeVO.getGradecd().getGradecd();
            this.gradename = employeeVO.getGradecd().getGradename();
        }

        // UserMaster 초기화 시 null 체크
        if (employeeVO.getUsertype() == null) {
            this.usertype = "";
            this.username = "";
        } else {
            this.usertype = employeeVO.getUsertype().getUsertype();
            this.username = employeeVO.getUsertype().getUsername();
        }

        // FileVO 초기화 시 null 체크
        if (fileVO == null) {
            this.fileno = -1;
            this.filename = "";
            this.physicalpath = "";
            this.relatedpath = "";
            this.filesize = -1;
            this.kind = "";
            this.dno = -1;
        } else {
            this.fileno =  fileVO.getFileno();
            this.filename = fileVO.getFilename();
            this.physicalpath = fileVO.getPhysicalpath();
            this.relatedpath = fileVO.getRelatedpath();
            this.filesize = fileVO.getFilesize();
            this.kind = fileVO.getKind();
            this.dno = fileVO.getDno();
        }
    }

    /* DepartmentCodeVO -> SelectDto
    * 부서코드 가져오기 */
    public SelectDto(DepartmentCodeVO departmentCodeVO) {
        this.departmentcd = departmentCodeVO.getDepartmentcd();
        this.departmentname = departmentCodeVO.getDepartmentname();
    }

    /* GradeCodeVO -> SelectDto
    *  직급코드 가져오기 */
    public SelectDto(GradeCodeVO gradeCodeVO) {
        this.gradecd = gradeCodeVO.getGradecd();
        this.gradename = gradeCodeVO.getGradename();
    }

    /* BankCodeVO -> SelectDto
     *  은행코드 가져오기 */
    public SelectDto(BankCodeVO bankCodeVO) {
        this.bankcd = bankCodeVO.getBankcd();
        this.bankname = bankCodeVO.getBankname();
    }

    /* UserMasterVO -> SelectDto
     *  권한코드 가져오기 */
    public SelectDto(UserMasterVO userMasterVO) {
        this.usertype = userMasterVO.getUsertype();
        this.username = userMasterVO.getUsername();
    }

    public SelectDto(EmployeeVO employeeVO, Object fileVO) {
    }
}