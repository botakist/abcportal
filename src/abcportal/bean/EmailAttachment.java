/**
 * 
 */
package abcportal.bean;

/**
 * <p>Consists of components of an email attachment</p>
 * @author admin
 *
 */
public class EmailAttachment {
	int email_att_id,bulk_email_id;
	String email_att_name;
	/**
	 * @return the email_att_id
	 */
	public int getEmail_att_id() {
		return email_att_id;
	}
	/**
	 * @param email_att_id the email_att_id to set
	 */
	public void setEmail_att_id(int email_att_id) {
		this.email_att_id = email_att_id;
	}
	/**
	 * @return the bulk_email_id
	 */
	public int getBulk_email_id() {
		return bulk_email_id;
	}
	/**
	 * @param bulk_email_id the bulk_email_id to set
	 */
	public void setBulk_email_id(int bulk_email_id) {
		this.bulk_email_id = bulk_email_id;
	}
	/**
	 * @return the email_att_name
	 */
	public String getEmail_att_name() {
		return email_att_name;
	}
	/**
	 * @param email_att_name the email_att_name to set
	 */
	public void setEmail_att_name(String email_att_name) {
		this.email_att_name = email_att_name;
	}
}
