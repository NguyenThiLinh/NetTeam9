package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connDB.DB;
import model.bean.LoaiDichVuBean;

public class LoaiDichVuDAO {
	public ArrayList<LoaiDichVuBean> getListLoaiDV() throws Exception{
		Connection connection = DB.getSQLServerConnection_JTDS();
		String sql ="SELECT * FROM LOAIDICHVU";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<LoaiDichVuBean> listLoaiDV = new ArrayList<LoaiDichVuBean>();
		while(rs.next()) {
			listLoaiDV.add(new LoaiDichVuBean(rs.getString("iDLoaiDV"), rs.getString("loaiDichVu")));
		}
		rs.close();
		
		return listLoaiDV;
	}
}
