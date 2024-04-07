package hr.tvz.sirac.rentacarapp.repo;

import hr.tvz.sirac.rentacarapp.models.Vehicle;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{
    private final List<Vehicle> vozilaList;
    public VehicleRepositoryImpl() {
        vozilaList = new ArrayList<>();

        // Create at least two Vozilo objects and add them to the list
        Vehicle vehicle1 = new Vehicle("Code123", 5, "Manual", true, 4, "Petrol", LocalDate.now().minusYears(1), LocalDate.now().plusMonths(6), 15000, "ZG123AA", "ASDSDADSADA");
        Vehicle vehicle2 = new Vehicle("Code456", 7, "Automatic", true, 5, "Diesel", LocalDate.now().minusMonths(3), LocalDate.now().plusMonths(12), 3000, "ZG321BB", "BABASFDASDA");

        vozilaList.add(vehicle1);
        vozilaList.add(vehicle2);
    }
    @Override
    public List<Vehicle> findAll() {
        return new ArrayList<>(vozilaList);
    }

    @Override
    public Optional<Vehicle> findVehicleByCode(String code) {
        return vozilaList.stream()
                .filter(vozilo -> vozilo.getVehicleCode().equals(code))
                .findFirst();
    }
}
