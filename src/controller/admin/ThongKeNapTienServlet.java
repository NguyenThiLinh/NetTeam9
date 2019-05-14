package controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.KhachHangNapTienBO;

/**
 * Servlet implementation class ThongKeNapTienServlet
 */
public class ThongKeNapTienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeNapTienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if(session.getAttribute("tenDangNhap")==null){
			response.sendRedirect("dangNhap.jsp");
			return;
		}
		String thongKeNapTien = request.getParameter("thongKeNapTien");
		String tuNgay = request.getParameter("tungay");
		String denNgay = request.getParameter("denngay");
		System.out.println(tuNgay);
		System.out.println(denNgay);
		KhachHangNapTienBO khachHangNapTienBO = new KhachHangNapTienBO();
		float total = 0;
		if(thongKeNapTien != null) {
			try {
				total = khachHangNapTienBO.getToTal(tuNgay, denNgay);
				request.setAttribute("total", total);
				RequestDispatcher rd = request.getRequestDispatcher("thongKeNapTien.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("thongKeNapTien.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
