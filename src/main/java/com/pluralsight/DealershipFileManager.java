package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

    private final String file_Name = "dealership.csv";

    public Dealership getDealership(){
        Dealership dealership = null;
        String line = "";
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file_Name));

            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                String[] divider = line.split("\\|");
                if (lineNumber == 0) {
                    String name = divider[0].trim();
                    String address = divider[1].trim();
                    String phone = divider[2].trim();
                    dealership = new Dealership(name, address, phone);
                } else {
                    int vin = Integer.parseInt(divider[0]);
                    int year = Integer.parseInt(divider[1]);
                    String make = divider[2].trim();
                    String model = divider[3].trim();
                    String vehicleType = divider[4].trim();
                    String color = divider[5].trim();
                    int odometer = Integer.parseInt(divider[6]);
                    double price = Double.parseDouble(divider[7]);

                    dealership.addVehicle(new Vehicle(vin,year,make,model,vehicleType,color,odometer,price));

                }
                lineNumber++;
            }
            reader.close();
        } catch (Exception ex) {
            System.err.println("Something went wrong");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership){

    }
}
