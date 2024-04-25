/*
 * Author:       Chandler Ward, Thomas Dooley
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.dealership.mainClass;
import org.dealership.Entities.Customer;

public class CustomerInformationDAO {
    mainClass driver = new mainClass();
    public static String customerID;
    public static String[] customerInfoHolder = new String[11];
      
    public void addNewCustomerInfoHelper(String SSN,  String driverLicense,  String dateOfBirth, String phoneNumber, String firstName, 
                                        String lastName, String customerAddress, Float downPayment, String creditScore, String insuranceNo)
    {
        addNewCustomerInfo(SSN,  driverLicense,  dateOfBirth, phoneNumber,  firstName,  lastName,  customerAddress, downPayment,  creditScore,  insuranceNo);
    }

    /*
     * Method is solely for inputting the customer information to the database when they are 
     * buying a vehicle
     */
    private void addNewCustomerInfo(String SSN,  String driverLicense,  String dateOfBirth, String phoneNumber, String firstName, String lastName, String customerAddress, Float downPayment, String creditScore, String insuranceNo){
        try{
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String insertToTable = "insert into customer(customerID, SSN, driverLicense, dateOfBirth, phoneNumber, firstName, lastName, customerAddress, downpayment, creditScore, insuranceNo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(insertToTable);

            stmt.setString(2, SSN);
            stmt.setString(3, driverLicense);
            stmt.setString(4, dateOfBirth);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, firstName);
            stmt.setString(7, lastName);
            stmt.setString(8, customerAddress);
            stmt.setFloat(9, downPayment);
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


    //these two commented out methods are for retrieving the customer ID via their SSN as a way of testing a pages functionality
    public void getCustomerIDHelper(){
        getCustomerID();
    }

    /*
     * Method is solely for getting the customers ID since it is auto generated
     * by the database and not manually created by the employee/manager, due to 
     * this the method is used to get the ID by the SSN since that is unique to each customer.
     */
    public String getCustomerID(){
        Customer customerSSN = new Customer(); 
        try{
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String customerIDforBuying = "SELECT customerID FROM customer where SSN = ?";
            PreparedStatement customerIDbySSN = conn.prepareStatement(customerIDforBuying);
            System.out.println("Getting SSN to then get ID");
            customerSSN.getSSN();
            customerIDbySSN.setString(1, customerSSN.getSSN());
            ResultSet customerIDResult = customerIDbySSN.executeQuery();

            if(customerIDResult.next()){
                System.out.println("The if statement was entered");
                customerID = customerIDResult.getString("customerID");
                System.out.println(customerID);
                return customerID;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Customer ID couldnt be found");
        }
        return null;
    }

    //method for auto filling spaces in the buying vehicle page for the customer based on the ID entered
    public String[] getInformationForBuyingPage(String ID){
        try{

            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String customerInfo = "SELECT * FROM customer where customerID = " + ID;

            PreparedStatement customerInfoQuery = conn.prepareStatement(customerInfo);
            ResultSet customerInfoResult = customerInfoQuery.executeQuery();

            //this allows for the result set that is holding information to put the information 
            //in the SQL table into a static array to be used else where
            if(customerInfoResult.next()){
                    customerInfoHolder[0] = customerInfoResult.getString("SSN");
                    customerInfoHolder[1] = customerInfoResult.getString("driversLicense");
                    customerInfoHolder[2] = customerInfoResult.getString("dateOfBirth");
                    customerInfoHolder[3] = customerInfoResult.getString("phoneNumber");
                    customerInfoHolder[4] = customerInfoResult.getString("firstName");
                    customerInfoHolder[5] = customerInfoResult.getString("lastName");
                    customerInfoHolder[6] = customerInfoResult.getString("customerAddress");
                    customerInfoHolder[7] = Integer.toString(customerInfoResult.getInt("downPayment"));
                    customerInfoHolder[8] = customerInfoResult.getString("creditScore");
                    customerInfoHolder[9] = customerInfoResult.getString("insuranceNo");
                    customerInfoHolder[10] = customerInfoResult.getString("paymentType");

                return customerInfoHolder;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
