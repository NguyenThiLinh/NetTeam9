/*
* @Author HCD-Fresher183
* @Date Feb 28, 2019
*/

package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import connDB.DB;

public class SuDungMayDAO {
	Connection connection;
	Statement stmt;
	public void themPhienSuDung(String maMay, String tenKhach, Date gioBD) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("Insert into SDMAY (iDMay, userName, gioBatDau) values (N'%s',N'%s',N'%s')", maMay, tenKhach, gioBD);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void dongPhienSD(String tenKhach, Date gioBD, Date gioKT, float h) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("UPDATE SDMAY  SET  gioKetThuc = N'%s', soGio = N'%s' WHERE userName = N'%s' and  gioBatDau = N'%s'",
				gioKT, h, tenKhach, gioBD);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	}


