package com.example.software_partner.cars_api.cars;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByYear(int year);
}
