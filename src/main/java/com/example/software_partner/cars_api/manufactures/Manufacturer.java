package com.example.software_partner.cars_api.manufactures;

import com.example.software_partner.cars_api.cars.Car;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue
    private int manufacturerId;
    private String manufacturerName;

    @OneToMany(
            mappedBy = "manufacturer",
            cascade = CascadeType.ALL
    )
    private List<Car> cars;

    public Manufacturer() {}

    public Manufacturer(int manufacturerId, String manufacturerName, List<Car> cars) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
        this.cars = cars;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
