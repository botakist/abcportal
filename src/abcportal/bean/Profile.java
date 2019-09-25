package abcportal.bean;

import lombok.Data;

/**
 * <p>initialises the components of a user profile</p>
 * @author admin
 *
 */
public @Data class Profile {
	private int user_id;
	private String user_firstname,user_lastname,user_email,user_password,user_birthday,user_gender,user_country,user_role;
}