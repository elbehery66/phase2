package com.WEG_Project.modles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Gamedb {
	
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
	
	
	public ArrayList<String> showCourses() throws Exception
	{   ArrayList<String> courses=new ArrayList<String>();
		Connection connection=Get_Conncetion();
		 Statement st= connection.createStatement();
		String g="SELECT * FROM `course`";
        
		ResultSet result = st.executeQuery(g);
		while (result.next()) {
			String str=result.getString("courseName");
			courses.add(str);
			
				
                    } 
		
		return courses;
		
	}
	public boolean addnewGame(Game game) throws Exception
	{
		try { 
			Connection connection=Get_Conncetion();
		 Statement st= connection.createStatement();
		                                   
		 String g="INSERT INTO `game`(`GameName`,  `UserName`, `GameDescription`, `course`) VALUES ('"+game.getGameName()+"','"+game.getUserName()+"','"+game.getGameDescription()+"','"+game.getCourse()+"')";
         System.out.println(g);
         st.executeUpdate(g);
		 
			
         return true;
			
			}
			catch (SQLException e) {
		
		
	}
		return false;	
		
	}

public boolean addnewquestion(Question question) throws Exception
{
	try { 
		Connection connection=Get_Conncetion();
	 Statement st= connection.createStatement();
	                                   
	 String g="INSERT INTO `question`(`Question`, `Answer`, `GameName`, `QuestionNumer`) VALUES ('"+question.getQuestion()+"','"+question.getAnswer()+"','"+question.getGameName()+"','"+question.getQuestionNumer()+"')";
	System.out.println(g);
     st.executeUpdate(g);
	 
		
     return true;
		
		}
		catch (SQLException e) {
	
	
}
	return false;	
	
}

public ArrayList<String> showgameInCourse(String CourseName) throws Exception
{   ArrayList<String> courses=new ArrayList<String>();
	Connection connection=Get_Conncetion();
	 Statement st= connection.createStatement();
	 String g = "SELECT * FROM game where course=" + "'" + CourseName + "'";
    
	ResultSet result = st.executeQuery(g);
	while (result.next()) {
		String str=result.getString("GameName");
		courses.add(str);
		
			
                } 
	
	return courses;
	
}
public ArrayList<Question> returnAnswer(String gameName) throws Exception
{   ArrayList<Question> quest=new ArrayList<Question>();
	Connection connection=Get_Conncetion();
	 Statement st= connection.createStatement();
	 String g = "SELECT * FROM question where GameName=" + "'" + gameName + "'";
    
	ResultSet result = st.executeQuery(g);
	Question Q=null;
	//(String question, String answer, String gameName, int questionNumer)
	while (result.next()) {
		Q=new Question(result.getString("Question"),result.getString("Answer"),result.getString("GameName"),result.getInt("QuestionNumer"));
				
		quest.add(Q);
		
			
                } 
	
	return quest;
	
}

}
