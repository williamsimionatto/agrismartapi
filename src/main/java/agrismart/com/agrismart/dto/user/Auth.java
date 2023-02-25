package agrismart.com.agrismart.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auth implements Serializable {
    @NotNull(message = "Username cannot be null")
    @JsonProperty("username")
    private String userName;

    @NotNull(message = "Password cannot be null")
    @JsonProperty("password")
    private String password;
}
