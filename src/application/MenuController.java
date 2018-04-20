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

    public void init2(MenuController controller, Stage stage){
		this.stage = stage;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CheckPane.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            AddController converController =  loader.getController();
            converController.init2(this, conStage);



            conStage.setTitle("hei");
            conStage.setScene(new Scene(conRoot));
            conStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML

	public void dmBtn() throws FileNotFoundException {
        try {//显示所有学生数据
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DmPage.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            DmMenu converController = loader.getController();
            converController.init(this, conStage);
            conStage.setTitle("点名！");
            conStage.setScene(new Scene(conRoot));
            conStage.show();
        }
        catch(Exception e) {
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

    public static void onAbsent(String Number) throws FileNotFoundException, Exception {//修改学生4
        int i =0;
    	File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        }



        Student[] stu = new Student[i];
        try(Scanner Input = new Scanner(fl)){
            for(int j =0; j < i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt(),Input.nextInt());
                if(Number.compareTo(stu[j].GetNumber()) == 0){
                    stu[j] = new Student(stu[j].GetName(), stu[j].GetClass(),
                    		stu[j].GetNumber(), stu[j].GetScore(),(stu[j].GetAbsent()+1));
                }
            }
        }

        try(PrintWriter output = new PrintWriter(Fl)){
            output.print(i);
        }

        if(i == 0){
            try (PrintWriter output = new PrintWriter(fl)) {
            }
        }
        else{
            try (PrintWriter output = new PrintWriter(fl)) {
                for(int j = 0;j < i;j ++){
                    output.print(stu[j].GetName() + "\t");
                    output.print(stu[j].GetClass() + "\t");
                    output.print(stu[j].GetNumber() + "\t");
                    output.print(stu[j].GetScore() + "\t");
                    output.println(stu[j].GetAbsent());
                }
            }
        }

    }

    private void BackToMenu(){
		try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));
    		Parent conRoot = loader.load();
			Stage conStage = new Stage();

			MenuController menuController =  loader.getController();
			menuController.init2(this, conStage);



			conStage.setTitle("Con");
			conStage.setScene(new Scene(conRoot));
			conStage.show();
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
	}

}
