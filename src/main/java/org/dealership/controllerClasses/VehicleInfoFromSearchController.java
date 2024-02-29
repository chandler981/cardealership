package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VehicleInfoFromSearchController {
    driverClass driver = new driverClass();

    @FXML
    void GoBack(ActionEvent event) throws IOException {
        driver.changeScene("UpdateEmployeeInfoPanel.fxml");
    }

    @FXML
    void GoToRecordCustInfo(ActionEvent event) throws IOException {
        driver.changeScene("RecordCustomerInfoPanel.fxml");
    }
    
}
