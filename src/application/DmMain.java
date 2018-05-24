package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//��������¼�¼
//0524 �����˷�ֹ�ظ�ע��Ĺ���
//0524 �����˱���·���޸ģ������˲��ϸ�ʽ��ע����ʾ
//0517 �����޸�ʱ������ʾ
//0517 �����˹�����-�����
//0517 ��txt�����Ϊcsv���棬��ȡ�޸ĸ����� -�����
//0516 ������output���� -�����
//0502 css�ļ������˽��� -�����
//0502 ������ʱ�ӹ��� -�����
//0424 �޸����ϴ�Githubʱ������δ֪Bug -�����
//0424 �����˼Ӽ��ֹ��ܰ�ť - �����
//0420 ����������������� -�����
//0420 �����˵���������� -������
//0419 �����˻�ԭ���ܣ��ı��˸����ļ��ķ������޸��˻�ԭ���޷���ȡ��Bug -�����
//0419 ������ȱ�ڼ�¼���� -�����
//0418 �ı������򿪹رյķ�ʽ��ʱ�� -������ �����
//0418 �����˽�ʦ��¼ϵͳע��͵�¼����
//0418 �����˵�¼���� ������
//0417 ���������������� -�����
//0518 �޸Ľ��棬�ڡ��������ѡ���ɾ���ظ��ġ��޸�ѧ����Ϣ�� ������

public class DmMain extends Application {
	public static int i = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/DsMain.fxml"));//�����¼ע�����
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
