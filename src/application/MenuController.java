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

	private void dmBtn() throws FileNotFoundException {//显示所有学生数据
        int i = 0;
		File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        }

        GridPane pane = new GridPane();
        pane.setHgap(20);
        pane.setVgap(10);

        pane.add(new Label("次序") , 0, 0);
        pane.add(new Label("姓名"), 1, 0);
        pane.add(new Label("班级"), 2, 0);
        pane.add(new Label("学号"), 3, 0);
        pane.add(new Label("成绩"), 4, 0);
        pane.add(new Label("缺勤选项"), 5, 0);
        pane.add(new Label("缺勤次数"), 6, 0);
        Student[] stu = new Student[i];
        Text[][] text = new Text[i][5];
        Button[] bt1= new Button[i];
        int j;
        String[] Num=new String[i];//新建数组储存学号（j会销毁不能在onAbsent（）直接用）
        try(Scanner Input = new Scanner(fl)){

            for(j =0; j <i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt(),Input.nextInt());
                text[j][0] = new Text(stu[j].GetName());
                text[j][1] = new Text(stu[j].GetClass());
                text[j][2] = new Text(stu[j].GetNumber());
                text[j][3] = new Text("" + stu[j].GetScore());
                text[j][4] = new Text("" + stu[j].GetAbsent());
                bt1[j]=new Button("缺勤");
                pane.add(new Label("" + j + 1), 0, j + 1);
                pane.add(text[j][0], 1, j + 1);
                pane.add(text[j][1], 2, j + 1);
                pane.add(text[j][2], 3, j + 1);
                pane.add(text[j][3], 4, j + 1);
                pane.add(bt1[j],5,j + 1);
                pane.add(text[j][4], 6, j + 1);
                int k = j;
                Num[k] = stu[j].GetNumber();
                bt1[j].setOnAction(e -> {
                	try {
                		onAbsent(Num[k]);
        				dmBtn();
        			} catch (FileNotFoundException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			} catch (Exception e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
                });
            }
        }
        Button bt = new Button("out");
        pane.add(bt, 2, j + 1);



        bt.setOnAction(e -> {
        	BackToMenu();
        	stage.close();
        });
        Scene scene = new Scene(pane);
        stage.setScene(scene);
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

    private void onAbsent(String Number) throws FileNotFoundException, Exception {//修改学生4
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
