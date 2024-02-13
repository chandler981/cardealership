/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for running handling figuring out a customers 
 * new commission amount, total sales, and other information like
 * that.
 *  
 * % java driverClass
 */

package org.dealership.Entities;

import org.dealership.backend.employeeInformationSQL;

public class employee {

    private String name;
    private String DOB;
    private String SSN;
    private String PhoneNum;
    private String address;
    private String bankAccntNum;
    private int totalSalesMade;

    private static double fivePercComm = 0.05;
    private static double sevenPercComm = 0.07;

    private double saleAmmount;

    private static double employeePaymentAmmount;

    employeeInformationSQL empSQL = new employeeInformationSQL();

    private void updateEmployeeInformation(){

    }

    private void createEmployeeID(){

    }

    public void computeCommHelper(double saleAmmount){
        setSaleAmmnt(saleAmmount);
    }

    public void setSaleAmmnt(double saleAmmount){
        this.saleAmmount = saleAmmount;
    }

    public double getSaleAmmnt(){
        return this.saleAmmount;
    }

    public double getEmpPaymentAmmnt(){
        computeCommissions();
        return employeePaymentAmmount;
    }

    private void computeCommissions(){
        if(this.saleAmmount <= 100000.0){ // checks if sales made by employee are <= 100k
            employeePaymentAmmount = this.saleAmmount * 0.05;
        }
        if(this.saleAmmount > 100000.0 && this.saleAmmount <= 200000.0){ //checks if sales made by employee are > 100k or between 200k
            employeePaymentAmmount = this.saleAmmount * 0.07;
        }
    }


    private void salesData(){

    }    
}