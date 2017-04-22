package com.WEG_Project.modles;

public class Account 
{
	private String FirstName;
	private String LastName;
	private String Gender;
	private String Email;
	private String PassWord;
	private String Type;
	private String UserName;
	
	public Account(String firstName, String lastName, String gender, String email, String passWord, String type,
			String userName) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Gender = gender;
		Email = email;
		PassWord = passWord;
		Type = type;
		UserName = userName;
	}
	public Account()
	{
		FirstName ="";
		LastName = "";
		Gender = "";
		Email = "";
		PassWord ="";
		Type = "";
		UserName ="";
		
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	

}
