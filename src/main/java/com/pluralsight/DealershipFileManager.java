package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DealershipFileManager {

    public final static String dataFileName = "inventory.csv";
    public static ArrayList<Vehicle> carInventory = getCarInventory();

    // This Method gets all the Car Inventory from the inventory.csv
    public static ArrayList<Vehicle> getCarInventory(){
        ArrayList<Vehicle> carInventory = new ArrayList<Vehicle>();
        try{
            FileReader fr = new FileReader(dataFileName);
            BufferedReader br = new BufferedReader(fr);

            br.readLine();

            String input;
            while( (input = br.readLine()) != null){
                String[] tokens = input.split(Pattern.quote("|"));
                int vinNumber = Integer.parseInt(tokens[0]);
                int yearNumber = Integer.parseInt(tokens[1]);
                String carMake = tokens[2];
                String carModel = tokens[3];
                String vehicleType = tokens[4];
                String carColor = tokens[5];
                int carOdometer = Integer.parseInt(tokens[6]);
                double carPrice = Double.parseDouble(tokens[7]);
                Vehicle v = new Vehicle(vinNumber, yearNumber, carMake, carModel, vehicleType, carColor, carOdometer, carPrice);
                carInventory.add(v);
            }
            br.close();
        }
        catch (Exception e){
            System.out.println("ERROR!!");
            e.printStackTrace();
        }
        return carInventory;
    }
    // todo make first line of inventory.csv readable and separated
    public static ArrayList<Vehicle> getCarDealershipInformation(){
        ArrayList<Vehicle> carInventory = new ArrayList<Vehicle>();
        try{
            FileReader fr = new FileReader(dataFileName);
            BufferedReader br = new BufferedReader(fr);

            String input;
            while( (input = br.readLine()) != null){
                String[] tokens = input.split(Pattern.quote("|"));
                String dealershipName = tokens[0];
                String dealershipAddress = tokens[1];
                String dealershipPhoneNumber = tokens[2];
                Dealership d = new Dealership(dealershipName, dealershipAddress, dealershipPhoneNumber);
//                carInventory.add(d);
            }
            br.close();
        }
        catch (Exception e){
            System.out.println("ERROR!!");
            e.printStackTrace();
        }
        return carInventory;
    }

    // This Method writes car inventory info to the inventory.csv
    public static void writeTransactions(){

        try{
            FileWriter fw = new FileWriter(dataFileName);

            fw.write("D & B Used Cars|111 Old Benbrook Rd|817-555-5555\n");

            for(Vehicle v : carInventory){
                String data = v.getVinNumber() + "|" + v.getYearNumber() + "|" + v.getCarMake() + "|" + v.getCarModel() + "|" +
                        v.getVehicleType() + "|" + v.getCarColor() + "|" + v.getCarOdometer() + "|" + v.getCarPrice() + "\n";
                fw.write(data);
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("FILE WRITE ERROR");
            e.printStackTrace();
        }

    }
}
