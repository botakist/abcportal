/**
 * 
 */
package abcportal.action;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import abcportal.dao.LoginDao;

/**
 * @author admin
 *
 */
public class LoginTest {
	protected String user_email_test,user_password_test,message;
	protected int i = 0;
	protected ResultSet rs = null;
	protected LoginDao loginTestObj = new LoginDao();
	@Test
	public void wrongEmailInput() throws Exception {
		setUser_email_test("dsasdfdsfas");
		setUser_password_test("fdsafdsafs");
		  try {
			rs = loginTestObj.loginUser(user_email_test,user_password_test);
			if(rs!=null) {
				while(rs.next()) {
					i++;}
				if(i==0) {
					message = "Email or Password is incorrect.";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  //this confirms the login validation has failed and is displayed the correct error message
		  assertTrue(i==0);
	}
	@Test
	public void wrongPasswordInput() throws Exception {
		setUser_email_test("test1@gmail.com");
		setUser_password_test("fdsafdsafs");
		try {
			rs = loginTestObj.loginUser(user_email_test,user_password_test);
			if(rs!=null) {
				while(rs.next()) {
					i++;}
				if(i==0) {
					message = "Email or Password is incorrect.";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this confirms the login validation has failed and is displayed the correct error message
		  assertTrue(i==0);
		
	}
	@Test
	public void validCredentialsTest() throws Exception {
		setUser_email_test("test1@gmail.com");
		setUser_password_test("123456");
		try {
			rs = loginTestObj.loginUser(user_email_test,user_password_test);
			if(rs!=null) {
				while(rs.next()) {
					i++;}
				if(i==0) {
					message = "Email or Password is incorrect.";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this confirms the login validation has passed and the if statement of the error message is not run
		  assertFalse(i==0);
		
	}
	
	public String getUser_email_test() {
		return user_email_test;
	}
	public void setUser_email_test(String user_email_test) {
		this.user_email_test = user_email_test;
	}
	public String getUser_password_test() {
		return user_password_test;
	}
	public void setUser_password_test(String user_password_test) {
		this.user_password_test = user_password_test;
	}
}
