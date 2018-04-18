package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaneController {
	private Stage stage;
	public void init(DsController controller, Stage stage){
		this.stage = stage;
	}


	@FXML
	public TextField result;


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



			closeStage.setTitle("Close");
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



			addStage.setTitle("Add");
			addStage.setScene(new Scene(addRoot));
			addStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }
	@FXML
	 private void amendStudents() {//查看修改学生，与AddPane共用一个controller
		try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/AmdPane.fxml"));
    		Parent amdRoot = loader.load();
			Stage amdStage = new Stage();

			AddController amdController =  loader.getController();
			amdController.init(this, amdStage);



			amdStage.setTitle("Amd");
			amdStage.setScene(new Scene(amdRoot));
			amdStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }

	@FXML
	private void checkallStudents() throws FileNotFoundException {//显示所有学生数据
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
        Student[] stu = new Student[i];
        Text[][] text = new Text[i][4];
        int j;
        try(Scanner Input = new Scanner(fl)){
            for(j =0; j <i;j++){
                stu[j] = new Student(Input.next(), Input.next(),
                        Input.next(), Input.nextInt());
                text[j][0] = new Text(stu[j].GetName());
                text[j][1] = new Text(stu[j].GetClass());
                text[j][2] = new Text(stu[j].GetNumber());
                text[j][3] = new Text("" + stu[j].GetScore());
                pane.add(new Label("" + j + 1), 0, j + 1);
                pane.add(text[j][0], 1, j + 1);
                pane.add(text[j][1], 2, j + 1);
                pane.add(text[j][2], 3, j + 1);
                pane.add(text[j][3], 4, j + 1);
            }
        }
        Button bt = new Button("out");
        pane.add(bt, 2, j + 1);

        bt.setOnAction(e -> {
            try {
                stage.close();
            }
            catch (Exception ex) {
                Logger.getLogger(Students.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }
	@FXML
	private void onBackup()throws IOException{//备份数据库
		File oldf=new File("Students.txt");
		File newf=new File("F:\\StudentsBackup.txt");//新文件路径（注意要用 \\来代替\，转义字符）
		File oldf2=new File("Number.txt");
		File newf2=new File("F:\\NumberBackup.txt");//新文件路径（注意要用 \\来代替\，转义字符）
		copyfile(oldf,newf);;
		copyfile(oldf2,newf2);;


	}

	public  void copyfile(File oldfile,File newfile) throws IOException{
		//复制文件
		FileInputStream ins = new FileInputStream(oldfile);
		FileOutputStream out = new FileOutputStream(newfile);
		//自定义缓冲对象
		byte[] b = new byte[1024];
		int n=0;
		while((n=ins.read(b))!=-1){
		out.write(b, 0, b.length);
		}
		ins.close();
		out.close();

		result.setText("备份成功");
		;

		}

}
