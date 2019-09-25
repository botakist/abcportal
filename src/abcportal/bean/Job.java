package abcportal.bean;

import lombok.Data;

/**
 * <p>Consists of the components of a job
 * @author admin
 *
 */
public @Data class Job {
	int job_id;
	int user_id;
	String job_title,job_scope,job_salary,job_availability;
}
