package com.example.software_partner.cars_api.manufactures;

import com.example.software_partner.cars_api.BaseEntity;
import com.example.software_partner.cars_api.cars.Car;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Manufacturer extends BaseEntity {
    @Id
    @GeneratedValue
    private Integer manufacturerId;
    @Column(unique = true)
    private String manufacturerName;

    @OneToMany(
            mappedBy = "manufacturer",
            cascade = CascadeType.ALL
    )
    private List<Car> cars;

}
