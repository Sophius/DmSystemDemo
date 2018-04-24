package application;

public class Student {
	//建立学生类，包含属性姓名、班级、学号、成绩、缺席次数和序号。（序号本来打算用于随机点名，后用数组形式实现）
	private String Name;
    private String Number;
    private String Class;
    private int Score;
    private int Absent;
    private int Index;



    public Student(String Name,String Class,String Number,int Score, int Absent, int index){
        this.Name = Name;
        this.Number = Number;
        this.Score = Score;
        this.Class = Class;
        this.Absent= Absent;
        this.Index=Index;
    }


    public Student(String Name,String Class,String Number,int Score, int Absent){
        this.Name = Name;
        this.Number = Number;
        this.Score = Score;
        this.Class = Class;
        this.Absent= Absent;
    }


    public void SetName(String Name){
        this.Name = Name;
    }

    public void SetNumber(String Number){
        this.Number = Number;
    }

    public void SetClass(String Class){
        this.Class = Class;
    }

    public void SetScore(int Score){
        this.Score = Score;
    }

    public void SetAbsent(int Absent){
    	 this.Absent= Absent;
    }

    public void SetIndex(int Index){
   	 this.Index= Index;
   }

    public String GetName(){
        return Name;
    }

    public String GetNumber(){
        return Number;
    }

    public String GetClass(){
        return Class;
    }

    public int GetScore(){
        return Score;
    }

    public int GetAbsent(){
        return Absent;
    }

    public int GetIndex(){
        return Index;
    }
}
