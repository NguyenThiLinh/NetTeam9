/*
* @Author HCD-Fresher183
* @Date Mar 1, 2019
*/

package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.May;
import model.dao.MayDAO;

public class MayBO {
	MayDAO mayDAO = new MayDAO();
	public void dongPhienSD(String maMay, float soGio) throws ClassNotFoundException, SQLException {
		mayDAO.dongPhienSD(maMay, soGio);
		
	}
	public May getSoGioSuDungMay(String maMay) throws ClassNotFoundException, SQLException {
		return mayDAO.getSoGioSuDungMay(maMay);
	}
	public ArrayList<May> getListMay() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return mayDAO.getListMay();
	}
	



}
