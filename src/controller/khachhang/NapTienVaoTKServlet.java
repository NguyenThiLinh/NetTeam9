package controller.khachhang;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.KhachHang;
import model.bo.KhachHangBO;
import model.bo.KhachHangNapTienBO;

/**
 * Servlet implementation class NapTienVaoTKServlet
 */
public class NapTienVaoTKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date ngay = new Date();
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	String ngayNap = sdf2.format(ngay).toString();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NapTienVaoTKServlet() {
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
		KhachHangNapTienBO khachNapBO = new KhachHangNapTienBO();
		String iDKhach = request.getParameter("iDKhach");
	
		String napThem = request.getParameter("napThem");
		if ("submit".equals(request.getParameter("submit"))) {
			String hoTen = request.getParameter("hoTen");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String tKcu = request.getParameter("soTienTrongTK");
			try {
				float soTienTrongTK = Float.parseFloat(napThem) + Float.parseFloat(tKcu);
				khachHangBO.napTien(iDKhach, hoTen, userName, password, soTienTrongTK);
				khachNapBO.napTien(userName, napThem, ngayNap);
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
			RequestDispatcher rd = request.getRequestDispatcher("napTien.jsp");
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
