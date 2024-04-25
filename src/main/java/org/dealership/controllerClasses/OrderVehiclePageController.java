/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
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
import org.dealership.Entities.employee;

import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.scene.control.ChoiceBox;
 import javafx.scene.control.TextField;
 
 public class OrderVehiclePageController {
 
    driverClass driver = new driverClass();
    employee currentEmployee = new employee();
 
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
 
     //method that is attached to a butotn that assigns the 
     //text field inputs to variables that are then passed to 
     //an object of a DAO class so that the information can be 
     //stored for use
     @FXML
     void OrderVehicle(ActionEvent event) {
 
     }
 
     @FXML
     void goBackButton(ActionEvent event) throws IOException {
        if(currentEmployee.getEmployeeStatus() == true){
            driver.changeScene("ManagerOptionPanel.fxml");
            System.out.println(currentEmployee.getEmployeeStatus());
        }else{
            driver.changeScene("EmployeeOptionsPanel.fxml");
            System.out.println("status is employee");
        }
     }
 
 }
