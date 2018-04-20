package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DmMenu {
    private Stage stage;
    public void init(MenuController controller, Stage stage){
        this.stage = stage;
    }
    public void init2(DmMenu controller, Stage stage){
        this.stage = stage;
    }


    @FXML
    private void randomDm() throws FileNotFoundException{
    	int i = 0;
    	File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    	int num=(int)(Math.random()*i);
    	randomDm2(num);
    }
    private void randomDm2(int num) throws FileNotFoundException{
    	int i = 0;
        File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        Text[] text = new Text[5];
        Button bt1= new Button();
        int j = 0;
        String[] Num=new String[i];//新建数组储存学号（j会销毁不能在onAbsent（）直接用）
        String[] Name=new String[i];
        try(Scanner Input = new Scanner(fl)){

            for(j =0; j <i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt(),Input.nextInt());


                int k = j;
                Num[k] = stu[j].GetNumber();
                Name[k] = stu[j].GetName();
                }
            text[0] = new Text(stu[num].GetName());
            text[1] = new Text(stu[num].GetClass());
            text[2] = new Text(stu[num].GetNumber());
            text[3] = new Text("" + stu[num].GetScore());
            text[4] = new Text("" + stu[num].GetAbsent());
            bt1=new Button("缺勤");
            pane.add(new Label("" +  1), 0,  1);
            pane.add(text[0], 1,  1);
            pane.add(text[1], 2,  1);
            pane.add(text[2], 3,  1);
            pane.add(text[3], 4,  1);
            pane.add(bt1,5, 1);
            pane.add(text[4], 6,  1);
                bt1.setOnAction(e -> {
                    try {
                        MenuController.onAbsent(Num[num]);
                        randomDm2(num);
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
                Button bt = new Button("下一个");
                pane.add(bt, 2,  2);



                bt.setOnAction(e -> {
                    try {
						randomDm();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                });
                Scene scene = new Scene(pane);
                stage.setScene(scene);
            }
        }


    @FXML
    private void listDm(){
        int i = 0;
        File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        int j = 0;
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
                        MenuController.onAbsent(Num[k]);
                        listDm();
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
    public void BackToMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            DmMenu menuController =  loader.getController();
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
