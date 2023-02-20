package agrismart.com.agrismart.domain;

import java.io.Serializable;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pasture")
public class Pasture implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(nullable = false)
  private String name;

  @NonNull
  @Column(nullable = false)
  private Double area;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "farm_id", nullable = false)
  private Farm farm;
}
