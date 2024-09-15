package com.example.software_partner.cars_api.manufactures;

import com.example.software_partner.cars_api.cars.Car;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Manufacturer {
    @Id
    @GeneratedValue
    private int manufacturerId;
    @Column(unique = true)
    private String manufacturerName;

    @OneToMany(
            mappedBy = "manufacturer",
            cascade = CascadeType.ALL
    )
    private List<Car> cars;

}
