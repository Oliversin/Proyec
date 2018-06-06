package com.uabcs.obeltran.db;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.uabcs.obeltran.db.Config.*;

public class DBConnection {
	
	private Connection connection;
	
	public Connection getConnection(){
		this.connection=null;
		try {
			Class.forName(DRIVER);
			this.connection= DriverManager.getConnection(URL+DATABASE, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return this.connection;
		}
		
	}
}
