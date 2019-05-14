package model.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connDB.DB;
import model.bean.NhanVienBEAN;

public class NhanVienDAO {
	Connection connection;
	Statement stmt = null;
	
	ArrayList<NhanVienBEAN> list = new ArrayList<>();
	
	public ArrayList<NhanVienBEAN> getNV() throws ClassNotFoundException, SQLException{
		connection = DB.getSQLServerConnection_JTDS();
		
		String sql = "select * from NHANVIEN";
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next()) {
			String iDNV = rs.getString("iDNV");
			String hoTen = rs.getString("ten");
			String iDPhong = rs.getString("iDPhong");
			float luong = rs.getFloat("luong");
			String sdt = rs.getString("sdt");
			String diaChi = rs.getString("diaChi");
			String taiKhoan = rs.getString("taiKhoan");
			String matKhau = rs.getString("matKhau");
			
			NhanVienBEAN nhanVienBEAN = new NhanVienBEAN(iDNV, hoTen, iDPhong, luong, sdt, diaChi, taiKhoan, matKhau);
			
			list.add(nhanVienBEAN);
		}
		
		rs.close();
		connection.close();
		
		return list;
	}
	
	// xem thông tin tai khoan
	public NhanVienBEAN xemThongTinTK(String tenDN) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		System.out.println(tenDN);
		String sql = "select * from NHANVIEN where taiKhoan = '"+tenDN+"'";
		
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		NhanVienBEAN nhanVienBEAN = null;
		while (rs.next()) {
			String idNV = rs.getString("iDNV");
			String hoTen = rs.getString("ten");
			String sdt = rs.getString("sdt");
			String diaChi = rs.getString("diaChi");
			String taiKhoan = rs.getString("taiKhoan");
			
			nhanVienBEAN = new NhanVienBEAN();
			nhanVienBEAN.setiDNV(idNV);
			nhanVienBEAN.setHoTen(hoTen);
			nhanVienBEAN.setSdt(sdt);
			nhanVienBEAN.setDiaChi(diaChi);	
			nhanVienBEAN.setTaiKhoan(taiKhoan);
		}
		
		rs.close();
		connection.close();
		
		return nhanVienBEAN;
	}
	
	// thay doi thong tin ca nhan
	public int thayDoiThongTinNV(String hoTen, String sdt, String diaChi, String taiKhoan) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		//boolean kq = false;
		
		String sql = "UPDATE NHANVIEN SET ten = ?, sdt = ?, diaChi = ? where taiKhoan = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setString(1, hoTen);
		cmd.setString(2, sdt);
		cmd.setString(3, diaChi);
		cmd.setString(4, taiKhoan);
		
		int kq = cmd.executeUpdate();
		
		connection.close();
		
		return kq;
		
	}
	
	//thay doi mat khau
	public int thayDoiMatKhauNV(String taiKhoan, String matKhau) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		//boolean kq = false;
		
		String sql = "UPDATE NHANVIEN SET matKhau = '"+matKhau+"' where taiKhoan = '"+taiKhoan+"'";
		PreparedStatement cmd = connection.prepareStatement(sql);
		
		int kq = cmd.executeUpdate();
		
		connection.close();
		
		return kq;
		
	}
	
	public boolean checkLogin(String tenDangNhap, String matKhau) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "select * from NHANVIEN where taiKhoan = '"+tenDangNhap+"' and matKhau = '"+matKhau+"'";
		
		try {
			PreparedStatement cmd = connection.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean ktMKCu(String taiKhoan, String mKCu) throws ClassNotFoundException, SQLException {
		
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "select matKhau from NHANVIEN where taiKhoan = '"+taiKhoan+"'";
		
		try {
			PreparedStatement cmd = connection.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			if (rs.next() ) {
				String matKhau = rs.getString("matKhau");
				System.out.println(matKhau);
				if(matKhau.equals(mKCu));
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
		
	}
}
