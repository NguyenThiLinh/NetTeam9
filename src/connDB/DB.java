/*
* @Author HCD-Fresher183
* @Date Feb 12, 2019
*/

package connDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	public static Connection getSQLServerConnection_JTDS() //
			throws SQLException, ClassNotFoundException {

		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "QlQuanNet_Team09";
		String userName = "sa";
		String password = "Vbdhmtk52`";

		return getSQLServerConnection_JTDS(hostName, sqlInstanceName, database, userName, password);
	}

	private static Connection getSQLServerConnection_JTDS(String hostName, //
			String sqlInstanceName, String database, String userName, String password) throws SQLException {

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			System.out.println("Ket noi thanh cong");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}

		String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" //
				+ database + ";instance=" + sqlInstanceName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

}