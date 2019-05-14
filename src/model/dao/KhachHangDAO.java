/*
* @Author HCD-Fresher183
* @Date Feb 25, 2019
*/

package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connDB.DB;
import model.bean.KhachHang;

public class KhachHangDAO {
	Connection connection;
	Statement stmt = null;
	public ArrayList<KhachHang> getListKhachHang() throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql=	"select iDKhach, hoTen, userName, soTienTrongTK from KHACHHANG";
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		
		while(rs.next()) {
			KhachHang khachHang = new  KhachHang();
			khachHang.setIdKhach(rs.getString("iDKhach"));
			khachHang.setHoTen(rs.getString("hoTen"));
			khachHang.setUserName(rs.getString("userName"));
			khachHang.setTaiKhoan(rs.getFloat("soTienTrongTK"));
			list.add(khachHang);
		}
		
		return list;
	}
	public void themKhachHang(String iDKhach, String hoTen, String userName, String password, String soTienTrongTK) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("Insert into KHACHHANG values (N'%s',N'%s',N'%s',N'%s',N'%s')", iDKhach, hoTen, userName, password, soTienTrongTK);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public KhachHang getThongTinKhachHang(String iDKhach)  throws ClassNotFoundException, SQLException{
		connection = DB.getSQLServerConnection_JTDS();
		String sql=	String.format("SELECT iDKhach, hoTen, userName, password, soTienTrongTK "+
				" FROM KHACHHANG WHERE iDKhach = '%s'", iDKhach);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		KhachHang khachHang = new KhachHang();
		try {
			while(rs.next()){
				khachHang.setIdKhach(rs.getString("iDKhach"));
				khachHang.setHoTen(rs.getString("hoTen"));
				khachHang.setUserName(rs.getString("userName"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setTaiKhoan(rs.getFloat("soTienTrongTK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		khachHang.getHoTen();
		return khachHang;
	}
	public void napTien(String iDKhach, String hoTen, String userName, String password, float soTienTrongTK) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("Update KHACHHANG set hoTen = N'%s', userName = N'%s', password = N'%s', soTienTrongTK = N'%s' "
				+ "Where iDKhach = N'%s' ", hoTen, userName, password, soTienTrongTK, iDKhach);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void suaThongTinKhachHang(String iDKhach, String hoTen, String userName, String password, String soTienTrongTK) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("Update KHACHHANG set hoTen = N'%s', userName = N'%s', password = N'%s', soTienTrongTK = N'%s' "
				+ "Where iDKhach = N'%s' ", hoTen, userName, password, soTienTrongTK, iDKhach);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void xoaKhachHang(String iDKhach) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql=	String.format("DELETE FROM KHACHHANG WHERE iDKhach = '%s'", iDKhach);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean checkLogin(String tenDangNhap, String matKhau) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("SELECT userName FROM KHACHHANG WHERE userName = '%s' AND password = '%s'",
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
	public KhachHang getThongTinKhachHangByAcc(String tenKhach)  throws ClassNotFoundException, SQLException{
		connection = DB.getSQLServerConnection_JTDS();
		String sql=	String.format("SELECT iDKhach, hoTen, userName, password, soTienTrongTK "+
				" FROM KHACHHANG WHERE userName = '%s'", tenKhach);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		KhachHang khachHang = new KhachHang();
		try {
			while(rs.next()){
				khachHang.setIdKhach(rs.getString("iDKhach"));
				khachHang.setHoTen(rs.getString("hoTen"));
				khachHang.setUserName(rs.getString("userName"));
				khachHang.setPassword(rs.getString("password"));
				khachHang.setTaiKhoan(rs.getFloat("soTienTrongTK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return khachHang;
	}
	public void dongPhienSD(String tenKhach, float soDu) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = String.format("Update KHACHHANG set  soTienTrongTK = N'%s' "
				+ "Where userName = N'%s' ", soDu, tenKhach);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
