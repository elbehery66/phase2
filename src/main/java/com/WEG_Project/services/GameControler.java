package com.WEG_Project.services;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.WEG_Project.modles.CourseDB;
import com.WEG_Project.modles.Game;
import com.WEG_Project.modles.Gamedb;
import com.WEG_Project.modles.Question;
@Controller
public class GameControler {
	public String currgame; 
	public int questionNumber=1;
	public static int x=0,score=0;
	public ArrayList<Question> question=new ArrayList<Question>();
	@RequestMapping ("/addgame")
	private String addCourse(Model model) throws Exception {
		Gamedb db=new Gamedb();
		  model.addAttribute("courses",db.showCourses() );
//		  for (int i=0;i<db.showCourses().size();i++)
//			  System.err.println(db.showCourses().get(i));
		return "addGame";

	}
	
	@RequestMapping("/addNewGame")
	public ModelAndView addnewGame(Model model,@RequestParam ("coursename") String courseName,
			@RequestParam ("Description") String Description ,
			 @RequestParam ("gameName") String gameName) throws Exception
	    
	{  User currentUser = new User();
		Game game =new Game();
		game.setCourse(courseName);
		game.setGameDescription(Description);
		game.setGameName(gameName);
		game.setUserName(currentUser.getAcount().getUserName());
		
//		System.out.println(game.getCourse());
//		System.out.println(game.getGameDescription());
//		System.out.println(game.getGameName());
//		System.out.println(game.getUserName());
//	
		currgame=gameName;
		model.addAttribute("gameName", gameName);
		Gamedb db=new Gamedb();
		db.addnewGame(game);
		ModelAndView mv=new ModelAndView("/question");
		return mv;
	
	}
	
	@RequestMapping("/addQuestion")
	public String addQuestion(@RequestParam ("question") String question,
			@RequestParam ("answer") String answer ,
			@RequestParam ("anther") Boolean next 
			) throws Exception
	    
	{  
		User currentUser = new User();
		Gamedb db=new Gamedb();
		Question q =new Question();
		q.setQuestion(question);
		q.setGameName(currgame);
		q.setAnswer(answer);
		q.setQuestionNumer(questionNumber);
		System.out.println(db.addnewquestion(q));
		System.out.println("next = "+next);
		if(next)
		{   questionNumber ++;
			return  "question";
		}
		else
		{  questionNumber=1;
		
			return  "teacher";
		}
		
	
		
		
	
	}
	
	@RequestMapping("/showGameInCourse")
	public String ShowGame(Model model,@RequestParam("courseName") String CourseName) throws Exception
	{ 
		Gamedb db =new Gamedb();
		model.addAttribute("CourseName", CourseName);
		model.addAttribute("courseingame", db.showgameInCourse(CourseName));
		
		return "gameincourse";
	}
	

	@RequestMapping("/playgame")
	public String playgame(Model model, @RequestParam("GName") String gamename) {
		try {
			Gamedb db=new Gamedb();
			question=db.returnAnswer(gamename);
			
			x = 0;
			
 
			model.addAttribute("Game", question.get(x));
 
			return "playgame";
		} catch (Exception e) {
			User u=new User();
			return u.getAcount().getType() ;
 
		}
 
	}
	@RequestMapping("/question")
	public String play(Model model, @RequestParam("a") String selected) {
		if (selected.equals(question.get(x).getAnswer())) {
 
			score++;
		}
		x++;
		if (x >= question.size()) {
			/*gamedb.saveScore(score,User.getAccount().getEmail(),game.getGame_Name());
			System.out.println(score);
			model.addAttribute("score",score);
			score = 0;*/
			User user =new User();
			 System.out.println(user.getAcount().getType() );
			return user.getAcount().getType() ;
			//return "teacher";
		}
		model.addAttribute("Game", question.get(x));
		User user =new User();
		System.out.println("as"+user.getAcount().getType()) ;
		return "playgame";
 
	}
	
	
	
}
