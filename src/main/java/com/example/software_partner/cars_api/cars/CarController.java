package com.example.software_partner.cars_api.cars;

import com.example.software_partner.cars_api.cars.dto.CarCreationDTO;
import com.example.software_partner.cars_api.cars.dto.CarResponseDTO;
import com.example.software_partner.cars_api.cars.dto.CarWithOwnerDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponseDTO> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public CarResponseDTO addNewCar(@Valid @RequestBody CarCreationDTO dto){
        return carService.addCar(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id) {
        carService.deleteCarById(id);
    }

    @GetMapping("/{id}")
    public CarResponseDTO getCarById(@PathVariable Integer id) {
        return carService.getCarById(id);
    }

    @GetMapping("/production/{year}")
    public List<CarResponseDTO> getCarsByYear(@PathVariable Integer year) {
        return carService.getCarsByYear(year);
    }

    @PostMapping("/{id}")
    public CarWithOwnerDTO setOwner(@PathVariable Integer id, @RequestParam Integer ownerId) {
        return carService.setOwnerForCar(id, ownerId);
    }
}
