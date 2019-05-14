package controller.nhanvien;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVienBO;

public class suaThongTinNVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public suaThongTinNVServlet() {
        super();
    }
    NhanVienBO nhanVienBO = new NhanVienBO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String taiKhoan = request.getParameter("taiKhoan");
		String hoTen = request.getParameter("hoTen");
		String sdt = request.getParameter("sdt");
		String diaChi = request.getParameter("diaChi");
		
		try {
			nhanVienBO.thayDoiThongTinNV(hoTen, sdt, diaChi, taiKhoan);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
