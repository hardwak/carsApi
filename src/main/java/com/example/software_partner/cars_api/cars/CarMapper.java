package com.example.software_partner.cars_api.cars;

import com.example.software_partner.cars_api.cars.dto.CarCreationDTO;
import com.example.software_partner.cars_api.cars.dto.CarFullDTO;
import com.example.software_partner.cars_api.cars.dto.CarResponseDTO;
import com.example.software_partner.cars_api.manufactures.Manufacturer;
import com.example.software_partner.cars_api.manufactures.dto.ManufacturerDTO;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {
    public Car toCar(CarCreationDTO dto, ManufacturerDTO manufacturerDTO) {
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

    public CarFullDTO toCarFullDTO(Car car) {
        return new CarFullDTO(
                car.getCarId(),
                car.getModel(),
                car.getYear(),
                car.getManufacturer().getManufacturerId(),
                car.getManufacturer().getManufacturerName()
        );
    }
}
