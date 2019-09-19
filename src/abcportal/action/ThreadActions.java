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

import abcportal.dao.ThreadsActionDao;
import abcportal.bean.Thread;

/**
 * @author admin
 *
 */
public class ThreadActions extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8727519147184569119L;
	private Map <String, Object> userSession;
	private int user_id;
	private String user_email, user_password;
	private int thread_id,creator_id;
	private String thread_subject;
	private String submitType;
	private String isAdminRole;
	private String error_msg;
	private int rslt = 0;
	ResultSet rs = null;
	List<Thread> threadDataList = null;
	ThreadsActionDao ThrActionObj = new ThreadsActionDao();
	@Override
	public String execute() throws Exception {
		user_id = (int) userSession.get("user_id");
		user_email = (String) userSession.get("email");
		user_password = (String) userSession.get("password");
		try {
			threadDataList = new ArrayList<Thread>();
			Thread thread = null;
			if(submitType.equals("viewAll")) {
				rs = ThrActionObj.validateRole(user_id,user_email,user_password);
				if(rs!=null) {
					while(rs.next()) {
						setIsAdminRole(rs.getString("user_role"));
					}
				}
				rs = ThrActionObj.viewThrListing();
				if(rs!=null) {
					while(rs.next()) {
						thread = new Thread();
						thread.setThr_id(rs.getInt("thr_id"));
						thread.setThr_subject(rs.getString("thr_subject"));
					//	thread.setThr_msg_id("thr_msg_id"); add total number of messages to display
						thread.setUser_id(rs.getInt("user_id"));
						threadDataList.add(thread);
					}
				}
				if(isAdminRole.equals("Admin")) {

					return "ADMINTHREADLISTING";
				}else {

					return "NORMALTHREADLISTING";
				}
				
				//technically displaying thread details on input form
			}else if(submitType.equals("fetchAdmin")) {
				
			}
			else if(submitType.equals("viewSingle")) {
				
			}
			
			else if(submitType.equals("editListing")) {
				rs = ThrActionObj.validateRole(user_id,user_email,user_password);
				if(rs!=null) {
					while(rs.next()) {
						setIsAdminRole(rs.getString("user_role"));
					}
				}
				if(isAdminRole.equals("Admin")) {
					setRs(ThrActionObj.editThrListing(thread_id));
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							thread.setUser_id(rs.getInt("user_id"));
							threadDataList.add(thread);
						}
					}
					return "EDITTHREADSUCCESS";
				}else { // re-direct to error page for non-admin users
					return "INVALIDROLE";
				}
			}
			
			
			
			else if(submitType.equals("post")) {
				rslt = ThrActionObj.postNewThr(thread_subject,user_id);
				return "POSTTHREADSUCCESS";
			}
			
			
			
			else if(submitType.equals("update")) {
				rslt = ThrActionObj.updateThrListing(thread_subject,thread_id);
				return "UPDATETHREADSUCCESS";
				
			}
			
			
			
			else if(submitType.equals("delete")) {
				rslt = ThrActionObj.deleteThrListing(thread_id);
				return "DELETETHREADSUCCESS";
			}
			
			
			
			else {
				System.out.println("invalid submit type");
				setError_msg("invalid action command, please contact the system admin.");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return "THREADACTIONERROR";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		userSession = session;
	}
	/**
	 * @return the userSession
	 */
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	/**
	 * @param userSession the userSession to set
	 */
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
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
	 * @return the user_password
	 */
	public String getUser_password() {
		return user_password;
	}
	/**
	 * @param user_password the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	/**
	 * @return the thread_id
	 */
	public int getThread_id() {
		return thread_id;
	}
	/**
	 * @param thread_id the thread_id to set
	 */
	public void setThread_id(int thread_id) {
		this.thread_id = thread_id;
	}
	/**
	 * @return the creator_id
	 */
	public int getCreator_id() {
		return creator_id;
	}
	/**
	 * @param creator_id the creator_id to set
	 */
	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}
	/**
	 * @return the thread_subject
	 */
	public String getThread_subject() {
		return thread_subject;
	}
	/**
	 * @param thread_subject the thread_subject to set
	 */
	public void setThread_subject(String thread_subject) {
		this.thread_subject = thread_subject;
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
	 * @return the isAdminRole
	 */
	public String getIsAdminRole() {
		return isAdminRole;
	}
	/**
	 * @param isAdminRole the isAdminRole to set
	 */
	public void setIsAdminRole(String isAdminRole) {
		this.isAdminRole = isAdminRole;
	}
	/**
	 * @return the error_msg
	 */
	public String getError_msg() {
		return error_msg;
	}
	/**
	 * @param error_msg the error_msg to set
	 */
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
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
	 * @return the threadDataList
	 */
	public List<Thread> getThreadDataList() {
		return threadDataList;
	}
	/**
	 * @param threadDataList the threadDataList to set
	 */
	public void setThreadDataList(List<Thread> threadDataList) {
		this.threadDataList = threadDataList;
	}
	/**
	 * @return the thrActionObj
	 */
	public ThreadsActionDao getThrActionObj() {
		return ThrActionObj;
	}
	/**
	 * @param thrActionObj the thrActionObj to set
	 */
	public void setThrActionObj(ThreadsActionDao thrActionObj) {
		ThrActionObj = thrActionObj;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
