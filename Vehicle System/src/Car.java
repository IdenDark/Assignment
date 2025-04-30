public class Car extends Vehicle {

    private boolean isElectric;

    public void setElectric(boolean isElectric) {
        this.isElectric = isElectric;
    }

    @Override
    double calculateTax() {
        double tax = 1;
        if (isElectric) {
            tax = tax * 0.80;
        }
        if ((2025 - getYearOfFabrication()) > 10) {
            tax = tax == 1 ? tax * 0.10 : tax + 0.10;
        }
        return tax;
    }

    @Override
    void generateTaxReport() {

        System.out.println("-- Details of tax--");
        System.out.println("\n Your car will pay " + getBaseTaxRate() * calculateTax() + " of tax");
        System.out.println("\n -- End --");

    }

}
