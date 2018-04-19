package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;

public class MenuController {

    private Stage stage;
    private DsController controller;
    public void init(DsController controller, Stage stage){
        this.stage = stage;
        this.controller = controller;
    }

    @FXML
    private Button checkInfo;

    @FXML
    private Button moreManage;

    @FXML
    private Button dm;
    @FXML
    private void checkBtn(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pane.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            PaneController converController =  loader.getController();
            converController.init(this, conStage);



            conStage.setTitle("hei");
            conStage.setScene(new Scene(conRoot));
            conStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void dmBtn(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pane.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            PaneController converController =  loader.getController();
            converController.init(this, conStage);



            conStage.setTitle("yo");
            conStage.setScene(new Scene(conRoot));
            conStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void manageBtn(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pane.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            PaneController converController =  loader.getController();
            converController.init(this, conStage);



            conStage.setTitle("yes");
            conStage.setScene(new Scene(conRoot));
            conStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
