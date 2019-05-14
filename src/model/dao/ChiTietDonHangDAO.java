package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connDB.DB;
import model.bean.ChiTietDonHangBEAN;

public class ChiTietDonHangDAO {
	public ArrayList<ChiTietDonHangBEAN> getListCTDH(long idDonHang) throws Exception{
		Connection connection = DB.getSQLServerConnection_JTDS();
		String sql ="SELECT * FROM View_ChiTietDichVu WHERE iDDonHang = ?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setLong(1,  idDonHang);
		ResultSet rs = cmd.executeQuery();
		ArrayList<ChiTietDonHangBEAN> listDV = new ArrayList<ChiTietDonHangBEAN>();
		while(rs.next()) {
			listDV.add(new ChiTietDonHangBEAN(rs.getLong("iDDonHang"), rs.getString("iDDV"), rs.getString("tenDV"), rs.getFloat("gia"), rs.getString("donViTinh"), rs.getInt("soLuong"), rs.getFloat("thanhTien")));
		}
		rs.close();
		
		return listDV;
	}
	public void InsertChitietDonHang(long iDDonHang, String iDDV, float soLuong, float thanhTien) throws Exception{
		Connection connection = DB.getSQLServerConnection_JTDS();
		String sql = "INSERT CHITIETDONHANG(iDDonHang,iDDV,soLuong,thanhTien) VALUES (?,?,?,?)";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setLong(1,iDDonHang);
		cmd.setString(2,iDDV);
		cmd.setFloat(3, soLuong);
		cmd.setFloat(4,thanhTien);
		cmd.executeUpdate();
		
	}
}
