/*
 * Author:       Chandler Ward, Thomas Dooley
 * Written:      4 / 1 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for creating and updating the database
 * table that handles discounts or deals that the manager sets
 * for that time period.
 *  
 * % java driverClass
 */

package org.dealership.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.dealership.mainClass;

public class DealInfomationDAO {


    mainClass driver = new mainClass();


    public void discountingHelp(String Type,double discount){
        discounting(Type, discount);
    }
    
    private void discounting(String type, double discounting){

        try{
            //marks as discount and gives discount multiplier (20% as 0.20, etc) to allow finial price as original_price-(original_price*discount)
            // and then allow to search if true for a stated type of vehicle
            Connection conn = DriverManager.getConnection(driver.getConnection());
            System.out.println("Connection Established.");

            String updateVecsDiscount= "Update deal SET vehicleType = (?) , discount = (?) Where ID=1";
            
            PreparedStatement stmt = conn.prepareStatement(updateVecsDiscount);
            stmt.setString(1,type);
            stmt.setFloat(2,(float) discounting);

            stmt.addBatch();
            stmt.executeBatch();

            System.out.println("Batch executed");

            conn.close();
            stmt.close();
    
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
