package abcportal.bean;
/**
 * <p>initialises the components of skills
 * @author admin
 *
 */
public class Skills {
	int skills_id,user_id;
	String skills_name,skills_proficiency;
	/**
	 * @return the skills_id
	 */
	public int getSkills_id() {
		return skills_id;
	}
	/**
	 * @param skills_id the skills_id to set
	 */
	public void setSkills_id(int skills_id) {
		this.skills_id = skills_id;
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
	/**
	 * @return the skills_name
	 */
	public String getSkills_name() {
		return skills_name;
	}
	/**
	 * @param skills_name the skills_name to set
	 */
	public void setSkills_name(String skills_name) {
		this.skills_name = skills_name;
	}
	/**
	 * @return the skills_proficiency
	 */
	public String getSkills_proficiency() {
		return skills_proficiency;
	}
	/**
	 * @param skills_proficiency the skills_proficiency to set
	 */
	public void setSkills_proficiency(String skills_proficiency) {
		this.skills_proficiency = skills_proficiency;
	}
	
}
