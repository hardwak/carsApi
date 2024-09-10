package com.example.software_partner.cars_api.manufactures;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    List<Manufacturer> findAllByManufacturerNameContains (String manufacturerName);
    Manufacturer findManufacturerByManufacturerName(String manufacturerName);
}
