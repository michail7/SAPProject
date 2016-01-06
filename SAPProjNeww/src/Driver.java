import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			Statement myStmt = myConn.createStatement();
			
			String sql = "insert into users" 
						+ "(id, username, password, role)" 
						+ "values ('1', 'admin', 'admin123', 'administrator')";
			
			myStmt.executeUpdate(sql);
			
			System.out.println("End");
			
//			ResultSet myRs = myStmt.executeQuery("select * from users");
//			
//			while(myRs.next()){
//				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
