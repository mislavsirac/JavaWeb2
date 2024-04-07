package hr.tvz.sirac.rentacarapp.controllers;

import hr.tvz.sirac.rentacarapp.models.Vehicle;
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

    @GetMapping("/search/by-registration/{registration}")
    public ResponseEntity<Vehicle> getVehicleByRegistration(@PathVariable String registration) {
        Vehicle vehicle = vehicleService.findByRegistration(registration);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/by-chassis-number/{chassisNumber}")
    public ResponseEntity<Vehicle> getVehicleByChassisNumber(@PathVariable String chassisNumber) {
        Vehicle vehicle = vehicleService.findByChassisNumber(chassisNumber);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addVehicle(@Valid @RequestBody Vehicle vehicle) {
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
        boolean isDeleted = vehicleService.deleteByRegistration(registration);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
