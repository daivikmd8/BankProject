package com.Bank.Connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection requestConnection() {

		 Connection con=null;
		 String url="jdbc:mysql://localhost:3306/bank";
		 String user="root";
		 String password="daivikmd@08";
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(url, user, password);
		 
		 }
		 catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
		 return con;

	}

}
