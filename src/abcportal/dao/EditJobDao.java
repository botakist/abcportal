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
public class EditJobDao {
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
/**
 * 
 * @param job_id
 * @param job_title
 * @param job_scope
 * @param job_salary
 * @param job_availability
 * @return
 * @throws SQLException
 * @throws Exception
 */
	public int updateJobPosting(int job_id,String job_title,String job_scope,String job_salary,String job_availability) throws SQLException, Exception {
		// TODO Auto-generated method stub
		getConnection().setAutoCommit(false);
		System.out.println(job_title);
		System.out.println(job_scope);
		System.out.println(job_salary);
		System.out.println(job_availability);
		System.out.println(job_id);
		int i = 0;
		try {
			String sql = "UPDATE job set job_title=?,job_scope=?,job_salary=?,job_availability=? WHERE job_id =?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, job_title);
			ps.setString(2, job_scope);
			ps.setString(3, job_salary);
			ps.setString(4, job_availability);
			ps.setInt(5, job_id);
			i = ps.executeUpdate();
			return i;
		}catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}
/**
 * 
 * @param job_id
 * @return
 */
	public ResultSet retrieveJobPosting(int job_id) throws SQLException, Exception{
		// TODO Auto-generated method stub
		ResultSet rs = null;
		System.out.println("retrieve job posting for job id "+job_id);
		try {
			String sql = "SELECT * FROM job WHERE job_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, job_id);
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
public ResultSet backToListing() throws SQLException, Exception{
	// TODO Auto-generated method stub
	ResultSet rs = null;
	try {
		String sql = "SELECT * FROM job";
		PreparedStatement ps = getConnection().prepareStatement(sql);
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

}
