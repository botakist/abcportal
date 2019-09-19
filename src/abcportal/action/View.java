package abcportal.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.bean.Profile;
import abcportal.dao.ViewDao;
/**
 * <p>View action class allows the user to view their own profile page.</p>
 * @author admin
 *
 */
public class View extends ActionSupport implements SessionAware{


	private static final long serialVersionUID = -5388516772901973881L;
	private Map <String, Object> userSession;
	private String user_firstname,user_lastname,user_email,user_password,user_gender,user_birthday,user_country,user_role;
	private String error_message = null;
	ViewDao viewObject = new ViewDao();
	ResultSet rs = null;
	List<Profile> profileDataList = null;
	/**
	 * 
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if((String)userSession.get("email")==null || (String) userSession.get("password")==null) {
			setError_message("View profile error, please re-verify your login information.");
			return "VIEWERROR";
		}
		user_email = (String) userSession.get("email");
		user_password = (String) userSession.get("password");
		System.out.println(user_email + " is the email retrieved from user session.");
		System.out.println(user_password + " is the password retrieved from the user session.");
		try {
			profileDataList = new ArrayList<Profile>();
			Profile profile = null;
			rs = viewObject.viewProfile(user_email,user_password);
			if(rs!=null) {
				while(rs.next()) {
					profile = new Profile();
					profile.setUser_firstname(rs.getString("user_firstname"));
					profile.setUser_lastname(rs.getString("user_lastname"));
					profile.setUser_email(rs.getString("user_email"));
					profile.setUser_birthday(rs.getString("user_birthday"));
					profile.setUser_gender(rs.getString("user_gender"));
					profile.setUser_country(rs.getString("user_country"));
					profile.setUser_role(rs.getString("user_role"));
					//remember include profile picture and resume at a later stage
					profileDataList.add(profile);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "VIEWSUCCESS";
	}
/**
 * 
 * @return
 */
	public List<Profile> getProfileDataList() {
		return profileDataList;
	}
/**
 * 
 * @param profileDataList
 */
	public void setProfileDataList(List<Profile> profileDataList) {
		this.profileDataList = profileDataList;
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
	public String getUser_gender() {
		return user_gender;
	}
	/**
	 * 
	 * @param user_gender
	 */
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
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
	public String getUser_role() {
		return user_role;
	}
	/**
	 * 
	 * @param user_role
	 */
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	/**
	 * 
	 * @return
	 */
	public ViewDao getViewObject() {
		return viewObject;
	}
	/**
	 * 
	 * @param viewObject
	 */
	public void setViewObject(ViewDao viewObject) {
		this.viewObject = viewObject;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 * @return
	 */
	public String getError_message() {
		return error_message;
	}
	/**
	 * 
	 * @param error_message
	 */
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
	
}
