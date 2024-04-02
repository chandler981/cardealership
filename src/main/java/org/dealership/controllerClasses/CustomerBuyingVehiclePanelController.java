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
import java.net.URL;
import java.util.ResourceBundle;

import org.dealership.driverClass;
import org.dealership.backend.CustomerInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CustomerBuyingVehiclePanelController implements Initializable{

    driverClass driver = new driverClass();
    CustomerInformationDAO customer = new CustomerInformationDAO();

    @FXML
    private TextField CustomerAddress;

    @FXML
    private ChoiceBox<String> CustomerBuyOption = new ChoiceBox();

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

    //method that allows for the choice box to be populated with set data options
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            String[] options = {"Nothing Selected",  "buy from dealer", "buy from secondary", "buy from manufacturer"};
            CustomerBuyOption.getItems().addAll(options);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

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
