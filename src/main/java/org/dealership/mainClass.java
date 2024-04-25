/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for running the application and handling
 * the stages or the parts of the GUI that is used.
 *  
 * % java driverClass
 */

package org.dealership;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainClass extends Application{

    private static Stage stage; //stage variable for the ui to be able to cycle between scenes

    //in the password section put whatever password was created in your mySQL for the database on your desktop, this will allow you to connect and test queries and all
    private static String sqlConnection = "jdbc:mysql://localhost:3306/mysql?user = root & password = G@607537"; //password will need to be changed based on what your MySQL password is set to

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    public void start(Stage primaryStage){
        try{
            try{
                stage = primaryStage;
                Parent root = FXMLLoader.load((getClass().getResource("/fxmlFiles/CalculateComissionPage.fxml")));
                Scene newScene = new Scene(root, 750, 530);
                primaryStage.setScene(newScene);
                primaryStage.setResizable(true);
                primaryStage.show();
            }
            catch(Exception e){
                System.err.println("Error loading LoginScene:");
                e.printStackTrace();
            }
        }
        catch(Exception e){
            System.out.println("GUI couldn't be created. The error occurs at. ");
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml) throws IOException { //changes the scene based on the input from other methods via button presses
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/" + fxml));
        stage.getScene().setRoot(root);
    }

    //method for helping with persisting info from one page to another when its needed
    public void changeScene(String fxml, Parent root) throws IOException{
        stage.getScene().setRoot(root);
    }

    public String getConnection(){
        return sqlConnection;
    }
}
