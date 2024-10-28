package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> carInventory;


    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.carInventory = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle){
        carInventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){}

    public void getAllVehicles(){
        for (Vehicle vehicle : carInventory){
            System.out.println(vehicle.toString());
        }
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        return null;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        return null;
    }


}
