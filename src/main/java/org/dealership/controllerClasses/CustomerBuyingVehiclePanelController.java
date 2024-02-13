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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CustomerBuyingVehiclePanelController {

    driverClass driver = new driverClass();

    @FXML
    private TextField CustomerAddress;

    @FXML
    private ChoiceBox<?> CustomerBuyOption;

    @FXML
    private TextField CustomerDIscount;

    @FXML
    private TextField CustomerDownPayment;

    @FXML
    private TextField CustomerIDBuying;

    @FXML
    private TextField CustomerPaymentType;

    @FXML
    private DatePicker CustomerPurchaseDate;

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }
    
}
