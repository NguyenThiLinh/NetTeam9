package controller.nhanvien;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanVienBEAN;
import model.bo.NhanVienBO;

public class LayThongTinNVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LayThongTinNVServlet() {
        super();
    }

    NhanVienBO nhanVienBO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		nhanVienBO = new NhanVienBO();
		
		try {
			
			NhanVienBEAN nhanVienBEAN = new NhanVienBEAN() ;
			nhanVienBEAN = nhanVienBO.xemThongTinTK(request.getParameter("tk"));
			request.setAttribute("thongTinNV", nhanVienBEAN);
			
			RequestDispatcher rd = request.getRequestDispatcher("thayDoiThongTinNV.jsp");
			rd.forward(request, response);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
