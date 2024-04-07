package hr.tvz.sirac.rentacarapp.service;

import hr.tvz.sirac.rentacarapp.models.Vehicle;
import hr.tvz.sirac.rentacarapp.models.VehicleDTO;
import hr.tvz.sirac.rentacarapp.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public VehicleDTO findVehicleByCode(String code) {
        return vehicleRepository.findVehicleByCode(code)
                .map(this::convertToVehicleDTO)
                .orElse(null);
    }

    @Override
    public boolean checkForDuplicate(Vehicle vehicle) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().anyMatch(v ->
                v.getRegistration().equals(vehicle.getRegistration()) ||
                        v.getChassisNumber().equals(vehicle.getChassisNumber()));

    }

    @Override
    public void save(Vehicle vehicle) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        vehicles.add(vehicle);
    }

    @Override
    public boolean deleteByRegistration(String registration) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getRegistration().equals(registration)) {
                vehicles.remove(vehicle);
                return true;
            }
        }
        return false;
    }

    @Override
    public Vehicle findByRegistration(String registration) {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> registration.equals(vehicle.getRegistration()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Vehicle findByChassisNumber(String chassisNumber) {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> chassisNumber.equals(vehicle.getChassisNumber()))
                .findFirst()
                .orElse(null);
    }

    private VehicleDTO convertToVehicleDTO(Vehicle vehicle) {
        return new VehicleDTO(
                vehicle.getMaxNumberOfPassengers(),
                vehicle.getTransmission(),
                vehicle.isAirConditioning(),
                vehicle.getNumberOfDoors(),
                vehicle.getFuelType(),
                vehicle.getMileage()
        );
    }
}
