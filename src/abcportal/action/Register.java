package abcportal.action;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.dao.RegisterDao;
import lombok.Data;


/**
 * <p>Registration action sends the input of the new user to be inserted into the database tables.
 * This process will go through a round of validation for existing email addresses and password confirmation</p>
 */
public @Data class Register extends ActionSupport implements SessionAware{

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
				registerObject.send("nastoi1201@gmail.com", "Khairi120195.", "yxwong2608@gmail.com");
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
}
