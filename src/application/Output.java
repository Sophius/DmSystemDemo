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
	    // ����һ��CSV·��  
	    String csvFilePath = "D://StemQ.csv";  
	    try {  
	        // ����CSVд���� ����:CsvWriter(�ļ�·�����ָ����������ʽ);  
	        CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));  
	        // д��ͷ  
	        String[] csvHeaders = { "���", "����", "����" };  
	        csvWriter.writeRecord(csvHeaders);  
	        // д����  
	        for (int i = 0; i < 20; i++) {  
	            String[] csvContent = { i + "000000", "StemQ", "1" + i };  
	            csvWriter.writeRecord(csvContent);  
	        }  
	        csvWriter.close();  
	        System.out.println("--------CSV�ļ��Ѿ�д��--------");  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}  
}
