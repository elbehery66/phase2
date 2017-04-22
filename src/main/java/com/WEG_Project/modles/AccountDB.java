package com.WEG_Project.modles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestParam;

public class AccountDB {

	public static Connection Get_Conncetion() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1/weg_database";
			String userName = "root";
			String PassWord = "";
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, userName, PassWord);
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// public static void InsertAccountData(Account acc) throws Exception{
	// Connection connection=Get_Conncetion();
	// Statement st= connection.createStatement();
	// String g="INSERT INTO `account`(`FirstName`, `LastName`, `Gender`,
	// `Email`, `PassWord`, `Type`, `UserName`) VALUES
	// (acc.,'ismail','M','ahmed@gamil.com','12345','T','mido')";
	// st.executeUpdate(g);
	//
	//
	//
	//
	// }
	public String checkaccount(String username, String password) throws Exception {
		try {
			Connection connection = Get_Conncetion();
			Statement st = connection.createStatement();
			String g = "SELECT * FROM  account where UserName='" + username + "'";

			ResultSet result = st.executeQuery(g);
			while (result.next()) {
				if (result.getString("UserName").equals(username) && result.getString("PassWord").equals(password)) {
					String str = result.getString("Type");
					return str;
				}
			}
		} catch (SQLException e) {

		}
		return "notfound";

	}

	public boolean CreateAccountDB(Account account) throws Exception {

		try {
			/*
			 * Connection connect=Get_Conncetion(); PreparedStatement ps =
			 * connect
			 * .prepareStatement("INSERT INTO account(FirstName,LastName, Gender,Email,PassWord, Type) VALUES (?,?,?,?,?,?)"
			 * ); ps.setString(1, account.getFirstName()); ps.setString(2,
			 * account.getLastName()); ps.setString(3, account.getGender());
			 * ps.setString(4, account.getEmail()); ps.setString(5,
			 * account.getPassWord()); ps.setString(6, account.getType()); int j
			 * = ps.executeUpdate();
			 */

			Connection connection = Get_Conncetion();
			Statement st = connection.createStatement();
			String g = "INSERT INTO `account`(`FirstName`, `LastName`, `Gender`, `Email`, `PassWord`, `Type`, `UserName`) VALUES ('"
					+ account.getFirstName() + "','" + account.getLastName() + "','" + account.getGender() + "','"
					+ account.getEmail() + "','" + account.getPassWord() + "','" + account.getType() + "','"
					+ account.getUserName() + "')";
			System.out.println(g);
			st.executeUpdate(g);
			// return true;
		} catch (SQLException e) {

			return false;
		}

		return true;
	}

	////////////////////////////////////////////////////////////////

	public Account GetUserInfo(String UserName) throws Exception {
		try {
        
			Connection connection = Get_Conncetion();
			Statement st = connection.createStatement();
			String g = "SELECT * FROM account where UserName=" + "'" + UserName + "'";
			
			Account account =null;
			ResultSet result = st.executeQuery(g);
		  while(result.next()) {
			 account = new Account(result.getString("FirstName"), result.getString("LastName"),
					result.getString("Gender"), result.getString("Email"), result.getString("PassWord"),
					result.getString("Type"), result.getString("UserName"));
			System.out.println(account.getEmail()); }
			return account;

		} catch (SQLException e) {
			System.out.println("Show User info exception:)");
			Account account = new Account();
			return account;
		}
		
	}

}
