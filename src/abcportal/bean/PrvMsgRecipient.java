package abcportal.bean;
/**
 * <p>intialises the components of a private message recipient</p>
 * @author admin
 *
 */
public class PrvMsgRecipient {
	int prv_msg_rec_id,prv_msg_id;
	String prv_msg_rec_user;
	/**
	 * @return the prv_msg_rec_id
	 */
	public int getPrv_msg_rec_id() {
		return prv_msg_rec_id;
	}
	/**
	 * @param prv_msg_rec_id the prv_msg_rec_id to set
	 */
	public void setPrv_msg_rec_id(int prv_msg_rec_id) {
		this.prv_msg_rec_id = prv_msg_rec_id;
	}
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
	 * @return the prv_msg_rec_user
	 */
	public String getPrv_msg_rec_user() {
		return prv_msg_rec_user;
	}
	/**
	 * @param prv_msg_rec_user the prv_msg_rec_user to set
	 */
	public void setPrv_msg_rec_user(String prv_msg_rec_user) {
		this.prv_msg_rec_user = prv_msg_rec_user;
	}
	
}
