package sjht.erp.workinfo.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class WorkInfoRequestDto {
    private String approveryn;
    private LocalDateTime start;
    private LocalDateTime end;
    private String name;
    private int empno;

    public WorkInfoRequestDto() {
        this.approveryn = "w";
    }

    public WorkInfoRequestDto(String approveryn) {
        this.approveryn = approveryn;
    }

    public WorkInfoRequestDto(String approveryn, LocalDateTime start, LocalDateTime end) {
        this.approveryn = approveryn;
        if (start.isBefore(end)) {
            this.start = start;
            this.end = end;
        }
    }

    public WorkInfoRequestDto(String approveryn, String name) {
        this.approveryn = approveryn;
        if (name.equals("")) {
            this.name = name;
        }
    }

    public WorkInfoRequestDto(String approveryn, int empno) {
        this.approveryn = approveryn;
        if (empno != 0) {
            this.empno = empno;
        }
    }

    public WorkInfoRequestDto(String approveryn, LocalDateTime start, LocalDateTime end, String name) {
        this.approveryn = approveryn;
        if (start.isBefore(end)) {
            this.start = start;
            this.end = end;
        }
        if (name.equals("")) {
            this.name = name;
        }
    }

    public WorkInfoRequestDto(String approveryn, String name, int empno) {
        this.approveryn = approveryn;
        if (name.equals("")) {
            this.name = name;
        }
        if (empno != 0) {
            this.empno = empno;
        }
    }

    public WorkInfoRequestDto(String approveryn, LocalDateTime start, LocalDateTime end, String name, int empno) {
        this.approveryn = approveryn;
        if (start.isBefore(end)) {
            this.start = start;
            this.end = end;
        }
        if (name.equals("")) {
            this.name = name;
        }
        if (empno != 0) {
            this.empno = empno;
        }
    }
}
