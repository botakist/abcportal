package abcportal.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.bean.Profile;
import abcportal.dao.LoginDao;

/**
 * <p>Login Action Class take in the inputs from the user and verify if its email and password are existing
 * inside the database server. </p>
 * @author admin
 */
public class Login extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1110080016661746574L;
	private Map <String, Object> userSession;
	Profile profile = null;
	private String email, password, role;
	private int user_id;

	LoginDao loginObject = new LoginDao();
	ResultSet rs = null;

	private String message = "";
	@Override
	public String execute() throws Exception {
		profile = new Profile();
		try {
			int i = 0;
			rs = loginObject.loginUser(email,password);
			if(rs!=null) {
				while(rs.next()) {
					i++;
					role = rs.getString("user_role");
					userSession.put("email",this.email);
					userSession.put("password",this.password);
					user_id = rs.getInt("user_id");
					System.out.println("user id of account is "+ user_id);
					userSession.put("user_id", this.user_id);
				}
				if(i==0) {
					message = "Email or Password is incorrect.";
					return "LOGINERROR";
				}else {
					if(role.equals("Admin")) {
						return "ADMIN";
					}
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "LOGINSUCCESS";	
	}
	
	/**
	 * @return the userSession
	 */
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	/**
	 * @param userSession the userSession to set
	 */
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the loginObject
	 */
	public LoginDao getLoginObject() {
		return loginObject;
	}

	/**
	 * @param loginObject the loginObject to set
	 */
	public void setLoginObject(LoginDao loginObject) {
		this.loginObject = loginObject;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}