import java.sql.*;
public class databasechk {
  
	//static final  String jdbc_driver="com.mysql.jdbc.Driver";
	//  static final String db_url="jdbc:mysql://localhost:3306/kirusa";
	  
	// final static  String user="root";
	//static final  String pass="root";
	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kirusa","root","root");
			
			stmt = conn.createStatement();
			
		//	String sql = "create table sample (a int(3) )";
			
			// stmt.executeUpdate(sql);
			
			 String sql1= "select username,password from register ";
			 
			 ResultSet rs = stmt.executeQuery(sql1);
			while(rs.next())
			{
				String username=rs.getString("username");
				String password=rs.getString("password");
				
				
				System.out.print("username "+username);
				System.out.print(", password "+password);
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally { }
		
		
		
	}

}
