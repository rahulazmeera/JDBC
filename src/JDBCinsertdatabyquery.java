import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCinsertdatabyquery {

	public static void main(String[] args) throws SQLException {
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
			//Inserting New Employees 
			System.out.println("inserting new employee details");
			//before inserting number of employees
			Myres=myStm.executeQuery("select * from employees");
			//process the result set
			while(Myres.next()){
				System.out.println(Myres.getString("last_name")+","+Myres.getString("first_name"));
				
			}
		
			
			int rowsAffected=myStm.executeUpdate("insert into employees "+ "(last_name,first_name,email, department, salary)" + "values" + "('king', 'Rahul','rahul@gmail.com', 'HR', 44400.00)");
			System.out.print("Updated");
			
			Myres = myStm.executeQuery("select * from employees order by last_name");
			System.out.print("sucessfully selected ");
			
			//process the results 
			while(Myres.next()){
				System.out.println(Myres.getString("last_name")+","+Myres.getString("first_name"));
			}
			

		}catch (Exception e){
			e.printStackTrace();
			
		}
		finally{
			if(Myres!=null){
				Myres.close();
			}
		}
		
		
		
		

	}

}
