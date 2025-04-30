public class Motocycle extends Vehicle {
    private int engineCapacity;

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Load capacity must be greater than 0.");
        }
        this.engineCapacity = capacity;
    }

    @Override
    double calculateTax() {
        double tax = 1;
        if (getEngineCapacity() > 500) {
            tax = tax * 1.2;
        }
        if (2025 - getYearOfFabrication() > 5) {
            tax = tax == 1 ? tax * 1.5 : tax + 1.5;
        }
        return tax;
    }

    @Override
    void generateTaxReport() {
        System.out.println("-- Details of tax--");
        System.out.println("\n Your Moto will pay " + getBaseTaxRate() * calculateTax() + " of tax");
        System.out.println("\n -- Age-based depreciation: 5% reduction every 5 years --");
        System.out.println("\n -- End --");

    }

}
