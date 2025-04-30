import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Vehicle> registeredVehicles = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== VEHICLE TAX MANAGEMENT MENU =====");
            System.out.println("1. Register a new vehicle");
            System.out.println("2. View registered vehicles");
            System.out.println("3. Calculate tax for all vehicles");
            System.out.println("4. Generate tax reports");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number (1-5): ");
                scanner.next(); // clear buffer
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    registerVehicle();
                    break;
                case 2:
                    viewVehicles();
                    break;
                case 3:
                    calculateTaxForAll();
                    break;
                case 4:
                    generateTaxReports();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 5);
    }

    public static void registerVehicle() {
        System.out.print("Enter vehicle type (Car, Truck, Bus, SUV, Motorcycle): ");
        String type = scanner.nextLine().trim().toLowerCase();

        Vehicle vehicle = null;

        switch (type) {
            case "car":
                vehicle = new Car(); // then use setters

                break;
            case "truck":
                vehicle = new Truck();
                break;
            case "bus":
                vehicle = new Bus();
                break;
            case "suv":
                vehicle = new SUV();
                break;
            case "motorcycle":
                vehicle = new Motocycle();
                break;
            default:
                System.out.println("Invalid vehicle type!");
                return;
        }

        System.out.print("\nEnter vehicle ID: ");
        vehicle.setVehicleId(scanner.nextLine());

        while (true) {
            try {
                System.out.print("Enter owner name: ");
                String name = scanner.nextLine();
                vehicle.setOwnerName(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Enter year of fabrication: ");
                int year = scanner.nextInt();
                scanner.nextLine(); // clear newline
                vehicle.setYearOfFabrication(year); // validate here
                break; // valid input
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter a valid number!");
                scanner.nextLine(); // flush input
            }
        }

        while (true) {
            try {
                System.out.print("Enter vehicle type: ");
                String name = scanner.nextLine();
                vehicle.setVehicleType(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }

        switch (type) {
            case "car":
                while (true) {
                    try {
                        System.out.print("Is the car electric? (true/false): ");
                        boolean isElectric = Boolean.parseBoolean(scanner.nextLine());
                        ((Car) vehicle).setElectric(isElectric);
                        break;
                    } catch (Exception e) {
                        System.out.println("❌ Please enter true or false.");
                    }
                }

                break;

            case "truck":
                while (true) {
                    try {
                        System.out.print("Enter load capacity (tons): ");
                        double loadCapacity = scanner.nextDouble();
                        scanner.nextLine();
                        ((Truck) vehicle).setLoadCapacity(loadCapacity);
                        break;
                    } catch (Exception e) {
                        System.out.println("In tons man");
                    }
                }

                break;

            case "bus":
                System.out.print("Enter passenger capacity: ");
                int passengerCapacity = scanner.nextInt();
                scanner.nextLine();
                ((Bus) vehicle).setPassengerCapacity(passengerCapacity);
                break;

            case "suv":
                while (true) {
                    try {
                        System.out.print("4WD? (true/false): ");
                        boolean WD = Boolean.parseBoolean(scanner.nextLine());
                        ((SUV) vehicle).setFourWheelDrive(WD);
                        break;
                    } catch (Exception e) {
                        System.out.println("❌ Please enter true or false.");
                    }
                }

                break;

            case "motorcycle":
                System.out.print("Enter engine capacity (cc): ");
                int engineCapacity = scanner.nextInt();
                scanner.nextLine();
                ((Motocycle) vehicle).setEngineCapacity(engineCapacity);
                break;
        }
        // Now use setters to assign values (you'll handle validation in those)
        // Example:
        // System.out.print("Enter vehicle ID: ");
        //
        // Add the rest...

        registeredVehicles.add(vehicle);
        System.out.println("Vehicle registered successfully!");
    }

    public static void viewVehicles() {
        if (registeredVehicles.isEmpty()) {
            System.out.println("No vehicles registered.");
        } else {
            for (Vehicle v : registeredVehicles) {
                System.out.println(v);
            }
        }
    }

    public static void calculateTaxForAll() {
        for (Vehicle v : registeredVehicles) {
            double tax = v.calculateTax() * v.getBaseTaxRate();
            System.out.println(v.getVehicleType() + " [" + v.getVehicleType() + "] Tax: " + tax);
        }
    }

    public static void generateTaxReports() {
        for (Vehicle v : registeredVehicles) {
            v.generateTaxReport();
        }
    }
}
