package abcportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * <p>This classes initialises the connection to the MySQL Database.</p>
 * @author admin
 *
 */
public class RegisterDao {
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
	 * <p>This class executes the sql statement to insert a new user profile into the user table.</p>
	 * @param user_firstname
	 * @param user_lastname
	 * @param user_email
	 * @param user_password
	 * @param user_birthday
	 * @param user_gender
	 * @param user_country
	 * @param user_role
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public int registerUser(String user_firstname,String user_lastname,String user_email,String user_password,String user_birthday,String user_gender,String user_country,String user_role) throws SQLException, Exception{
//		ResultSet rs = null;
		int rslt = 0;
		try {
			String sql = "INSERT INTO `user` (`user_id`, `user_firstname`, `user_lastname`, `user_email`, `user_password`,`user_birthday`, `user_gender`, `user_country`, `user_picture`, `user_resume`, `user_role`) VALUES(NULL, ?,?,?,?,?,?,?,NULL,NULL,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user_firstname);
			ps.setString(2, user_lastname);
			ps.setString(3, user_email);
			ps.setString(4, user_password);
			ps.setString(5, user_birthday);
			ps.setString(6, user_gender);
			ps.setString(7, user_country);
			ps.setString(8, user_role);
//			rs = ps.executeQuery();
			rslt = ps.executeUpdate();
			return rslt;
		}catch(Exception e){
			e.printStackTrace();
			return rslt;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
		
	}
	//BACKEND METHOD TO CHECK EXISTING EMAIL BEFORE REGISTRATION
	public ResultSet isEmailExisting(String user_email) throws Exception {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		try {
			String sql = "SELECT user_email FROM user WHERE user_email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user_email);
			rs = ps.executeQuery();
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return rs;
		}finally {
			if(getConnection() != null) {
				getConnection().close();
			}
		}
	}

}
