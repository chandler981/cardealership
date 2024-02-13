/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac employeeInformationSQL.java
 * Execution:    java employeeInformationSQL
 * 
 * This file or class is for handling the information 
 * that is pulled from the login screen so that the user
 * can be logged into either the manager screen or the 
 * employee screen.
 *  
 * % java employeeInformationSQL
 *  
 * (example of what could be an output)
 * 
 */

package org.dealership.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.dealership.driverClass;
import org.dealership.Entities.employee;
import org.dealership.controllerClasses.LoginScreenController;

public class employeeInformationSQL{

    // this line is for creating a string that will allow the bridge connection of java and sql and is used globally
    // the first part is referring to the driver that allows java to talk to the sql server
    // the second part is the name of the sql server or just the port with the host name
    // the third part is the name of the databse 

    private String employeeID;
    private String employeePassword;

    driverClass driver = new driverClass();
    
    public void checkLogin(String empID, String empPass) throws IOException{
        setEmpID(empID);
        setEmpPass(empPass);
        checkLoginHelper(getEmpID(), getEmpPass()); //Stage stage
    }
    
    public void setEmpID(String ID){
        this.employeeID = ID;
    }
    public void setEmpPass(String password){
        this.employeePassword = password;
    }
    
    public String getEmpID(){
        return this.employeeID;
    }
    public String getEmpPass(){
        return this.employeePassword;
    }
    
    private void checkLoginHelper(String ID, String password) throws IOException{ 
        LoginScreenController login = new LoginScreenController();
        try{
            //this allows the user to connect and interact with the sql database
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            //this represents a way of executing something in sql through java
            PreparedStatement passwordCheck = conn.prepareStatement("SELECT employeePassword FROM employee WHERE employeeID = " + ID); //prepares a statement to be executed as a query with sql
            ResultSet passwordResult = passwordCheck.executeQuery(); //will hold the result of the query for the password

            PreparedStatement userNameCheck = conn.prepareStatement("SELECT employeeId FROM employee WHERE employeeID = " + ID);
            ResultSet userNameResult = userNameCheck.executeQuery(); //will hold the result of the query for the username

            PreparedStatement managerStatus = conn.prepareStatement("SELECT isManager FROM employee WHERE employeeID = " + ID);
            ResultSet managerStatusResult = managerStatus.executeQuery(); //will hold the result of the query for the manager status

            if(userNameResult.next()){ //gets the next result from the query
                String checkUser = userNameResult.getString("employeeID");

                if(checkUser.equals(ID)){ //checks to see if result from data table is equal to user input userName from login screen
                    System.out.println("Username is correct. ");
                }
            }

            if(passwordResult.next()){ //gets the next result from the query for the password for a specified userName
                String checkPass = passwordResult.getString("employeePassword");

                if(checkPass.equals(password)){ //checks if the password from the database query is equal to login screen password input
                    System.out.println("password is correct. ");
                }
            }

            if(managerStatusResult.next()){
                Boolean checkManager = managerStatusResult.getBoolean("isManager");
                    if(checkManager){
                        System.out.println("Manager logged in.");
                        login.changeToManager(); 
                    }
                    else{
                        System.out.println("Employee logged in.");  
                        login.changeToEmployee();
                        //add in where it redirects to regular employee page
                    }
            }

            passwordCheck.close();
            userNameCheck.close();
            System.out.println("stmt was closed.");

            //closes the connection so that nothing else in terms of CRUD is happening to the data base
            conn.close();   
            System.out.println("conn was closed.");
        }
        catch(SQLException e){
            System.out.println("login attempt failed.");
            e.printStackTrace();
        }
    }

    public void inputNewCommAmntHelper(String empID, String newCommAmmnt) throws IOException{ //method to help with inputting an employees new commission ammount
        inputNewCommissionAmnt(empID, newCommAmmnt);
    }

    private void inputNewCommissionAmnt(String empID, String newCommAmmnt) throws IOException{  //method that actually pushes the new commission ammount to the database
        employee emp = new employee();
        
        try{    
            Connection conn = DriverManager.getConnection(driver.getConnection());

            System.out.println(empID);
            System.out.println("Connection Established.");
            
            //takes the input that was given from the employee controller class, sends it to the employee entity class, 
            //gets the commission ammount, and then has it returned in the sql statement line to be sent to the database
            //the computeCommHelper simply takes in the newCommAmmnt, it does nothing else, a parseDouble is used since what 
            //is returned is a string and needs to be set as a double to be added to the database
            emp.computeCommHelper(Double.parseDouble(newCommAmmnt));

            String inputNewCommissionAmount = "UPDATE employeeEarnings SET employeeCommissionCurrent = " + emp.getEmpPaymentAmmnt() + " WHERE employeeID = " + empID;

            System.out.println(emp.getEmpPaymentAmmnt());

            PreparedStatement stmt = conn.prepareStatement(inputNewCommissionAmount);

            stmt.addBatch();
            stmt.executeUpdate();

            conn.close();
            stmt.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
