package se.lexicon.model;

public class Vehicle {

    private VehicleType vehicleType;
    private String plateNumber;


    public Vehicle(VehicleType vehicleType, String plateNumber) {

        setVehicleType(vehicleType);
        setPlateNumber(plateNumber);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        isNullOrBlank(plateNumber, "Plate number is null or empty");
        this.plateNumber = plateNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    private void setVehicleType(VehicleType vehicleType) {
        if (vehicleType == null || vehicleType.name().isBlank())
            throw new IllegalArgumentException("Vehicle type is null or empty");
        this.vehicleType = vehicleType;
    }

    private void isNullOrBlank(String text, String message) {
        boolean status = (text == null || text.isBlank());
        if (status) throw new IllegalArgumentException(message);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleType=" + vehicleType +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
