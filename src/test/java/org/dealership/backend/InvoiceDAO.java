/*
 * Author:       Chandler Ward, Zhania Douglas
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling any invoices that are
 * created via a sale that is to be input into the 
 * database or retrieved for whatever it is needed
 * for.
 *  
 * % java driverClass
 */

package org.dealership.backend;

import java.sql.Connection;
import java.sql.DriverManager;

import org.dealership.mainClass;
import org.dealership.Entities.Invoice;

public class InvoiceDAO {

    mainClass driver = new mainClass();

    public void saveInvoice(Invoice inv) {
    	try {
      	// Call on connection to database
      	Connection conn = DriverManager.getConnection(driver.getConnection());
      	System.out.println("Connection Established.");
        
        // SQL Query
        // IMPORTANT: In Progress - Remove all statements in <>, add the rest of the attributes, add rest of inv.get methods
        String insertNewInvoice = "INSERT INTO Invoice (<attribute1>, <attribute2>, <attribute3> ) VALUES (inv.getCustAddress(), inv.getFees(), inv.getCustID(), inv.getDiscountTotal(), inv.getPaymentTotal(), inv.getPaymentType(), inv.getPurchaseDate() )";
        
      } catch(Exception e) {
      	 e.printStackTrace();
      }
    }
    
}
