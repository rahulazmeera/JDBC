package blobsAndClobs;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Handlingblobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection mycon=null;
		PreparedStatement mystm=null;
		FileInputStream input=null;
		
		try{
			// to establish the connection 
			mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student", "student");
			
			
			//creating sql query prepared statement
			String sql="update employees set resume=? where email='john.doe@foo.com'";
			mystm=mycon.prepareStatement(sql);
			
			//now give the input file for the resume 
	      File thefile=new File("C:\\Users\\azmeera rahul\\Desktop\\RahulPIC.jpg");
			input=new FileInputStream(thefile);
			mystm.setBinaryStream(1, input);
			
			//execute the above query
			mystm.executeUpdate();
			
		System.out.println("Uploaded sucessfully");	
		}catch (Exception e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
