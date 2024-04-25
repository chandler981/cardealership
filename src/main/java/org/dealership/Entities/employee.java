/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
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

    private static boolean currentEmployeeStatus;

    private static double fivePercComm = 0.05;
    private static double sevenPercComm = 0.07;

    private double saleAmmount;

    private double employeePaymentAmmount;

    employeeInformationSQL empSQL = new employeeInformationSQL();

    private void updateEmployeeInformation(){

    }

    private void createEmployeeID(){

    }

    public void currentEmployeeStatusUpdate(Boolean statusUpdate){
        currentEmployeeStatus = statusUpdate;
        System.out.println("status is updated");
    }

    public Boolean getEmployeeStatus(){
        return currentEmployeeStatus;
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

    //Method calculates a comission amount based on the sale of a vehicle
    private void computeCommissions(){
        if(saleAmmount <= 100000.0){ // checks if sales made by employee are <= 100k
            employeePaymentAmmount = saleAmmount * 0.05;
        }
        if(saleAmmount > 100000.0 && saleAmmount <= 200000.0){ //checks if sales made by employee are > 100k or between 200k
            employeePaymentAmmount = saleAmmount * 0.07;
        }
    }

    public double getEmpPaymentAmmnt(){
        return employeePaymentAmmount;
    }

    private void salesData(){

    }    
 }
