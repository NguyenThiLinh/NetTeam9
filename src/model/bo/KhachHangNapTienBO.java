package model.bo;

import java.sql.SQLException;
import java.util.Date;

import model.dao.KhachHangNapTienDAO;

public class KhachHangNapTienBO {
	KhachHangNapTienDAO khachHangNapTienDAO = new KhachHangNapTienDAO();
	public void napTien(String userName, String napThem, String ngayNap) throws ClassNotFoundException, SQLException {
		khachHangNapTienDAO.napTien(userName, napThem, ngayNap);
		
	}
	public float getToTal(String tuNgay, String denNgay) throws ClassNotFoundException, SQLException {
		
		return khachHangNapTienDAO.getToTal(tuNgay, denNgay);
	}

}
