/**
 * 
 */
package abcportal.action;

import java.sql.ResultSet;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.dao.PostJobDao;

/**
 * @author admin
 *
 */
public class PostJobListing extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6166817392768110467L;
	private Map <String, Object> userSession;
	private int admin_id;
	private String admin_email,admin_password,admin_role;
	private String job_title, job_scope,job_salary,job_availability;
	private int rslt;
	ResultSet rs = null;
	PostJobDao postJobObj = new PostJobDao();
	
	@Override
	public String execute() throws Exception {
		admin_id = (int) userSession.get("user_id");
		admin_email = (String) userSession.get("email");
		admin_password = (String) userSession.get("password");
		System.out.println(admin_id+admin_email+admin_password);
		try {
				
				rs = postJobObj.isAdminRole(admin_email,admin_password,admin_id);
				if(rs!=null) {
					while(rs.next()) {
						admin_role = rs.getString("user_role");
						
					}
					System.out.println(admin_role);
				}
				if(admin_role.equals("Admin")) {
					System.out.println("Admin validation complete, job will be posted.");
					rslt = postJobObj.postJobListing(job_title,job_scope,job_salary,job_availability,admin_id);
					return "POSTJOBSUCCESS";
				}
				else {
					System.out.println(admin_role);
					return "POSTJOBERROR";
				}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
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
	public Map <String, Object> getUserSession() {
		return userSession;
	}
	/**
	 * @param userSession the userSession to set
	 */
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
	 * @return the admin_role
	 */
	public String getAdmin_role() {
		return admin_role;
	}
	/**
	 * @param admin_role the admin_role to set
	 */
	public void setAdmin_role(String admin_role) {
		this.admin_role = admin_role;
	}
	/**
	 * @return the job_title
	 */
	public String getJob_title() {
		return job_title;
	}
	/**
	 * @param job_title the job_title to set
	 */
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	/**
	 * @return the job_scope
	 */
	public String getJob_scope() {
		return job_scope;
	}
	/**
	 * @param job_scope the job_scope to set
	 */
	public void setJob_scope(String job_scope) {
		this.job_scope = job_scope;
	}
	/**
	 * @return the job_salary
	 */
	public String getJob_salary() {
		return job_salary;
	}
	/**
	 * @param job_salary the job_salary to set
	 */
	public void setJob_salary(String job_salary) {
		this.job_salary = job_salary;
	}
	/**
	 * @return the job_availability
	 */
	public String getJob_availability() {
		return job_availability;
	}
	/**
	 * @param job_availability the job_availability to set
	 */
	public void setJob_availability(String job_availability) {
		this.job_availability = job_availability;
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
	 * @return the postJobObj
	 */
	public PostJobDao getPostJobObj() {
		return postJobObj;
	}
	/**
	 * @param postJobObj the postJobObj to set
	 */
	public void setPostJobObj(PostJobDao postJobObj) {
		this.postJobObj = postJobObj;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
