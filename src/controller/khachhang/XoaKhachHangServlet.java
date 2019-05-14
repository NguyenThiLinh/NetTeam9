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
 * Servlet implementation class XoaKhachHangServlet
 */
public class XoaKhachHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaKhachHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		KhachHangBO khachHangBO = new KhachHangBO();
		String iDKhach=request.getParameter("iDKhach");
		if("submit".equals(request.getParameter("submit"))){	
			try {
				khachHangBO.xoaKhachHang(iDKhach);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("DanhSachSinhVienServlet");
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
			RequestDispatcher rd = request.getRequestDispatcher("xoaKhachHang.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		KhachHangBO khachHangBO = new KhachHangBO();
		String iDKhach=request.getParameter("iDKhach");
		if("submit".equals(request.getParameter("submit"))){	
			try {
				khachHangBO.xoaKhachHang(iDKhach);
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
			RequestDispatcher rd = request.getRequestDispatcher("xoaKhachHang.jsp");
			rd.forward(request, response);
		}
	}

}
