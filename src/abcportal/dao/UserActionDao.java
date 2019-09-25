package abcportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserActionDao {
	
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
	
	public String validateUserRole(String user_email, String user_password) throws SQLException, Exception {
		ResultSet rs = null;
		String user_role = null;
		try {
			String sql = "SELECT * FROM user WHERE user_email=? AND user_password=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user_email);
			ps.setString(2, user_password);
			rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					user_role = rs.getString("user_role");
					System.out.println("role of this user is: "+user_role);
				}
			}
			return user_role;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ResultSet findAll() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("find all error");
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public ResultSet findById(int profile_id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE user_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, profile_id);
			rs = ps.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("find by id error.");
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

	public int deleteUserById(int profile_id) throws SQLException, Exception {
		int rslt = 0;
		try {
			String sql = "DELETE FROM user WHERE user_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, profile_id);
			rslt = ps.executeUpdate();
			return rslt;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("delete by id error.");
			return rslt;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
}
