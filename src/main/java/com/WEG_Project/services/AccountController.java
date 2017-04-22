package com.WEG_Project.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.WEG_Project.modles.Account;
import com.WEG_Project.modles.AccountDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class AccountController {
	User currentUser = new User();

	@RequestMapping("/")
	public String Login() {
		return "login";
	}

	@RequestMapping("/signup")
	public String gignup() {
		return "signup";
	}

	@RequestMapping("/signin")
	public ModelAndView addnewuser(@RequestParam("username") String UserName, @RequestParam("pass") String PassWord)
			throws Exception {

		AccountDB DB = new AccountDB();
		String Type = DB.checkaccount(UserName, PassWord);
		if (Type == "notfound") {
			ModelAndView mv = new ModelAndView("/login");
			return mv;
		}
		Account new_user = new Account();
		new_user.setUserName(UserName);
		new_user.setPassWord(PassWord);
		new_user.setType(Type);
		currentUser.setAcount(new_user);
		System.out.println("aaa" + currentUser.getAcount().getType());
		ModelAndView mv = new ModelAndView("/" + Type);
		return mv;
	}

	@RequestMapping("/CreateAccount")

	public ModelAndView addnewuser(@RequestParam("fname") String Fname, @RequestParam("lname") String Lname,
			@RequestParam("username") String UserName, @RequestParam("gender") String Gender,
			@RequestParam("mail") String Email, @RequestParam("pass") String PassWord, @RequestParam("type") String Type

	) throws Exception {
		System.out.println(Type);
		Account new_user = new Account(Fname, Lname, Gender, Email, PassWord, Type, UserName);
		AccountDB DB = new AccountDB();

		currentUser.setAcount(new_user);
		System.out.println(DB.CreateAccountDB(new_user));

		ModelAndView mv = new ModelAndView("/" + Type);

		return mv;

	}

	@RequestMapping("/showUserInformation")
	public String showinformation(Model model) throws Exception {
		User currentUser = new User();

		AccountDB db = new AccountDB();

		model.addAttribute("information", db.GetUserInfo(currentUser.getAcount().getUserName()));
		return currentUser.getAcount().getType();
	}

	// public void Account_Detail
	// (
	// @RequestParam("fname") String name,
	// @RequestParam("lname") String pass,
	// @RequestParam("username") String UserName,
	// @RequestParam("gender") String Gender,
	// @RequestParam ("mail") String Email,
	// @RequestParam ("pass") String PassWord,
	// @RequestParam ("type") String Type
	//
	//
	// )
	// throws Exception
	{

		// Get_Conncetion();
		// InsertAccountData();

		// print(name,pass);
		// Student s=new Student(name,pass);
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("Login");
		// mv.addObject("student", s);
		// return mv;
	}

}
