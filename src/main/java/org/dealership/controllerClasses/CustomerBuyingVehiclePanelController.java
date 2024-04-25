/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 4 / 25 / 2024
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

import org.dealership.mainClass;
import org.dealership.Entities.Customer;
import org.dealership.backend.CustomerInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CustomerBuyingVehiclePanelController implements Initializable{
    
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

    mainClass driver = new mainClass();
    CustomerInformationDAO customer = new CustomerInformationDAO();
    Customer c = new Customer();

    @FXML
    void BuyVehicle(ActionEvent event) throws IOException {
        /*
         * add in functionality where it pushes entered info to the
         * invoice controller class and to the database if needed
        */
        c.setBuyDate(CustomerPurchaseDate.getValue());
        CreateInvoiceController inv = new CreateInvoiceController();
        driver.changeScene("CreateInvoicePanel.fxml");
        
        // inv.fillText();
    }

    //method that allows for the choice box to be populated with set data options
    //for the employee to select from if needed
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
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    /*
     * Method that utilizes a static array and then takes said info
     * at given indeces and then pushes it to the text fields so that
     * the employee can see the info and that it can then be pushed to the 
     * database for the invoice.
     */
    @FXML
    void ShowCustomerInfo(ActionEvent event) {
        Customer c = new Customer();
        System.out.println(c.getSSN());
        CustomerIDBuying.setText(c.getCustomerID());

        CustomerIDBuying.setText(customer.getCustomerID());
        String customerInfo[] = customer.getInformationForBuyingPage(customer.getCustomerID());
        CustomerAddress.setText(customerInfo[6]);
        CustomerDownPayment.setText((String) customerInfo[7]);
        CustomerPaymentType.setText(customerInfo[10]);
    }
}