package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.NhanVienBEAN;
import model.dao.NhanVienDAO;

public class NhanVienBO {
	
	NhanVienDAO nhanVienDAO = new NhanVienDAO();
	NhanVienBEAN nhanVienBEAN = new NhanVienBEAN();
	
	public ArrayList<NhanVienBEAN> getNV() throws ClassNotFoundException, SQLException {
		return nhanVienDAO.getNV();
	}
	
	//xem thong tin tk
	public NhanVienBEAN xemThongTinTK(String taiKhoan) throws ClassNotFoundException, SQLException {
		return nhanVienDAO.xemThongTinTK(taiKhoan);
	}
	
	//sua thong tin
	public int thayDoiThongTinNV(String hoTen, String sdt, String diaChi, String taiKhoan) throws ClassNotFoundException, SQLException {
		return nhanVienDAO.thayDoiThongTinNV(hoTen, sdt, diaChi, taiKhoan);
	}
	
	//kTraMatKhau mới 1 và mk mới 2
	public boolean kTraMK(String matKhau1, String matKhau2) {
		if (matKhau1.equals(matKhau2))
			return true;
		else 
			return false;
	}
	
	//thay doi mat khau
	public int thayDoiMatKhauNV(String taiKhoan, String matKhau) throws ClassNotFoundException, SQLException {
		return nhanVienDAO.thayDoiMatKhauNV(taiKhoan, matKhau);
	}
	
		
	public boolean checkLogin(String tenDangNhap, String matKhau) throws ClassNotFoundException, SQLException {
		return nhanVienDAO.checkLogin(tenDangNhap, matKhau);
		
	}

	public boolean ktMKCu(String taiKhoan, String mKCu) throws ClassNotFoundException, SQLException {
		return nhanVienDAO.ktMKCu(taiKhoan, mKCu);
	
		 
	}
}
