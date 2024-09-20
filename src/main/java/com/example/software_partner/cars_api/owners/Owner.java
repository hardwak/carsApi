package com.example.software_partner.cars_api.owners;

import com.example.software_partner.cars_api.BaseEntity;
import com.example.software_partner.cars_api.cars.Car;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Owner extends BaseEntity {
    @Id
    @GeneratedValue
    private Integer ownerId;
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    @Column(unique = true)
    private String phone;
    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL
    )
    private List<Car> cars;

    public Owner(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}
