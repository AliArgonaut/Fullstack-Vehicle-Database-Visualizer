package tech.springular_crud.employeemanager.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
@Data
public class VehicleDto {

    @NonNull
    private Long id;

    @NonNull
    private String brand;

    @NonNull
    private String model;

    @NonNull
    private String color;

    @NonNull
    private Integer year;

    @Setter
    @Getter
    private String imageUrl;

    public VehicleDto(long id, String brand, String model, String color, Integer year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public @NonNull Long getId() {
        return id;
    }

    public @NonNull String getBrand() {
        return brand;
    }

    public @NonNull String getModel() {
        return model;
    }

    public @NonNull String getColor() {
        return color;
    }

    public @NonNull Integer getYear() {
        return year;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public void setModel(@NonNull String model) {
        this.model = model;
    }

    public void setColor(@NonNull String color) {
        this.color = color;
    }

    public void setYear(@NonNull Integer year) {
        this.year = year;
    }

}
