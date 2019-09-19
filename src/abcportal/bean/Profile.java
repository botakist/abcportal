package abcportal.bean;
/**
 * <p>initialises the components of a user profile</p>
 * @author admin
 *
 */
public class Profile {
	private int user_id;
	private String user_firstname,user_lastname,user_email,user_password,user_birthday,user_gender,user_country,user_role;
	/**
	 * 
	 * @return the user_firstname
	 */
	public String getUser_firstname() {
		return user_firstname;
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
	 * @param user_firstname the user_firstname to set
	 */
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}	
}