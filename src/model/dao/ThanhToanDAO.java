package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connDB.DB;
import model.bean.ThanhToanBEAN;
import model.bo.ChiTietDonHangBO;

public class ThanhToanDAO {
	Connection connection;
	public ArrayList<ThanhToanBEAN> getListSDDV() throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		ArrayList<ThanhToanBEAN> listDV = new ArrayList<ThanhToanBEAN>();
		ChiTietDonHangBO ctdhBo = new ChiTietDonHangBO();
		String sql ="SELECT * FROM View_ThanhToan";
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			listDV.add(new ThanhToanBEAN(rs.getLong("iDDonHang"), rs.getString("hoTen"), rs.getFloat("tongTien"), rs.getInt("trangThaiXuLy"), rs.getString("userName"), null));
		}
		rs.close();
		for(ThanhToanBEAN ttbean : listDV) {
			ttbean.setList(ctdhBo.getListCTDH(ttbean.getIdDonHang()));
		}
		return listDV;
	}
	public ArrayList<ThanhToanBEAN> getListSDDV0(String tenKhach) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		ArrayList<ThanhToanBEAN> listDV = new ArrayList<ThanhToanBEAN>();
		ChiTietDonHangBO ctdhBo = new ChiTietDonHangBO();
		String sql ="SELECT * FROM View_ThanhToan WHERE trangThaiXuLy = 0 AND userName = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setString(1,  tenKhach);
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			listDV.add(new ThanhToanBEAN(rs.getLong("iDDonHang"), rs.getString("hoTen"), rs.getFloat("tongTien"), rs.getInt("trangThaiXuLy"),rs.getString("userName"), null));
		}
		rs.close();
		for(ThanhToanBEAN ttbean : listDV) {
			ttbean.setList(ctdhBo.getListCTDH(ttbean.getIdDonHang()));
		}
		return listDV;
	}
	public ArrayList<ThanhToanBEAN> getListSDDV1(String tenKhach, int idDonHang) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		ArrayList<ThanhToanBEAN> listDV = new ArrayList<ThanhToanBEAN>();
		ChiTietDonHangBO ctdhBo = new ChiTietDonHangBO();
		String sql ="SELECT * FROM View_ThanhToan WHERE trangThaiXuLy = 2 AND userName = ? AND iDDonHang = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setString(1,  tenKhach);
		cmd.setInt(2, idDonHang);
		ResultSet rs = cmd.executeQuery();
		
		while(rs.next()) {
			listDV.add(new ThanhToanBEAN(rs.getLong("iDDonHang"), rs.getString("hoTen"), rs.getFloat("tongTien"), rs.getInt("trangThaiXuLy"),rs.getString("userName"), null));
		}
		rs.close();
		for(ThanhToanBEAN ttbean : listDV) {
			ttbean.setList(ctdhBo.getListCTDH(ttbean.getIdDonHang()));
		}
		return listDV;
	}
	public void updateTrangThai(long idDonHang) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "update SDDV set trangThaiXuLy = 2 where iDDonHang = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setLong(1, idDonHang);
		cmd.executeUpdate();
		cmd.close();
		connection.close();
	}
	public long taoMaThanhToan() throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql="SELECT MAX(iDDonHang) FROM SDDV";
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery(); long MaTT = 1;
		if(rs.next())
			MaTT = rs.getLong(1);
		rs.close();
		return MaTT;
	}
	public long InsertThanhToan(String tenKhach, float tongTien, String idPhong, String ngaySuDung) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "INSERT SDDV(tenKhach, trangThaiXuLy, tongTien , iDPhong, ngaySuDung) VALUES  (?,0,?, ?,?)";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setString(1,tenKhach);
		cmd.setFloat(2, tongTien);
		cmd.setString(3,idPhong);
		cmd.setString(4, ngaySuDung);
		cmd.executeUpdate();
		return taoMaThanhToan();
	}
	public void updateXuLyDonHang(int maDonHang) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "UPDATE SDDV SET trangThaiXuLy = 1 WHERE iDDonHang = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setInt(1,maDonHang);
		cmd.executeUpdate();
		connection.close();
		}
	public void updateThanhToanDonHang(int maDonHang) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "UPDATE SDDV SET trangThaiXuLy = 2 WHERE iDDonHang = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setInt(1,maDonHang);
		cmd.executeUpdate();
		connection.close();
		}
	public void updateHuyDonHang(int maDonHang) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "UPDATE SDDV SET trangThaiXuLy = -1 WHERE iDDonHang = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setInt(1,maDonHang);
		cmd.executeUpdate();
		connection.close();
	}
	public void updateHoiPhucDonHang(int maDonHang) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql = "UPDATE SDDV SET trangThaiXuLy = 0 WHERE iDDonHang = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setInt(1,maDonHang);
		cmd.executeUpdate();
		connection.close();
	}
	
	public ArrayList<ThanhToanBEAN> getListSDDVtheoTT(int trangThaiDH) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		ArrayList<ThanhToanBEAN> listDV = new ArrayList<ThanhToanBEAN>();
		ChiTietDonHangBO ctdhBo = new ChiTietDonHangBO();
		String sql ="SELECT * FROM View_ThanhToan WHERE trangThaiXuLy = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setInt(1,trangThaiDH);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			listDV.add(new ThanhToanBEAN(rs.getLong("iDDonHang"), rs.getString("hoTen"), rs.getFloat("tongTien"), rs.getInt("trangThaiXuLy"),rs.getString("userName"), null));
		}
		rs.close();
		for(ThanhToanBEAN ttbean : listDV) {
			ttbean.setList(ctdhBo.getListCTDH(ttbean.getIdDonHang()));
		}
		return listDV;
	}
	public float getToTal(String tuNgay, String denNgay) throws ClassNotFoundException, SQLException {
		Connection connection = DB.getSQLServerConnection_JTDS();
		String sql = "SELECT total = Sum(tongTien) FROM SDDV WHERE ngaySuDung BETWEEN '"+tuNgay+"' and '"+denNgay+"'";
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

