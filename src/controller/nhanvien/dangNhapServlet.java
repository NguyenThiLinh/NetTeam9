package controller.nhanvien;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NhanVienBO;

public class dangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dangNhapServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String tenDangNhap = request.getParameter("loginUsername");
		String matKhau = request.getParameter("loginPassword");
		NhanVienBO nhanVienBO = new NhanVienBO();
		try {
			if(nhanVienBO.checkLogin(tenDangNhap, matKhau)){
				HttpSession session = request.getSession();
				session.setAttribute("tenNhanVien",tenDangNhap);
				//response.sendRedirect("QuanLyNhanVienController");
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("thongBao", "Tên đăng nhập hoặc mật khẩu của bạn không đúng" );
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
