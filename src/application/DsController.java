package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DsController {//ע���¼ҳ��
	@FXML
    private Button showBtn;
	@FXML
	private TextField setName;
	@FXML
	private TextField setPass;

	@FXML
	private Label warnLabel;

	

	private Stage stage;

	public void init(DsController controller, Stage stage){
		this.stage = stage;
	}
	@FXML
	private void signin() throws IOException {
		String TN = setName.getText();
		String TP = setPass.getText();
		File csv = new File("Teachers.csv");
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        Output.readCSV2("Teachers.csv", list);
        int i = list.size();
        Teacher[] tea = new Teacher[i];
        for(int j =0; j < i;j++){
        	tea[j] = list.get(j);
        	if(TN.compareTo(tea[j].GetName()) == 0) {
        		warnLabel.setText("���û����ѱ�ʹ��");
        		return;
        	}
       
        }
        
		if(TP == null||TN == null||TP.indexOf(" ")!=-1||TN.indexOf(" ")!=-1||TP.indexOf(",")!=-1||TN.indexOf(",")!=-1) {
			warnLabel.setText("�밴��ȷ��ʽ���룬��Ҫ����ո�Ͷ���");
		}
		
		else {
			signin1(TN,TP);
		}
	}
	
	private void signin1(String TN,String TP) throws IOException {

		Teacher tea = new Teacher(TN,TP);//ʹ���Զ��������ʱ��������

		
      

       try (FileWriter out = new FileWriter("Teachers.csv",true)) {
           
           out.write(tea.GetName() + ",");

           out.write(tea.GetPass() + "\r\n");
           warnLabel.setText("ע��ɹ�");
       }

       
       
	}

	@FXML
	private void onShowCon()throws FileNotFoundException{
		
		File csv = new File("Teachers.csv");
        ArrayList<Teacher> list = new ArrayList<Teacher>();
        Output.readCSV2("Teachers.csv", list);
        int i = list.size();
        

        String Password = setPass.getText();
        String Username = setName.getText();
        Teacher[] tea = new Teacher[i];
        int j;
       
            for(j =0; j < i;j++){
                tea[j] = list.get(j);
                if(Username.compareTo(tea[j].GetName()) == 0){
                	if(Password.compareTo(tea[j].GetPass()) == 0){
                		signup();
                	}else {
                		warnLabel.setText("�������");
                	}
                	break;
                }
            }
            if(j==i){
            	warnLabel.setText("δע���˻�");
            }
        }
	

    private void signup() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));
    		Parent conRoot = loader.load();
			Stage conStage = new Stage();

			MenuController converController =  loader.getController();
			converController.init(this, conStage);



			conStage.setTitle("���˵�");
			conStage.setScene(new Scene(conRoot));
			conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			conStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
