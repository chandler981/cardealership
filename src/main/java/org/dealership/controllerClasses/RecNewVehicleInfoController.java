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

import org.dealership.mainClass;
import org.dealership.backend.InputValidation;
import org.dealership.backend.VehicleInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RecNewVehicleInfoController {

    mainClass driver = new mainClass();
    boolean allValid = true;
    InputValidation validation = new InputValidation();

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

    @FXML
    void EnterVehicleInfoToDB(ActionEvent event) {

        if(!validation.carColorValidation(CarColorTF.getText())) {
            allValid = false;
            CarColorTF.clear(); 
        }
        if(!validation.carMakeValidation(CarMakeTF.getText())) {
            allValid = false;
            CarMakeTF.clear(); 
        } 
        if(!validation.carMileageValidation(CarMileageTF.getText())) {
            allValid = false;
            CarMileageTF.clear(); 
        } 
        if(!validation.carModelValidation(CarModelTF.getText())) {
            allValid = false;
            CarModelTF.clear(); 
        } 
        if(!validation.carTransmissionValidation(CarTransmissionTF.getText())) {
            allValid = false;
            CarTransmissionTF.clear(); 
        } 
        if(!validation.carTypeValidation(CarTypeTF.getText())) {
            allValid = false;
            CarTypeTF.clear(); 
        } 
        if(!validation.carVINValidation(CarVINTf.getText())) {
            allValid = false;
            CarVINTf.clear(); 
        } 
        if(!validation.carYearValidation(CarYearTF.getText())) {
            allValid = false;
            CarYearTF.clear(); 
        } 
        if(!validation.carConditionValidation(VehicleConditionTF.getText())) {
            allValid = false;
            VehicleConditionTF.clear(); 
        }  
         
        if(allValid) {
            VehicleInformationDAO vehicle = new VehicleInformationDAO();
            vehicle.addNewVehicleInfoHelper(CarColorTF.getText(), CarMakeTF.getText(), Integer.parseInt(CarMileageTF.getText()), 
                                            CarModelTF.getText(), CarTransmissionTF.getText(), CarTypeTF.getText(), 
                                            CarVINTf.getText(), CarYearTF.getText(), VehicleConditionTF.getText());
        } else {
            // Optionally, display an error message to the user in the console
            System.out.println("Invalid input in one or more fields. Please correct and try again.");
        }
    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }

    
}
