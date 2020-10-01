package com.pmt.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pmt.util.DatabaseCommon;




public class DatabaseConnectionServer {
	 public  String DB_NAME = "PMT_SEA_SOUTH";
	 public  String DB_IP="45.77.254.67";
	 public  String DB_PORT="1433";
	 public  String DB_URL = "jdbc:sqlserver://"+DB_IP+"\\SQLEXPRESS:"+DB_PORT+";databaseName="+DB_NAME+"";
	 public  String DRIVERSQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 public   String DB_USER = "sa";
	 public   String DB_PASS = "indruino@123";
	Connection conn = null;
	public DatabaseConnectionServer()
	{
		
	}
	
	public Connection getConnection() {
		
		 try {
			  
	            Class.forName(DRIVERSQLSERVER).newInstance();
	            System.out.println(DB_URL + "  " +  DB_USER  + "  " +  DB_PASS );
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
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
