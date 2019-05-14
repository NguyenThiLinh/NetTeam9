package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.PhongBean;

import connDB.DB;

public class PhongDAO {
Connection connection;
	
	ArrayList<PhongBean> list = new ArrayList<>();
	
	public ArrayList<PhongBean> getPhong() throws ClassNotFoundException, SQLException{
		connection = DB.getSQLServerConnection_JTDS();
		
		String sql = "select * from PHONG";
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next()) {
			String iDPhong = rs.getString("iDPhong");
			String diaChi = rs.getString("diaChi");
			int soLuong = rs.getInt("soLuong");
			
			PhongBean phongBean = new PhongBean(iDPhong, diaChi, soLuong);
			
			list.add(phongBean);
		}
		
		rs.close();
		connection.close();
		
		return list;
	}
	
	//get phong theo id
	public PhongBean getPhong_iD(String iDPhong) throws ClassNotFoundException, SQLException{
		connection = DB.getSQLServerConnection_JTDS();
		PhongBean phongBean = null;
		
		String sql = "select * from PHONG where iDPhong = '"+iDPhong+"'";
		PreparedStatement cmd = connection.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		
		while (rs.next()) {
			//String iDPhong = rs.getString("iDPhong");
			String diaChi = rs.getString("diaChi");
			int soLuong = rs.getInt("soLuong");
			
			phongBean = new PhongBean(iDPhong, diaChi, soLuong);
		}
		
		rs.close();
		connection.close();
		
		return phongBean;
	}
	
	//them phong
	public void themPhong(String iDPhong, String diaChi, int soLuong) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		
		String sql = "insert into PHONG values('"+iDPhong+"', '"+diaChi+"', '"+soLuong+"')";
		
		PreparedStatement cmd = connection.prepareStatement(sql);
		
		cmd.executeUpdate();
		
		connection.close();
	}
	
	// sua phong
	public void thayDoiThongTinPhong(String iDPhong, String diaChi, int soLuong) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		//boolean kq = false;
		
		String sql = "UPDATE PHONG SET diaChi ='"+diaChi+"', soLuong ='"+soLuong+"' where iDPhong = '"+iDPhong+"'";
		PreparedStatement cmd = connection.prepareStatement(sql);
		
		cmd.executeUpdate();
		
		connection.close();
		
	}
	// xóa phòng
	public void xoaPhong(String iDPhong) throws ClassNotFoundException, SQLException {
		connection = DB.getSQLServerConnection_JTDS();
		
		String sql = "DELETE FROM PHONG where iDPhong = '"+iDPhong+"'";
		PreparedStatement cmd = connection.prepareStatement(sql);
		
		cmd.executeUpdate();
		
		connection.close();
		
	}
	
}
