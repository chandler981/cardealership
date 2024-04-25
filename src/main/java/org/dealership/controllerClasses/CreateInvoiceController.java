/*
 * Author:       Chandler Ward, Zhania Douglas
 * Written:      2 / 13 / 2024
 * Last Updated: 4 / 25 / 2024
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

import org.dealership.mainClass;
import org.dealership.Entities.Customer;
import org.dealership.Entities.Invoice;
import org.dealership.backend.CustomerInformationDAO;
import org.dealership.backend.InvoiceDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateInvoiceController {

    mainClass driver = new mainClass();

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

    /*
     * Method that is called on when the text fields
     * are required to be filled in, it does this by 
     * using an object of a different class and then
     * accessing a static array via this object
     */
    public void fillText(){
      CustomerInformationDAO c = new CustomerInformationDAO();
      Customer cust = new Customer();
      String Info [] = c.customerInfoHolder;

      // BuyerFeesInvoice.setText();
      // DiscountTotalInvoice.setText();
      // PaymentTotalInvoice.setText();
      CustomerIDInvoice.setText(c.customerID);
      PaymentTypeInvoice.setText(Info[7]);
      PurchaseDateInvoice.setText(cust.getBuyDate());
      BuyerAddressInvoice.setText(Info[6]);
      for(int i = 0; i < Info.length; i++){
        System.out.println("Info array " + Info[i]);
        System.out.println("Info array from customer class " + c.customerInfoHolder[i]);
      }
    }

    @FXML
    void AutoFill(ActionEvent event) {
      fillText();
    }

    @FXML
    void generateInvoiceButton(ActionEvent event) {
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

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }
}
