package abcportal.bean;
/**
 * <p>initialise the components of a private message
 * @author admin
 *
 */
public class PrivateMessage {
	int prv_msg_id;
	String prv_msg_sender,prv_msg_text;
	/**
	 * @return the prv_msg_id
	 */
	public int getPrv_msg_id() {
		return prv_msg_id;
	}
	/**
	 * @param prv_msg_id the prv_msg_id to set
	 */
	public void setPrv_msg_id(int prv_msg_id) {
		this.prv_msg_id = prv_msg_id;
	}
	/**
	 * @return the prv_msg_sender
	 */
	public String getPrv_msg_sender() {
		return prv_msg_sender;
	}
	/**
	 * @param prv_msg_sender the prv_msg_sender to set
	 */
	public void setPrv_msg_sender(String prv_msg_sender) {
		this.prv_msg_sender = prv_msg_sender;
	}
	/**
	 * @return the prv_msg_text
	 */
	public String getPrv_msg_text() {
		return prv_msg_text;
	}
	/**
	 * @param prv_msg_text the prv_msg_text to set
	 */
	public void setPrv_msg_text(String prv_msg_text) {
		this.prv_msg_text = prv_msg_text;
	}
	
}
