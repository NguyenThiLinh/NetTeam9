package controller.dichvu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.bean.ThanhToanBEAN;
import model.bo.ThanhToanBO;

/**
 * Servlet implementation class DonHang
 */
public class DonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("qua roi ne");
		
		HttpSession session = request.getSession();
		try {
			ArrayList<ThanhToanBEAN> listTT = new ArrayList<ThanhToanBEAN>();
			ThanhToanBO ttBo = new ThanhToanBO();
			String tenKhach = (String)session.getAttribute("tenKhach");
			
			System.out.println(tenKhach);
			String thongBao = (String)session.getAttribute("thongBao");
			if(tenKhach != null) {
				listTT = ttBo.getListSDDV0(tenKhach);
				if(listTT.size() != 0) {
					request.setAttribute("listTT", listTT);
					request.setAttribute("thongBao", thongBao);
					
					request.getRequestDispatcher("DonHang.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/DichVuChoKhachHang").forward(request, response);
					
				}
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
