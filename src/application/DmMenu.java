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
<<<<<<< HEAD
	PaneController pc = new PaneController();
=======
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
    private Stage stage;
    public void init(MenuController controller, Stage stage){
        this.stage = stage;
    }
    public void init2(DmMenu controller, Stage stage){
        this.stage = stage;
    }


    @FXML
<<<<<<< HEAD
    private void randomDm() throws FileNotFoundException{//�������1 ����i���������
=======
    private void randomDm() throws FileNotFoundException{
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
    	int i = 0;
    	File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
    	int num=(int)(Math.random()*i);//���������
    	randomDm2(num);
    }
    private void randomDm2(int num) throws FileNotFoundException{//�������2
=======
    	int num=(int)(Math.random()*i);
    	randomDm2(num);
    }
    private void randomDm2(int num) throws FileNotFoundException{
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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

<<<<<<< HEAD
        pane.add(new Label("����") , 0, 0);
        pane.add(new Label("����"), 1, 0);
        pane.add(new Label("�༶"), 2, 0);
        pane.add(new Label("ѧ��"), 3, 0);
        pane.add(new Label("�ɼ�"), 4, 0);
        pane.add(new Label("ȱ��ѡ��"), 5, 0);
        pane.add(new Label("ȱ�ڴ���"), 6, 0);
        pane.add(new Label("�ӷְ�ť"), 7, 0);
        pane.add(new Label("�۷ְ�ť"), 8, 0);
        Student[] stu = new Student[i];
        Text[] text = new Text[5];
        Button bt1= new Button();
        Button bt2= new Button();
        Button bt3= new Button();
        int j = 0;
        String[] Num=new String[i];//���鴢��ѧ��
        String[] Name=new String[i];//���鴢������
=======
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
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
        try(Scanner Input = new Scanner(fl)){

            for(j =0; j <i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt(),Input.nextInt());


                int k = j;
                Num[k] = stu[j].GetNumber();
                Name[k] = stu[j].GetName();
<<<<<<< HEAD
                }//������ѧ�Ŵ�������
=======
                }
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
            text[0] = new Text(stu[num].GetName());
            text[1] = new Text(stu[num].GetClass());
            text[2] = new Text(stu[num].GetNumber());
            text[3] = new Text("" + stu[num].GetScore());
            text[4] = new Text("" + stu[num].GetAbsent());
<<<<<<< HEAD
            bt1=new Button("ȱϯ");
            bt2=new Button("+1");
            bt3=new Button("-1");
=======
            bt1=new Button("缺勤");
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
            pane.add(new Label("" +  1), 0,  1);
            pane.add(text[0], 1,  1);
            pane.add(text[1], 2,  1);
            pane.add(text[2], 3,  1);
            pane.add(text[3], 4,  1);
            pane.add(bt1,5, 1);
            pane.add(text[4], 6,  1);
<<<<<<< HEAD
            pane.add(bt2,7, 1);
            pane.add(bt3,8, 1);
                bt1.setOnAction(e -> {//ȱ�ڴ���+1��ˢ��ҳ��
                    try {
                        MenuController.onAbsent(Num[num]);
                        randomDm2(num);//ˢ��ҳ��
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
                bt2.setOnAction(e -> {
                    try {
                        pc.onPlus(Num[num]);
                        randomDm2(num);
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
                bt3.setOnAction(e -> {
                    try {
                        pc.onSubtract(Num[num]);
=======
                bt1.setOnAction(e -> {
                    try {
                        MenuController.onAbsent(Num[num]);
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
                        randomDm2(num);
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
<<<<<<< HEAD
                Button bt = new Button("��һ��");
=======
                Button bt = new Button("下一个");
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
                pane.add(bt, 2,  2);



                bt.setOnAction(e -> {
                    try {
<<<<<<< HEAD
						randomDm();//�������
=======
						randomDm();
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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
<<<<<<< HEAD
    private void listDm(){//˳�����
=======
    private void listDm(){
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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

<<<<<<< HEAD
        pane.add(new Label("����") , 0, 0);
        pane.add(new Label("����"), 1, 0);
        pane.add(new Label("�༶"), 2, 0);
        pane.add(new Label("ѧ��"), 3, 0);
        pane.add(new Label("�ɼ�"), 4, 0);
        pane.add(new Label("ȱ��ѡ��"), 5, 0);
        pane.add(new Label("ȱ�ڴ���"), 6, 0);
        pane.add(new Label("�ӷְ�ť"), 7, 0);
        pane.add(new Label("�۷ְ�ť"), 8, 0);
        Student[] stu = new Student[i];
        Text[][] text = new Text[i][5];
        Button[] bt1= new Button[i];
        Button[] bt2= new Button[i];
        Button[] bt3= new Button[i];
=======
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
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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
<<<<<<< HEAD
                bt1[j]=new Button("out");
                bt2[j]=new Button("+1");
                bt3[j]=new Button("-1");
=======
                bt1[j]=new Button("缺勤");
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
                pane.add(new Label("" + j + 1), 0, j + 1);
                pane.add(text[j][0], 1, j + 1);
                pane.add(text[j][1], 2, j + 1);
                pane.add(text[j][2], 3, j + 1);
                pane.add(text[j][3], 4, j + 1);
                pane.add(bt1[j],5,j + 1);
                pane.add(text[j][4], 6, j + 1);
<<<<<<< HEAD
                pane.add(bt2[j],7,j + 1);
                pane.add(bt3[j],8,j + 1);
=======
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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
<<<<<<< HEAD
                bt2[j].setOnAction(e -> {
                    try {
                        pc.onPlus(Num[k]);
                        listDm();
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
                bt3[j].setOnAction(e -> {
                    try {
                        pc.onSubtract(Num[k]);
                        listDm();
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                });
=======
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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
<<<<<<< HEAD
    public void BackToMenu(){//�ص����˵�
=======
    public void BackToMenu(){
>>>>>>> 9acffe00a812e1fdcdb2bd83472a728d2243da8f
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
