package abcportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * <p>Data access object for the edit action class.</p>
 * @author admin
 *
 */
public class EditDao {
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
 * <p>This class executes the sql statement
 * when user wants to view their user profile.</p>
 * @param user_email
 * @param user_password
 * @return
 * @throws SQLException
 * @throws Exception
 */
	public ResultSet fetchProfileDetails(String user_email,String user_password) throws SQLException, Exception {
		// TODO Auto-generated method stub
		ResultSet rs = null;
//		System.out.println(user_email + " passed thru session");
//		System.out.println(user_password +" passed thru session");
		try {
			String sql = "SELECT * FROM user WHERE user_email=? AND user_password=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user_email);
			ps.setString(2, user_password);
			rs = ps.executeQuery();
			return rs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}
/**
 * <p>This class executes the sql statement for updating the user's profile.</p>
 * @param user_firstname
 * @param user_lastname
 * @param user_country
 * @param user_birthday
 * @param user_email
 * @param user_password
 * @return
 * @throws SQLException
 * @throws Exception
 */
	public int updateProfile(String user_firstname, String user_lastname,String user_country,String user_birthday,String user_email,String user_password) throws SQLException, Exception {
		// TODO Auto-generated method stub
		getConnection().setAutoCommit(false);
		System.out.println(user_email + " received to update");
		System.out.println(user_password + " received to update");
		System.out.println(user_firstname + " to be changed on first name of profile");
		System.out.println(user_lastname + " to be changed on last name of profile");
		System.out.println(user_country + " is the updated country");
		System.out.println(user_birthday + " is the updated date");
		int i = 0;
		try {
			String sql = "UPDATE user SET user_firstname=?,user_lastname=?,user_country=?,user_birthday=? WHERE user_email=? AND user_password=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user_firstname);
			ps.setString(2, user_lastname);
			ps.setString(3, user_country);
			ps.setString(4, user_birthday);
			ps.setString(5, user_email);
			ps.setString(6, user_password);
		
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			getConnection().rollback();
			return 0;
		} finally {
			if (getConnection() != null) {
				getConnection().close();
			}
		}
	}

}
