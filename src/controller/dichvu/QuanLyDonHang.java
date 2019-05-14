package controller.dichvu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThanhToanBEAN;
import model.bo.ThanhToanBO;

/**
 * Servlet implementation class QuanLyDonHang
 */
public class QuanLyDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try{
			ArrayList<ThanhToanBEAN> listTT = new ArrayList<ThanhToanBEAN>();
			ThanhToanBO ttBo = new ThanhToanBO();
			String trangThaiDonHang = request.getParameter("tinhTrangDonHang");
			if(trangThaiDonHang == null) {
				listTT = ttBo.getListSDDV();
				request.setAttribute("listTT", listTT);
				System.out.println(listTT.size());
				System.out.println("diem qua trang");
				request.getRequestDispatcher("QuanLyDonHang.jsp").forward(request, response);
			}else {
				int trangThaiDH = Integer.parseInt(trangThaiDonHang);
				listTT = ttBo.getListSDDVtheoTT(trangThaiDH);
				request.setAttribute("listTT", listTT);
				request.getRequestDispatcher("QuanLyDonHang.jsp").forward(request, response);
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
