package controller.nhanvien;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVienBEAN;
import model.bo.NhanVienBO;

public class QuanLyNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyNhanVienController() {
        super();
    }
    
    NhanVienBO nhanVienBO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		nhanVienBO = new NhanVienBO();
		
		if ("xemThongTinTaiKhoan".equals(request.getParameter("act"))) {
			try {
				NhanVienBEAN nhanVienBEAN = new NhanVienBEAN() ;
				nhanVienBEAN = nhanVienBO.xemThongTinTK(request.getParameter("tk"));
				request.setAttribute("thongTinNV", nhanVienBEAN);
				
				RequestDispatcher rd = request.getRequestDispatcher("thongTinTK.jsp");
				rd.forward(request, response);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("thayDoiThongTin".equals(request.getParameter("act"))) {
			
			NhanVienBEAN nhanVienBEAN = new NhanVienBEAN() ;
			try {
				nhanVienBEAN = nhanVienBO.xemThongTinTK(request.getParameter("tk"));
				
				request.setAttribute("thongTinNV", nhanVienBEAN);
				
				RequestDispatcher rd = request.getRequestDispatcher("thayDoiThongTinNV.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		} else if ("nutThayDoiThongTinBenTrangThayDoi".equals(request.getParameter("act"))) {
			try {
				
				// thay doi thong tin nhan vien
				
				//String iDNV = request.getParameter("iDNV");
				String hoTen = request.getParameter("hoTen");
				String sdt = request.getParameter("sdt");
				String diaChi = request.getParameter("diaChi");
				String taiKhoan = request.getParameter("taiKhoan");
				
				nhanVienBO.thayDoiThongTinNV(hoTen, sdt, diaChi, taiKhoan);
				
				if (nhanVienBO.thayDoiThongTinNV(hoTen, sdt, diaChi, taiKhoan) != 0) {
					request.setAttribute("thongBao", "ok da sua thanh cong");
					
					NhanVienBEAN nhanVienBEAN = new NhanVienBEAN() ;
					nhanVienBEAN = nhanVienBO.xemThongTinTK(taiKhoan);
					request.setAttribute("thongTinNV", nhanVienBEAN);
				} else {
					request.setAttribute("thongBao", "sua khong thanh cong");
					
					NhanVienBEAN nhanVienBEAN = new NhanVienBEAN() ;
					try {
						nhanVienBEAN = nhanVienBO.xemThongTinTK(request.getParameter("tk"));
						
						request.setAttribute("thongTinNV", nhanVienBEAN);
						
						RequestDispatcher rd = request.getRequestDispatcher("thayDoiThongTinNV.jsp");
						rd.forward(request, response);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("thongTinTK.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} /*else if ("nutHuyThayDoiThongTinBenTrangThayDoi".equals(request.getParameter("act1"))) {
			try {
				NhanVienBEAN nhanVienBEAN = new NhanVienBEAN() ;
				nhanVienBEAN = nhanVienBO.xemThongTinTK(request.getParameter("tk"));
				request.setAttribute("thongTinNV", nhanVienBEAN);
				
				RequestDispatcher rd = request.getRequestDispatcher("thongTinTK.jsp");
				rd.forward(request, response);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}*/
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
