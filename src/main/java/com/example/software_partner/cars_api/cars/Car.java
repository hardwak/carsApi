package com.example.software_partner.cars_api.cars;

import com.example.software_partner.cars_api.manufactures.Manufacturer;
import com.example.software_partner.cars_api.owners.Owner;
import jakarta.persistence.*;

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

    public Car() {}

    public Car(int carId, Manufacturer manufacturer, String model, int year, Owner owner) {
        this.carId = carId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
