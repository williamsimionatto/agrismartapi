package agrismart.com.agrismart.domain;

import agrismart.com.agrismart.dto.farm.AddFarmDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "farm")
public class Farm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @Column
    private String address;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pasture> pastures;

    public Farm(AddFarmDTO farm) {
        this.name = farm.getName();
        this.address = farm.getAddress();
    }
}
