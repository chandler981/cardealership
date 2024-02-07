/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling the information that
 * the manager types into the page and for ordering the
 * vehicle from either the manufacturer or another
 * dealership
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class OrderVehiclePageController {

    driverClass driver = new driverClass();

    @FXML
    private TextField VehicleColorOrder;

    @FXML
    private TextField VehicleMakeOrder;

    @FXML
    private TextField VehicleModelOrder;

    @FXML
    private TextField VehicleTransTypeOrder;

    @FXML
    private TextField VehicleTypeOrder;

    @FXML
    private TextField VehicleYearOrder;

    @FXML
    private ChoiceBox<?> OrderFromOptions;

    @FXML
    void OrderVehicle(ActionEvent event) {

    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }

}
