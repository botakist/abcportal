package abcportal.action;
import abcportal.dao.RegisterDao;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


/**
 * <p>Registration action sends the input of the new user to be inserted into the database tables.
 * This process will go through a round of validation for existing email addresses and password confirmation</p>
 */
public class Register extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 2876775444485107577L;
	private Map<String, Object> userSession;
	private String user_firstname,user_lastname,user_email,user_password,user_confirm_password,user_gender,user_birthday,user_country;
	private String user_role = "SP"; // auto-set role as software programmer
	private String email_error_message = "";
	private String pwd_error_message = "";
	RegisterDao registerObject = new RegisterDao();
	ResultSet rs = null;
	int rslt = 0;
	@Override
	public String execute() throws Exception {
		try {
			
			int i = 0;
			if(!user_password.equals(user_confirm_password)) {
				setPwd_error_message("Your password inputs do not match.");
				return "REGISTERERROR";
			}
			rs = registerObject.isEmailExisting(user_email);
			if(rs!=null) {
				while(rs.next()) {
					i++;
				}
			}
			if(i>0) {
				setEmail_error_message("Email address has already been registered");
				return "REGISTERERROR";
			}
			else {
				rslt = registerObject.registerUser(user_firstname,user_lastname,user_email,user_password,user_birthday,user_gender,user_country,user_role);
				return "REGISTERSUCCESS";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "REGISTERERROR";
		}
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}

	/**
	 * @return the user_firstname
	 */
	public String getUser_firstname() {
		return user_firstname;
	}

	/**
	 * @param user_firstname the user_firstname to set
	 */
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	/**
	 * @return the user_lastname
	 */
	public String getUser_lastname() {
		return user_lastname;
	}

	/**
	 * @param user_lastname the user_lastname to set
	 */
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}

	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	/**
	 * @return the user_password
	 */
	public String getUser_password() {
		return user_password;
	}

	/**
	 * @param user_password the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * @return the user_confirm_password
	 */
	public String getUser_confirm_password() {
		return user_confirm_password;
	}

	/**
	 * @param user_confirm_password the user_confirm_password to set
	 */
	public void setUser_confirm_password(String user_confirm_password) {
		this.user_confirm_password = user_confirm_password;
	}

	/**
	 * @return the user_gender
	 */
	public String getUser_gender() {
		return user_gender;
	}

	/**
	 * @param user_gender the user_gender to set
	 */
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	/**
	 * @return the user_birthday
	 */
	public String getUser_birthday() {
		return user_birthday;
	}

	/**
	 * @param user_birthday the user_birthday to set
	 */
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}

	/**
	 * @return the user_country
	 */
	public String getUser_country() {
		return user_country;
	}

	/**
	 * @param user_country the user_country to set
	 */
	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}

	/**
	 * @return the user_role
	 */
	public String getUser_role() {
		return user_role;
	}

	/**
	 * @param user_role the user_role to set
	 */
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	/**
	 * @return the email_error_message
	 */
	public String getEmail_error_message() {
		return email_error_message;
	}

	/**
	 * @param email_error_message the email_error_message to set
	 */
	public void setEmail_error_message(String email_error_message) {
		this.email_error_message = email_error_message;
	}

	/**
	 * @return the pwd_error_message
	 */
	public String getPwd_error_message() {
		return pwd_error_message;
	}

	/**
	 * @param pwd_error_message the pwd_error_message to set
	 */
	public void setPwd_error_message(String pwd_error_message) {
		this.pwd_error_message = pwd_error_message;
	}

	/**
	 * @return the registerObject
	 */
	public RegisterDao getRegisterObject() {
		return registerObject;
	}

	/**
	 * @param registerObject the registerObject to set
	 */
	public void setRegisterObject(RegisterDao registerObject) {
		this.registerObject = registerObject;
	}

	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	/**
	 * @return the rslt
	 */
	public int getRslt() {
		return rslt;
	}

	/**
	 * @param rslt the rslt to set
	 */
	public void setRslt(int rslt) {
		this.rslt = rslt;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the userSession
	 */
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	
}
