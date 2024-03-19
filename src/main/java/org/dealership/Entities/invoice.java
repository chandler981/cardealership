/*
 * Author:       Chandler Ward, Zhania Douglas
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
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
    String custAddress = "No Address Specified";
    String fees = "No Address Specified";
    String custID = "No Address Specified";
    String discountTotal = "No Address Specified";
    String paymentTotal = "No Address Specified";
    String paymentType = "No Address Specified";
    String purchaseDate = "No Address Specified";

    
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
