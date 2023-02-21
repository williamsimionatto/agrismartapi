package agrismart.com.agrismart.domain.enums;

public enum Role {
  ADMIN("ADMIN"),
  VET("VET"),
  FARMER("FARMER");

  private String role;

  private Role(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }
}
