package sjht.erp.common.vo;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterVO {
    private String usertype; // 유저 권한 종류
    private String username; // 유저 권한 이름
}
