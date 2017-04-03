package blobsAndClobs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadingBlobsFromDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection mycon=null;
		Statement mystm=null;
		ResultSet myrs=null;
		
		InputStream input=null;
		FileOutputStream output=null;
		
		try{
			
			//establishing the connecton hear
			mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "student", "student");
			//query executing  the statement 
			mystm=mycon.createStatement();
			String sql="select resume from employees where email='john.doe@foo.com'";
			myrs=mystm.executeQuery(sql);
			//set up a handle to the file
			File thefile=new File("kinfromDB.jpg");
			output=new FileOutputStream(thefile);
			if(myrs.next()){
				
				
				input=myrs.getBinaryStream("resume");
				byte[] buffer=new byte[1024];
				while(input.read(buffer)>0){
					output.write(buffer);
				}
				System.out.println(thefile.getAbsolutePath());
				System.out.println("Sucessfull downloaded");
			}
			
		}catch(Exception ecx){
			
			ecx.printStackTrace();
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
