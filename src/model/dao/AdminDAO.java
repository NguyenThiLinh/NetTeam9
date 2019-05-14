/*
* @Author HCD-Fresher183
* @Date Feb 26, 2019
*/

package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connDB.DB;

public class AdminDAO {
	Connection connection;
	Statement stmt = null;
	public boolean checkLogin(String tenDangNhap, String matKhau) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("SELECT taiKhoan FROM ADMIN_ WHERE taiKhoan = '%s' AND matKhau = '%s'",
				tenDangNhap, matKhau);
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		
		}

		return false;
	}

}
