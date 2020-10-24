package com.pmt.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pmt.util.DatabaseCommon;




public class DatabaseConnection {
	public static String DB_IP="192.168.1.50";
	Connection conn = null;
	public DatabaseConnection()
	{
	
	}
	
	public Connection getConnection() { 	
		 try {
//			 File file = new File("C:\\PMT\\ipconfig.txt"); 
//			  BufferedReader br = new BufferedReader(new FileReader(file)); 
//			  String st; 
			  System.out.println(InetAddress.getLocalHost().getHostAddress());
//			  while ((st = br.readLine()) != null) 
//			  {
//				  DB_IP=st.trim();
//			  } 
			  System.out.println(InetAddress.getLocalHost().getHostName());;
			   DB_IP = InetAddress.getLocalHost().getHostAddress().trim();
			   String DB_URL = "jdbc:sqlserver://"+DB_IP+"\\SQLEXPRESS:"+DatabaseCommon.DB_PORT+";databaseName="+DatabaseCommon.DB_NAME+"";
	            Class.forName(DatabaseCommon.DRIVERSQLSERVER).newInstance();
	            System.out.println(DB_URL + "  " +  DatabaseCommon.DB_USER  + "  " +  DatabaseCommon.DB_PASS );
	            conn = DriverManager.getConnection(DB_URL, DatabaseCommon.DB_USER, DatabaseCommon.DB_PASS);
	            if(conn!=null){
	            	System.out.println("Ket Noi Thanh Cong!!");
	            }
	            else{
	            	System.out.println("Ket Noi That Bai!!");
	            }     
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 return conn;
	}
	
	public boolean closeConnection() {
		
		try {
			this.conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}

}
