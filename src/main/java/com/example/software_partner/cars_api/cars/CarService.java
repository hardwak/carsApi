package com.example.software_partner.cars_api.cars;

import com.example.software_partner.cars_api.cars.dto.CarCreationDTO;
import com.example.software_partner.cars_api.cars.dto.CarResponseDTO;
import com.example.software_partner.cars_api.cars.dto.CarWithOwnerDTO;
import com.example.software_partner.cars_api.manufactures.ManufacturerService;
import com.example.software_partner.cars_api.manufactures.dto.ManufacturerDTO;
import com.example.software_partner.cars_api.owners.Owner;
import com.example.software_partner.cars_api.owners.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarsRepository carsRepository;
    private final CarMapper carMapper;
    private final OwnerRepository ownerRepository;
    private final ManufacturerService manufacturerService;

    public CarService(CarsRepository carsRepository, CarMapper carMapper, OwnerRepository ownerRepository, ManufacturerService manufacturerService) {
        this.carsRepository = carsRepository;
        this.carMapper = carMapper;
        this.ownerRepository = ownerRepository;
        this.manufacturerService = manufacturerService;
    }

    public CarResponseDTO addCar(CarCreationDTO carDTO) {
        ManufacturerDTO manufacturer = manufacturerService.getManufacturerById(carDTO.manufacturerId());
        carsRepository.save(carMapper.toCar(carDTO, manufacturer));
        return carMapper.toCarResponseDTO(carMapper.toCar(carDTO, manufacturer));
    }

    public List<CarResponseDTO> getAllCars() {
        return carsRepository.findAll()
                .stream()
                .map(carMapper::toCarResponseDTO)
                .toList();
    }

    public void deleteCarById(int id) {
        carsRepository.deleteById(id);
    }

    public CarResponseDTO getCarById(int id) {
        return carMapper.toCarResponseDTO(carsRepository.findById(id).orElse(null));
    }

    public List<CarResponseDTO> getCarsByYear(int year) {
        return carsRepository.findAllByYear(year)
                .stream()
                .map(carMapper::toCarResponseDTO)
                .toList();
    }

    @Transactional
    public CarWithOwnerDTO setOwnerForCar(int id, int ownerId) {
        Car car = carsRepository.findById(id).orElse(null);
        Owner owner = ownerRepository.findById(ownerId).orElse(null);
        if (car == null || owner == null) {
            // throw 404 not found
            return null;
        }

        car.setOwner(owner);
        carsRepository.save(car);

        return new CarWithOwnerDTO(
                car.getModel(),
                car.getYear(),
                car.getManufacturer().getManufacturerName(),
                car.getOwner().getFirstName() + " " + car.getOwner().getLastName());
    }
}
