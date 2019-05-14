/*
* @Author HCD-Fresher183
* @Date Feb 25, 2019
*/

package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.KhachHang;
import model.dao.KhachHangDAO;

public class KhachHangBO {
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	public ArrayList<KhachHang> getListKhachHang() throws ClassNotFoundException, SQLException {
		return khachHangDAO.getListKhachHang();
		
	}
	public void themKhachHang(String iDKhach, String hoTen, String userName, String password, String soTienTrongTK) throws ClassNotFoundException, SQLException {
		khachHangDAO.themKhachHang(iDKhach, hoTen, userName, password,soTienTrongTK);
		
	}
	public KhachHang getThongTinKhachHang(String iDKhach) throws ClassNotFoundException, SQLException {
		return khachHangDAO.getThongTinKhachHang(iDKhach);
	}
	
	public void napTien(String iDKhach, String hoTen, String userName, String password, float soTienTrongTK) throws ClassNotFoundException, SQLException {
		khachHangDAO.napTien(iDKhach, hoTen, userName, password, soTienTrongTK);
		
	}
	public void suaThongTinKhachHang(String iDKhach, String hoTen, String userName, String password,
			String soTienTrongTK) throws ClassNotFoundException, SQLException {
		khachHangDAO.suaThongTinKhachHang(iDKhach, hoTen, userName, password, soTienTrongTK);
		
	}
	public void xoaKhachHang(String iDKhach) throws ClassNotFoundException, SQLException {
		khachHangDAO.xoaKhachHang(iDKhach);
		
	}
	public boolean checkLogin(String tenDangNhap, String matKhau) throws ClassNotFoundException, SQLException {
		return khachHangDAO.checkLogin(tenDangNhap, matKhau);
	}
	public KhachHang getThongTinKhachHangByAcc(String tenKhach) throws ClassNotFoundException, SQLException {
		return khachHangDAO.getThongTinKhachHangByAcc(tenKhach);
		
	}
	public void dongPhienSD(String tenKhach, float soDu) throws ClassNotFoundException, SQLException {
		khachHangDAO.dongPhienSD(tenKhach, soDu);
		
	}
	

	

}
