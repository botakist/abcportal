package abcportal.bean;

import lombok.Data;

/**
 * <p>Initialises the variables of thread messages
 * @author admin
 *
 */
public @Data class ThreadMessage {
	private int thr_msg_id;
	private String thr_msg_text;
	private int thr_id;
	private int user_id;
	
}
