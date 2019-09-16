package application;

public class Teacher {

	//建立教师类，属性为用户名及密码
	private String Username;
	private String Password;





	public Teacher(String Username, String Password){
		this.Username=Username;
		this.Password=Password;
	}

	public void setName(String Username){
		this.Username=Username;

	}

	public void setPass(String Password){
		this.Password=Password;

	}

	public String GetName(){
        return Username;
    }

	public String GetPass(){
        return Password;
    }

}
