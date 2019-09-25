/**
 * 
 */
package abcportal.bean;

import lombok.Data;

/**
 * <p>Consists of components of an email attachment</p>
 * @author admin
 *
 */
public @Data class EmailAttachment {
	int email_att_id,bulk_email_id;
	String email_att_name;
}
