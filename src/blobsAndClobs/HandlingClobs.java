package blobsAndClobs;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class HandlingClobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Connection mycon=null;
	PreparedStatement mystm=null;
	
	FileReader input=null;
	
	try{
		// 1. get connection to the database 
		mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student", "student");
		//2. prepared statement for the execution 
		String sql="update employees set file=? where email='john.doe@foo.com'";
		mystm=mycon.prepareStatement(sql);
		
		//give the location the input file
		File thefile=new File("C:\\Users\\azmeera rahul\\Desktop\\apppium text.txt");
        input=new FileReader(thefile);
        mystm.setCharacterStream(1, input);
        //execute the statement
        mystm.executeUpdate();
       System.out.println("sucessfully updated");
	}catch (Exception e){
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
