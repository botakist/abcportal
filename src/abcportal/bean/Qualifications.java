package abcportal.bean;
/**
 * <p>Initialises the components of qualifications
 * @author admin
 *
 */
public class Qualifications {
	int qual_id,user_id;
	String qual_name,qual_date_achieved;
	/**
	 * @return the qual_id
	 */
	public int getQual_id() {
		return qual_id;
	}
	/**
	 * @param qual_id the qual_id to set
	 */
	public void setQual_id(int qual_id) {
		this.qual_id = qual_id;
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
	 * @return the qual_name
	 */
	public String getQual_name() {
		return qual_name;
	}
	/**
	 * @param qual_name the qual_name to set
	 */
	public void setQual_name(String qual_name) {
		this.qual_name = qual_name;
	}
	/**
	 * @return the qual_date_achieved
	 */
	public String getQual_date_achieved() {
		return qual_date_achieved;
	}
	/**
	 * @param qual_date_achieved the qual_date_achieved to set
	 */
	public void setQual_date_achieved(String qual_date_achieved) {
		this.qual_date_achieved = qual_date_achieved;
	}
	
}
