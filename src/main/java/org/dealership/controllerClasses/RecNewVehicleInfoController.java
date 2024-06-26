/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling the information that
 * the manager inputs into the screen for a new vehicle
 * that they get, thats not a used vehicle, and then pushing
 * it to the class that handles the sql portion of updating 
 * the database with the new information.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;
import org.dealership.backend.vehicleInformationSQL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RecNewVehicleInfoController {

    driverClass driver = new driverClass();

    @FXML
    private TextField CarColorTF;

    @FXML
    private TextField CarMakeTF;

    @FXML
    private TextField CarMileageTF;

    @FXML
    private TextField CarModelTF;

    @FXML
    private TextField CarTransmissionTF;

    @FXML
    private TextField CarTypeTF;

    @FXML
    private TextField CarVINTf;

    @FXML
    private TextField CarYearTF;

    @FXML
    private TextField VehicleConditionTF;

    /*
     * Method that is attached to a button that is used
     * for manually entering a new vehicle into the vehicle
     * database via the manager, everything in the textfields
     * gets run through the input validation methods and then
     * passed to the corresponding class to be pushed to the database
     */
    @FXML
    void EnterVehicleInfoToDB(ActionEvent event) {
        String vehicleColor = CarColorTF.getText();
        String vehicleMake = CarMakeTF.getText();
        int vehicleMileage = Integer.parseInt(CarMileageTF.getText());
        String vehicleModel = CarModelTF.getText();
        String vehicleTransmission = CarTransmissionTF.getText();
        String vehicleType = CarTypeTF.getText();
        String vehicleVIN = CarVINTf.getText();
        String vehicleYear = CarYearTF.getText();
        String vehicleCondition = VehicleConditionTF.getText();

        vehicleInformationSQL vehicle = new vehicleInformationSQL();

        vehicle.addNewVehicleInfoHelper(vehicleColor, vehicleMake, vehicleMileage, vehicleModel, vehicleTransmission, vehicleType, vehicleVIN, vehicleYear, vehicleCondition);
    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }

    
}
