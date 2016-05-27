package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.AbstractEntity;

public class MysqlAdapter extends AbstractAdapter {
	String dsn = "jdbc:mysql//37.120.191.124:22436/black";
	String user = "";
	String pass = "";
	
	Connection connection = null;
	
	public MysqlAdapter() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find driver", e);
		}
		
		try {
			connection = DriverManager.getConnection(dsn, user, pass);
			
			if(connection.isClosed()) {
				throw new Exception("Couldn't connect to database");
			}
		}
		catch (Exception e) {
			throw new Exception("Fail to connecto to mysql");
		}
	}
	
	public ResultSet query(String sql) throws Exception {
		try {
			Statement stmt = connection.createStatement();
			return stmt.executeQuery(sql);
		}
		catch (SQLException e) {
			throw new Exception("Mysql error: "+e.getMessage());
		}
	}
	
	/*
	 * TODO for abstraction of adapter
	public String[] fetchAll(String table) {
		// create query
		String sql = "SELECT * from "+table;
		
		try {
			// get data
			ResultSet rs = this.query(sql);
		
			// build array
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] data = new String[rsmd.getColumnCount()];
			for(int i = 0; i <= rsmd.getColumnCount(); i++) {
				data[i] = rsmd.getColumnName(i);
			}
		
			int count = 0;
			while(rs.next()) {
				rs.
				
				
				count++;
			}
		}
		catch (Exception e) {}
	}
	*/
}
