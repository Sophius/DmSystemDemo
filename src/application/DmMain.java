package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//开发与更新记录
//0524 增加了防止重复注册的功能
//0524 增加了备份路径修改，增加了不合格式的注册提示
//0517 增加修改时错误提示
//0517 增加了滚动条-许嘉熙
//0517 将txt储存改为csv储存，读取修改更方便 -许嘉熙
//0516 集成了output功能 -许嘉熙
//0502 css文件美化了界面 -许嘉熙
//0502 增加了时钟功能 -许嘉熙
//0424 修复了上传Github时发生的未知Bug -许嘉熙
//0424 增加了加减分功能按钮 - 许嘉熙
//0420 增加了随机点名功能 -许嘉熙
//0420 增加了单独点名面板 -张欣予
//0419 增加了还原功能，改变了复制文件的方法，修复了还原后无法读取的Bug -许嘉熙
//0419 增加了缺勤记录功能 -许嘉熙
//0418 改变了面板打开关闭的方式和时序 -张欣予 许嘉熙
//0418 增加了教师登录系统注册和登录功能
//0418 增加了登录界面 张欣予
//0417 开发出管理面板初版 -许嘉熙
//0518 修改界面，在“更多管理选项”中删除重复的“修改学生信息” 张欣予

public class DmMain extends Application {
	public static int i = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/DsMain.fxml"));//进入登录注册界面
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
