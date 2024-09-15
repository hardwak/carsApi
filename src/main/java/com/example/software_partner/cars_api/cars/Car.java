package com.example.software_partner.cars_api.cars;

import com.example.software_partner.cars_api.manufactures.Manufacturer;
import com.example.software_partner.cars_api.owners.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Car {

    @Id
    @GeneratedValue
    private int carId;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    private String model;
    private int year;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

}
