public class Bus extends Vehicle {
    private int passengerCapacity;

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be greater than 0.");
        }
        this.passengerCapacity = capacity;
    }

    @Override
    double calculateTax() {

        double tax = 1;
        if (getPassengerCapacity() > 10) {
            tax = tax * 1.2;
        }
        if (2025 - getYearOfFabrication() > 20) {
            tax = tax == 1 ? tax * 1.20 : tax + 1.20;
        }
        return tax;
    }

    @Override
    void generateTaxReport() {

        System.out.println("-- Details of tax--");
        System.out.println("\n Your Bus will pay " + getBaseTaxRate() * calculateTax() + " of tax");
        System.out.println("\n -- End --");

    }

}
