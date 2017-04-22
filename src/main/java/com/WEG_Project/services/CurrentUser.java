package com.WEG_Project.services;

import com.WEG_Project.modles.Account;

public final class CurrentUser {
	public static  Account acount;

	public static Account getAcount() {
		return acount;
	}

	public static void setAcount(Account acount) {
		CurrentUser.acount = acount;
	}

	public CurrentUser() {
		super();
		acount=null;
	}

}
