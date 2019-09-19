/**
 * 
 */
package abcportal.bean;

/**
 * <p>Bulk email bean where the components of a bulk email is being initialized.</p>
 * @author admin
 *
 */
public class BulkEmail {
	int bulk_email_id,user_id;
	String sender_email,email_subject,email_message,email_cc,email_bcc,email_recipient;
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
	 * @return the sender_email
	 */
	public String getSender_email() {
		return sender_email;
	}
	/**
	 * @param sender_email the sender_email to set
	 */
	public void setSender_email(String sender_email) {
		this.sender_email = sender_email;
	}
	/**
	 * @return the email_subject
	 */
	public String getEmail_subject() {
		return email_subject;
	}
	/**
	 * @param email_subject the email_subject to set
	 */
	public void setEmail_subject(String email_subject) {
		this.email_subject = email_subject;
	}
	/**
	 * @return the email_message
	 */
	public String getEmail_message() {
		return email_message;
	}
	/**
	 * @param email_message the email_message to set
	 */
	public void setEmail_message(String email_message) {
		this.email_message = email_message;
	}
	/**
	 * @return the email_cc
	 */
	public String getEmail_cc() {
		return email_cc;
	}
	/**
	 * @param email_cc the email_cc to set
	 */
	public void setEmail_cc(String email_cc) {
		this.email_cc = email_cc;
	}
	/**
	 * @return the email_bcc
	 */
	public String getEmail_bcc() {
		return email_bcc;
	}
	/**
	 * @param email_bcc the email_bcc to set
	 */
	public void setEmail_bcc(String email_bcc) {
		this.email_bcc = email_bcc;
	}
	/**
	 * @return the email_recipient
	 */
	public String getEmail_recipient() {
		return email_recipient;
	}
	/**
	 * @param email_recipient the email_recipient to set
	 */
	public void setEmail_recipient(String email_recipient) {
		this.email_recipient = email_recipient;
	}
}

