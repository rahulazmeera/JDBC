import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStatements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection mycon=null;
		PreparedStatement myStm=null;
		ResultSet res=null;
		
		try{
			
			//get connection to the data base 
			mycon= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student", "student");
			
			System.out.println("connection is sucessful\n");
			
			//create a statement
			myStm=mycon.prepareStatement("select * from employees where salary>? and department=?");
			
			myStm.setDouble(1, 80000);
			myStm.setString(2, "legal");
			
			res=myStm.executeQuery();
			
			
			display(res);
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void display(ResultSet res) {
		// TODO Auto-generated method stub
		
	}

}
