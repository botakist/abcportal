package abcportal.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import abcportal.bean.Profile;
import abcportal.dao.UserActionDao;
import lombok.Data;

public @Data class UserActions extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	private static final String ADMIN = "admin";
	private static final String SP = "sp";
	private Map <String, Object> userSession;
	private Profile profile;
	private String submitType;
	
	private int profile_id;
	private int user_id;
	
	private String user_email;
	private String user_password;
	private String user_role;
	private String error_msg;
	
	private int rslt;
	private ResultSet rs;
	private List<Profile> profileDataList;
	private UserActionDao userActionObj;
	
	@Override
	public String execute() throws Exception {
		user_id = (int) userSession.get("user_id");
		user_email = (String) userSession.get("email");
		user_password = (String) userSession.get("password");
		
		try {
			profileDataList = new ArrayList<Profile>();
			userActionObj  = new UserActionDao();
			System.out.println("command is "+submitType);
			// TODO: validate user role before allowing user to execute functions/go to unauthorized pages
			user_role = userActionObj.validateUserRole(user_email,user_password);
			System.out.println(user_role);
			System.out.println(submitType);
			if(user_role.equalsIgnoreCase(ADMIN)) {
				switch(submitType) {
				case "viewAll":
					rs = userActionObj.findAll();
					if(rs!=null) {
						while(rs.next()) {
							profile = new Profile();
							profile.setUser_id(rs.getInt("user_id"));
							profile.setUser_firstname(rs.getString("user_firstname"));
							profile.setUser_lastname(rs.getString("user_lastname"));
							profile.setUser_email(rs.getString("user_email"));
							profile.setUser_birthday(rs.getString("user_birthday"));
							profile.setUser_gender(rs.getString("user_gender"));
							profile.setUser_country(rs.getString("user_country"));
							profile.setUser_role(rs.getString("user_role"));
							profileDataList.add(profile);
						}
					}
					return "USERLISTADMIN";
					
				case "viewSingle":
					rs = userActionObj.findById(profile_id);
					if(rs!=null) {
						while(rs.next()) {
							profile = new Profile();
							profile.setUser_id(rs.getInt(user_id));
							profile.setUser_firstname(rs.getString("user_firstname"));
							profile.setUser_lastname(rs.getString("user_lastname"));
							profile.setUser_email(rs.getString("user_email"));
							profile.setUser_birthday(rs.getString("user_birthday"));
							profile.setUser_gender(rs.getString("user_gender"));
							profile.setUser_country(rs.getString("user_country"));
							profile.setUser_role(rs.getString("user_role"));
							profileDataList.add(profile);
						}
					}
					return "USERSINGLEADMIN";
					
				case "deleteThisUser":
					rslt = userActionObj.deleteUserById(profile_id);
					return "DELETESUCCESS";
					
				case "returnToListing":
					return "ADMINBACK";
				default:
					setError_msg("invalid submit type: "+submitType+" from role: "+user_role);
					return "ADMIN404";
					
				}
			}else if(user_role.equalsIgnoreCase(SP)) {
				switch(submitType) {
				case "viewAll":
					rs = userActionObj.findAll();
					if(rs!=null) {
						while(rs.next()) {
							profile = new Profile();
							profile.setUser_id(rs.getInt("user_id"));
							profile.setUser_firstname(rs.getString("user_firstname"));
							profile.setUser_lastname(rs.getString("user_lastname"));
							profile.setUser_email(rs.getString("user_email"));
							profile.setUser_birthday(rs.getString("user_birthday"));
							profile.setUser_gender(rs.getString("user_gender"));
							profile.setUser_country(rs.getString("user_country"));
							profile.setUser_role(rs.getString("user_role"));
							profileDataList.add(profile);
						}
					}
					return "USERLISTNORMAL";
					
				case "viewSingle":
					rs = userActionObj.findById(profile_id);
					if(rs!=null) {
						while(rs.next()) {
							profile = new Profile();
							profile.setUser_id(rs.getInt(user_id));
							profile.setUser_firstname(rs.getString("user_firstname"));
							profile.setUser_lastname(rs.getString("user_lastname"));
							profile.setUser_email(rs.getString("user_email"));
							profile.setUser_birthday(rs.getString("user_birthday"));
							profile.setUser_gender(rs.getString("user_gender"));
							profile.setUser_country(rs.getString("user_country"));
							profile.setUser_role(rs.getString("user_role"));
							profileDataList.add(profile);
						}
					}
					return "USERSINGLENORMAL";
					
				case "returnToListing":
					return "NORMALBACK";
				default:
					setError_msg("invalid submit type: "+submitType+" from role: "+user_role);
					return "USER404";
				}
			}else {
				setError_msg("invalid role in user: " + user_role);
				return "USER404";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
}
