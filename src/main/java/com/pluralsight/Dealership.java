package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * List<Vehicle> calls the Vehicle class to return an array out of each given data
     */

    public List<Vehicle> getVehiclesByPrice(double minPrice, double maxPrice) {
        List<Vehicle> price = new ArrayList<>();
        for (Vehicle vehicle : getAllVehicles()) {
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice){
                price.add(vehicle);
            }
        }
        return price;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        return null;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public List<Vehicle> getVehiclesByMileage(int minMileage, double maxMileage) {
        return null;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}
