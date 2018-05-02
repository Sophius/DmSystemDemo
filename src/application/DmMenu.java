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
	PaneController pc = new PaneController();
    private Stage stage;
    public void init(MenuController controller, Stage stage){
        this.stage = stage;
    }
    public void init2(DmMenu controller, Stage stage){
        this.stage = stage;
    }


    @FXML
    private void randomDm() throws FileNotFoundException{//随机点名1 产生i以内随机数
    	int i = 0;
    	File Fl = new File("Number.txt");
        File fl = new File("Students.txt");
        try (Scanner input = new Scanner(Fl)) {
            i = input.nextInt();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    	int num=(int)(Math.random()*i);//产生随机数
    	randomDm2(num);
    }
    private void randomDm2(int num) throws FileNotFoundException{//随机点名2
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
        pane.add(new Label("加分按钮"), 7, 0);
        pane.add(new Label("扣分按钮"), 8, 0);
        Student[] stu = new Student[i];
        Text[] text = new Text[5];
        Button bt1= new Button();
        Button bt2= new Button();
        Button bt3= new Button();
        int j = 0;
        String[] Num=new String[i];//数组储存学号
        String[] Name=new String[i];//数组储存姓名
        try(Scanner Input = new Scanner(fl)){

            for(j =0; j <i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt(),Input.nextInt());


                int k = j;
                Num[k] = stu[j].GetNumber();
                Name[k] = stu[j].GetName();
                }//将姓名学号存入数组
            text[0] = new Text(stu[num].GetName());
            text[1] = new Text(stu[num].GetClass());
            text[2] = new Text(stu[num].GetNumber());
            text[3] = new Text("" + stu[num].GetScore());
            text[4] = new Text("" + stu[num].GetAbsent());
            bt1=new Button("缺席");
            bt2=new Button("+1");
            bt3=new Button("-1");
            pane.add(new Label("" +  1), 0,  1);
            pane.add(text[0], 1,  1);
            pane.add(text[1], 2,  1);
            pane.add(text[2], 3,  1);
            pane.add(text[3], 4,  1);
            pane.add(bt1,5, 1);
            pane.add(text[4], 6,  1);
            pane.add(bt2,7, 1);
            pane.add(bt3,8, 1);
                bt1.setOnAction(e -> {//缺勤次数+1，刷新页面
                    try {
                        MenuController.onAbsent(Num[num]);
                        randomDm2(num);//刷新页面
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
						randomDm();//重新随机
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
    private void listDm(){//顺序点名
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
        pane.add(new Label("加分按钮"), 7, 0);
        pane.add(new Label("扣分按钮"), 8, 0);
        Student[] stu = new Student[i];
        Text[][] text = new Text[i][5];
        Button[] bt1= new Button[i];
        Button[] bt2= new Button[i];
        Button[] bt3= new Button[i];
        int j = 0;
        String[] Num=new String[i];//鏂板缓鏁扮粍鍌ㄥ瓨瀛﹀彿锛坖浼氶攢姣佷笉鑳藉湪onAbsent锛堬級鐩存帴鐢級
        try(Scanner Input = new Scanner(fl)){

            for(j =0; j <i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt(),Input.nextInt());
                text[j][0] = new Text(stu[j].GetName());
                text[j][1] = new Text(stu[j].GetClass());
                text[j][2] = new Text(stu[j].GetNumber());
                text[j][3] = new Text("" + stu[j].GetScore());
                text[j][4] = new Text("" + stu[j].GetAbsent());
                bt1[j]=new Button("缺席");
                bt2[j]=new Button("+1");
                bt3[j]=new Button("-1");
                pane.add(new Label("" + j + 1), 0, j + 1);
                pane.add(text[j][0], 1, j + 1);
                pane.add(text[j][1], 2, j + 1);
                pane.add(text[j][2], 3, j + 1);
                pane.add(text[j][3], 4, j + 1);
                pane.add(bt1[j],5,j + 1);
                pane.add(text[j][4], 6, j + 1);
                pane.add(bt2[j],7,j + 1);
                pane.add(bt3[j],8,j + 1);
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
        pane.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
    }
    public void BackToMenu(){//回到主菜单
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));
            Parent conRoot = loader.load();
            Stage conStage = new Stage();

            DmMenu menuController =  loader.getController();
            menuController.init2(this, conStage);



            conStage.setTitle("Con");
            conStage.setScene(new Scene(conRoot));
            conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            conStage.show();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
}
}
