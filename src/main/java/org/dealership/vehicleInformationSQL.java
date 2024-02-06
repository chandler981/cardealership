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

package org.dealership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class vehicleInformationSQL {

    driverClass driver = new driverClass();
    

    public void addNewVehicleInfoHelper(String vehicleColor, String vehicleMake, int vehicleMileage, String vehicleModel, String vehicleTransmission, String vehicleType, String vehicleVIN, String vehicleYear, String vehicleCondition){
        addNewVehicleInfo(vehicleColor, vehicleMake, vehicleMileage, vehicleModel, vehicleTransmission, vehicleType, vehicleVIN, vehicleYear, vehicleCondition);
    }

    private void addNewVehicleInfo(String vehicleColor, String vehicleMake, int vehicleMileage, String vehicleModel, String vehicleTransmission, String vehicleType, String vehicleVIN, String vehicleYear, String vehicleCondition){
        try{
            //this allows the user to connect and interact with the sql database
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String insertToTable = "insert into vehicle(vehicleVIN, vehicleMake, vehicleModel, vehicleType, vehicleColor, vehicleYear, vehicleTransmission, vehicleMileage, vehicleCondition) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //this represents a way of executing something in sql through java
            PreparedStatement stmt = conn.prepareStatement(insertToTable);

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

            conn.close();
            stmt.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
