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
import lombok.Data;

/** 
 * This class handles all the actions for the Job entity. This includes: view available jobs, apply for available jobs,
 * update applications and delete applications for jobs.
 * @author admin
 *
 */
public @Data class ViewJobListing extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3866934801463721244L;
	private Map <String, Object> userSession;
	private int job_id;
	private String job_title;
	private String job_scope;
	private String job_salary;
	private String job_availability;
	private String error_message = null;
	private String user_email;
	private String user_password;
	private int singleJobId;
	private int adminId;
	private String submitType;
	private JobActionsDao jobActionObj = new JobActionsDao();
	private ResultSet rs = null;
	private List<Job> jobDataList = null;
	
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
				return "VIEWADMINPOST"; // this to return the job listings that this admin posted
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
				return "SINGLEJOBADMIN"; //
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
	
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}
	
	

}
