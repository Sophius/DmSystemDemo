package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuController {



    private Stage stage;

    private DsController controller;
    public void init(DsController controller, Stage stage){
        this.stage = stage;
        this.controller = controller;
    }

    public void init2(MenuController controller, Stage stage){
		this.stage = stage;
	}																		//���ڴ���ת��

    @FXML
    private Button checkInfo;

    @FXML
    private Button moreManage;

    @FXML
    private Label timeLbl;

    @FXML
    private Button dm;
    @FXML
    private void checkBtn(){
    	//�����ѯѧ����Ϣ���
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/CheckPane.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            AddController converController =  loader.getController();
            converController.init2(this, conStage);



            conStage.setTitle("��ѯ");
            conStage.setScene(new Scene(conRoot));
            conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            conStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML

	public void dmBtn() throws FileNotFoundException {
        try {//����������
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DmPage.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            DmMenu converController = loader.getController();
            converController.init(this, conStage);
            conStage.setTitle("������ʽ");
            conStage.setScene(new Scene(conRoot));
            conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            conStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
/**   //�˴���ԭ��û���������ʱ��˳���������
        int i = 0;
		File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        }

        GridPane pane = new GridPane();
        pane.setHgap(20);
        pane.setVgap(10);

        pane.add(new Label("����") , 0, 0);
        pane.add(new Label("����"), 1, 0);
        pane.add(new Label("�༶"), 2, 0);
        pane.add(new Label("ѧ��"), 3, 0);
        pane.add(new Label("�ɼ�"), 4, 0);
        pane.add(new Label("ȱ��ѡ��"), 5, 0);
        pane.add(new Label("ȱ�ڴ���"), 6, 0);
        Student[] stu = new Student[i];
        Text[][] text = new Text[i][5];
        Button[] bt1= new Button[i];
        int j;
        String[] Num=new String[i];//ʹ�����鴢��j����ֹѭ�������������
        try(Scanner Input = new Scanner(fl)){

            for(j =0; j <i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt(),Input.nextInt());
                text[j][0] = new Text(stu[j].GetName());
                text[j][1] = new Text(stu[j].GetClass());
                text[j][2] = new Text(stu[j].GetNumber());
                text[j][3] = new Text("" + stu[j].GetScore());
                text[j][4] = new Text("" + stu[j].GetAbsent());
                bt1[j]=new Button("ȱ��");
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
*/
    @FXML
    private void manageBtn(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pane.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            PaneController converController =  loader.getController();
            converController.init(this, conStage);



            conStage.setTitle("����˵�");
            conStage.setScene(new Scene(conRoot));
            conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            conStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void onAbsent(String Number) throws FileNotFoundException, Exception {//�޸�ѧ��4
        int i =0;
    	
    	File csv = new File("Students.csv");
        ArrayList<Student> list = new ArrayList();
        Output.readCSV("Students.csv", list);
        i=list.size();



        Student[] stu = new Student[i];
        
            for(int j =0; j < i;j++){
                stu[j] = list.get(j);
                if(Number.compareTo(stu[j].GetNumber()) == 0){
                    stu[j] = new Student(stu[j].GetName(), stu[j].GetClass(),
                    		stu[j].GetNumber(), stu[j].GetScore(),(stu[j].GetAbsent()+1));
                }
            }
        

        

        if(i == 0){
            try (PrintWriter output = new PrintWriter(csv)) {
            }
        }
        else{
            try (PrintWriter output = new PrintWriter(csv)) {
                for(int j = 0;j < i;j ++){
                	Output.outputCsv(stu[j].GetName(), stu[j].GetClass(), stu[j].GetNumber(), stu[j].GetScore(), stu[j].GetAbsent(), output);
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



			conStage.setTitle("���˵�");
			conStage.setScene(new Scene(conRoot));
			conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			conStage.show();
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
	}


    @FXML
    private void onClock(){


    	ClockPane clock = new ClockPane();

        //��clock����pane��
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);

        //����һ��handler
        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
        };

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene= new Scene(pane, 250, 250);
        Stage Stage3 = new Stage();
        Stage3.setTitle("ʱ��");
        Stage3.setScene(scene);
        Stage3.show();

        //��clock���洰�ڵı仯���仯
        pane.widthProperty().addListener(ov -> clock.setW(pane.getWidth()));
        pane.heightProperty().addListener(ov -> clock.setH(pane.getHeight()));
    }

}
