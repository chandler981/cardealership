/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 2 / 13 / 2024
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

import org.dealership.driverClass;
import org.dealership.backend.customerInformationSQL;
import org.dealership.backend.vehicleInformationSQL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VehicleTradeInInformationPanelController {

    driverClass driver = new driverClass();
    customerInformationSQL customer = new customerInformationSQL();

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

        vehicleInformationSQL tradeIn = new vehicleInformationSQL();
        tradeIn.addTradeInVehicleInfoHelper(tradeInTransmission, tradeInColor, tradeInMake, tradeInMiles, tradeInModel, tradeInVIN, tradeInVerification, tradeInYear, tradeInType);
        driver.changeScene("CustomerBuyingVehiclePanel.fxml");
    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void TestButtonToChangeScene(ActionEvent event) throws IOException {
        driver.changeScene("CustomerBuyingVehiclePanel.fxml");
    }

}
