package hr.tvz.sirac.rentacarapp.repo;

import hr.tvz.sirac.rentacarapp.models.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    List<Vehicle> findAll();
    Optional<Vehicle> findVehicleByCode(String code);
    List<Vehicle> save(Vehicle vehicle);

    boolean delete(Vehicle vehicle);
}
