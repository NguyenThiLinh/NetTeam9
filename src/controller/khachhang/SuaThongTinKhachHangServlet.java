package controller.khachhang;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.KhachHang;
import model.bo.KhachHangBO;

/**
 * Servlet implementation class NapTienVaoTKServlet
 */
public class SuaThongTinKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaThongTinKhachHangServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		KhachHangBO khachHangBO = new KhachHangBO();
		String iDKhach = request.getParameter("iDKhach");
		if ("submit".equals(request.getParameter("submit"))) {
			String hoTen = request.getParameter("hoTen");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String soTienTrongTK = request.getParameter("soTienTrongTK");
			try {
				khachHangBO.suaThongTinKhachHang(iDKhach, hoTen, userName, password, soTienTrongTK);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("DanhSachKhachHangServlet");

		} else {
			KhachHang khachHang = null;
			try {
				khachHang = khachHangBO.getThongTinKhachHang(iDKhach);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("khachHang", khachHang);
			RequestDispatcher rd = request.getRequestDispatcher("suaThongTinKhachHang.jsp");
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
