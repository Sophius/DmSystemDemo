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
        }//向文件中写入新的学生信息

        

        Text text = new Text(100, 100, "程序已将所有数据删除！");
        Button bt1 = new Button("确定");

        bt1.setLayoutX(130);
        bt1.setLayoutY(130);


        Pane pane = new Pane();
        pane.getChildren().addAll(text, bt1);
        Scene scene = new Scene(pane,350, 300);

        stage.setScene(scene);
        bt1.setOnAction(e -> bt());


   }

	@FXML
	 private void onNo() throws FileNotFoundException{//关闭界面，结束程序
       stage.close();
   }

	private void bt() {//关闭界面，结束程序
        stage.close();
    }
}
