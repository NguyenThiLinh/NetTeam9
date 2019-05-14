package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connDB.DB;

import model.bean.DichVuBean;

public class DichVuDAO {
Connection connection;
	
	ArrayList<DichVuBean> list = new ArrayList<>();
	
	public ArrayList<DichVuBean> getDichVu() throws ClassNotFoundException, SQLException{
		connection = DB.getSQLServerConnection_JTDS();
		
		String sql = "select * from DICHVU";
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next()) {
			String iDDV = rs.getString("iDDV");
			String tenDV = rs.getString("tenDV");
			float gia = rs.getFloat("gia");
			String iDLoaiDV = rs.getString("iDLoaiDV");
			String donViTinh = rs.getString("donViTinh");
			
			DichVuBean dichVuBean = new DichVuBean(iDDV, tenDV, gia, iDLoaiDV, donViTinh);
			
			list.add(dichVuBean);
		}
		
		rs.close();
		connection.close();
		
		return list;
	}
	
	//get Dv theo id
	public DichVuBean getDV_iD(String iDDV) throws ClassNotFoundException, SQLException{
		connection = DB.getSQLServerConnection_JTDS();
		DichVuBean dichVuBean = null;
		
		String sql = "select * from DICHVU where iDDV = '"+iDDV+"'";
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next()) {
			String tenDV = rs.getString("tenDV");
			float gia = rs.getFloat("gia");
			String donViTinh = rs.getString("donViTinh");
			
			dichVuBean = new DichVuBean(iDDV, tenDV, gia, donViTinh, null);
		}
		
		rs.close();
		connection.close();
		
		return dichVuBean;
	}
	
	//them dich vu
	public void themDV(String iDDV, String tenDV, float gia, String donViTinh) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		
		String sql = "insert into DICHVU values('"+iDDV+"', '"+tenDV+"', '"+gia+"', '"+donViTinh+"')";
		
		PreparedStatement cmd = connection.prepareStatement(sql);
		
		cmd.executeUpdate();
		
		connection.close();
	}
	
	// sua dich vu
	public int thayDoiThongTinDV(String iDDV, String tenDV, float gia, String donViTinh) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		//boolean kq = false;
		
		String sql = "UPDATE DICHVU SET tenDV = '"+tenDV+"', gia = '"+gia+"', donViTinh = '"+donViTinh+"' where iDDV = '"+iDDV+"'";
		PreparedStatement cmd = connection.prepareStatement(sql);
		
		int kq = cmd.executeUpdate();
		
		connection.close();
		
		return kq;
		
	}
	// xóa dich vu
	public int xoaDV(String iDDV) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		//boolean kq = false;
		
		String sql = "DELETE FROM DICHVU where iDDV = '"+iDDV+"'";
		PreparedStatement cmd = connection.prepareStatement(sql);
		
		int kq = cmd.executeUpdate();
		
		connection.close();
		
		return kq;
		
	}
	
	public ArrayList<DichVuBean> getListDV() throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql ="SELECT * FROM DICHVU";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<DichVuBean> listDV = new ArrayList<DichVuBean>();
		while(rs.next()) {
			listDV.add(new DichVuBean(rs.getString("iDDV"), rs.getString("tenDV"), rs.getFloat("gia"), rs.getString("idLoaiDV"), rs.getString("donViTinh")));
		}
		rs.close();
		return listDV;
	}
	public ArrayList<DichVuBean> getListDVTheoLoaiDV(String maLoaiDV) throws Exception{
		connection = DB.getSQLServerConnection_JTDS();
		String sql ="SELECT * FROM DICHVU WHERE iDLoaiDV =?";
		PreparedStatement cmd = connection.prepareStatement(sql);
		cmd.setString(1,  maLoaiDV);
		ResultSet rs = cmd.executeQuery();
		ArrayList<DichVuBean> listDV = new ArrayList<DichVuBean>();
		while(rs.next()) {
			listDV.add(new DichVuBean(rs.getString("iDDV"), rs.getString("tenDV"), rs.getFloat("gia"), rs.getString("idLoaiDV"), rs.getString("donViTinh")));
		}
		rs.close();
		return listDV;
	}
}
