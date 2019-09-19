package abcportal.bean;
/**
 * <p>Initialises the variables of thread messages
 * @author admin
 *
 */
public class ThreadMessage {
	int thr_msg_id;
	String thr_msg_creator,thr_msg_text;
	/**
	 * @return the thr_msg_id
	 */
	public int getThr_msg_id() {
		return thr_msg_id;
	}
	/**
	 * @param thr_msg_id the thr_msg_id to set
	 */
	public void setThr_msg_id(int thr_msg_id) {
		this.thr_msg_id = thr_msg_id;
	}
	/**
	 * @return the thr_msg_creator
	 */
	public String getThr_msg_creator() {
		return thr_msg_creator;
	}
	/**
	 * @param thr_msg_creator the thr_msg_creator to set
	 */
	public void setThr_msg_creator(String thr_msg_creator) {
		this.thr_msg_creator = thr_msg_creator;
	}
	/**
	 * @return the thr_msg_text
	 */
	public String getThr_msg_text() {
		return thr_msg_text;
	}
	/**
	 * @param thr_msg_text the thr_msg_text to set
	 */
	public void setThr_msg_text(String thr_msg_text) {
		this.thr_msg_text = thr_msg_text;
	}
	
}
