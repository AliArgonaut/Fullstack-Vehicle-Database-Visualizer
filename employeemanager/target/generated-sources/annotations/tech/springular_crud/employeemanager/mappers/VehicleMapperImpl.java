package tech.springular_crud.employeemanager.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.springular_crud.employeemanager.dtos.VehicleDto;
import tech.springular_crud.employeemanager.entities.Vehicle;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T06:08:29-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public Vehicle toVehicle(VehicleDto vehicleDto) {
        if ( vehicleDto == null ) {
            return null;
        }

        Vehicle.VehicleBuilder vehicle = Vehicle.builder();

        vehicle.id( vehicleDto.getId() );
        vehicle.brand( vehicleDto.getBrand() );
        vehicle.model( vehicleDto.getModel() );
        vehicle.color( vehicleDto.getColor() );
        vehicle.year( vehicleDto.getYear() );
        vehicle.imageUrl( vehicleDto.getImageUrl() );

        return vehicle.build();
    }

    @Override
    public VehicleDto toVehicleDto(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleDto.VehicleDtoBuilder vehicleDto = VehicleDto.builder();

        vehicleDto.id( vehicle.getId() );
        vehicleDto.brand( vehicle.getBrand() );
        vehicleDto.model( vehicle.getModel() );
        vehicleDto.color( vehicle.getColor() );
        vehicleDto.year( vehicle.getYear() );
        vehicleDto.imageUrl( vehicle.getImageUrl() );

        return vehicleDto.build();
    }

    @Override
    public List<VehicleDto> toVehicleDtos(List<Vehicle> vehicles) {
        if ( vehicles == null ) {
            return null;
        }

        List<VehicleDto> list = new ArrayList<VehicleDto>( vehicles.size() );
        for ( Vehicle vehicle : vehicles ) {
            list.add( toVehicleDto( vehicle ) );
        }

        return list;
    }

    @Override
    public void updateVehicle(Vehicle target, Vehicle source) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setBrand( source.getBrand() );
        target.setModel( source.getModel() );
        target.setColor( source.getColor() );
        target.setYear( source.getYear() );
        target.setImageUrl( source.getImageUrl() );
    }
}
