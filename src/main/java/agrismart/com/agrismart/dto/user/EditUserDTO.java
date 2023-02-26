package agrismart.com.agrismart.dto.user;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import agrismart.com.agrismart.domain.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditUserDTO implements Serializable {
  @NotNull(message = "Username cannot be null")
  @JsonProperty("user_name")
  private String userName;

  @NotNull(message = "Role cannot be null")
  @JsonProperty("role")
  private Role role;

  @NotNull(message = "Farm cannot be null")
  @JsonProperty("farm_id")
  private Long farmId;
}
