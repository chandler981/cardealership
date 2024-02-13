package org.dealership;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class driverClass extends Application{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreenPanel.fxml"));
            Parent root = loader.load();
            guiController controllerOne = loader.getController();
            controllerOne.setMainWindow(primaryStage);
            Scene newScene = new Scene(root, 600, 400);
            primaryStage.setTitle("Employee Sign In");
            primaryStage.setScene(newScene);
            primaryStage.show();
        }
        catch(Exception e){
            System.out.println("GUI couldn't be created. The error occurs at. ");
            e.printStackTrace();
        }
        
    }
}
