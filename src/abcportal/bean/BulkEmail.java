/**
 * 
 */
package abcportal.bean;

import lombok.Data;

/**
 * <p>Bulk email bean where the components of a bulk email is being initialized.</p>
 * @author admin
 *
 */
public @Data class BulkEmail {
	int bulk_email_id,user_id;
	String sender_email,email_subject,email_message,email_cc,email_bcc,email_recipient;
}

