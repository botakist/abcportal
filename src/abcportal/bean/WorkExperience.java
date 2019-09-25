package abcportal.bean;

import lombok.Data;

/**
 * <p>Initialises the variables for work experience.
 * @author admin
 *
 */
public @Data class WorkExperience {
	int workexp_id,user_id;
	String workexp_title, workexp_description,workexp_start,workexp_end;
}
