package org.dealership;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employeeInformationSQL{

    //this line is for creating a string that will allow the bridge connection of java and sql and is used globally
    // the first part is referring to the driver that allows java to talk to the sql server
    // the second part is the name of the sql server or just the port with the host name
    // the third part is the name of the databse 

    //in the password section put whatever password was created in your mySQL for the database on your desktop, this will allow you to connect and test queries and all
    static String sqlConnection = "jdbc:mysql://localhost:3306/mysql?user = root & password = G@607537";

    public void checkLogin(String empID, String empPass){
        checkLoginHelper(empID, empPass);
    }

    private void checkLoginHelper(String ID, String password){
        try{
            //this allows the user to connect and interact with the sql database
            Connection conn = DriverManager.getConnection(sqlConnection);
            System.out.println("Connection Established.");

            //this represents a way of executing something in sql through java
            PreparedStatement passwordCheck = conn.prepareStatement("SELECT employeePassword FROM employee WHERE employeeID = " + ID); //prepares a statement to be executed as a query with sql
            ResultSet passwordResult = passwordCheck.executeQuery(); //will hold the result of the query for the password

            PreparedStatement userNameCheck = conn.prepareStatement("SELECT employeeId FROM employee WHERE employeeID = " + ID);
            ResultSet userNameResult = userNameCheck.executeQuery(); //will hold the result of the query for the username

            if(userNameResult.next()){ //gets the next result from the query
                String checkUser = userNameResult.getString("employeeID");

                if(checkUser.equals(ID)){ //checks to see if result from data table is equal to user input userName from login screen
                    System.out.println("Username is correct. ");

                    if(passwordResult.next()){ //gets the next result from the query for the password for a specified userName
                        String checkPass = passwordResult.getString("employeePassword");

                        if(checkPass.equals(password)){ //checks if the password from the database query is equal to login screen password input
                            System.out.println("password is correct. ");
                        }
                        else{
                            System.out.println("password is wrong");
                        }
                    }
                }
                else{
                    System.out.println("Username is wrong.");
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
}
