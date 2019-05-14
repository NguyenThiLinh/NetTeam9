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
import javax.servlet.http.HttpSession;

import model.bo.AdminBO;
import model.bo.KhachHangBO;
import model.bo.MayBO;
import model.bo.SuDungMayBO;

/**
 * Servlet implementation class KhachHangDangNhapServlet
 */
public class KhachHangDangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangDangNhapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String tenKhach = request.getParameter("tenKhach");
		String matKhau = request.getParameter("matKhau");
		String maMay = request.getParameter("maMay");
		Date gioBD = new Date();
		KhachHangBO khachHangBO = new KhachHangBO();
		SuDungMayBO suDungMayBO = new SuDungMayBO();
		
		try {
			if(khachHangBO.checkLogin(tenKhach, matKhau)){
				HttpSession session = request.getSession();
				session.setAttribute("tenKhach", tenKhach);
				session.setAttribute("maMay", maMay);
				session.setAttribute("gioBD", gioBD);
				suDungMayBO.themPhienSuDung(maMay, tenKhach, gioBD);
				response.sendRedirect("KhachHangSDMayServlet");
			} else {
				request.setAttribute("thongBao", "Tên đăng nhập hoặc mật khẩu không đúng");
				RequestDispatcher rd = request.getRequestDispatcher("khachDangNhap.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
