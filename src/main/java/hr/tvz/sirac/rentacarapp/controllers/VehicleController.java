package hr.tvz.sirac.rentacarapp.controllers;

import hr.tvz.sirac.rentacarapp.models.Vehicle;
import hr.tvz.sirac.rentacarapp.models.VehicleCommand;
import hr.tvz.sirac.rentacarapp.models.VehicleDTO;
import hr.tvz.sirac.rentacarapp.service.VehicleService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vehicles") // Base path for all handlers in this controller
public class VehicleController {

    private static final Logger log = LoggerFactory.getLogger(VehicleController.class);
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{code}")
    public ResponseEntity<VehicleDTO> getVehicleByCode(@PathVariable String code) {
        VehicleDTO vehicleDTO = vehicleService.findVehicleByCode(code);
        if (vehicleDTO != null) {
            log.info("Succesfully got the object");
            return ResponseEntity.ok(vehicleDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/registration/{registration}")
    public ResponseEntity<Vehicle> getVehicleByRegistration(@PathVariable String registration) {
        Vehicle vehicle = vehicleService.findByRegistration(registration);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/chassis/{chassisNumber}")
    public ResponseEntity<Vehicle> getVehicleByChassisNumber(@PathVariable String chassisNumber) {
        Vehicle vehicle = vehicleService.findByChassisNumber(chassisNumber);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addVehicle(@Valid @RequestBody VehicleCommand validVehicleCommand) {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleCode(validVehicleCommand.getVehicleCode());
        vehicle.setMaxNumberOfPassengers(validVehicleCommand.getMaxNumberOfPassengers());
        vehicle.setTransmission(validVehicleCommand.getTransmission());
        vehicle.setAirConditioning(validVehicleCommand.getAirConditioning());
        vehicle.setNumberOfDoors(validVehicleCommand.getNumberOfDoors());
        vehicle.setFuelType(validVehicleCommand.getFuelType());
        vehicle.setLastServiceDate(validVehicleCommand.getLastServiceDate());
        vehicle.setNextServiceDate(validVehicleCommand.getNextServiceDate());
        vehicle.setMileage(validVehicleCommand.getMileage());
        vehicle.setRegistration(validVehicleCommand.getRegistration());
        vehicle.setChassisNumber(validVehicleCommand.getChassisNumber());

        boolean isDuplicate = vehicleService.checkForDuplicate(vehicle);
        if (isDuplicate) {
            return new ResponseEntity<>("Duplicate vehicle found (same registration or chassis number).", HttpStatus.CONFLICT);
        } else {
            vehicleService.save(vehicle);
            return new ResponseEntity<>("Vehicle added successfully", HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{registration}")
    public ResponseEntity<?> deleteVehicleByRegistration(@PathVariable String registration) {
        var vehicle = vehicleService.findByRegistration(registration);
        boolean isDeleted = vehicleService.deleteByRegistration(vehicle);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
