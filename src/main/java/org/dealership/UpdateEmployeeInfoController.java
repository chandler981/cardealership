/*
 * Author:       
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for updating a specified employees information 
 * based on what the manager inputs into the page.
 *  
 * % java driverClass
 */

package org.dealership;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateEmployeeInfoController {

    driverClass driver = new driverClass();

     @FXML
    private TextField EmpAddressChange;

    @FXML
    private TextField EmpBankNumChange;

    @FXML
    private TextField EmpDOBChange;

    @FXML
    private TextField EmpIDChange;

    @FXML
    private TextField EmpPhoneNumChange;

    @FXML
    private TextField EmpSSNChange;

    @FXML
    private TextField EmpTotalSalesChange;

    @FXML
    void UpdateEmployeeInfo(ActionEvent event) {

    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }

    
}
