/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling updating the information
 * in the database for vehicles that either come into the 
 * databse or is getting removed from the database.
 *  
 * % java driverClass
 */

package org.dealership.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
    import java.util.Random;

import org.dealership.mainClass;
import org.dealership.Entities.Vehicle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehicleInformationDAO {
    mainClass driver = new mainClass();
    public static ObservableList<Vehicle> resultHolder = FXCollections.observableArrayList();
    public static Vehicle orderedVecVehicle;

    public void addNewVehicleInfoHelper(String vehicleColor, String vehicleMake, int vehicleMileage, String vehicleModel, String vehicleTransmission, String vehicleType, String vehicleVIN, String vehicleYear, String vehicleCondition){
        addNewVehicleInfo(vehicleColor, vehicleMake, vehicleMileage, vehicleModel, vehicleTransmission, vehicleType, vehicleVIN, vehicleYear, vehicleCondition);
    }

    private void addNewVehicleInfo(String vehicleColor, String vehicleMake, int vehicleMileage, String vehicleModel, String vehicleTransmission, String vehicleType, String vehicleVIN, String vehicleYear, String vehicleCondition){
        try{
            //this allows the user to connect and interact with the sql database
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String insertToTable = "INSERT into vehicle(vehicleVIN, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleYear, vehicleTransmission, vehicleMileage, vehicleCondition) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //this represents a way of executing something in sql through java
            PreparedStatement stmt = conn.prepareStatement(insertToTable);

            //these are essentially prepping the statement that was created with the variables that were created with the gui that have information
            stmt.setString(1, vehicleVIN);
            stmt.setString(2, vehicleMake);
            stmt.setString(3, vehicleModel);
            stmt.setString(4, vehicleType);
            stmt.setString(5, vehicleColor);
            stmt.setString(6, vehicleYear);
            stmt.setString(7, vehicleTransmission);
            stmt.setInt(8, vehicleMileage);
            stmt.setString(9, vehicleCondition);

            stmt.addBatch();
            stmt.executeBatch();

            System.out.println("Batch executed");

            conn.close();
            stmt.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addTradeInVehicleInfoHelper(String tradeInTransmission, String tradeInColor, String tradeInMake, int tradeInMiles, String tradeInModel, String tradeInVIN, Boolean tradeInVerification, String tradeInYear, String tradeInType){
        addTradeInVehicleInfo(tradeInTransmission, tradeInColor, tradeInMake, tradeInMiles, tradeInModel, tradeInVIN, tradeInVerification, tradeInYear, tradeInType);
    }

    private void addTradeInVehicleInfo(String vehicleTransmission, String vehicleColor, String vehicleMake, int vehicleMileage, String vehicleModel, String vehicleVIN, Boolean vehicleVerification, String vehicleYear, String vehicleType){
        try{
            //this allows the user to connect and interact with the sql database
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String vehicleCondition = "used";
            float vehicleSalePrice = (float) 0.0;
            String vehicleAvailability = "In stock";

            String insertToTable = "INSERT into vehicle(vehicleVIN, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleYear, vehicleTransmission, vehicleMileage, vehicleCondition, vehicleSalePrice, vehicleAvailability, vehicleVerification) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //this represents a way of executing something in sql through java
            PreparedStatement stmt = conn.prepareStatement(insertToTable);

            //these are essentially prepping the statement that was created with the variables that were created with the gui that have information
            stmt.setString(1, vehicleVIN);
            stmt.setString(2, vehicleMake);
            stmt.setString(3, vehicleModel);
            stmt.setString(4, vehicleType);
            stmt.setString(5, vehicleColor);
            stmt.setString(6, vehicleYear);
            stmt.setString(7, vehicleTransmission);
            stmt.setInt(8, vehicleMileage);
            stmt.setString(9, vehicleCondition);
            stmt.setFloat(10, vehicleSalePrice);
            stmt.setString(11, vehicleAvailability);
            stmt.setBoolean(12, vehicleVerification);

            stmt.addBatch();
            stmt.executeBatch();

            System.out.println("Batch executed");

            conn.close();
            stmt.close();


        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public ObservableList<Vehicle> vehicleSearchResultHelper(String query, String dealQuery){
        return vehicleSearchResult(query, dealQuery);
    }

    //method for adding objects to the list to be used on table
    private ObservableList<Vehicle> vehicleSearchResult(String query, String dealQuery){

        resultHolder.clear();

        try{
            Vehicle vehicleView;

            //this allows the user to connect and interact with the sql database
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            PreparedStatement vehicleInfoQuery = conn.prepareStatement(query);
            ResultSet vehicleInfoResult = vehicleInfoQuery.executeQuery();

            PreparedStatement vehicleDealQuery = conn.prepareStatement(dealQuery);
            ResultSet vehicleDealResult = vehicleDealQuery.executeQuery();

            while(vehicleInfoResult.next()) //loops through database result to add the contents to a object
            {
                String vehMake = vehicleInfoResult.getString("vehicleMake");
                String vehModel = vehicleInfoResult.getString("vehicleModel");
                String vehType = vehicleInfoResult.getString("vehicleType");
                String vehColor = vehicleInfoResult.getString("vehicleColor");
                String vehYear = vehicleInfoResult.getString("vehicleYear");
                String vehTransmission = vehicleInfoResult.getString("vehicleTransmission");
                String vehMiles = vehicleInfoResult.getString("vehicleMileage");
                String vehCondition = vehicleInfoResult.getString("vehicleCondition");
                String vehPrice = vehicleInfoResult.getString("vehicleSalePrice");
                String vehAvail = vehicleInfoResult.getString("vehicleAvailability");
                
                if(vehicleDealResult.next())//checks for if a discount is available for that specified car type
                {
                    Float vehDisc = Float.parseFloat(vehicleDealResult.getString("discount"));
                    System.out.println("entered the if");

                    //this sends the retrieved info from the database and sends it to an object of the vehicle type, which is then added to the resultHolder list to be used at a later point
                    vehicleView = new Vehicle(vehMake, vehModel, vehType, vehColor, vehYear, vehTransmission, vehMiles, vehCondition, vehPrice, vehAvail, vehDisc);
                    System.out.println("discount");
                    resultHolder.add(vehicleView);
                }
                else
                {
                    vehicleView = new Vehicle(vehMake, vehModel, vehType, vehColor, vehYear, vehTransmission, vehMiles, vehCondition, vehPrice, vehAvail, (float) 0);
                    System.out.println("discount not here");
                    resultHolder.add(vehicleView);
                    
                }
            }

            vehicleInfoQuery.close();
            System.out.println("Statement closed.");
            vehicleInfoResult.close();
            System.out.println("Result closed.");
            conn.close();
            System.out.println("Connection closed.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return resultHolder;
    }
    public void OrderVecHelper(String vehicleColorOrder, String vehicleMakeOrder, String vehicleModelOrder,
    String vehicleTransTypeOrder, String vehicleTypeOrder, String vehicleYearOrder,
    String OrderFromOptionsString){
        OrderVec(vehicleColorOrder, vehicleMakeOrder, vehicleModelOrder, vehicleTransTypeOrder, vehicleTypeOrder, vehicleYearOrder, OrderFromOptionsString);    }

    private void OrderVec(String vehicleColorOrder, String vehicleMakeOrder, String vehicleModelOrder,
    String vehicleTransTypeOrder, String vehicleTypeOrder, String vehicleYearOrder,
            String OrderFromOptionsString) {
        String VecVin=generateVIN();
        orderedVecVehicle=new Vehicle(vehicleMakeOrder, vehicleModelOrder, vehicleTypeOrder, vehicleColorOrder, vehicleYearOrder,vehicleTransTypeOrder, "Ordered", "Ordered", "Ordered", "Ordered", OrderFromOptionsString);;
        try{
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String vehicleCondition = "used";
            float vehicleSalePrice = (float) 0.0;
            String vehicleAvailability = "Ordered";

            String insertToTable = "INSERT into vehicle(vehicleVIN, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleYear, vehicleTransmission, vehicleMileage, vehicleCondition, vehicleSalePrice, vehicleAvailability) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(insertToTable);
            stmt.setString(1, VecVin);
            stmt.setString(2,vehicleMakeOrder);
            stmt.setString(3, vehicleModelOrder);
            stmt.setString(4, vehicleTypeOrder);
            stmt.setString(5, vehicleColorOrder);
            stmt.setString(6, vehicleYearOrder);
            stmt.setString(7, vehicleTransTypeOrder);
            stmt.setInt(8, 0);
            stmt.setString(9, vehicleCondition);
            stmt.setFloat(10, vehicleSalePrice);
            stmt.setString(11, vehicleAvailability);

            stmt.addBatch();
            stmt.executeBatch();

            System.out.println("Batch executed");

            conn.close();
            stmt.close();


        }catch(Exception e){
            e.printStackTrace();
        }

    } 
    
    private String generateVIN() {
        // The standard VIN length is 17 characters
        int vinLength = 17;
        
        // Characters allowed in a VIN except 'I', 'O', and 'Q' (to avoid confusion with 1 and 0)
        String allowedCharacters = "ABCDEFGHJKLMNPRSTUVWXYZ1234567890";
        
        StringBuilder vinBuilder = new StringBuilder();
        Random random = new Random();
        
        // The first three characters are World Manufacturer Identifier (WMI)
        for (int i = 0; i < 3; i++) {
            vinBuilder.append(allowedCharacters.charAt(random.nextInt(allowedCharacters.length())));
        }
        
        // The next 5 characters are Vehicle Descriptor Section (VDS)
        for (int i = 0; i < 5; i++) {
            vinBuilder.append(allowedCharacters.charAt(random.nextInt(allowedCharacters.length())));
        }
        
        // The 9th character is the check digit, which is calculated later
        
        // The next 8 characters are Vehicle Identifier Section (VIS)
        for (int i = 0; i < 8; i++) {
            vinBuilder.append(allowedCharacters.charAt(random.nextInt(allowedCharacters.length())));
        }
        
        // Convert StringBuilder to String
        String vin = vinBuilder.toString();
        
        // Calculate the check digit
        char checkDigit = calculateCheckDigit(vin);
        
        // Insert the check digit at the 9th position
        vin = vin.substring(0, 8) + checkDigit + vin.substring(9);
        
        return vin;
    }
    
    private static char calculateCheckDigit(String vin) {
        // Weight factors for each position in the VIN
        int[] weights = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };
        
        int sum = 0;
        for (int i = 0; i < vin.length(); i++) {
            char c = vin.charAt(i);
            if (Character.isDigit(c)) {
                sum += Character.getNumericValue(c) * weights[i];
            } else if (Character.isLetter(c)) {
                // For letters, A=1, B=2, ..., Z=26
                sum += (c - 'A' + 1) * weights[i];
            }
        }
        
        // Calculate check digit
        int checkDigitValue = sum % 11;
        if (checkDigitValue == 10) {
            return 'X'; // Use 'X' for check digit 10
        } else {
            return Character.forDigit(checkDigitValue, 10);
        }
    }
}

