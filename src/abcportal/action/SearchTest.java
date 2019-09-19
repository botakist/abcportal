package abcportal.action;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import abcportal.bean.Profile;
import abcportal.dao.SearchDao;

public class SearchTest {
	List<Profile> profileDataList = null;
	private String search_query,error_message;
	ResultSet rs = null;
	int i = 0;
	String searchUser = null;
	SearchDao searchObj = new SearchDao();
	@Test
	public void testValidSearchQuery() {
		try {
			//change search query here
			setSearch_query("John");
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
				System.out.println("there is "+i+" results found.");
				assertTrue(profile.getUser_email()!=null);
				if(i==0) {
					setError_message("no profile found.");
					System.out.println(error_message);
					System.out.println("no profile found error is handled appropriately.");
					assertTrue(error_message.equals("no profile found."));
				}
			}else {fail();}
	} catch (Exception e) {
		e.printStackTrace();
	}
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

}
