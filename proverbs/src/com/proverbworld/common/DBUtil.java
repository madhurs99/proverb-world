/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proverbworld.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Provides database operations to add, delete and fetch records from database.
 * 
 */
public class DBUtil {
	private static Logger log = Logger.getLogger(DBUtil.class);
	private static DBUtil dbuUtil = new DBUtil();
	Connection connection = null;
	Properties props = new Properties();

	private DBUtil() {
		try {
			InputStream inputStream = DBUtil.class.getClassLoader()
					.getResourceAsStream("database.properties");
			props.load(inputStream);
			Class.forName(props.getProperty("driver"));
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

	}

	public static DBUtil getInstance(){
		if(dbuUtil ==null){
			synchronized (dbuUtil) {
				dbuUtil = new DBUtil();
			}
		}
		return dbuUtil;
	}	/**
	 * Method that obtains a connection for the given mysql driver
	 * 
	 * @returns a Connection object
	 */
	public Connection getConnection() throws Exception {
		if (connection == null || connection.isClosed()) {
			try {
				connection = DriverManager.getConnection(props
						.getProperty("sqlurl"), props.getProperty("username"),
						props.getProperty("password"));
			} catch (SQLException ex) {
				log.error(ex.getMessage(), ex);
				throw new Exception(
						"Exception occured whie connecting to database.");
			}
		}
		return connection;
	}

	/**
	 * Method that creates a statement for a given connection
	 * 
	 * @param connection
	 * @return a statement object for the given connection
	 */

	public  Statement getStatement(Connection connection) {
		Statement statement = null;
		try {
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
		}

		return statement;
	}

	public  void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);

		}

	}

	public  void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

	}
	public void finalize(){
		closeConnection();
	}

}
