package abcportal.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import abcportal.dao.ForgetDao;
/**
 * <p>This action class is run when user forgets their password and require them to proceed to the forget password page.
 * They will then key in their email address and this action class will verify if their email address is an existing email address
 * stored inside the database.</p>
 * <p>If it is verified they are a existing user, this page will redirect to a page where a message will prompt them to check their email.</p>
 * @author admin
 */
public class Forget extends ActionSupport {

	private static final long serialVersionUID = 2109055982055774497L;
	private String user_email;
	private String error_message = "";
	ForgetDao forgetObj = new ForgetDao();
	ResultSet rs = null;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
			int i = 0;
			rs = forgetObj.retrievePwd(user_email);
			if(rs!=null) {
				while(rs.next()) {
					i++;
				}
			}
			if (i==0) {
				setError_message("Email address is not registered.");
				return "FORGETERROR";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		setError_message(null);
		return "FORGETSUCCESS";
	}
	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}
	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
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
	 * @return the forgetObj
	 */
	public ForgetDao getForgetObj() {
		return forgetObj;
	}
	/**
	 * @param forgetObj the forgetObj to set
	 */
	public void setForgetObj(ForgetDao forgetObj) {
		this.forgetObj = forgetObj;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
