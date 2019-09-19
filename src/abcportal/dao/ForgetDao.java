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
public class ForgetDao {
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
	 * <p>This class returns the result set after executing the sql statement
	 * for verifying the user's email.</p>
	 * @param user_email
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet retrievePwd(String user_email) throws SQLException, Exception{
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE user_email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, user_email);
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
