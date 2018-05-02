package application;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPane extends Pane{
    private int hour;
    private int minute;
    private int second;

    //����ʱ�����Ŀ�Ⱥ͸߶�
    private double w = 250, h = 250;

    //���캯��
    public ClockPane() {
        setCurrentTime();
    }

    //���ô������Ĺ��캯��
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    //����Сʱ
    public int getHour() {
        return hour;
    }

    //���ط���
    public int getMinute() {
        return minute;
    }

    //��������
    public int getSecond() {
        return second;
    }

    //����һ���µ�Сʱ
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    //����һ���µķ���
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    //����һ���µ�����
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    //����ʱ�����Ŀ��
    public double getW() {
        return w;
    }

    //����һ���µ������
    public void setW(double w) {
        this.w = w;
        paintClock();
    }

    //����ʱ�����ĸ߶�
    public double getH() {
        return h;
    }

    //����ʱ�����ĸ߶�
    public void setH(double h) {
        this.h = h;
        paintClock();
    }

    public void setCurrentTime() {
        //��ȡ��ǰʱ��
        Calendar calendar = new GregorianCalendar();

        //���õ�ǰʱ��
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        //�ػ�
        paintClock();
    }

    public void paintClock() {
        //��ʼ��ʱ�Ӳ���
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;

        //��ʾ��ǰʱ��,������ʱ����ʾ��λ��
        String timeString = hour + ":" + minute + ":" + second;
        Label labelCurrentTime = new Label(timeString);
        labelCurrentTime.setLayoutX(centerX - 25);
        labelCurrentTime.setLayoutY(centerY + clockRadius + 5);

        //��Բ
        Circle circle = new Circle(centerX, centerY, clockRadius);
        //circle.setFill(Color.WHITE);
        //circle.setStroke(Color.BLACK);
        circle.setStyle("-fx-stroke: black; -fx-fill: white");
        Text t1 = new Text(centerX - 5, centerY - clockRadius +12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 5, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        //������
        double sLength = clockRadius * 0.8; //��������ĳ���
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60.0));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60.0));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        //������
        double mLength = clockRadius * 0.65; //���÷���ĳ���
        double minuteX = centerX + mLength * Math.sin(minute * 2 * Math.PI / 60.0);
        double minuteY = centerY - mLength * Math.cos(minute * 2 * Math.PI / 60.0);
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.BLUE);

        //��ʱ��
        double hLength = clockRadius * 0.5; //����ʱ��ĳ���
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * 2 * Math.PI / 12);
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * 2 * Math.PI / 12);
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine, labelCurrentTime);
    }

}