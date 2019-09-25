/**
 * 
 */
package abcportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author admin
 *
 */
public class ThreadsActionDao {
	private static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/portal?useUnicode=true&useJDBCCompliantTimezone"
		            + "Shift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet validateRole(int user_id, String user_email, String user_password) throws SQLException,Exception {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE user_id=? AND user_email=? AND user_password=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setString(2, user_email);
			ps.setString(3, user_password);
			rs = ps.executeQuery();
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ResultSet viewThrListing() throws SQLException, Exception{
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM thread";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int postNewThr(String thread_subject, int user_id) throws SQLException, Exception{
		int rslt = 0;
		try {
			String sql = "INSERT INTO `thread`(`thr_id`, `thr_subject`, `user_id`)"
					+ " VALUES (NULL,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, thread_subject);
			ps.setInt(2, user_id);
			rslt = ps.executeUpdate();
			return rslt;
		}catch(Exception e) {
			e.printStackTrace();
			return rslt;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int updateThrListing(String thread_subject,int thread_id) throws SQLException, Exception {
		int rslt = 0;
		try {
			String sql = "UPDATE portal.thread SET thr_subject=? WHERE thr_id =?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, thread_subject);
			ps.setInt(2, thread_id);
			rslt = ps.executeUpdate();
			return rslt;
		}catch(Exception e) {
			e.printStackTrace();
			return rslt;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int deleteThrListing(int thread_id) throws SQLException, Exception {
		int rslt = 0;
		try {
			String sql = "DELETE FROM `thread` WHERE thr_id=? ";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, thread_id);
			rslt = ps.executeUpdate();
			return rslt;
		}catch(Exception e) {
			e.printStackTrace();
			return rslt;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ResultSet getThreadById(int thread_id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM `thread` WHERE thr_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, thread_id);
			rs = ps.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ResultSet getThreadMessagesOfId(int thread_id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM portal.threadmessage WHERE thr_id = ?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, thread_id);
			System.out.println(ps);
			rs = ps.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int deleteThrMessageById(int thread_msg_id) throws SQLException, Exception{
		int rslt = 0;
		try {
			String sql = "DELETE FROM `portal`.`threadmessage` WHERE `thr_msg_id`=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, thread_msg_id);
			System.out.println(ps);
			rslt = ps.executeUpdate();
			
			return rslt;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int postNewThrMessage(int thread_id, String thread_message_text, int user_id) throws SQLException, Exception {
		int rslt = 0;
		try {
			String sql = "INSERT INTO `portal`.`threadmessage` (`thr_msg_text`, `thr_id`, `user_id`)"
					+ "VALUES(?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, thread_message_text);
			ps.setInt(2, thread_id);
			ps.setInt(3, user_id);
			System.out.println(ps);
			rslt = ps.executeUpdate();
			return rslt;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
		
	}
	
	
	

}
