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
public class SearchDao {
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
	 * <p>This class executes the sql statement for the search function. </p>
	 * @param search_query
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ResultSet searchUser(String search_query) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM user WHERE user_firstname=? OR user_lastname=? OR user_email=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, search_query);
			ps.setString(2, search_query);
			ps.setString(3, search_query);
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
