package hr.tvz.sirac.rentacarapp.models;

import java.time.LocalDate;

public class Vehicle
{
    public String vehicleCode;
    public int maxNumberOfPassengers;
    public String transmission;
    public boolean airConditioning;
    public int numberOfDoors;
    public String fuelType;
    public LocalDate lastServiceDate;
    public LocalDate nextServiceDate;
    public int mileage;
    public String registration;
    public String chassisNumber;

    public Vehicle() {
    }

    public Vehicle(String vehicleCode, int maxNumberOfPassengers, String transmission, boolean airConditioning, int numberOfDoors, String fuelType, LocalDate lastServiceDate, LocalDate nextServiceDate, int mileage, String registration, String chassisNumber) {
        this.vehicleCode = vehicleCode;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.transmission = transmission;
        this.airConditioning = airConditioning;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.lastServiceDate = lastServiceDate;
        this.nextServiceDate = nextServiceDate;
        this.mileage = mileage;
        this.registration = registration;
        this.chassisNumber = chassisNumber;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public LocalDate getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(LocalDate lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public LocalDate getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(LocalDate nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }
}
