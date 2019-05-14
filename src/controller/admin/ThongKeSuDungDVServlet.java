package controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.bo.ThanhToanBO;

/**
 * Servlet implementation class ThongKeSuDungDVServlet
 */
public class ThongKeSuDungDVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeSuDungDVServlet() {
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
		String thongKeDichVu = request.getParameter("thongKeDichVu");
		String tuNgay = request.getParameter("tungay");
		String denNgay = request.getParameter("denngay");
		System.out.println(tuNgay);
		System.out.println(denNgay);
		ThanhToanBO thanhToanBO = new ThanhToanBO();
		float total = 0;
		if(thongKeDichVu != null) {
			try {
				total = thanhToanBO.getToTal(tuNgay, denNgay);
				request.setAttribute("total", total);
				RequestDispatcher rd = request.getRequestDispatcher("thongKeSDDV.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("thongKeSDDV.jsp");
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
