package abcportal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * <p>This class starts the connection to the MySQL database.</p>
 * @author admin
 *
 */
public class ViewDao {
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
 * <p>This class executes the sql statement where the user is able to view their profile.</p>
 * @param user_email
 * @param user_password
 * @return
 * @throws SQLException
 * @throws Exception
 */
	public ResultSet viewProfile(String user_email, String user_password) throws SQLException, Exception{
		ResultSet rs = null;
		System.out.println(user_email + " is the email account being processed");
		System.out.println(user_password + " is the password of the account being processed");
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

	
}
