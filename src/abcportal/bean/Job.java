package abcportal.bean;
/**
 * <p>Consists of the components of a job
 * @author admin
 *
 */
public class Job {
	int job_id;
	int user_id;
	String job_title,job_scope,job_salary,job_availability;
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
}
