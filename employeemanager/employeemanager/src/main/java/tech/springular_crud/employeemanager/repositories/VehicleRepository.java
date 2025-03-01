package tech.springular_crud.employeemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.springular_crud.employeemanager.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}
