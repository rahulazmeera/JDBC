import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection mycon=null;
		Statement myStm=null;
		ResultSet res=null;
		try{
			//get connection to the data base 
			mycon= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student", "student");
			System.out.println("connection is sucessful\n");
			//create a statement
			myStm=mycon.createStatement();
			//execute SQL query
			res=myStm.executeQuery("select * from employees");
			//process the result set
			while(res.next()){
				System.out.println(res.getString("last_name")+","+res.getString("first_name"));
			}
		}catch (Exception exc){
			exc.printStackTrace();
		}
		
	}

}
