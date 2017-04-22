package com.WEG_Project.modles;

public class Question {
	private String Question;
	private String Answer;
	private String GameName;
	private int QuestionNumer;
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String gameName) {
		GameName = gameName;
	}
	public int getQuestionNumer() {
		return QuestionNumer;
	}
	public void setQuestionNumer(int questionNumer) {
		QuestionNumer = questionNumer;
	}
	public Question(String question, String answer, String gameName, int questionNumer) {
		super();
		Question = question;
		Answer = answer;
		GameName = gameName;
		QuestionNumer = questionNumer;
	}
	public Question() {
		super();
		Question = "";
		Answer = "";
		GameName = "";
		QuestionNumer = 0;
	}
	
	

}
