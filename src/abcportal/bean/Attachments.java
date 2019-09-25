/**
 * 
 */
package abcportal.bean;

import lombok.Data;

/**
 * <p>Bean class containing the variables of an attachment that is included inside an email attachment.</p>
 * @author admin
 * @since 1991
 *
 */
public @Data class Attachments {
	private int attach_id, thr_msg_id;
	private String attach_name, attach_file;

}
