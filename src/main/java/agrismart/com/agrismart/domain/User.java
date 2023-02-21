package agrismart.com.agrismart.domain;

import java.io.Serializable;

import agrismart.com.agrismart.domain.enums.Role;
import agrismart.com.agrismart.dto.user.AddUserDTO;
import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(name = "user_name", unique = true)
  private String userName;

  @NonNull
  @Column
  private String password;

  @NonNull
  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private Role role;

  @Nullable
  @Column(name = "farm_id")
  private Long farmId;

  public User(AddUserDTO data) {
    this.userName = data.getUserName();
    this.role = data.getRole();
    this.farmId = data.getFarmId();
  }
}
