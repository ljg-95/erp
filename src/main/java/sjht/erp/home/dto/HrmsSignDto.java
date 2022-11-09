package sjht.erp.home.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sjht.erp.common.vo.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HrmsSignDto {

    private String yn; //승인 여부
    private String regdate; //신청 날짜
    private String approvedate; //승인 날짜

    private String startdate; // 휴가 시작일

    private String enddate; // 휴가 종류일
    private int amt; // 신청 금액


    public HrmsSignDto(ExpendInformationVO vo){
        this.yn = vo.getDvappyn();
        if(vo.getDvregdate()==null){
            this.regdate="";
        }else{
            this.regdate=vo.getDvregdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(vo.getDvappdate()==null){
            this.approvedate="";
        }else{
            this.approvedate=vo.getDvappdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        this.amt = vo.getDvamt();
    }

    public HrmsSignDto(WorkTimeManagementVO vo){
        this.yn = vo.getApproveryn();
        if(vo.getRegistdate()==null){
            this.regdate="";
        }else{
            this.regdate=vo.getRegistdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(vo.getStartdate()==null){
            this.startdate="";
        }else{
            this.startdate=vo.getStartdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        if(vo.getEnddate()==null){
            this.enddate="";
        }else{
            this.enddate=vo.getEnddate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
    }
}
