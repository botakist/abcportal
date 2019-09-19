package abcportal.action;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Test;

import abcportal.dao.ForgetDao;

public class ForgetTest {
	protected String user_email_test,message;
	protected int i = 0;
	protected ResultSet rs = null;
	protected ForgetDao forgetObj = new ForgetDao();
	
	@Test
	public void testInvalidEmail() throws Exception {
		setUser_email_test("testdev@testdev.testdev");
		try {
			int i = 0;
			rs = forgetObj.retrievePwd(user_email_test);
			if(rs!=null) {
				while(rs.next()) {
					i++;
				}
			}
			if (i==0) {
				setMessage("Email address is not registered.");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			assertTrue(e==null);
		}
		//confirms result set returned has no results and error message will display
		assertTrue(i==0);
		assertTrue(message!=null);
		
	}
	@Test
	public void testValidEmail() throws Exception{
		setUser_email_test("test2@gmail.com");
		try {
			int i = 0;
			rs = forgetObj.retrievePwd(user_email_test);
			if(rs!=null) {
				while(rs.next()) {
					i++;
				}
			}
			System.out.println(i);
			if (i==0) {
				setMessage("Email address is not registered.");
				System.out.println(message);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		//confirms result set returned is a valid result and the if statement of the error message will not be run
		assertTrue(message==null);
	}
	

	public String getUser_email_test() {
		return user_email_test;
	}

	public void setUser_email_test(String user_email_test) {
		this.user_email_test = user_email_test;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
