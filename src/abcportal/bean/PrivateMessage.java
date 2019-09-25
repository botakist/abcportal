package abcportal.bean;

import lombok.Data;

/**
 * <p>initialise the components of a private message
 * @author admin
 *
 */
public @Data class PrivateMessage {
	int prv_msg_id;
	String prv_msg_sender,prv_msg_text;
	
	
}
