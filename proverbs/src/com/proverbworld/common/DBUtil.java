/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proverbworld.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;



/**
 * Provides database operations to add, delete and fetch records from database.
 * @author archana_panchamukhi
 */
public class DBUtil {
	private static Logger log = Logger.getLogger(DBUtil.class);
	/**
	 * Method that obtains a connection for the given mysql driver
	 * @returns a Connection object
	 */
	public static Connection getConnection() throws Exception {
		Connection connection = null;
		Properties props = new Properties();

		try {
			InputStream inputStream = DBUtil.class.getClassLoader()
					.getResourceAsStream("database.properties");
			props.load(inputStream);
			Class.forName(props.getProperty("driver"));
			connection = DriverManager.getConnection(props
					.getProperty("sqlurl"), props.getProperty("username"),
					props.getProperty("password"));
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new Exception(
					"Exception occured whie connecting to database.");
		} catch (ClassNotFoundException ex) {
			log.error(ex.getMessage(), ex);
			throw new Exception("Databse Driver not Found");
		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
			throw new Exception(
					"Unable to connect to database due to network problem");
		}

		return connection;
	}

	/**
	 * Method that creates a statement for a given connection
	 * @param connection
	 * @return a statement object for the given connection
	 */

	public static Statement getStatement(Connection connection) {
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

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);

		}

	}

	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

	}

}
