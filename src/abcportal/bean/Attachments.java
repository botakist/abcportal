/**
 * 
 */
package abcportal.bean;

/**
 * <p>Bean class containing the variables of an attachment that is included inside an email attachment.</p>
 * @author admin
 * @since 1991
 *
 */
public class Attachments {
	private int attach_id, thr_msg_id;
	private String attach_name, attach_file;
	/**
	 * @return the attach_id
	 */
	public int getAttach_id() {
		return attach_id;
	}
	/**
	 * @param attach_id the attach_id to set
	 */
	public void setAttach_id(int attach_id) {
		this.attach_id = attach_id;
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
	 * @return the attach_name
	 */
	public String getAttach_name() {
		return attach_name;
	}
	/**
	 * @param attach_name the attach_name to set
	 */
	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
	}
	/**
	 * @return the attach_file
	 */
	public String getAttach_file() {
		return attach_file;
	}
	/**
	 * @param attach_file the attach_file to set
	 */
	public void setAttach_file(String attach_file) {
		this.attach_file = attach_file;
	}
}
