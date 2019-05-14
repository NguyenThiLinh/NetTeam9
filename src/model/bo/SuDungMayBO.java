/*
* @Author HCD-Fresher183
* @Date Feb 28, 2019
*/

package model.bo;

import java.sql.SQLException;
import java.util.Date;

import model.dao.SuDungMayDAO;

public class SuDungMayBO {
	SuDungMayDAO suDungMayDAO = new SuDungMayDAO();
	public void themPhienSuDung(String maMay, String tenKhach, Date gioBD) throws ClassNotFoundException, SQLException {
		suDungMayDAO.themPhienSuDung( maMay, tenKhach, gioBD);
		
	}
	public void dongPhienSD(String tenKhach, Date gioBD, Date gioKT, float h) throws ClassNotFoundException, SQLException {
		suDungMayDAO.dongPhienSD(tenKhach, gioBD,gioKT, h);
		
	}
	

}
