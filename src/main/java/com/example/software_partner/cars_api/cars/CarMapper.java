package com.example.software_partner.cars_api.cars;

import com.example.software_partner.cars_api.cars.dto.CarDTO;
import com.example.software_partner.cars_api.cars.dto.CarResponseDTO;
import com.example.software_partner.cars_api.manufactures.Manufacturer;
import com.example.software_partner.cars_api.manufactures.dto.ManufacturerDTO;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {
    public Car toCar(CarDTO dto, ManufacturerDTO manufacturerDTO) {
        Car car = new Car();
        car.setModel(dto.model());
        car.setYear(dto.year());

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerId(dto.manufacturerId());
        manufacturer.setManufacturerName(manufacturerDTO.manufacturerName());
        car.setManufacturer(manufacturer);

        return car;
    }

    public CarResponseDTO toCarResponseDTO(Car car) {
        if (car == null)
            return null;

        return new CarResponseDTO(car.getModel(), car.getYear(), car.getManufacturer().getManufacturerName());
    }
}
