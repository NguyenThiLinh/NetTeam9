package model.bo;

import java.util.ArrayList;

import model.bean.LoaiDichVuBean;
import model.dao.LoaiDichVuDAO;

public class LoaiDichVuBO {
	LoaiDichVuDAO loaiDao = new LoaiDichVuDAO();
	public ArrayList<LoaiDichVuBean> listLoai;
	public ArrayList<LoaiDichVuBean> getListLoaiDV() throws Exception{
		listLoai = loaiDao.getListLoaiDV();
		return listLoai;
	}
}
