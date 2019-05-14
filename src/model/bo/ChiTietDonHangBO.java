package model.bo;

import java.util.ArrayList;

import model.bean.ChiTietDonHangBEAN;
import model.dao.ChiTietDonHangDAO;

public class ChiTietDonHangBO {
	ChiTietDonHangDAO ctdhDao = new ChiTietDonHangDAO();
	public ArrayList<ChiTietDonHangBEAN> list;
	public ArrayList<ChiTietDonHangBEAN> getListCTDH(long idDonHang) throws Exception{
		list = ctdhDao.getListCTDH(idDonHang);
		return list;
	}
	public void InsertChitietDonHang(long iDDonHang, String iDDV, float soLuong, float thanhTien) throws Exception{
		ctdhDao.InsertChitietDonHang(iDDonHang, iDDV, soLuong, thanhTien);
	}
}
