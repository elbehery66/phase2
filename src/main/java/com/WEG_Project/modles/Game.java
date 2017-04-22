package com.WEG_Project.modles;

public class Game {
	private String GameName;
	private String GameType;
	private String UserName;
	private String GameDescription;
	private String course;
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String gameName) {
		GameName = gameName;
	}
	public String getGameType() {
		return GameType;
	}
	public void setGameType(String gameType) {
		GameType = gameType;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getGameDescription() {
		return GameDescription;
	}
	public void setGameDescription(String gameDescription) {
		GameDescription = gameDescription;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Game(String gameName, String gameType, String userName, String gameDescription, String course) {
		super();
		GameName = gameName;
		GameType = gameType;
		UserName = userName;
		GameDescription = gameDescription;
		this.course = course;
	}
	public Game() {
		GameName = "";
		GameType = "";
		UserName = "";
		GameDescription = "";
		this.course = "";
		
	}
	
	
	
	
	
	
	
	
	
}
