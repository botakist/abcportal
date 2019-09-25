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
import lombok.Data;
import abcportal.bean.Thread;
import abcportal.bean.ThreadMessage;

/**
 * @author admin
 *
 */
public @Data class ThreadActions extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 8727519147184569119L;
	private Map <String, Object> userSession;
	private int user_id;
	private String user_email;
	private String user_password;
	private int thr_id;
	private int thr_msg_id;
	private String thr_subject;
	private String thr_msg_text;
	private String submitType;
	private String isAdminRole;
	private String error_msg;
	private int rslt = 0;
	private ResultSet rs = null;
	private List<Thread> threadDataList = null;
	private List<ThreadMessage> threadMessageList = null;
	private ThreadsActionDao ThrActionObj;
	@Override
	public String execute() throws Exception {
		user_id = (int) userSession.get("user_id");
		user_email = (String) userSession.get("email");
		user_password = (String) userSession.get("password");
		
		threadDataList = new ArrayList<Thread>();
		threadMessageList = new ArrayList<ThreadMessage>();
		ThrActionObj = new ThreadsActionDao();
		Thread thread = null;
		ThreadMessage threadMessage = null;
		//execute role validation of current user
		try {
			
			rs = ThrActionObj.validateRole(user_id,user_email,user_password);
			if(rs!=null) {
				while(rs.next()) {
					setIsAdminRole(rs.getString("user_role"));
				}
			}
			if(isAdminRole.equalsIgnoreCase("admin")) {
				/**
				 * allows submittype to have admin and sp functions
				 */
				switch(submitType) {
				case "viewAll"://TODO
					rs = ThrActionObj.viewThrListing();
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							// add total number of messages to display
							thread.setUser_id(rs.getInt("user_id"));
							threadDataList.add(thread);
						}
					}
					return "ADMINTHREADLISTING";
				case "viewSingle": //TODO
					rs = ThrActionObj.getThreadById(thr_id);
					while(rs.next()) {
						thread = new Thread();
						thread.setThr_id(rs.getInt("thr_id"));
						thread.setThr_subject(rs.getString("thr_subject"));
						threadDataList.add(thread);
					}
					
					rs = ThrActionObj.getThreadMessagesOfId(thr_id);
					while(rs.next()) {
						threadMessage = new ThreadMessage();
						threadMessage.setThr_msg_id(rs.getInt("thr_msg_id"));
						threadMessage.setThr_msg_text((rs.getString("thr_msg_text")));
						threadMessage.setThr_id(rs.getInt("thr_id"));
						threadMessage.setUser_id(rs.getInt("user_id"));
						threadMessageList.add(threadMessage);
					}
					return "VIEWSINGLETHREADADMIN";
					
				case "editListing"://TODO
					setRs(ThrActionObj.getThreadById(thr_id));
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							threadDataList.add(thread);
						}
					}
					rs = ThrActionObj.getThreadMessagesOfId(thr_id);
					while(rs.next()) {
						threadMessage = new ThreadMessage();
						threadMessage.setThr_msg_id(rs.getInt("thr_msg_id"));
						threadMessage.setThr_msg_text((rs.getString("thr_msg_text")));
						threadMessage.setThr_id(rs.getInt("thr_id"));
						threadMessage.setUser_id(rs.getInt("user_id"));
						threadMessageList.add(threadMessage);
					}
					return "UPDATETHREADFORM";
				case "postNewThread"://TODO
					rslt = ThrActionObj.postNewThr(thr_subject,user_id);
					rs = ThrActionObj.viewThrListing();
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							// add total number of messages to display
							thread.setUser_id(rs.getInt("user_id"));
							threadDataList.add(thread);
						}
					}
					return "ADMINTHREADLISTING";
					
					
					
					
					
				case "postThreadMessage"://TODO
					rslt = ThrActionObj.postNewThrMessage(thr_id,thr_msg_text,user_id);
					setRs(ThrActionObj.getThreadById(thr_id));
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							threadDataList.add(thread);
						}
					}
					rs = ThrActionObj.getThreadMessagesOfId(thr_id);
					while(rs.next()) {
						threadMessage = new ThreadMessage();
						threadMessage.setThr_msg_id(rs.getInt("thr_msg_id"));
						threadMessage.setThr_msg_text((rs.getString("thr_msg_text")));
						threadMessage.setThr_id(rs.getInt("thr_id"));
						threadMessage.setUser_id(rs.getInt("user_id"));
						threadMessageList.add(threadMessage);
					}
					return "VIEWSINGLETHREADADMIN";
					
					
					
					
				case "updateListing": //TODO
					rslt = ThrActionObj.updateThrListing(thr_subject,thr_id);
					setRs(ThrActionObj.getThreadById(thr_id));
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							threadDataList.add(thread);
						}
					}
					setError_msg("Thread subject is updated.");
					return "ADMINTHREADLISTING";
					
					
					
					
				case "deleteThread"://TODO
					rslt = ThrActionObj.deleteThrListing(thr_id);
					rs = ThrActionObj.viewThrListing();
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							// add total number of messages to display
							thread.setUser_id(rs.getInt("user_id"));
							threadDataList.add(thread);
						}
					}
					return "ADMINTHREADLISTING";
					
					
					
					
				case "removeThreadMessage": //TODO
					setRslt(ThrActionObj.deleteThrMessageById(thr_msg_id));
					setRs(ThrActionObj.getThreadById(thr_id));
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							threadDataList.add(thread);
						}
					}
					rs = ThrActionObj.getThreadMessagesOfId(thr_id);
					while(rs.next()) {
						threadMessage = new ThreadMessage();
						threadMessage.setThr_msg_id(rs.getInt("thr_msg_id"));
						threadMessage.setThr_msg_text((rs.getString("thr_msg_text")));
						threadMessage.setThr_id(rs.getInt("thr_id"));
						threadMessage.setUser_id(rs.getInt("user_id"));
						threadMessageList.add(threadMessage);
					}
					return "VIEWSINGLETHREADADMIN";
					
					
				default:
					setError_msg("admin submit type error.");
					return "404";
				}
			
			}else if(isAdminRole.equalsIgnoreCase("sp")) {
				/**
				 * allows submittype to have sp functions only
				 */
				switch(submitType) {
				case "viewAll":
					rs = ThrActionObj.viewThrListing();
					if(rs!=null) {
						while(rs.next()) {
							thread = new Thread();
							thread.setThr_id(rs.getInt("thr_id"));
							thread.setThr_subject(rs.getString("thr_subject"));
							// add total number of messages to display
							thread.setUser_id(rs.getInt("user_id"));
							threadDataList.add(thread);
						}
					}
					return "NORMALTHREADLISTING";
					
				case "viewSingle":
					rs = ThrActionObj.getThreadById(thr_id);
					while(rs.next()) {
						thread = new Thread();
						thread.setThr_id(rs.getInt("thr_id"));
						thread.setThr_subject(rs.getString("thr_subject"));
						threadDataList.add(thread);
					}
					rs = ThrActionObj.getThreadMessagesOfId(thr_id);
					while(rs.next()) {
						threadMessage = new ThreadMessage();
						threadMessage.setThr_msg_id(rs.getInt("thr_msg_id"));
						threadMessage.setThr_msg_text((rs.getString("thr_msg_text")));
						threadMessage.setThr_id(rs.getInt("thr_id"));
						threadMessage.setUser_id(rs.getInt("user_id"));
						threadMessageList.add(threadMessage);
					}
					return "NORMALSINGLETHREAD";
				case "postNewThread":
					rslt = ThrActionObj.postNewThr(thr_subject,user_id);
					rs = ThrActionObj.getThreadById(thr_id);
					while(rs.next()) {
						thread = new Thread();
						thread.setThr_id(rs.getInt("thr_id"));
						thread.setThr_subject(rs.getString("thr_subject"));
						threadDataList.add(thread);
					}
					return "NORMALTHREADLISTING";
				case "postThreadMessage":
					rslt = ThrActionObj.postNewThrMessage(thr_id,thr_msg_text,user_id);
					rs = ThrActionObj.getThreadById(thr_id);
					while(rs.next()) {
						thread = new Thread();
						thread.setThr_id(rs.getInt("thr_id"));
						thread.setThr_subject(rs.getString("thr_subject"));
						threadDataList.add(thread);
					}
					rs = ThrActionObj.getThreadMessagesOfId(thr_id);
					while(rs.next()) {
						threadMessage = new ThreadMessage();
						threadMessage.setThr_msg_id(rs.getInt("thr_msg_id"));
						threadMessage.setThr_msg_text((rs.getString("thr_msg_text")));
						threadMessage.setThr_id(rs.getInt("thr_id"));
						threadMessage.setUser_id(rs.getInt("user_id"));
						threadMessageList.add(threadMessage);
					}
					return "NORMALSINGLETHREAD";
				default:
					setError_msg("SP submit type error.");
					return "404";
				}
			}else {
				/**
				 * invalid user_role, proceed to error page.
				 */
				setError_msg("Invalid User Role.");
				return "404";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			setError_msg("Backend error, please contact the system admin.");
			return "404";
		}
	}
	@Override
	public void setSession(Map<String, Object> session) {
		userSession = session;
	}
	
	
}
