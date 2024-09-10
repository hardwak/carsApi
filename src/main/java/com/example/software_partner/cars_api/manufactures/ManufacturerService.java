package com.example.software_partner.cars_api.manufactures;

import com.example.software_partner.cars_api.manufactures.dto.ManufacturerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    public ManufacturerService(ManufacturerRepository manufacturerRepository, ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    public ManufacturerDTO createManufacturer(ManufacturerDTO manufacturer) {
        manufacturerRepository.save(manufacturerMapper.toManufacturer(manufacturer));
        return manufacturer;
    }

    public List<ManufacturerDTO> getAllManufacturers() {
        return manufacturerRepository
                .findAll()
                .stream()
                .map(manufacturerMapper::toManufacturerDTO)
                .toList();
    }

    public ManufacturerDTO getManufacturerById(int id) {
        return manufacturerMapper.toManufacturerDTO(manufacturerRepository.findById(id).orElse(null));
    }

    public List<ManufacturerDTO> getManufacturerByName(String name) {
        return manufacturerRepository.findAllByManufacturerNameContains(name)
                .stream()
                .map(manufacturerMapper::toManufacturerDTO)
                .toList();
    }

    public void deleteManufacturerById(int id) {
        manufacturerRepository.deleteById(id);
    }

}
