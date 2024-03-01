/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 2 / 13 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for creating the invoice for 
 * the customer and the dealership when a vehicle
 * is purchased.
 *  
 * % java driverClass
 */
package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateInvoiceController {

    driverClass driver = new driverClass();

    @FXML
    private TextField BuyerAddressInvoice;

    @FXML
    private TextField BuyerFeesInvoice;

    @FXML
    private TextField CustomerIDInvoice;

    @FXML
    private TextField DiscountTotalInvoice;

    @FXML
    private TextField PaymentTotalInvoice;

    @FXML
    private TextField PaymentTypeInvoice;

    @FXML
    private TextField PurchaseDateInvoice;

    @FXML
    void generateInvoiceButton(ActionEvent event) {

    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }
    
}
