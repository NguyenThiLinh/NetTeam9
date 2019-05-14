/*
* @Author HCD-Fresher183
* @Date Mar 1, 2019
*/

package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connDB.DB;
import model.bean.KhachHang;
import model.bean.May;

import model.bo.MayBO;

public class MayDAO {
	Connection connection;
	Statement stmt;
	public void dongPhienSD(String maMay, float soGio) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("UPDATE MAY  SET  soGioSuDung = N'%s' WHERE iDMay = N'%s'", soGio, maMay);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public May getSoGioSuDungMay(String maMay) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql=	String.format("SELECT soGioSuDung FROM MAY WHERE iDMay = '%s'", maMay);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		May may = new May();
		try {
			while(rs.next()){
				may.setSoGioSuDung(rs.getFloat("soGioSuDung"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return may;
	}
	public ArrayList<May> getListMay() throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql=	"select iDMay from May";
	ResultSet rs = null;
	try {
		Statement stmt = connection.createStatement();
		rs = stmt.executeQuery(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ArrayList<May> listMay = new ArrayList<May>();
	May may;
	try {
		while(rs.next()){
			may = new May();
			may.setiDMay(rs.getString("iDMay"));			
			listMay.add(may);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return listMay;
	
	}
}


