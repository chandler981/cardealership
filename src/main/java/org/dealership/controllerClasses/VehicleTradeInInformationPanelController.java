/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for allowing the employee to
 * enter the information on the vehicle a customer
 * is trading in so it can be added to the database
 * and so that it can be used to calcualte any discounts
 * the customer may get from it.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.mainClass;
import org.dealership.Entities.Customer;
import org.dealership.backend.CustomerInformationDAO;
import org.dealership.backend.VehicleInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VehicleTradeInInformationPanelController {

    mainClass driver = new mainClass();
    CustomerInformationDAO customer = new CustomerInformationDAO();

    @FXML
    private TextField TradeInVehiclTransmission;

    @FXML
    private TextField TradeInVehicleColor;

    @FXML
    private TextField TradeInVehicleMake;

    @FXML
    private TextField TradeInVehicleMileage;

    @FXML
    private TextField TradeInVehicleModel;

    @FXML
    private TextField TradeInVehicleType;

    @FXML
    private TextField TradeInVehicleVIN;

    @FXML
    private TextField TradeInVehicleVINVerification;

    @FXML
    private TextField TradeInVehicleYear;

    @FXML
    void EnterTradeInVehicleInfo(ActionEvent event) throws IOException {
        if((TradeInVehiclTransmission.getText().isEmpty() && TradeInVehicleColor.getText().isEmpty()&& TradeInVehicleMileage.getText().isEmpty() && 
            TradeInVehicleModel.getText().isEmpty() && TradeInVehicleVIN.getText().isEmpty() && TradeInVehicleYear.getText().isEmpty() && 
            TradeInVehicleType.getText().isEmpty()) == true){
                driver.changeScene("CustomerBuyingVehiclePanel.fxml");
        }
        else{
            String tradeInTransmission = TradeInVehiclTransmission.getText();
            String tradeInColor = TradeInVehicleColor.getText();
            String tradeInMake = TradeInVehicleMake.getText();
            int tradeInMiles = Integer.parseInt(TradeInVehicleMileage.getText());
            String tradeInModel = TradeInVehicleModel.getText();
            String tradeInVIN = TradeInVehicleVIN.getText();
            Boolean tradeInVerification = true;
            String tradeInYear = TradeInVehicleYear.getText();
            String tradeInType = TradeInVehicleType.getText();
    
            //tradeInTrans, tradeInColor, tradeInMake, tradeInMiles, tradeInModel, tradeInVIN, tradeInVerif, tradeInYear
    
            VehicleInformationDAO tradeIn = new VehicleInformationDAO();
            tradeIn.addTradeInVehicleInfoHelper(tradeInTransmission, tradeInColor, tradeInMake, tradeInMiles, tradeInModel, tradeInVIN, tradeInVerification, tradeInYear, tradeInType);
            driver.changeScene("CustomerBuyingVehiclePanel.fxml");
        }
    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void TestButtonToChangeScene(ActionEvent event) throws IOException {
        Customer c = new Customer();
        driver.changeScene("CustomerBuyingVehiclePanel.fxml");
    }

}
