/**
 * 
 */
package abcportal.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.bean.Job;
import abcportal.dao.JobActionsDao;

/** 
 * This class handles all the actions for the Job entity. This includes: view available jobs, apply for available jobs,
 * update applications and delete applications for jobs.
 * @author admin
 *
 */
public class ViewJobListing extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3866934801463721244L;
	private Map <String, Object> userSession;
	private int job_id;
	private String job_title,job_scope,job_salary,job_availability;
	private String error_message = null;
	private String user_email, user_password;
	int singleJobId;
	int adminId;
	private String submitType;
	JobActionsDao jobActionObj = new JobActionsDao();
	ResultSet rs = null;
	List<Job> jobDataList = null;
	
	@Override
	public String execute() throws Exception {
		adminId = (int) userSession.get("user_id");
		System.out.println(adminId);
		System.out.println("submit type is " + submitType);
		try {
			jobDataList = new ArrayList<Job>();
			Job job = null;
			
			if(adminId!=0 && submitType.equals("fetchAdmin")) {
				System.out.println("display job posting where user_id = "+adminId);
				rs = jobActionObj.viewAdminJobPosting(adminId);
				if(rs!=null) {
					while(rs.next()) {
						job = new Job();
						job.setJob_id(rs.getInt("job_id"));
						job.setJob_title(rs.getString("job_title"));
						job.setJob_scope(rs.getString("job_scope"));
						job.setJob_salary(rs.getString("job_salary"));
						job.setJob_availability(rs.getString("job_availability"));
						job.setUser_id(adminId);
						jobDataList.add(job);
					}
				}
				return "VIEWADMINPOST";
			}
			if(singleJobId!=0 && submitType.equals("fetchSingle")) {
				System.out.println(singleJobId + " is the job id to display.");
				rs = jobActionObj.viewSingleJob(singleJobId);
				if(rs!=null) {
					while(rs.next()) {
						job = new Job();
						job.setJob_id(rs.getInt("job_id"));
						job.setJob_title(rs.getString("job_title"));
						job.setJob_scope(rs.getString("job_scope"));
						job.setJob_salary(rs.getString("job_salary"));
						job.setJob_availability(rs.getString("job_availability"));
						jobDataList.add(job);
					}
				}
				return "SINGLEJOBADMIN";
			}
			else {
				rs = jobActionObj.viewJob();
				if(rs!=null) {
					while(rs.next()) {
						job = new Job();
						job.setJob_id(rs.getInt("job_id"));
						job.setJob_title(rs.getString("job_title"));
						job.setJob_scope(rs.getString("job_scope"));
						job.setJob_salary(rs.getString("job_salary"));
						job.setJob_availability(rs.getString("job_availability"));
						job.setUser_id(rs.getInt("user_id"));
						jobDataList.add(job);
					}
					return "VIEWJOBSUCCESS";
				}
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return "VIEWJOBERROR";
		}
		return "VIEWJOBSUCESS";
	}
	
	/**
	 * @return the singleJobId
	 */
	public int getSingleJobId() {
		return singleJobId;
	}

	/**
	 * @param singleJobId the singleJobId to set
	 */
	public void setSingleJobId(int singleJobId) {
		this.singleJobId = singleJobId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param userSession the userSession to set
	 */
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
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
	/**
	 * @return the error_message
	 */
	public String getError_message() {
		return error_message;
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
	 * @param error_message the error_message to set
	 */
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	/**
	 * @return the jobActionObj
	 */
	public JobActionsDao getJobActionObj() {
		return jobActionObj;
	}
	/**
	 * @param jobActionObj the jobActionObj to set
	 */
	public void setJobActionObj(JobActionsDao jobActionObj) {
		this.jobActionObj = jobActionObj;
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
	 * @return the jobDataList
	 */
	public List<Job> getJobDataList() {
		return jobDataList;
	}
	/**
	 * @param jobDataList the jobDataList to set
	 */
	public void setJobDataList(List<Job> jobDataList) {
		this.jobDataList = jobDataList;
	}
	/**
	 * @return the userSession
	 */
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the submitType
	 */
	public String getSubmitType() {
		return submitType;
	}

	/**
	 * @param submitType the submitType to set
	 */
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	
	

}
