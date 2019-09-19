package abcportal.bean;
/**
 * <p>bean class for initialising variables of Thread
 * @author admin
 *
 */
public class Thread {
	int thr_id,thr_msg_id,user_id;
	String thr_creator,thr_subject;
	/**
	 * @return the thr_id
	 */
	public int getThr_id() {
		return thr_id;
	}
	/**
	 * @param thr_id the thr_id to set
	 */
	public void setThr_id(int thr_id) {
		this.thr_id = thr_id;
	}
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
	 * @return the thr_creator
	 */
	public String getThr_creator() {
		return thr_creator;
	}
	/**
	 * @param thr_creator the thr_creator to set
	 */
	public void setThr_creator(String thr_creator) {
		this.thr_creator = thr_creator;
	}
	/**
	 * @return the thr_subject
	 */
	public String getThr_subject() {
		return thr_subject;
	}
	/**
	 * @param thr_subject the thr_subject to set
	 */
	public void setThr_subject(String thr_subject) {
		this.thr_subject = thr_subject;
	}
	
}
