/**
 * 
 */
package abcportal.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.dao.DeleteJobDao;

/**
 * @author admin
 *
 */
public class DeleteJobListing extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8240933326844592201L;
	private Map <String, Object> userSession;
	private int admin_id;
	private String admin_email,admin_password;
	private String isAdminRole;
	private int job_id;
	private String error_message = null;
	private int rslt; // variable to store data after delete statement
	ResultSet rs = null;
	DeleteJobDao DeleteJobObj = new DeleteJobDao();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		admin_email = (String) userSession.get("email");
		System.out.println(admin_email);
		admin_password = (String) userSession.get("password");
		System.out.println(admin_password);
		admin_id = (int) userSession.get("user_id");
		System.out.println(admin_id);
		try {
			rs = DeleteJobObj.validateRole(admin_email,admin_password,admin_id);
			if(rs!=null) {
				while (rs.next()) {
					isAdminRole = rs.getString("user_role");
					System.out.println("user role is " + isAdminRole);
				}
			}
			//if user role is not admin
			if(!(isAdminRole.equals("Admin"))) {
				setError_message("role cannot be validated. job listing not deleted.");
				rs.close();
				return "DELETEJOBERROR";
			}
			// if user role is admin
			else if(isAdminRole.equals("Admin")) {
				// validation success
				System.out.println(job_id);
				try {
					setRslt(DeleteJobObj.deleteJob(job_id));
					return "DELETEJOBSUCCESS";
				}catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			else {
				System.out.println("delete job listing error. Please view the error log.");
				rs.close();
				return "DELETEJOBERROR";
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "DELETEJOBERROR";
		}
	}
	/**
	 * @param userSession the userSession to set
	 */
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	/**
	 * @return the userSession
	 */
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}
	/**
	 * @return the admin_email
	 */
	public String getAdmin_email() {
		return admin_email;
	}
	/**
	 * @param admin_email the admin_email to set
	 */
	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}
	/**
	 * @return the admin_password
	 */
	public String getAdmin_password() {
		return admin_password;
	}
	/**
	 * @param admin_password the admin_password to set
	 */
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	/**
	 * @return the job_id
	 */
	public int getJob_id() {
		return job_id;
	}
	/**
	 * @param job_id the job_id to set
	 */
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	/**
	 * @return the error_message
	 */
	public String getError_message() {
		return error_message;
	}
	/**
	 * @param error_message the error_message to set
	 */
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}
	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	/**
	 * @return the deleteActionObj
	 */
	public DeleteJobDao getDeleteJobObj() {
		return DeleteJobObj;
	}
	/**
	 * @param deleteActionObj the deleteActionObj to set
	 */
	public void setDeleteActionObj(DeleteJobDao deleteJobObj) {
		DeleteJobObj = deleteJobObj;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the admin_id
	 */
	public int getAdmin_id() {
		return admin_id;
	}
	/**
	 * @param admin_id the admin_id to set
	 */
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	/**
	 * @return the isAdminRole
	 */
	public String getIsAdminRole() {
		return isAdminRole;
	}
	/**
	 * @param isAdminRole the isAdminRole to set
	 */
	public void setIsAdminRole(String isAdminRole) {
		this.isAdminRole = isAdminRole;
	}
	/**
	 * @return the rslt
	 */
	public int getRslt() {
		return rslt;
	}
	/**
	 * @param rslt the rslt to set
	 */
	public void setRslt(int rslt) {
		this.rslt = rslt;
	}
	
	

}
