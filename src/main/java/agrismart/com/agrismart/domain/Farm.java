package agrismart.com.agrismart.domain;

import java.util.ArrayList;
import java.util.List;

import agrismart.com.agrismart.dto.farm.AddFarmDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

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

    public Farm(AddFarmDTO farm) {
        this.name = farm.getName();
        this.address = farm.getAddress();
    }
}
