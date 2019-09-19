package abcportal.action;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import abcportal.dao.RegisterDao;

public class RegisterTest {
	protected String user_email, user_password,user_firstname,user_lastname,user_gender,user_birthday,user_country,user_confirm_password,user_role;
	protected String error_message;
	protected int i = 0;
	protected int rslt = 0;
	protected ResultSet rs = null;
	RegisterDao registerObj = new RegisterDao();

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validEmailTest() throws Exception {
		setUser_firstname("testdev");
		setUser_lastname("testdev");
		setUser_email("testdev@testdev.co");
		setUser_password("testdev");
		setUser_birthday("1995-11-11");
		setUser_gender("Male");
		setUser_country("testdev");
		setUser_role("SP");
		try {
			rslt = registerObj.registerUser(user_firstname,user_lastname,user_email,user_password,user_birthday,user_gender,user_country,user_role);
		}catch (Exception e) {
			e.printStackTrace();
			assertTrue(e==null);
		}
	}
	
	@Test
	public void checkExistingEmailTest() throws Exception{
		setUser_email("test1@gmail.com");
		try {
			rs = registerObj.isEmailExisting(user_email);
			if(rs!=null) {
				while(rs.next()) {
					i++;
				}
			}
			if(i>0) {
				setError_message("email has been registered");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(i>0);
	}

	public String getUser_firstname() {
		return user_firstname;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public String getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	public String getUser_country() {
		return user_country;
	}

	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}

	public String getUser_confirm_password() {
		return user_confirm_password;
	}

	public void setUser_confirm_password(String user_confirm_password) {
		this.user_confirm_password = user_confirm_password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

}
