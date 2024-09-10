package com.example.software_partner.cars_api.manufactures;

import com.example.software_partner.cars_api.manufactures.dto.ManufacturerDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/manufacturers")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public List<ManufacturerDTO> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    @PostMapping
    public ManufacturerDTO addManufacturer(@Valid @RequestBody ManufacturerDTO manufacturerDTO) {
        return manufacturerService.createManufacturer(manufacturerDTO);
    }

    @GetMapping("/{id}")
    public ManufacturerDTO getManufacturerById(@PathVariable int id) {
        return manufacturerService.getManufacturerById(id);
    }

    @GetMapping("/search/{name}")
    public List<ManufacturerDTO> searchManufacturerByName(@PathVariable String name) {
        return manufacturerService.getManufacturerByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteManufacturerById(@PathVariable int id) {
        manufacturerService.deleteManufacturerById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ){
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
