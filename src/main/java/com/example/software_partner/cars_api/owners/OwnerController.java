package com.example.software_partner.cars_api.owners;

import com.example.software_partner.cars_api.owners.dto.OwnerCreationDTO;
import com.example.software_partner.cars_api.owners.dto.OwnerResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/v1/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerResponseDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping
    public OwnerCreationDTO addOwner(@Valid @RequestBody OwnerCreationDTO ownerCreationDTO) {
        return ownerService.createOwner(ownerCreationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable int id) {
        ownerService.deleteOwner(id);
    }

    @GetMapping("/{id}")
    public OwnerResponseDTO getOwner(@PathVariable int id) {
        return ownerService.getOwnerById(id);
    }

    @GetMapping("/search/{lastname}")
    public List<OwnerResponseDTO> searchOwner(@PathVariable String lastname) {
        return ownerService.getOwnersByLastname(lastname);
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
