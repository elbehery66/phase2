package com.WEG_Project.modles;

public class Course {
	private String courseName;
	private String username;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Course(String courseName, String username) {
		super();
		this.courseName = courseName;
		this.username = username;
	}
	public Course() {
		courseName="";
		username="";
		
	}
	
	

}
