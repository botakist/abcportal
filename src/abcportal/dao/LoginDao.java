package abcportal.dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * <p>This class starts the MySQL connection to the database.</p>
 * @author admin
 *
 */
public class LoginDao{
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
	// LOGIN METHOD
	/**
	 * <p> this class executes the sql statement for login verification.</p>
	 * @param email
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet loginUser(String email,String password) throws SQLException, Exception{
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE user_email=? AND user_password=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
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