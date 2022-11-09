package sjht.erp.expendHistory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sjht.erp.expendHistory.dto.SelectParameterEHDto;
import sjht.erp.expendHistory.dto.SelectResultEHDto;
import sjht.erp.expendHistory.service.ExpendHistoryService;
import sjht.erp.expendInformation.dto.SelectParameterEIDto;
import sjht.erp.expendInformation.dto.SelectResultEIDto;
import sjht.erp.expendInformation.service.ExpendInformationService;
import sjht.erp.login.dto.EmployeeDto;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpendHistoryRestController {

    private final ExpendHistoryService service;

    @PostMapping("/api/expendHistoryParam")
    public ResponseEntity<List<SelectResultEHDto>> expendParam(@RequestBody HashMap<String, String> map){
        System.out.println("expendParam before");
        List<SelectResultEHDto> result = service.selectByCondition(map);
        System.out.println("result = " + result);
        System.out.println("expendParam after");
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/api/expendHistoryEno")
    public ResponseEntity<List<SelectResultEHDto>> expendEno(@RequestBody HashMap<String, String> map){
        List<SelectResultEHDto> result = service.selectEHByEno(map.get("modalEno"));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/api/expendHistorySummary")
    public ResponseEntity<List<SelectResultEHDto>> expendSummary(@RequestBody HashMap<String, String> map){
        List<SelectResultEHDto> result = service.selectSummary(map);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
