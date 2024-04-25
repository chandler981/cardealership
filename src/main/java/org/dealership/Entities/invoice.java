/*
 * Author:       Chandler Ward, Zhania Douglas
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

public class Invoice{

    // Data Fields for each attribute
    static String custAddress = "No Address Specified";
    static String fees = "No Address Specified";
    static String custID = "No Address Specified";
    static String discountTotal = "No Address Specified";
    static String paymentTotal = "No Address Specified";
    static String paymentType = "No Address Specified";
    static String purchaseDate = "No Address Specified";

    
    public Invoice(String custAddress, String fees, String custID, String discountTotal, String paymentTotal, String paymentType, String purchaseDate){
    // Assigning each argument to the corresponding data field
     this.custAddress = custAddress;
     this.fees = fees;
     this.custID = custID;
     this.discountTotal = discountTotal;
     this.paymentTotal = paymentTotal;
     this.paymentType = paymentType;
     this.purchaseDate = purchaseDate;
    }


    public String getCustAddress() {
        return this.custAddress;
    }
    
    public String getFees() {
        return this.fees;
    }
    
    public String getCustID() {
        return this.custID;
    }
    
    public String getDiscountTotal() {
     return this.discountTotal;
    }
    
    public String getPaymentTotal() {
        return this.paymentTotal;
    }
    
    public String getPaymentType () {
        return this.paymentType;
    }
    
    public String getPurchaseDate () {
        return this.purchaseDate;
    }
    
}
