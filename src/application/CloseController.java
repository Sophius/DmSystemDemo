package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CloseController {
	private Stage stage;
	public void init2(PaneController controller, Stage stage){
		this.stage = stage;
	}

	@FXML
	 private void onYes() throws FileNotFoundException{
		File fl = new File("Students.csv");
        try (PrintWriter output = new PrintWriter(fl)) {
        }//���ļ���д���µ�ѧ����Ϣ

        

        Text text = new Text(100, 100, "�����ѽ���������ɾ����");
        Button bt1 = new Button("ȷ��");

        bt1.setLayoutX(130);
        bt1.setLayoutY(130);


        Pane pane = new Pane();
        pane.getChildren().addAll(text, bt1);
        Scene scene = new Scene(pane,350, 300);

        stage.setScene(scene);
        bt1.setOnAction(e -> bt());


   }

	@FXML
	 private void onNo() throws FileNotFoundException{//�رս��棬��������
       stage.close();
   }

	private void bt() {//�رս��棬��������
        stage.close();
    }
}
