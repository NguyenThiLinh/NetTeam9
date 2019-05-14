package controller.dichvu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ThanhToanBO;

/**
 * Servlet implementation class XuLyDonHang
 */
public class XuLyDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			ThanhToanBO ttBo = new ThanhToanBO();
			if(request.getParameter("maDH") != null && request.getParameter("id") != null) {
				int maDH = Integer.parseInt(request.getParameter("maDH"));
				String id = request.getParameter("id");
				if(id.equals("0")) {
					ttBo.updateXuLyDonHang(maDH);
					response.sendRedirect("QuanLyDonHang");
				}
				if(id.equals("1")) {
					ttBo.updateThanhToanDonHang(maDH);
					String maKH = request.getParameter("maKH");
					System.out.println(maKH);
					session.setAttribute("maKH", maKH);
					response.sendRedirect("ThanhToan");
				}
				if(id.equals("huy")) {
					ttBo.updateHuyDonHang(maDH);
					response.sendRedirect("QuanLyDonHang");
				}
				if(id.equals("hoiPhuc")) {
					ttBo.updateHoiPhucDonHang(maDH);
					response.sendRedirect("QuanLyDonHang");
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
