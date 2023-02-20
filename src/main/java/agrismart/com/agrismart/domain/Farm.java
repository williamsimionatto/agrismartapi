package agrismart.com.agrismart.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import agrismart.com.agrismart.dto.AddFarmDTO;

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

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pasture> pastures = new ArrayList<>();

    public Farm(AddFarmDTO farm) {
        this.name = farm.getName();
        this.address = farm.getAddress();
    }
}
