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
public class PostJobDao {
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

	public ResultSet isAdminRole(String admin_email, String admin_password, int admin_id) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE user_email=? AND user_password=? AND user_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, admin_email);
			ps.setString(2, admin_password);
			ps.setInt(3, admin_id);
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

	public int postJobListing(String job_title, String job_scope, String job_salary, String job_availability, int admin_id) throws SQLException,Exception {
		int rslt = 0;
		try {
			String sql = "INSERT INTO `job`(`job_id`, `job_title`, `job_scope`, `job_salary`, `job_availability`, `user_id`)"
					+ " VALUES (NULL,?,?,?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, job_title);
			ps.setString(2, job_scope);
			ps.setString(3, job_salary);
			ps.setString(4, job_availability);
			ps.setInt(5, admin_id);
			rslt = ps.executeUpdate();
			return rslt;
		}catch(Exception e) {
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
