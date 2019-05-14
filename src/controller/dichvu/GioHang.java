package controller.dichvu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.GioHangBEAN;
import model.bo.GioHangBO;
import model.bo.LoaiDichVuBO;

/**
 * Servlet implementation class GioHang
 */
public class GioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			
			HttpSession session = request.getSession();
			GioHangBO gh = new GioHangBO();
			LoaiDichVuBO loaiDVBo = new LoaiDichVuBO();
			request.setAttribute("listLoai", loaiDVBo.getListLoaiDV());
			ArrayList<GioHangBEAN> listGioHang = null;
			if(session.getAttribute("gh") !=null) {
				gh = (GioHangBO)session.getAttribute("gh");
				listGioHang = gh.getgh();
				System.out.println("Gio hang co " + gh.getgh().size());
				float thanhTien = gh.thanhtien();
				request.setAttribute("listHangTrongGio", listGioHang);
				request.setAttribute("thanhTien", thanhTien);
				request.setAttribute("sl", gh.tongslhang());
			}else {
				session.setAttribute("gh", gh);
				float thanhTien = gh.thanhtien();
				request.setAttribute("listHangTrongGio", listGioHang);
				request.setAttribute("thanhTien", thanhTien);
				request.setAttribute("sl", gh.tongslhang());
			}
			RequestDispatcher rd = request.getRequestDispatcher("GioHanggg.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			response.getWriter().println(e.getMessage());
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
