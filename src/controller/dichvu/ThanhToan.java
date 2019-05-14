package controller.dichvu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bean.ThanhToanBEAN;
import model.bo.KhachHangBO;
import model.bo.ThanhToanBO;

/**
 * Servlet implementation class ThanhToan
 */
public class ThanhToan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			ArrayList<ThanhToanBEAN> listTT = new ArrayList<ThanhToanBEAN>();
			ThanhToanBO ttBo = new ThanhToanBO();
			String tenKhach = (String) session.getAttribute("tenKhach");
			System.out.println(tenKhach);
			if(tenKhach != null) {
				listTT = ttBo.getListSDDV1(tenKhach, 0);
				System.out.println(listTT.size());
				if(listTT.size() != 0) {
					request.setAttribute("listTT", listTT);
					request.getRequestDispatcher("ViewThanhToan.jsp").forward(request, response);
				}
				else {
					String thongBao = "Khach nay khong co don hang";
					request.setAttribute("thongBao", thongBao);
					request.getRequestDispatcher("ViewThanhToan.jsp").forward(request, response);
				}
			}
			else {
				request.getRequestDispatcher("ViewThanhToan.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
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
