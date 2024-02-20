/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling customer information
 * that is to be retrieved or input into the database.
 *  
 * % java driverClass
 */

package org.dealership.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dealership.driverClass;

public class customerInformationSQL {
    driverClass driver = new driverClass();


     /*
      * Author: Thomas Dooley
      Written: 16/02/2024
      Last updated: 18/02/2024

      method for adding a new customer row in database in Customer table
      */
      public void addNewCustomerInfoHelper(String customerID, String SSN,  String driverLicense,  String dateOfBirth, String phoneNumber, String firstName, String lastName, String customerAddress, String creditScore, String insuranceNo){
        addNewCustomerInfo(customerID, SSN,  driverLicense,  dateOfBirth, phoneNumber,  firstName,  lastName,  customerAddress,  creditScore,  insuranceNo);
      }
      private void addNewCustomerInfo(String customerID, String SSN,  String driverLicense,  String dateOfBirth, String phoneNumber, String firstName, String lastName, String customerAddress, String creditScore, String insuranceNo){
     
        try{
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String insertToTable = "insert into customer(customerID, SSN, driverLicense, dateOfBirth, phoneNumber, firstName, lastName, customerAddress, downpayment, creditScore, insuranceNo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(insertToTable);

            stmt.setString(1, customerID);
            stmt.setString(2, SSN);
            stmt.setString(3, driverLicense);
            stmt.setString(4, dateOfBirth);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, firstName);
            stmt.setString(7, lastName);
            stmt.setString(8, customerAddress);
            stmt.setString(10, creditScore);
            stmt.setString(11, insuranceNo);
            
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
