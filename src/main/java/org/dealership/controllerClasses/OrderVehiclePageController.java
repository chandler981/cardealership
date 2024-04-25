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
 
 import org.dealership.mainClass;
import org.dealership.Entities.Employee;
import org.dealership.backend.VehicleInformationDAO;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 import javafx.scene.control.ChoiceBox;
 import javafx.scene.control.TextField;
 
 public class OrderVehiclePageController {
    ObservableList<String> orderFromOpitionList = FXCollections.observableArrayList("Manufacture", "Dealer A", "Dealer B");
 
    mainClass driver = new mainClass();
    Employee currentEmployee = new Employee();
 
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
     private ChoiceBox<String> OrderFromOptions;

     @FXML
     private void initialize(){
        OrderFromOptions.setValue("Manufacture");
        OrderFromOptions.setItems(orderFromOpitionList);
     }
 
     @FXML
     void OrderVehicle(ActionEvent event) {
      String OrderFromOptionsString=OrderFromOptions.toString();
      String VehicleColor= VehicleColorOrder.getText();
      String VehicleMake= VehicleMakeOrder.getText();
      String VehicleModel= VehicleModelOrder.getText();
      String VehicleTransType= VehicleTransTypeOrder.getText();
      String VehicleType= VehicleTypeOrder.getText();
      String VehicleYear= VehicleYearOrder.getText();
      VehicleInformationDAO vehicle = new VehicleInformationDAO();
      vehicle.OrderVecHelper(VehicleColor, VehicleMake, VehicleModel, VehicleTransType, VehicleType, VehicleYear, OrderFromOptionsString);
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
