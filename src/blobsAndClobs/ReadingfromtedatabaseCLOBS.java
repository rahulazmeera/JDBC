package blobsAndClobs;

import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.Reader;
import java.nio.CharBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class ReadingfromtedatabaseCLOBS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection mycon=null;
		java.sql.Statement mystm=null;
		ResultSet res=null;
		
		Reader input=null;
		FileWriter output=null;
		
		try{
			//1. get connection 
			mycon=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=False", "student", "student");
			
			mystm=mycon.createStatement();
			String sql="select file from employees where email='john.doe@foo.com'";
		    res=mystm.executeQuery(sql);
			
			//2. establish the file output stream
			File thefile=new File("king.txt");
			output=new FileWriter(thefile);
			
			if(res.next()){
				input=res.getCharacterStream("file");
				
				int thechar;
				while((thechar=input.read())>0){
					output.write(thechar);
					
				}
				System.out.println(thefile.getAbsolutePath());
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
}
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
