package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ThanhToanBEAN;
import model.dao.ThanhToanDAO;

public class ThanhToanBO {
	ThanhToanDAO ttDao = new ThanhToanDAO();
	public ArrayList<ThanhToanBEAN> listTT;
	public ArrayList<ThanhToanBEAN> getListSDDV() throws Exception{
		listTT = ttDao.getListSDDV();
		return listTT;
	}
	public ArrayList<ThanhToanBEAN> getListSDDV0(String tenKhach) throws Exception{
		listTT = ttDao.getListSDDV0(tenKhach);
		return listTT;
	}
	public ArrayList<ThanhToanBEAN> getListSDDV1(String tenKhach, int idDonHang) throws Exception{
		listTT = ttDao.getListSDDV1(tenKhach, idDonHang);
		return listTT;
	}
	public void updateTrangThai(long idDonHang) throws Exception{
		ttDao.updateTrangThai(idDonHang);
	}
	public long InsertThanhToan(String tenKhach, float tongTien, String idPhong, String ngaySuDung) throws Exception{
		return ttDao.InsertThanhToan(tenKhach, tongTien, idPhong, ngaySuDung);	
	}
	public void updateXuLyDonHang(int maDonHang) throws Exception{
		ttDao.updateXuLyDonHang(maDonHang);
	}
	public void updateThanhToanDonHang(int maDonHang) throws Exception{
		ttDao.updateThanhToanDonHang(maDonHang);
	}
	public void updateHuyDonHang(int maDonHang) throws Exception{
		ttDao.updateHuyDonHang(maDonHang);
	}
	public void updateHoiPhucDonHang(int maDonHang) throws Exception{
		ttDao.updateHoiPhucDonHang(maDonHang);
	}
	public ArrayList<ThanhToanBEAN> getListSDDVtheoTT(int trangThaiDH) throws Exception{
		listTT = ttDao.getListSDDVtheoTT(trangThaiDH);
		return listTT;
	}
	public float getToTal(String tuNgay, String denNgay) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return ttDao.getToTal(tuNgay, denNgay);
	}
}
