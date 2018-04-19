package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
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

	public void init2(PaneController controller, Stage stage){
		this.stage = stage;
	}

	static int i = 0;
	@FXML
	public TextField result;


	@FXML
	 private void EXIT() {//�رս��棬��������
        stage.close();
    }
	@FXML
	 private void closeStudents() {//������ݿ�
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
	 private void addStudents() {//���ѧ��
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
	 private void deleteStudents() {//ɾ��ѧ������AddPane����һ��controller
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
	 private void amendStudents() {//�鿴�޸�ѧ������AddPane����һ��controller
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
	private void checkallStudents() throws FileNotFoundException {//��ʾ����ѧ������
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
        String[] Num=new String[i];//�½����鴢��ѧ�ţ�j�����ٲ�����onAbsent����ֱ���ã�
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



    			conStage.setTitle("Con");
    			conStage.setScene(new Scene(conRoot));
    			conStage.show();
            }
            catch (Exception ex) {
            	ex.printStackTrace();
            }
            stage.close();
        });
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }
	@FXML
	private void onBackup()throws IOException{//�������ݿ�
		File oldf=new File("Students.txt");
		File newf=new File("F:\\StudentsBackup.txt");//���ļ�·����ע��Ҫ�� \\������\��ת���ַ���
		File oldf2=new File("Number.txt");
		File newf2=new File("F:\\NumberBackup.txt");//���ļ�·����ע��Ҫ�� \\������\��ת���ַ���
		copyfile(oldf,newf);;
		copyfile(oldf2,newf2);;


	}

	public  void copyfile(File oldfile,File newfile) throws IOException{
		//�����ļ�
		FileInputStream ins = new FileInputStream(oldfile);
		FileOutputStream out = new FileOutputStream(newfile);
		//�Զ��建�����
		byte[] b = new byte[1024];
		int n=0;
		while((n=ins.read(b))!=-1){
		out.write(b, 0, b.length);
		}
		ins.close();
		out.close();

		result.setText("���ݳɹ�");
		;

		}
	private void onAbsent(String Number) throws FileNotFoundException, Exception {//�޸�ѧ��4
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

}
