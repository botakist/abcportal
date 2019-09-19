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
public class DeleteJobDao {
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

	public ResultSet validateRole(String admin_email, String admin_password, int admin_id) throws SQLException, Exception{
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE user_email=? AND user_password=? AND user_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, admin_email);
			ps.setString(2, admin_password);
			ps.setInt(3, admin_id);
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

	public int deleteJob(int job_id) throws SQLException, Exception{
		int rslt = 0;
		try {
			String sql = "DELETE FROM job WHERE job_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, job_id);
			System.out.println(ps);
			rslt = ps.executeUpdate();
			return rslt;
		}
		catch (Exception e) {
			e.printStackTrace();
			return rslt;
		}
		finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

}
