package hr.tvz.sirac.rentacarapp.models;

public class VehicleDTO {
    private int maxNumberOfPassengers;
    private String transmission;
    private boolean airConditioning;
    private int numberOfDoors;
    private String fuelType;
    private boolean newInOffer;

    public VehicleDTO() {
    }

    public VehicleDTO(int maxNumberOfPassengers, String transmission, boolean airConditioning, int numberOfDoors, String fuelType, int mileage) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.transmission = transmission;
        this.airConditioning = airConditioning;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.newInOffer = mileage < 5000;
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

    public boolean isNewInOffer() {
        return newInOffer;
    }

    public void setNewInOffer(boolean newInOffer) {
        this.newInOffer = newInOffer;
    }
}
