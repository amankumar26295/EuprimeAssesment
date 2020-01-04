package nit.mca5.util;

import java.sql.SQLException;
import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DBds {
	
	private final static  String DRIVER_CLASS="oracle.jdbc.driver.OracleDriver"; 
	private final static  String USER="system"; 
	private final static  String PASSWORD="root"; 
	
	public static DataSource getOracleDataSource(){
		
		OracleDataSource oracleDS = null;
		try {
			oracleDS = new OracleDataSource();
			oracleDS.setURL(DRIVER_CLASS);
			oracleDS.setUser(USER);
			oracleDS.setPassword(PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}
		
}