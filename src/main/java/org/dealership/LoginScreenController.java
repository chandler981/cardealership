package org.dealership;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {

    driverClass driver = new driverClass();
    
    @FXML
    private PasswordField employeePassword;

    @FXML
    private TextField employeeUsername;

    @FXML
    void checkEmployeeInfo(ActionEvent event) throws IOException { //action event method for the button on the login screen
        employeeInformationSQL employeeLoginCheck = new employeeInformationSQL();
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
