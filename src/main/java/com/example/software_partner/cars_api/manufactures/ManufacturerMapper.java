package com.example.software_partner.cars_api.manufactures;

import com.example.software_partner.cars_api.manufactures.dto.ManufacturerDTO;
import com.example.software_partner.cars_api.manufactures.dto.ManufacturerFullDTO;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerMapper {
    public Manufacturer toManufacturer(ManufacturerDTO dto) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerName(dto.manufacturerName());
        return manufacturer;
    }

    public ManufacturerDTO toManufacturerDTO(Manufacturer manufacturer) {
        if (manufacturer == null) {
            return null;
        }
        return new ManufacturerDTO(manufacturer.getManufacturerName());
    }

    public ManufacturerFullDTO toManufacturerFullDTO(Manufacturer manufacturer) {
        return new ManufacturerFullDTO(
                manufacturer.getManufacturerId(),
                manufacturer.getManufacturerName()
        );
    }
}
