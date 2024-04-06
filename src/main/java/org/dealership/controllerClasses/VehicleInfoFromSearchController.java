package org.dealership.controllerClasses;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.dealership.driverClass;
import org.dealership.Entities.vehicle;
import org.dealership.backend.VehicleInformationDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehicleInfoFromSearchController implements Initializable{
    
    @FXML
    private TableColumn<vehicle, String> AvailabilityColumn;
    
    @FXML
    private TableColumn<vehicle, String> DiscountColumn;
    
    @FXML
    private TableColumn<vehicle, String> PurchaseFromColumn;
    
    @FXML
    private TableColumn<vehicle, String> TransmissionColumn;
    
    @FXML
    private TableColumn<vehicle, String> VehicleColorColumn;
    
    @FXML
    private TableColumn<vehicle, String> VehicleMilesColumn;
    
    @FXML
    private TableColumn<vehicle, String> VehicleMakeColumn;
    
    @FXML
    private TableColumn<vehicle, String> VehicleModelColumn;
    
    @FXML
    private TableColumn<vehicle, String> VehicleTypeColumn;
    
    @FXML
    private TableColumn<vehicle, String> VehicleYearColumn;
    
    @FXML
    private TableColumn<vehicle, String> VehiclePrice;
    
    @FXML
    private TableColumn<vehicle, String> VehicleCondition;
    
    @FXML
    private TableView<vehicle> tableShowingResults;
    
    driverClass driver = new driverClass();
    VehicleInformationDAO vehicleTest = new VehicleInformationDAO();
    ObservableList<vehicle> results = FXCollections.observableArrayList();
    ObservableList<vehicle> dealResults = FXCollections.observableArrayList();
    String queryUsed;
    
    @FXML
    void TestingQueryToDisplay(ActionEvent event) {
        // for(int i = 0; i < results.size(); i++){ //get this method accept the inputs from the objects in the results list
            //     result = this.results.get(i);
            //     System.out.println(result.getVehicleMake());
            // }
    }
        
    @Override
    public void initialize(URL location, ResourceBundle resources) 
        {
        // tableShowingResults.clea
        SearchVehicleInformationPanelController query = new SearchVehicleInformationPanelController();
        
        String vehicleInfo = query.getQuery();
        // String vehicleInfo = "select * from vehicle where vehicleMake = 'Hyundai' and vehicleModel = 'santa fe' and vehicleType = 'suv' and vehicleColor = 'white' and vehicleYear = '2021' and vehicleMileage = 15000";
        String vehicleDeal = query.getDealQuery();
        //String vehicleDeal = "select discount from deal where vehicleType = 'suv'"; 

        this.results = FXCollections.observableArrayList(vehicleTest.vehicleSearchResultHelper(vehicleInfo, vehicleDeal));
        System.out.println(results);

        VehicleMakeColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleMake"));
        VehicleModelColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleModel"));
        VehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleType"));
        VehicleColorColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleColor"));
        AvailabilityColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleAvail"));
        VehicleYearColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleYear"));
        TransmissionColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleTransmission"));
        VehicleMilesColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleMiles"));
        VehicleCondition.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleCondition"));
        VehiclePrice.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehiclePrice"));
        DiscountColumn.setCellValueFactory(new PropertyValueFactory<vehicle, String>("VehicleDiscount"));
        
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
