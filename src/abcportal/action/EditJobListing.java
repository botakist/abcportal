/**
 * 
 */
package abcportal.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.bean.Job;
import abcportal.dao.EditJobDao;

/**
 * @author admin
 *
 */
public class EditJobListing extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1537132638095824868L;
	private int job_id;
	private String job_title,job_scope,job_salary,job_availability;
	private String error_message = null;
	private String submitType;
	List<Job> jobDataList = null;
	ResultSet rs = null;
	EditJobDao editJobObj = new EditJobDao();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("submit type on for editing job posting is "+submitType);
		try {
			jobDataList = new ArrayList<Job>();
			Job job = null;
			if(submitType.equals("view")) {
				System.out.println("job posting with id = "+ job_id +" will be displayed");
				rs = editJobObj.retrieveJobPosting(job_id);
				if(rs!=null) {
					while(rs.next()) {
						job_id = rs.getInt("job_id");
						job_title = rs.getString("job_title");
						job_scope = rs.getString("job_scope");
						job_salary = rs.getString("job_salary");
						job_availability = rs.getString("job_availability");
					}
				}
				return "EDITJOBSUCCESS";
			}
			else if(submitType.equals("update")) {
				System.out.println("Job Posting will be updated.");
				int i = editJobObj.updateJobPosting(job_id,job_title,job_scope,job_salary,job_availability);
				if(i>0) {
					setError_message("Job posting updated.");
				}else {
					setError_message("Job posting update error.");
				}
				return "EDITJOBSUCCESS";
			}
			else if(submitType.equals("cancel")) {
				System.out.println("submit type = "+submitType);
				System.out.println("returning to job listings page");
				rs = editJobObj.backToListing();
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
					return "GOBACK";
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "EDITJOBERROR";
		}
		return "EDITJOBERROR";
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
	/**
	 * @return the editJobObj
	 */
	public EditJobDao getEditJobObj() {
		return editJobObj;
	}
	/**
	 * @param editJobObj the editJobObj to set
	 */
	public void setEditJobObj(EditJobDao editJobObj) {
		this.editJobObj = editJobObj;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	

}
