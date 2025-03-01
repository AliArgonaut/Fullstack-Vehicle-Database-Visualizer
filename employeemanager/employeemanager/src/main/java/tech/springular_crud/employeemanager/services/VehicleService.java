package tech.springular_crud.employeemanager.services;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.springular_crud.employeemanager.dtos.VehicleDto;
import tech.springular_crud.employeemanager.entities.Vehicle;
import tech.springular_crud.employeemanager.exceptions.AppException;
import tech.springular_crud.employeemanager.mappers.VehicleMapper;
import tech.springular_crud.employeemanager.repositories.VehicleRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleDto getVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));
        return vehicleMapper.toVehicleDto(vehicle);
    }

    public List<VehicleDto> allVehicles() {
        List<Vehicle> all = vehicleRepository.findAll();
        return vehicleMapper.toVehicleDtos(all);
    }

    public VehicleDto createVehicle(@Valid VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDto);
        Vehicle createdVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toVehicleDto(createdVehicle);
    }

    public VehicleDto deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));

        vehicleRepository.deleteById(id);

        return vehicleMapper.toVehicleDto(vehicle);
    }

    public VehicleDto updateVehicle(Long id, @Valid VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("vehicle not found", HttpStatus.NOT_FOUND));

        vehicleMapper.updateVehicle(vehicle, vehicleMapper.toVehicle(vehicleDto));

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toVehicleDto(updatedVehicle);

    }
}
