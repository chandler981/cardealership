/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 *  
 * % java driverClass
 */

package org.dealership.Entities;

import java.time.LocalDate;

import org.dealership.backend.CustomerInformationDAO;

public class Customer{
    public static String SSN;
    public static String ID;
    public static LocalDate date;
    public static String Info[];

    public Customer(){
        System.out.println("SSN for customer is " + SSN);
    }

    public Customer(String SSNentered){
        System.out.println("SSN entered is 987-65-4321");
        SSN = SSNentered;
    }

    public String getSSN(){
        return SSN;
    }

    public void setID(){
        CustomerInformationDAO cust = new CustomerInformationDAO();
        ID = cust.getCustomerID();
        Info = cust.customerInfoHolder;
    }

    public String getCustomerID(){
        setID();
        return ID;
    }

    public void setBuyDate(LocalDate d){
        date = d;
    }

    public String getBuyDate(){
        return date.toString();
    }


    
}
