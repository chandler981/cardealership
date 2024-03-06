package org.dealership.controllerClasses;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.dealership.driverClass;
import org.dealership.Entities.Vehicle;
import org.dealership.backend.vehicleInformationDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehicleInfoFromSearchController implements Initializable{
    driverClass driver = new driverClass();
    vehicleInformationDAO vehicleTest = new vehicleInformationDAO();
    Vehicle result;
    ObservableList<Vehicle> results = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Vehicle, String> AvailabilityColumn;

    @FXML
    private TableColumn<Vehicle, String> DiscountColumn;

    @FXML
    private TableColumn<Vehicle, String> PurchaseFromColumn;

    @FXML
    private TableColumn<Vehicle, String> TransmissionColumn;

    @FXML
    private TableColumn<Vehicle, String> VehicleColorColumn;

    @FXML
    private TableColumn<Vehicle, String> VehicleMilesColumn;

    @FXML
    private TableColumn<Vehicle, String> VehicleMakeColumn;

    @FXML
    private TableColumn<Vehicle, String> VehicleModelColumn;

    @FXML
    private TableColumn<Vehicle, String> VehicleTypeColumn;

    @FXML
    private TableColumn<Vehicle, String> VehicleYearColumn;

    @FXML
    private TableColumn<Vehicle, String> VehiclePrice;

    @FXML
    private TableColumn<Vehicle, String> VehicleCondition;

    @FXML
    private TableView<Vehicle> tableShowingResults;

    @FXML
    void TestingQueryToDisplay(ActionEvent event) {
        for(int i = 0; i < results.size(); i++){ //get this method accept the inputs from the objects in the results list
            result = this.results.get(i);
            // tableShowingResults.setItems(vehicleTest.resultHolder);
            System.out.println(result.getVehicleMake());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.results = FXCollections.observableArrayList(vehicleTest.vehicleSearchResultHelper("select * from vehicle"));
        VehicleMakeColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleMake"));
        VehicleModelColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleModel"));
        VehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleType"));
        VehicleColorColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleColor"));
        AvailabilityColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleAvail"));
        VehicleYearColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleYear"));
        TransmissionColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleTransmission"));
        VehicleMilesColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleMiles"));
        VehicleCondition.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleCondition"));
        VehiclePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehiclePrice"));
        // DiscountColumn.setCellFactory(new PropertyValueFactory<>(null));
        // PurchaseFromColumn.setCellValueFactory(new PropertyValueFactory<>("Vehicle4Availablitiy"));
        
        tableShowingResults.setItems(this.results);
    }


    @FXML
    void GoBack(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void GoToRecordCustInfo(ActionEvent event) throws IOException {
        driver.changeScene("RecordCustomerInfoPanel.fxml");
    }

    
}
