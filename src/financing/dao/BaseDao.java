package financing.dao;
import java.sql.*;
public class BaseDao {
	public Connection getCon(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "CPE1704tks");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void closeAll(Connection con,Statement stmt,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(con != null && !con.isClosed()){
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
