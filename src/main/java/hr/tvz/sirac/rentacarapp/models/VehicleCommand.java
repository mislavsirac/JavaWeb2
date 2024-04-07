package hr.tvz.sirac.rentacarapp.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class VehicleCommand {
    @NotBlank(message = "Vehicle code cannot be blank")
    private String vehicleCode;

    @PositiveOrZero(message = "Maximum number of passengers must be positive or zero")
    private int maxNumberOfPassengers;

    @NotBlank(message = "Transmission cannot be blank")
    private String transmission;

    @NotNull(message = "Air conditioning information must be provided")
    private Boolean airConditioning;

    @PositiveOrZero(message = "Number of doors must be positive or zero")
    private int numberOfDoors;

    @NotBlank(message = "Fuel type cannot be blank")
    private String fuelType;

    @NotNull(message = "Last service date must be provided")
    private LocalDate lastServiceDate;

    @NotNull(message = "Next service date must be provided")
    private LocalDate nextServiceDate;

    @PositiveOrZero(message = "Mileage must be positive or zero")
    private int mileage;

    @NotBlank(message = "Registration cannot be blank")
    @Pattern(regexp = "^[A-Z0-9-]+$", message = "Registration contains invalid characters")
    private String registration;

    @NotBlank(message = "Chassis number cannot be blank")
    private String chassisNumber;
}
