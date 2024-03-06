/*
* Author:       Chandler Ward
* Written:      2 / 13 / 2024
* Last Updated: 2 / 13 / 2024
* 
* Compilation:  javac driverClass.java
* Execution:    java driverClass
* 
* This file is for just simply displaying
* the weekly deals that the manager selected
* for that week.
*  
* % java driverClass
*/

package org.dealership.controllerClasses;

import java.io.IOException;
import org.dealership.driverClass;
import org.dealership.Entities.Vehicle;
import org.dealership.backend.dealInfomationDAO;
import org.dealership.backend.vehicleInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class WeeklyDealsPanelController {

   driverClass driver = new driverClass();

   @FXML
   private TextField Discount;

   @FXML
   private TextField Type;

   @FXML
   void MakeDeal(ActionEvent event) {

       String vehicleType = Type.getText();

       //would put method to ensure type matches casing of all samilar types
       Float discount = Float.parseFloat(Discount.getText()) ;
       discount=(float) (discount/100.00);

       //standardized input so check for uppercase of vehicle Type
       vehicleType=vehicleType.toUpperCase();

       dealInfomationDAO deal = new dealInfomationDAO();
       deal.discountingHelp(vehicleType, discount);
   }

   @FXML
   void GoBackToManageOptions(ActionEvent event) throws IOException {
       driver.changeScene("ManagerOptionPanel.fxml");
   }

   
}
