package abcportal.bean;

import lombok.Data;

/**
 * <p>intialises the components of a private message recipient</p>
 * @author admin
 *
 */
public @Data class PrvMsgRecipient {
	int prv_msg_rec_id,prv_msg_id;
	String prv_msg_rec_user;
}
