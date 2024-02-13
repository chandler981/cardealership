package org.dealership;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class guiController {
    
    @FXML
    private PasswordField employeePassword;

    @FXML
    private TextField employeeUsername;

    private Stage mainWindow; //creates a stage object to be used

    //this method creates the main window from the guiForInputAndGraph class
    public void setMainWindow(Stage mainWindow){ //method that sets the stage equal to the window provided
        this.mainWindow = mainWindow;
    }

    @FXML
    void checkEmployeeInfo(ActionEvent event) { //action event method for the button on the login screen
        employeeInformationSQL employeeLoginCheck = new employeeInformationSQL();
        String password = employeePassword.getText();
        String username = employeeUsername.getText();
        employeeLoginCheck.checkLogin(username, password);
    }

    
}
