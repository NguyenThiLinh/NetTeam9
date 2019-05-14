package controller.khachhang;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bean.May;
import model.bo.KhachHangBO;
import model.bo.MayBO;

/**
 * Servlet implementation class KhachHangSDMay
 */
public class KhachHangSDMayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangSDMayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("tenKhach")==null){
			response.sendRedirect("khachDangNhap.jsp");
			return;
		}
		
		
		KhachHangBO khachHangBO = new KhachHangBO();
		MayBO mayBO = new MayBO();
		String tenKhach = (String) session.getAttribute("tenKhach");
		String maMay = (String)session.getAttribute("iDMay");
		KhachHang khachHang = null;
		May may = null;
		try {
			 khachHang =khachHangBO.getThongTinKhachHangByAcc(tenKhach);
			 may = mayBO.getSoGioSuDungMay(maMay);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("khachHang", khachHang );
		session.setAttribute("may", may);
		if(khachHang.getTaiKhoan()<=0) {
			session.invalidate();
			request.getRequestDispatcher("/khachDangNhap.jsp").forward(request,response);
			RequestDispatcher rd = request.getRequestDispatcher("/DongPhienSDServlet");
			rd.forward(request, response);
		};
		request.setAttribute("khachHang", khachHang);
		RequestDispatcher rd = request.getRequestDispatcher("khachHangSDMay.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
