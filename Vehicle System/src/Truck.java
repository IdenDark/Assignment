
public class Truck extends Vehicle {
    private double loadCapacity = 1;

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be greater than 0.");
        }
        this.loadCapacity = capacity;
    }

    @Override
    double calculateTax() {
        double tax = 1;
        if ((2025 - getYearOfFabrication()) > 15) {
            tax = tax * 1.15;
        }
        if (getLoadCapacity() > 10) {
            tax = tax == 1 ? tax * 1.25 : tax + 1.25;
        }
        return tax;
    }

    @Override
    void generateTaxReport() {
        System.out.println("-- Details of tax--");
        System.out.println("\n Your Truck will pay " + getBaseTaxRate() * calculateTax() + " of tax");
        System.out.println("\n -- End --");

    }

}
