/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling the login screen information
 * and sending it to the necessary classes to check if 
 * the information is correct or not.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;
import java.io.IOException;

import org.dealership.driverClass;
import org.dealership.Entities.Employee;
import org.dealership.backend.EmployeeInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {

    driverClass driver = new driverClass();
    Employee emp = new Employee();
    
    @FXML
    private PasswordField employeePassword;

    @FXML
    private TextField employeeUsername;

    @FXML
    void checkEmployeeInfo(ActionEvent event) throws IOException { //action event method for the button on the login screen
        EmployeeInformationDAO employeeLoginCheck = new EmployeeInformationDAO();
        String password = employeePassword.getText();
        String username = employeeUsername.getText();
        employeeLoginCheck.checkLogin(username, password);
    }

    public void changeToManager() throws IOException{
        driver.changeScene("ManagerOptionPanel.fxml");

    }

    public void changeToEmployee() throws IOException{
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    

    
}
