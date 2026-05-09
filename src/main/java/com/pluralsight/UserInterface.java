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
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetByAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "99" -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
        scanner.close();
    }

    public void processGetByPriceRequest() {
    }

    public void processGetByMakeModelRequest() {
    }

    public void processGetByYearRequest() {
    }

    public void processGetByColorRequest() {
    }

    public void processGetByMileageRequest() {
    }

    public void processGetByVehicleTypeRequest() {
    }

    public void processGetByAllVehiclesRequest() {
    }

    public void processAddVehicleRequest() {


    }

    public void processRemoveVehicleRequest() {
    }

    //helpers
    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
    }

    /*private void displayVehicles(Dealership list) {
        for (Vehicle allVehicle : list.getAllVehicles()) {
            System.out.println(allVehicle);
        }
    }*/

    /*private void displayVehicles(String input, List<Vehicle> inventory) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(input));
        }
    }*/
}
