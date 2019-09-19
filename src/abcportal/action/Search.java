package abcportal.action;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import abcportal.bean.Profile;
import abcportal.dao.SearchDao;
/**
 * <p>Search action provides the searching of other user's function in the ABC Portal.</p>
 * @author admin
 */
public class Search extends ActionSupport{

	private static final long serialVersionUID = 4198628183663730759L;
	List<Profile> profileDataList = null;
	private String search_query,error_message;
	ResultSet rs = null;
	int i = 0;
	String searchUser = null;
	SearchDao searchObj = new SearchDao();
	public String execute() throws Exception {
		try {
				profileDataList = new ArrayList<Profile>();
				Profile profile = null;
				rs = searchObj.searchUser(search_query);
				if(rs!=null) { 
					while(rs.next()) {
						i++;
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
					if(i==0) {
						setError_message("no profile found.");
					}
				}else {return "SEARCHERROR";}

			// adding a search via email if statement
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SEARCHSUCCESS";
	}
	/**
	 * @return the profileDataList
	 */
	public List<Profile> getProfileDataList() {
		return profileDataList;
	}
	/**
	 * @param profileDataList the profileDataList to set
	 */
	public void setProfileDataList(List<Profile> profileDataList) {
		this.profileDataList = profileDataList;
	}
	/**
	 * @return the search_query
	 */
	public String getSearch_query() {
		return search_query;
	}
	/**
	 * @param search_query the search_query to set
	 */
	public void setSearch_query(String search_query) {
		this.search_query = search_query;
	}
	/**
	 * @return the error_message
	 */
	public String getError_message() {
		return error_message;
	}
	/**
	 * @param error_message the error_message to set
	 */
	public void setError_message(String error_message) {
		this.error_message = error_message;
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
	 * @return the i
	 */
	public int getI() {
		return i;
	}
	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}
	/**
	 * @return the searchUser
	 */
	public String getSearchUser() {
		return searchUser;
	}
	/**
	 * @param searchUser the searchUser to set
	 */
	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}
	/**
	 * @return the searchObj
	 */
	public SearchDao getSearchObj() {
		return searchObj;
	}
	/**
	 * @param searchObj the searchObj to set
	 */
	public void setSearchObj(SearchDao searchObj) {
		this.searchObj = searchObj;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
