package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership = null;

    public UserInterface() {
    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to Ledger APP");
            System.out.println("-----------------------");
            System.out.println("Choose an option:");
            System.out.println("1) Get Vehicles by Price");
            System.out.println("2) Get Vehicles by Make and Model");
            System.out.println("3) Get Vehicles by Year");
            System.out.println("4) Get Vehicles by Color");
            System.out.println("5) Get Vehicles by mileage");
            System.out.println("6) Get Vehicles by type");
            System.out.println("7) Get All Vehicles");
            System.out.println("8) Add Vehicle");
            System.out.println("9) Remove Vehicle");
            System.out.println("99) Exit");
            System.out.println("-----------------------");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "1" -> processGetByPriceRequest(scanner);
                case "2" -> processGetByMakeModelRequest(scanner);
                case "3" -> processGetByYearRequest(scanner);
                case "4" -> processGetByColorRequest(scanner);
                case "5" -> processGetByMileageRequest(scanner);
                case "6" -> processGetByVehicleTypeRequest(scanner);
                case "7" -> processAllVehiclesRequest();
                case "8" -> processAddVehicleRequest(scanner);
                case "9" -> processRemoveVehicleRequest(scanner);
                case "99" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    public void processGetByPriceRequest(Scanner scanner) {
        System.out.println("enter your minimum amount: ");
        double minPrice = scanner.nextDouble();

        System.out.println("enter your maximum amount: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.println("enter your car make: ");
        String make = scanner.nextLine().trim();

        System.out.println("enter your car model: ");
        String model = scanner.nextLine().trim();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest(Scanner scanner) {
        System.out.println("enter your minimum year: ");
        int minYear = scanner.nextInt();

        System.out.println("enter your maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }

    public void processGetByColorRequest(Scanner scanner) {
        System.out.println("enter your car color: ");
        String color = scanner.nextLine().trim();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processGetByMileageRequest(Scanner scanner) {
        System.out.println("enter your minimum mileage: ");
        int minMileage = scanner.nextInt();

        System.out.println("enter your maximum mileage: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();

        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxMileage));
    }

    public void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.println("enter the car type: ");
        String carType = scanner.nextLine().trim();

        displayVehicles(dealership.getVehiclesByType(carType));
    }

    public void processAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scanner) {

        System.out.println("enter your cars VIN: ");
        int vin = scanner.nextInt();

        System.out.println("enter your cars year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter your car make: ");
        String make = scanner.nextLine().trim();

        System.out.println("enter your car model: ");
        String model = scanner.nextLine().trim();

        System.out.println("enter the car type: ");
        String vehicleType = scanner.nextLine().trim();

        System.out.println("enter your car color: ");
        String color = scanner.nextLine().trim();

        System.out.println("enter your cars mileage: ");
        int odometer = scanner.nextInt();

        System.out.println("enter your cars price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
        new DealershipFileManager().saveDealership(dealership);

    }


    public void processRemoveVehicleRequest(Scanner scanner) {
        //remove by exact vin
    }

    //helpers
    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void displayVehicles(List<Vehicle> inventory) {
        //sort the list
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle.getVin() + " | " + vehicle.getYear() + " | " + vehicle.getMake()
                    + " | " + vehicle.getModel() + " | " + vehicle.getVehicleType() + " | "
                    + vehicle.getColor() + " | " + vehicle.getOdometer() + " | " + vehicle.getPrice());
        }
    }

}
