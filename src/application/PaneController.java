﻿package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaneController {//管理系统面板

	@FXML
	private TextField backPath ;
	public String bp ;


	private Stage stage;
	public void init(MenuController controller, Stage stage){
		this.stage = stage;
	}

	public void init2(PaneController controller, Stage stage){
		this.stage = stage;
	}

	static int i = 0;
	@FXML
	public Label result;


	@FXML
	 private void EXIT() {//关闭界面，结束程序
        stage.close();
    }
	@FXML
	 private void closeStudents() {//清除数据库
		try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClosePane.fxml"));
    		Parent closeRoot = loader.load();
			Stage closeStage = new Stage();

			CloseController closeController =  loader.getController();
			closeController.init2(this, closeStage);



			closeStage.setTitle("清楚数据库");
			closeStage.setScene(new Scene(closeRoot));
			closeStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }
	@FXML
	 private void addStudents() {//添加学生
		try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddPane.fxml"));
    		Parent addRoot = loader.load();
			Stage addStage = new Stage();

			AddController addController =  loader.getController();
			addController.init(this, addStage);



			addStage.setTitle("Add");
			addStage.setScene(new Scene(addRoot));
			addStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }
	@FXML
	 private void deleteStudents() {//删除学生，与AddPane共用一个controller
		try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/DelPane.fxml"));
    		Parent addRoot = loader.load();
			Stage addStage = new Stage();

			AddController addController =  loader.getController();
			addController.init(this, addStage);



			addStage.setTitle("删除学生");
			addStage.setScene(new Scene(addRoot));
			addStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }
	/*@FXML
	 private void amendStudents() {//查看修改学生，与AddPane共用一个controller
		try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/AmdPane.fxml"));
    		Parent amdRoot = loader.load();
			Stage amdStage = new Stage();

			AddController amdController =  loader.getController();
			amdController.init(this, amdStage);



			amdStage.setTitle("查看与修改");
			amdStage.setScene(new Scene(amdRoot));
			amdStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }*/

	@FXML
	private void checkallStudents() throws FileNotFoundException {//显示所有学生数据
        int i = 0;

		File csv = new File("Students.csv");
        ArrayList<Student> list = new ArrayList();
        Output.readCSV("Students.csv", list);
        i=list.size();

        GridPane pane = new GridPane();
        ScrollPane sp = new ScrollPane();
        sp.setMaxHeight(500);
        sp.setMinWidth(650);
        sp.setContent(pane);
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
        int j;
        String[] Num=new String[i];//新建数组储存学号（j会销毁不能在onAbsent（）直接用）


            for(j =0; j <i;j++){
                stu[j] =list.get(j);
                text[j][0] = new Text(stu[j].GetName());
                text[j][1] = new Text(stu[j].GetClass());
                text[j][2] = new Text(stu[j].GetNumber());
                text[j][3] = new Text("" + stu[j].GetScore());
                text[j][4] = new Text("" + stu[j].GetAbsent());
                bt1[j]=new Button("缺勤");
                bt2[j]=new Button("+1");
                bt3[j]=new Button("-1");
                pane.add(new Label("" + j ), 0, j + 1);
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
                		onAbsent(Num[k]);
        				checkallStudents();
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
                		onPlus(Num[k]);
        				checkallStudents();
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
                		onSubtract(Num[k]);
        				checkallStudents();
        			} catch (FileNotFoundException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			} catch (Exception e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
                });
            }

        Button bt = new Button("out");
        pane.add(bt, 2, j + 1);



        bt.setOnAction(e -> {
            try {
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pane.fxml"));
        		Parent conRoot = loader.load();
    			Stage conStage = new Stage();

    			PaneController converController =  loader.getController();
    			converController.init2(this, conStage);



    			conStage.setTitle("管理菜单");
    			conStage.setScene(new Scene(conRoot));
    			conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    			conStage.show();
            }
            catch (Exception ex) {
            	ex.printStackTrace();
            }
            stage.close();
        });
        Scene scene = new Scene(sp);
        stage.setScene(scene);
    }

	@FXML
	private void onBackup()throws IOException{//备份数据库

		bp = backPath.getText();
		File oldf=new File("Students.csv");
		File newf=new File(bp);//新文件路径（注意要用 \\来代替\，转义字符）

		copyfile(oldf,newf);;



	}

	@SuppressWarnings("resource")
	public  void copyfile(File oldfile,File newfile) throws IOException{//从stream处理改为了Channel处理，去除冗余空字节。
		FileChannel inputChannel = null;
        FileChannel outputChannel = null;
    try {
        inputChannel = new FileInputStream(oldfile).getChannel();
        outputChannel = new FileOutputStream(newfile).getChannel();
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
    } finally {
        inputChannel.close();
        outputChannel.close();
    }

		result.setText("备份成功");
		;

		}
	private void onAbsent(String Number) throws FileNotFoundException, Exception {//缺勤次数+1

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

	void onPlus(String Number) throws FileNotFoundException, Exception {//加一分

        File csv = new File("Students.csv");
        ArrayList<Student> list = new ArrayList();
        Output.readCSV("Students.csv", list);
        i=list.size();



        Student[] stu = new Student[i];

            for(int j =0; j < i;j++){
                stu[j] =list.get(j);
                if(Number.compareTo(stu[j].GetNumber()) == 0){
                    stu[j] = new Student(stu[j].GetName(), stu[j].GetClass(),
                    		stu[j].GetNumber(), (stu[j].GetScore()+1),(stu[j].GetAbsent()));
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

	void onSubtract(String Number) throws FileNotFoundException, Exception {//扣一分

        File csv = new File("Students.csv");
        ArrayList<Student> list = new ArrayList();
        Output.readCSV("Students.csv", list);
        i=list.size();



        Student[] stu = new Student[i];

            for(int j =0; j < i;j++){
                stu[j] = list.get(j);
                if(Number.compareTo(stu[j].GetNumber()) == 0){
                    stu[j] = new Student(stu[j].GetName(), stu[j].GetClass(),
                    		stu[j].GetNumber(), (stu[j].GetScore()-1),(stu[j].GetAbsent()));
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


	@FXML
	private void onRepair(){//从F盘根目录的备份恢复

		bp=backPath.getText();
		System.out.println(bp);
		GridPane pane = new GridPane();
        Text text = new Text( "你确定要还原所有数据！");
        text.setFill(Color.RED);
        text.setFont(Font.font(20));//定义字体大小


        Button bt1 = new Button("Yes");
        Button bt2 = new Button("No");
        pane.add(text, 0, 0);
        pane.add(bt1, 0, 1);
        pane.add(bt2, 1, 1);
        Scene scene = new Scene(pane);
        stage.setScene(scene);

        bt1.setOnAction(e -> {
            try {
            	File oldf=new File(bp);
        		File newf=new File("Students.csv");//新文件路径（注意要用 \\来代替\，转义字符）

        		copyfile(oldf,newf);;




        		Text text2 = new Text(100, 100, "程序已将数据还原！");
                Button bt3 = new Button("确定");

                bt3.setLayoutX(130);
                bt3.setLayoutY(130);


                Pane pane2 = new Pane();
                pane2.getChildren().addAll(text2, bt3);
                Scene scene2 = new Scene(pane2,350, 300);

                stage.setScene(scene2);
                bt3.setOnAction(ex -> {stage.close();
                BackToPane();
                });

            }


            catch (FileNotFoundException ex) {
            	Logger.getLogger(PaneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });

        bt2.setOnAction(e -> {
        	BackToPane();
            stage.close();
        });
	}

	private void BackToPane(){//回到管理菜单
		try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pane.fxml"));
    		Parent conRoot = loader.load();
			Stage conStage = new Stage();

			PaneController converController =  loader.getController();
			converController.init2(this, conStage);



			conStage.setTitle("管理菜单");
			conStage.setScene(new Scene(conRoot));
			conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			conStage.show();
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
	}



}
