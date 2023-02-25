package agrismart.com.agrismart.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import agrismart.com.agrismart.domain.enums.Role;
import agrismart.com.agrismart.dto.user.AddUserDTO;
import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User implements UserDetails, Serializable {
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

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "user_permission",
    joinColumns = {@JoinColumn (name = "user_id")},
    inverseJoinColumns = {@JoinColumn (name = "permission_id")}
  )
  private List<Permission> permissions = new ArrayList<Permission>();

  public User(AddUserDTO data) {
    this.userName = data.getUserName();
    this.role = data.getRole();
    this.farmId = data.getFarmId();
  }

  public List<String> getRoles() {
      List<String> roles = new ArrayList<>();
      for (Permission permission : permissions) {
        roles.add(permission.getSlug());
      }

      return roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.permissions;
  }

  @Override
  public String getUsername() {
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
