package com.WEG_Project.services;

import com.WEG_Project.modles.Account;

public final class User {
	public static Account acount;

	public static Account getAcount() {
		return acount;
	}

	public static void setAcount(Account acount) {
		User.acount = acount;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
