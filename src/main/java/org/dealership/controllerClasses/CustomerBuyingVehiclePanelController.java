/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 2 / 13 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for allowing the employee
 * to enter the customers information for when 
 * they choose to buy a vehicle, it handles all
 * the information entered.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;
import org.dealership.backend.CustomerInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CustomerBuyingVehiclePanelController {

    driverClass driver = new driverClass();
    CustomerInformationDAO customer = new CustomerInformationDAO();

    @FXML
    private TextField CustomerAddress;

    @FXML
    private ChoiceBox<?> CustomerBuyOption;

    @FXML
    private TextField CustomerDiscount;

    @FXML
    private TextField CustomerDownPayment;

    @FXML
    private TextField CustomerIDBuying;

    @FXML
    private TextField CustomerPaymentType;

    @FXML
    private DatePicker CustomerPurchaseDate;

    @FXML
    void BuyVehicle(ActionEvent event) throws IOException {
        /*
         * add in functionality where it pushes entered info to the
         * invoice controller class and to the database if needed
        */

        driver.changeScene("CreateInvoicePanel.fxml");
    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void ShowCustomerInfo(ActionEvent event) {
        System.out.println(customer.getCustomerID());
        String customerInfo[] = customer.getInformationForBuyingPage();
        CustomerAddress.setText(customerInfo[6]);
        CustomerDownPayment.setText((String) customerInfo[7]);
        CustomerIDBuying.setText(customer.getCustomerID());
        CustomerPaymentType.setText(customerInfo[10]);
    }
}
