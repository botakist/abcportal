package abcportal.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.dao.EditDao;
/**
 * <p>returns the result message when the updating of user profile.
 * It will set an error message to be displayed on the user's profile page when there is an error in updating profile.</p>
 * @author admin
 */
public class Edit extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 744892979157211097L;
	private Map <String, Object> userSession;
	private String user_firstname,user_lastname,user_email,user_password,user_country,user_birthday;
	private String msg = "";
	String submitType;
	ResultSet rs = null;
	EditDao editObj = new EditDao();
	/**
	 * 
	 */
	@Override
	public String execute() throws Exception {
		user_email = (String) userSession.get("email");
		user_password = (String) userSession.get("password");
		System.out.println(user_email + " is the email retrieved from session");
		System.out.println(user_password + " is the password retrieved from session");
		System.out.println("Submit Type is "+submitType);
		// TODO Auto-generated method stub
		try {
			if (submitType.equals("fetch")) {
				rs = editObj.fetchProfileDetails(user_email,user_password);
				if (rs != null) {
					while (rs.next()) {
						user_firstname = rs.getString("user_firstname");
						user_lastname = rs.getString("user_lastname");
						user_country = rs.getString("user_country");
						user_birthday = rs.getString("user_birthday");
					}
				}
			}
			else if(submitType.equals("update")){
				int i = editObj.updateProfile(user_firstname,user_lastname,user_country,user_birthday,user_email,user_password);
				if (i > 0) {
					setMsg("Profile Edited Successfully");
				} else {
					setMsg("Profile edit error");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "EDITSUCCESS";
	}
	/**
	 * 
	 * @return
	 */
	public String getUser_country() {
		return user_country;
	}
	/**
	 * 
	 * @param user_country
	 */
	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}
	/**
	 * 
	 * @return
	 */
	public String getUser_birthday() {
		return user_birthday;
	}
	/**
	 * 
	 * @param user_birthday
	 */
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	/**
	 * 
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}
	/**
	 * 
	 * @return
	 */
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	/**
	 * 
	 * @param userSession
	 */
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	/**
	 * 
	 * @return
	 */
	public String getUser_firstname() {
		return user_firstname;
	}
	/**
	 * 
	 * @param user_firstname
	 */
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	/**
	 * 
	 * @return
	 */
	public String getUser_lastname() {
		return user_lastname;
	}
	/**
	 * 
	 * @param user_lastname
	 */
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	/**
	 * 
	 * @return
	 */
	public String getUser_email() {
		return user_email;
	}
	/**
	 * 
	 * @param user_email
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	/**
	 * 
	 * @return
	 */
	public String getUser_password() {
		return user_password;
	}
	/**
	 * 
	 * @param user_password
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	/**
	 * 
	 * @return
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 
	 *@return
	 */
	public String getSubmitType() {
		return submitType;
	}
/**
 * 
 * @param submitType
 */
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	/**
	 * 
	 * @return
	 */
	public ResultSet getRs() {
		return rs;
	}
	/**
	 * 
	 * @param rs
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	/**
	 * 
	 * @return
	 */
	public EditDao getEditObj() {
		return editObj;
	}
	/**
	 * 
	 * @param editObj
	 */
	public void setEditObj(EditDao editObj) {
		this.editObj = editObj;
	}
	
	
	
}
