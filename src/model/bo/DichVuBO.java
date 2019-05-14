package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;


import model.bean.DichVuBean;
import model.dao.DichVuDAO;

public class DichVuBO {
	DichVuDAO dichVuDAO = new DichVuDAO();
	public ArrayList<DichVuBean> getDichVu() throws ClassNotFoundException, SQLException{
		return dichVuDAO.getDichVu();
	}
	
	//get Dv theo id
	public DichVuBean getDV_iD(String iDDV) throws ClassNotFoundException, SQLException{
		return dichVuDAO.getDV_iD(iDDV);
	}
	
	//them dich vu
	public void themDV(String iDDV, String tenDV, float gia, String donViTinh) throws ClassNotFoundException, SQLException {
		dichVuDAO.themDV(iDDV, tenDV, gia, donViTinh);
	}
	
	// sua dich vu
	public int thayDoiThongTinDV(String iDDV, String tenDV, float gia, String donViTinh) throws ClassNotFoundException, SQLException {
		return dichVuDAO.thayDoiThongTinDV(iDDV, tenDV, gia, donViTinh);
	}
	
	// xóa dich vu
	public int xoaDV(String iDDV) throws ClassNotFoundException, SQLException{
		return dichVuDAO.xoaDV(iDDV);
	}
	
	public ArrayList<DichVuBean> listDV;
	public ArrayList<DichVuBean> getListDV() throws Exception{
		listDV = dichVuDAO.getListDV();
		return listDV;
	}
	public ArrayList<DichVuBean> getListDVTheoLoaiDV(String maLoaiDV) throws Exception{
		listDV = dichVuDAO.getListDVTheoLoaiDV(maLoaiDV);
		return listDV;
	}
}
