package sjht.erp.paymanage.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjht.erp.hrms.dto.UpdateDto;
import sjht.erp.paymanage.dto.PayEmpDto;
import sjht.erp.paymanage.service.PayManageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PayManageApiController {

    final PayManageService payManageservice;

    @PostMapping("/api/hrms/payemplist")
    public ResponseEntity<List<PayEmpDto>> getPayEmpList(){
        List<PayEmpDto> list = payManageservice.getPayEmpList();

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/api/hrms/paysalary")
    public void paySalary(@RequestBody List<PayEmpDto> payEmpDtoList){

        payManageservice.payEmpDto(payEmpDtoList);
    }
}
