package controller.dichvu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.GioHangBO;

/**
 * Servlet implementation class ThemVaoGioHang
 */
public class ThemVaoGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemVaoGioHang() {
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
		if(request.getParameter("maDV") !=null && request.getParameter("tenDV") != null 
				&& request.getParameter("dvTinh") !=null 
				&& request.getParameter("soLuong") !=null 
				&& request.getParameter("giaDV") !=null ) {
			GioHangBO gh = new GioHangBO();
			String maDV = request.getParameter("maDV");
			String tenDV = request.getParameter("tenDV");
			System.out.println(tenDV);
			String dvTinh = request.getParameter("dvTinh");
			int soLuongDat = Integer.parseInt(request.getParameter("soLuong"));
			float gia = Float.parseFloat(request.getParameter("giaDV"));
			if(session.getAttribute("gh") != null) {
				gh =(GioHangBO)session.getAttribute("gh");
				gh.them(maDV, tenDV, gia, dvTinh, soLuongDat);
				session.setAttribute("gh", gh);
			}else {
				gh.them(maDV, tenDV, gia, dvTinh, soLuongDat);
				session.setAttribute("gh", gh);
			}
		}
		response.sendRedirect("GioHang");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
