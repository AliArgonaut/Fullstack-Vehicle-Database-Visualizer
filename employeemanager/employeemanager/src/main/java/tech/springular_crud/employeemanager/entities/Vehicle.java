package tech.springular_crud.employeemanager.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
    )
    private Long id;

    @Column
    private String  brand;

    @Column
    private String model;

    @Column
    private String color;

    @Column
    private Integer year;

    @Column
    private String imageUrl;

}
