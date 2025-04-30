public class SUV extends Vehicle {
    private boolean fourWheelDrive;

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    @Override
    double calculateTax() {
        double tax = 1;
        if (fourWheelDrive) {
            tax = tax * 1.1;
        }
        if (2025 - getYearOfFabrication() > 10) {
            tax = tax == 1 ? tax * 0.95 : tax + 0.95;
        }
        return tax;
    }

    @Override
    void generateTaxReport() {
        System.out.println("-- Details of tax--");
        System.out.println("\n Your SUV will pay " + getBaseTaxRate() * calculateTax() + " of tax");
        System.out.println("\n -- End --");
    }
}
