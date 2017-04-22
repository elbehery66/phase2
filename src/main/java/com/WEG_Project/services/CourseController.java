package com.WEG_Project.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.WEG_Project.modles.CourseDB;
import com.WEG_Project.modles.Gamedb;


@Controller
public class CourseController {

	
	@RequestMapping ("/addcourse")
	private String addCourse() {
		return "addcourse";

	}
	
	@RequestMapping ("/addDataCourse")
	public String addnewCourse(Model model,@RequestParam ("CourseName") String courseName ) throws Exception
	{


CourseDB db=new CourseDB();

User currentUser=new User();
db.addnewCourse(courseName,currentUser.getAcount().getUserName() );



 
return "teacher";
	}
	

	@RequestMapping ("/showCourses")
	
	private String showCourse(Model model) throws Exception {
		CourseDB db =new CourseDB();
		  model.addAttribute("courses",db.showCourses() );
//		  for (int i=0;i<db.showCourses().size();i++)
//			  System.err.println(db.showCourses().get(i));
		return "showCourses";

	}
	
}
