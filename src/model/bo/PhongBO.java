package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.PhongBean;
import model.dao.PhongDAO;

public class PhongBO {

	PhongDAO phongDAO = new PhongDAO();
	public ArrayList<PhongBean> getPhong() throws ClassNotFoundException, SQLException{
		return phongDAO.getPhong();
	}
	
	//get phong theo id
	public PhongBean getPhong_iD(String iDPhong) throws ClassNotFoundException, SQLException{
		return phongDAO.getPhong_iD(iDPhong);
	}
	
	// them phong
	public void themPhong(String iDPhong, String diaChi, int soLuong) throws ClassNotFoundException, SQLException {
		phongDAO.themPhong(iDPhong, diaChi, soLuong);
	}
	
	// sua phong
	public void thayDoiThongTinPhong(String iDPhong, String diaChi, int soLuong) throws ClassNotFoundException, SQLException {
		phongDAO.thayDoiThongTinPhong(iDPhong, diaChi, soLuong);
	}
	
	// xóa phòng
	public void xoaPhong(String iDPhong) throws ClassNotFoundException, SQLException {
		phongDAO.xoaPhong(iDPhong);
	}
}
