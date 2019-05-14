package controller.dichvu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.bean.DichVuBean;
import model.bean.KhachHang;
import model.bean.LoaiDichVuBean;
import model.bo.DichVuBO;
import model.bo.LoaiDichVuBO;

/**
 * Servlet implementation class DichVuChoKhachHang
 */
public class DichVuChoKhachHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DichVuChoKhachHang() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("tenKhach")==null){
			response.sendRedirect("khachDangNhap.jsp");
			return;
		}
		String tenKhach = (String) session.getAttribute("tenKhach");
		String idPhong = "P001";
		session.setAttribute("idPhong", idPhong);
		session.setAttribute("tenKhach", tenKhach);
		try {
			
			LoaiDichVuBO loaiBo = new LoaiDichVuBO();
			ArrayList<LoaiDichVuBean> listLoai = new ArrayList<>();
			listLoai = loaiBo.getListLoaiDV();
			
			DichVuBO dvBo = new DichVuBO();
			ArrayList<DichVuBean> listDV = new ArrayList<>();
			request.setAttribute("listLoai", listLoai);
			
			if(request.getParameter("maLoai") != null) {
				String maLoaiDV = request.getParameter("maLoai");
				listDV = dvBo.getListDVTheoLoaiDV(maLoaiDV);
				request.setAttribute("listDV", listDV);
			}
			else {
				listDV = dvBo.getListDV();
				request.setAttribute("listDV", listDV);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("DichVuChoKhachHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
