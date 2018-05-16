package application;

import java.io.PrintWriter;

public class Output {

	public static void output(String Name,String Class,String Number,int Score, int Absent, PrintWriter output){

		output.print(Name + "\t");
        output.print(Number + "\t");
        output.print(Class + "\t");
        output.print(Score+ "\t");
        output.println(Absent);

	}

	public static void nstage(String fxml){

	}
}
