import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateintoDATAbase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection myCon=null;
		Statement myStm=null;
		ResultSet Myres=null;
		
		String dbUrl="jdbc:mysql://localhost:3306/demo?useSSL=false";
		String user="student";
		String pass="student";
		
		
		try{
			//getting connection esatblished 
			myCon=DriverManager.getConnection(dbUrl, user, pass);
			//creating the statement 
			myStm=myCon.createStatement();
			//Inserting New updated details 
			System.out.println("Before Updating");
			//displayEmployee(myCon,"John","Doe");
	
			System.out.println("Executing the information  Updating");
		   //int rowsAffected=myStm.executeUpdate("update employees" + "set email ='john.doe@luv2code.com' " + " where last_name='Doe' and first_name='John' ");
			
			String sql = "update employees set email='rahulazmeeraing' where id=9";
			
			
			
			int rowsAffected = myStm.executeUpdate(sql);
			
			
			
			
			
		   System.out.println("After  Updating");
		   
		   System.out.println("Rows affected: " + rowsAffected);
			//displayEmployee(myCon,"John","Doe");
			
			
		
		
		}catch (Exception e){
			e.printStackTrace();
		
		
		}
		
		
		
		
	}

	}

	
