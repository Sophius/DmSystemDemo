package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.csvreader.CsvWriter;

public class Output {

	public static void output(String Name,String Class,String Number,int Score, int Absent, PrintWriter output){

		output.print(Name + "\t");
        output.print(Class + "\t");
        output.print(Number + "\t");
        output.print(Score+ "\t");
        output.println(Absent);

	}
	public static void outputCsv(String Name,String Class,String Number,int Score, int Absent, PrintWriter output){

		output.print(Name + ",");
        output.print(Class + ",");
        output.print(Number + ",");
        output.print(Score+ ",");
        output.print(Absent+ "\r\n");

	}

	public static void readCSV(String readpath, ArrayList list)	{
	    File inFile = new File(readpath);
	    try
	    {
	        BufferedReader reader = new BufferedReader(new FileReader(inFile));
	        
	        while(reader.ready())
	        {
	            String line = reader.readLine();
	            StringTokenizer st = new StringTokenizer(line, ",");
	            String Name;
	            String Number;
	            String Class;
	            int Score;
	            int Absent;
	            

	            if (st.hasMoreTokens() )
	            {
	                Name = st.nextToken().trim();
	                Class = st.nextToken().trim();
	                Number = st.nextToken().trim();
	                Score =Integer.valueOf(st.nextToken().trim());
	                Absent = Integer.valueOf(st.nextToken().trim());

	                Student sample = new Student(Name, Class, Number, Score, Absent);
	                list.add(sample);
	            }
	            
	        }
	        reader.close();

	    }
	    catch (FileNotFoundException e)
	    {

	        e.printStackTrace();
	    }
	    catch (IOException e)
	    {

	        e.printStackTrace();
	    }
	}
	public static void readCSV2(String readpath, ArrayList list)	{
	    File inFile = new File(readpath);
	    try
	    {
	        BufferedReader reader = new BufferedReader(new FileReader(inFile));
	        
	        while(reader.ready())
	        {
	            String line = reader.readLine();
	            StringTokenizer st = new StringTokenizer(line, ",");
	            String Name;
	            String Pass;
	            
	            

	            if (st.hasMoreTokens() )
	            {
	                Name = st.nextToken().trim();
	                Pass = st.nextToken().trim();
	                

	                Teacher sample = new Teacher(Name,Pass);
	                list.add(sample);
	            }
	            
	        }
	        reader.close();

	    }
	    catch (FileNotFoundException e)
	    {

	        e.printStackTrace();
	    }
	    catch (IOException e)
	    {

	        e.printStackTrace();
	    }
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
