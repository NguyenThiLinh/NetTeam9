package controller.dichvu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.GioHangBO;

/**
 * Servlet implementation class XuLyGioHang
 */
public class XuLyGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyGioHang() {
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
			if(request.getParameter("maDV")!=null) {
				String maDV = request.getParameter("maDV");
				if(request.getParameter("id").equals("giamSL")) {
					if(session.getAttribute("gh") != null) {
						GioHangBO ghBo = (GioHangBO)session.getAttribute("gh");
						ghBo.giam(maDV);
						session.setAttribute("gh", ghBo);
					}
				}
				if(request.getParameter("id").equals("tangSL")) {
					if(session.getAttribute("gh") != null) {
						GioHangBO ghBo = (GioHangBO)session.getAttribute("gh");
						ghBo.tang(maDV);
						session.setAttribute("gh", ghBo);
					}
				}
				if(request.getParameter("id").equals("xoa")) {
					if(session.getAttribute("gh") != null) {
						GioHangBO ghBo = (GioHangBO)session.getAttribute("gh");
						ghBo.xoa(maDV);
						session.setAttribute("gh", ghBo);
					}
				}
			}
			if(request.getParameter("id").equals("xoaHet")) {
				if(session.getAttribute("gh") != null) {
					GioHangBO ghBo = (GioHangBO)session.getAttribute("gh");
					ghBo.xoahet();
					session.setAttribute("gh", ghBo);
				}
			}
			response.sendRedirect("GioHang");
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
