package controller.dichvu;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.bean.GioHangBEAN;
import model.bean.KhachHang;
import model.bo.ChiTietDonHangBO;
import model.bo.GioHangBO;
import model.bo.ThanhToanBO;

/**
 * Servlet implementation class DatHang
 */
public class DatHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date ngay = new Date();
	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	String ngaySuDung = sdf2.format(ngay).toString();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatHang() {
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
		try {
			ThanhToanBO ttBo = new ThanhToanBO();
			ChiTietDonHangBO chiTietDHBo = new ChiTietDonHangBO();
			long maThanhToan = 0;
			float tongTien = 0;
			String thongBao = null;
			if(session.getAttribute("tenKhach") != null && session.getAttribute("idPhong") != null) {
				String tenKhach = (String)session.getAttribute("tenKhach");
				
				String idPhong = (String) session.getAttribute("idPhong");
				System.out.println(tenKhach);
				if(session.getAttribute("gh") != null) {
					GioHangBO ghBo = (GioHangBO)session.getAttribute("gh");
					System.out.println(ghBo.getgh().size());
					if(ghBo.getgh().size()>0) {
						System.out.println("them hoa don nao");
						for(GioHangBEAN gh : ghBo.getgh()) {
							tongTien += gh.getThanhTien();
						}
						maThanhToan = ttBo.InsertThanhToan(tenKhach, tongTien, idPhong, ngaySuDung);
						for(GioHangBEAN ghBean : ghBo.getgh()) {
							System.out.println("them chi tiet hoa don nao");
							chiTietDHBo.InsertChitietDonHang(maThanhToan, ghBean.getiDDichVu(), ghBean.getSoLuongDat(), ghBean.getThanhTien());
						}
						session.removeAttribute("gh");
						thongBao = "Đặt hàng thành công!\nQuý khách vui lòng đợi trong phút chốc.";
						System.out.println(thongBao);
						session.setAttribute("thongBao", thongBao);
					}else {
						response.sendRedirect("GioHang");
					}
				}
			}
			System.out.println("diem qua trang");
			response.sendRedirect("DonHang");
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
