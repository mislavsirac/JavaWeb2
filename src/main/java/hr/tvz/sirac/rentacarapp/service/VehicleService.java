package hr.tvz.sirac.rentacarapp.service;

import hr.tvz.sirac.rentacarapp.models.Vehicle;
import hr.tvz.sirac.rentacarapp.models.VehicleDTO;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();
    VehicleDTO findVehicleByCode(String code);
    boolean checkForDuplicate(Vehicle vehicle);
    void save(Vehicle vehicle);
    boolean deleteByRegistration(Vehicle vehicle);
    Vehicle findByRegistration(String registration);
    Vehicle findByChassisNumber(String chassisNumber);
}
