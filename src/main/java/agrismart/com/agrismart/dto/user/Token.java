package agrismart.com.agrismart.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {
    private String userName;
    private Boolean authenticated;
    private Date createdAt;
    private Date expiration;
    private String accessToken;
    private String refreshToken;
}
