/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
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

import org.dealership.driverClass;
import org.dealership.Entities.Vehicle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehicleInformationDAO {
    driverClass driver = new driverClass();
    public static ObservableList<Vehicle> resultHolder = FXCollections.observableArrayList();

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

    private ObservableList<Vehicle> vehicleSearchResult(String query, String dealQuery){
        try{
            Vehicle vehicleView;

            //this allows the user to connect and interact with the sql database
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            PreparedStatement vehicleInfoQuery = conn.prepareStatement(query);
            ResultSet vehicleInfoResult = vehicleInfoQuery.executeQuery();

            PreparedStatement vehicleDealQuery = conn.prepareStatement(dealQuery);
            ResultSet vehicleDealResult = vehicleDealQuery.executeQuery();

            while(vehicleInfoResult.next())
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
                
                if(vehicleDealResult.next())
                {
                    Float vehDisc = Float.parseFloat(vehicleDealResult.getString("discount"));
                    System.out.println("entered the if");
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
    
}
