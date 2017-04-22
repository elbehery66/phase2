package com.WEG_Project.modles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDB {
	public static Connection Get_Conncetion ()throws Exception
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url	  = "jdbc:mysql://127.0.0.1/weg_database";
			String userName = "root";
			String PassWord = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url,userName,PassWord);
			return con;
		}catch (Exception e) {
			System.out.println(e);
		}
		return null;
	} 
	
	public boolean addnewCourse(String courseName,String userName) throws Exception
	{
		try { 
			Connection connection=Get_Conncetion();
		 Statement st= connection.createStatement();
		 String g="INSERT INTO `course`(`courseName`, `UserName`) VALUES ('"+courseName+"','"+userName+"')";
         System.out.println(g);
         st.executeUpdate(g);
		 
			
         return true;
			
			}
			catch (SQLException e) {
		
		
	}
		return false;	
		
	}
	
	public ArrayList<String> showCourses() throws Exception
	{  
		Gamedb db=new Gamedb();
		return db.showCourses();
		
	}
	
	

}
