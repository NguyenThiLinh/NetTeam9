package controller.may;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bean.May;
import model.bo.KhachHangBO;
import model.bo.MayBO;
import model.bo.SuDungMayBO;

/**
 * Servlet implementation class ThemPhienSDServlet
 */
public class DongPhienSDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DongPhienSDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		KhachHangBO khachHangBO = new KhachHangBO();
		SuDungMayBO suDungMayBO = new SuDungMayBO();
		MayBO mayBO = new MayBO();
		
		HttpSession session = request.getSession(false);
		String tenKhach = (String) session.getAttribute("tenKhach");
		Date gioBD = (Date) session.getAttribute("gioBD");
		//String maMay = (String) session.getAttribute("maMay");
		KhachHang khachHang = (KhachHang)session.getAttribute("khachHang");
		float taiKhoan = khachHang.getTaiKhoan();
		May may = (May)session.getAttribute("may");
		String maMay = (String)session.getAttribute("maMay");
		float soGioSuDung = may.getSoGioSuDung();
		
		Date gioKT = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("ddhhmmss");
		String bd = sdf2.format(gioBD).toString();
		String kt = sdf2.format(gioKT).toString();
		int d = Integer.parseInt(kt.substring(0, 2)) - Integer.parseInt(bd.substring(0, 2));
		float h = Integer.parseInt(kt.substring(2, 4)) - Integer.parseInt(bd.substring(2, 4));
		int m = Integer.parseInt(kt.substring(4, 6)) - Integer.parseInt(bd.substring(4, 6));
		if(d!=0) {
			h+=24;
		}
		else if(m>=-60 && m<=-30) {
			h-= 0.5;
		}else if(m>-30 && m <0) {
			h+=0;
		}else if(m>=0 && m <= 30){
			h+=0.5;
		}else if(m>30) {
			h+=1;
		}
		float soDu = taiKhoan - 5000*h;
		float soGio = soGioSuDung + h;
		
		try {
			suDungMayBO.dongPhienSD(tenKhach, gioBD, gioKT, h );
			khachHangBO.dongPhienSD(tenKhach, soDu);
			mayBO.dongPhienSD(maMay, soGio);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(session != null)
		    session.invalidate();
		request.getRequestDispatcher("/khachDangNhap.jsp").forward(request,response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
