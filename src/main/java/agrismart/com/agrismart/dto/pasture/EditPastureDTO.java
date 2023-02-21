package agrismart.com.agrismart.dto.pasture;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditPastureDTO implements Serializable {
  @NotNull(message = "Name cannot be null")
  @JsonProperty("name")
  private String name;

  @NotNull(message = "Address cannot be null")
  @JsonProperty("area")
  private Double area;

  @NotNull(message = "Farm cannot be null")
  @JsonProperty("farm_id")
  private Long farmId;
}
