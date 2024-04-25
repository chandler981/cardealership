    /*
    * Author:       Chandler Ward
    * Written:      2 / 6 / 2024
    * Last Updated: 4 / 25 / 2024
    * 
    * Compilation:  javac driverClass.java
    * Execution:    java driverClass
    * 
    * This file is for updating the employee's
    * commissions based on how many sales they make
    * over a specified time slot.
    *  
    * % java driverClass
    */

    package org.dealership.controllerClasses;

    import java.io.IOException;

    import org.dealership.mainClass;
    import org.dealership.Entities.Employee;
    import org.dealership.backend.EmployeeInformationDAO;
import org.dealership.backend.InputValidation;

import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.TextField;

    public class CalcEmpCommissionController {

    mainClass driver = new mainClass();
    Employee emp = new Employee();
    EmployeeInformationDAO empSQL = new EmployeeInformationDAO();

    @FXML
    private TextField comissionAmnt;

    @FXML
    private TextField employeeIDForComission;

    /*
     * Method that is attached to a button that allows
     * for a employees comission amount to be taken and 
     * then calculated manually and put into the database
     */
    @FXML
    void CalculateComissionAmount(ActionEvent event) throws IOException, InterruptedException{
        InputValidation validation = new InputValidation();
        boolean allValid = true;

        if(!validation.commissionValidation(comissionAmnt.getText())){
            allValid = false;
            comissionAmnt.clear();
            comissionAmnt.setText("Invalid");

        }

        if(!validation.IDValidaiton(employeeIDForComission.getText())){
            allValid = false;
            employeeIDForComission.clear();
            employeeIDForComission.setText("Invalid");

        }

        if(allValid){
            String newComm = comissionAmnt.getText();
            Double newCommVal = Double.parseDouble(newComm);
            System.out.println("entered ammount is " + newCommVal);
            emp.computeCommHelper(newCommVal);
            empSQL.inputNewCommAmntHelper(employeeIDForComission.getText());
        }
        else{
            System.out.println("Multiple inputs invalid. Try again.");
        }

    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }


    }
