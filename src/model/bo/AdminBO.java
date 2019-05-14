/*
* @Author HCD-Fresher183
* @Date Feb 26, 2019
*/

package model.bo;

import java.sql.SQLException;

import model.dao.AdminDAO;

public class AdminBO {
	AdminDAO adminDAO = new AdminDAO();
	public boolean checkLogin(String tenDangNhap, String matKhau) throws ClassNotFoundException, SQLException {
		return adminDAO.checkLogin(tenDangNhap, matKhau);
		
	}

}
