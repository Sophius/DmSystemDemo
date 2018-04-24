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
	}																		//用于窗口转换

    @FXML
    private Button checkInfo;

    @FXML
    private Button moreManage;

    @FXML
    private Button dm;
    @FXML
    private void checkBtn(){
    	//进入查询学生信息面板
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CheckPane.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            AddController converController =  loader.getController();
            converController.init2(this, conStage);



            conStage.setTitle("查询");
            conStage.setScene(new Scene(conRoot));
            conStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML

	public void dmBtn() throws FileNotFoundException {
<<<<<<< HEAD
        try {//进入点名面板
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DmPage.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            DmMenu converController = loader.getController();
            converController.init(this, conStage);
            conStage.setTitle("点名方式");
            conStage.setScene(new Scene(conRoot));
            conStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
/**   //此处是原本没做随机点名时的顺序点名代码
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
        String[] Num=new String[i];//使用数组储存j，防止循环后变量被毁灭
        try(Scanner Input = new Scanner(fl)){
=======
        try {//显示所有学生数据
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DmPage.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f

            DmMenu converController = loader.getController();
            converController.init(this, conStage);
            conStage.setTitle("点名！");
            conStage.setScene(new Scene(conRoot));
            conStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
        Button bt = new Button("out");
        pane.add(bt, 2, j + 1);



        bt.setOnAction(e -> {
        	BackToMenu();
        	stage.close();
        });
        Scene scene = new Scene(pane);
        stage.setScene(scene);
*/
=======
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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

<<<<<<< HEAD
    public static void onAbsent(String Number) throws FileNotFoundException, Exception {//锟睫革拷学锟斤拷4
=======
    public static void onAbsent(String Number) throws FileNotFoundException, Exception {//修改学生4
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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
