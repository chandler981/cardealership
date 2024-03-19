/*
 * Author:       Chandler Ward, Zhania Douglas
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
import org.dealership.Entities.Invoice;
import org.dealership.backend.InvoiceDAO;

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

    // This method is called by user clicking submit button
    @FXML
		public void createInvoice() {
    	// Pull information from TextFields
      String addressText = BuyerAddressInvoice.getText();
      String feesText = BuyerFeesInvoice.getText();
      String customerIdText = CustomerIDInvoice.getText();
      String discountTotalText = DiscountTotalInvoice.getText();
      String paymentTotalText = PaymentTotalInvoice.getText();
      String paymentTypeText = PaymentTypeInvoice.getText();
      String purchaseDateText = PurchaseDateInvoice.getText();
      
      Invoice inv = new Invoice(addressText, feesText, customerIdText, discountTotalText, paymentTotalText, paymentTypeText, purchaseDateText);
      
      // Pass the inv object to the DAO class for saving
    	InvoiceDAO dao = new InvoiceDAO();
    	dao.saveInvoice(inv);
     
    }
    
}
