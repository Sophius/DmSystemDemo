package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import com.csvreader.CsvWriter;

public class Output {

	public static void output(String Name,String Class,String Number,int Score, int Absent, PrintWriter output){

		output.print(Name + "\t");
        output.print(Class + "\t");
        output.print(Number + "\t");
        output.print(Score+ "\t");
        output.println(Absent);

	}

	public static void nstage(String fxml){

	}
	
	public static void writeCSV() {  
	    // 定义一个CSV路径  
	    String csvFilePath = "D://StemQ.csv";  
	    try {  
	        // 创建CSV写对象 例如:CsvWriter(文件路径，分隔符，编码格式);  
	        CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));  
	        // 写表头  
	        String[] csvHeaders = { "编号", "姓名", "年龄" };  
	        csvWriter.writeRecord(csvHeaders);  
	        // 写内容  
	        for (int i = 0; i < 20; i++) {  
	            String[] csvContent = { i + "000000", "StemQ", "1" + i };  
	            csvWriter.writeRecord(csvContent);  
	        }  
	        csvWriter.close();  
	        System.out.println("--------CSV文件已经写入--------");  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}  
}
