package abcportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author admin
 *
 */
public class JobActionsDao {
	public static Connection getConnection() throws Exception {
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
	 * View the job listing page
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet viewJob() throws SQLException, Exception{
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM job";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
		}
/**
 * Views the in depth details of this a particular job posting.
 * @param singleJobId
 * @return
 * @throws SQLException
 * @throws Exception
 */
	public ResultSet viewSingleJob(int singleJobId) throws SQLException, Exception{
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			System.out.println(singleJobId + " is the id number being run in the SQL statement.");
			String sql = "SELECT * FROM `job` WHERE job_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			System.out.println(sql);
			
			ps.setInt(1, singleJobId);
			System.out.println(ps);
			rs = ps.executeQuery();
			return rs;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	public ResultSet viewAdminJobPosting(int adminId) throws SQLException, Exception{
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			System.out.println(adminId + " is the id number being run in the SQL statement.");
			String sql = "SELECT * FROM `job` WHERE user_id=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			System.out.println(sql);
			
			ps.setInt(1, adminId);
			System.out.println(ps);
			rs = ps.executeQuery();
			return rs;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
	}

