package abcportal.bean;

import lombok.Data;

/**
 * <p>initialises the components of skills
 * @author admin
 *
 */
public @Data class Skills {
	int skills_id,user_id;
	String skills_name,skills_proficiency;
}
