package agrismart.com.agrismart.dto;

import java.io.Serializable;

import agrismart.com.agrismart.domain.Farm;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EditFarmDTO implements Serializable {
  @NotNull(message = "Name cannot be null")
  private String name;

  @NotNull(message = "Address cannot be null")
  private String address;

  public EditFarmDTO(Farm farm) {
    this.name = farm.getName();
    this.address = farm.getAddress();
  }
}