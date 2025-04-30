import java.util.List;

public abstract class Vehicle {
    private String vehicleId;

    private String ownerName;

    private int yearOfFabrication;

    private String registrationNumber;

    private double baseTaxRate = 12000;

    private String vehicleType;

    abstract double calculateTax();

    abstract void generateTaxReport();

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be empty.");
        }
        this.vehicleId = vehicleId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty.");
        }
        this.ownerName = ownerName;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(int year) {

        if (year <= 1884 || year > 2025) {
            throw new IllegalArgumentException("Year must be between 1 and " + 2025 + ".");
        }
        this.yearOfFabrication = year;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String regNum) {
        if (regNum == null || regNum.trim().isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be empty.");
        }
        this.registrationNumber = regNum;
    }

    public double getBaseTaxRate() {
        return baseTaxRate;
    }

    public void setBaseTaxRate(double baseTaxRate) {
        this.baseTaxRate = baseTaxRate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String type) {
        List<String> allowed = List.of("Car", "Truck", "Motorcycle", "Bus", "SUV");
        if (!allowed.contains(type)) {
            throw new IllegalArgumentException("Invalid vehicle type. Must be one of: " + allowed);
        }
        this.vehicleType = type;
    }

}
