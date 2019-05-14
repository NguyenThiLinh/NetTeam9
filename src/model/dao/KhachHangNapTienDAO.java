package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import connDB.DB;

public class KhachHangNapTienDAO {

	public void napTien(String userName, String napThem, String ngayNap) throws ClassNotFoundException, SQLException {
		Connection connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("Insert into KHNAPTIEN values (N'%s',N'%s',N'%s')", userName, napThem, ngayNap);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public float getToTal(String tuNgay, String denNgay) throws ClassNotFoundException, SQLException {
		Connection connection = DB.getSQLServerConnection_JTDS();
		String sql = "SELECT total = Sum(soTien) FROM KHNAPTIEN WHERE ngayNap BETWEEN '"+tuNgay+"' and '"+denNgay+"'";
		ResultSet rs = null;
		float total=0;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				total += rs.getFloat("total");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return total;
	}

}
