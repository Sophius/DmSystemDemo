package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
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

public class DsController {//注册登录页面
	@FXML
    private Button showBtn;
	@FXML
	private TextField setName;
	@FXML
	private TextField setPass;

	@FXML
	private Label warnLabel;

	public String vers = "//开发与更新记录V2.2 2018.5.24\r\n" +
			"//0524 增加了版本说明 修复了小BUG-许嘉熙\r\n" +
			"//0524 增加了防止重复注册的功能 -许嘉熙\r\n" + 
			"//0524 增加了备份路径修改，增加了不合格式的注册提示 -许嘉熙\r\n" + 
			"//0517 增加修改时错误提示 -许嘉熙\r\n" + 
			"//0517 增加了滚动条-许嘉熙\r\n" + 
			"//0517 将txt储存改为csv储存，读取修改更方便 -许嘉熙\r\n" + 
			"//0516 集成了output功能 -许嘉熙\r\n" + 
			"//0502 css文件美化了界面 -许嘉熙\r\n" + 
			"//0502 增加了时钟功能 -许嘉熙\r\n" + 
			"//0424 修复了上传Github时发生的未知Bug -许嘉熙\r\n" + 
			"//0424 增加了加减分功能按钮 - 许嘉熙\r\n" + 
			"//0420 增加了随机点名功能 -许嘉熙\r\n" + 
			"//0420 增加了单独点名面板 -张欣予\r\n" + 
			"//0419 增加了还原功能，改变了复制文件的方法，修复了还原后无法读取的Bug -许嘉熙\r\n" + 
			"//0419 增加了缺勤记录功能 -许嘉熙\r\n" + 
			"//0418 改变了面板打开关闭的方式和时序 -张欣予 许嘉熙\r\n" + 
			"//0418 增加了教师登录系统注册和登录功能\r\n" + 
			"//0418 增加了登录界面 张欣予\r\n" + 
			"//0417 开发出管理面板初版 -许嘉熙\r\n" ;

	private Stage stage;
	public Stage stage2 = new Stage();

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
        		warnLabel.setText("此用户名已被使用");
        		return;
        	}
        	
       
        }
        
		if(TP.length()==0||TN .length()==0||TP.indexOf(" ")!=-1||TN.indexOf(" ")!=-1||TP.indexOf(",")!=-1||TN.indexOf(",")!=-1) {
			warnLabel.setText("请按正确格式输入，不要输入空格和逗号");
		}
		
		else {
			signin1(TN,TP);
		}
	}
	
	private void signin1(String TN,String TP) throws IOException {

		Teacher tea = new Teacher(TN,TP);//使用自定义的类暂时储存数据

		
      

       try (FileWriter out = new FileWriter("Teachers.csv",true)) {
           
           out.write(tea.GetName() + ",");

           out.write(tea.GetPass() + "\r\n");
           warnLabel.setText("注册成功");
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
                		warnLabel.setText("密码错误");
                	}
                	break;
                }
            }
            if(j==i){
            	warnLabel.setText("未注册账户");
            }
        }
	

    private void signup() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));
    		Parent conRoot = loader.load();
			Stage conStage = new Stage();

			MenuController converController =  loader.getController();
			converController.init(this, conStage);



			conStage.setTitle("主菜单");
			conStage.setScene(new Scene(conRoot));
			conRoot.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			conStage.show();
			stage.close();

		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void onVer() {
    	ScrollPane pane = new ScrollPane();
    	
        GridPane pane2 = new GridPane();
        pane2.add(new Text(vers) , 1, 1);
        Scene scene2 = new Scene(pane);

        pane.setContent(pane2);
        
        stage2.setScene(scene2);
        stage2.show();

        

       
    }
}
