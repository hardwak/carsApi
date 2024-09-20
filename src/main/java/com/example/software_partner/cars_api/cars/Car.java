package com.example.software_partner.cars_api.cars;

import com.example.software_partner.cars_api.BaseEntity;
import com.example.software_partner.cars_api.manufactures.Manufacturer;
import com.example.software_partner.cars_api.owners.Owner;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Car extends BaseEntity {

    @Id
    @GeneratedValue
    private Integer carId;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    private String model;
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

}
