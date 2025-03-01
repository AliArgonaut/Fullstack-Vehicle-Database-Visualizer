package tech.springular_crud.employeemanager.mappers;

import org.mapstruct.Mapping;
import tech.springular_crud.employeemanager.dtos.VehicleDto;
import tech.springular_crud.employeemanager.entities.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    Vehicle toVehicle(VehicleDto vehicleDto);
    VehicleDto toVehicleDto(Vehicle vehicle);
    List<VehicleDto> toVehicleDtos(List<Vehicle> vehicles);

    void updateVehicle(@MappingTarget Vehicle target, Vehicle source);
}