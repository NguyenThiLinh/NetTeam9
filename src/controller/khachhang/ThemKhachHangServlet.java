package controller.khachhang;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.KhachHangBO;

/**
 * Servlet implementation class ThemKhachHangServlet
 */
public class ThemKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemKhachHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		if (session.getAttribute("tenDangNhap") == null) {
			response.sendRedirect("dangNhap.jsp");
			return;
		}
		KhachHangBO khachHangBO = new KhachHangBO();
		if ("submit".equals(request.getParameter("submit"))) {
			String iDKhach = request.getParameter("iDKhach");
			String hoTen = request.getParameter("hoTen");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String soTienTrongTK = request.getParameter("soTienTrongTK");
			try {
				khachHangBO.themKhachHang(iDKhach, hoTen, userName, password, soTienTrongTK);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("DanhSachKhachHangServlet");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("themKhachHang.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
