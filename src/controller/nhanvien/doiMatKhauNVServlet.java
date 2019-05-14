package controller.nhanvien;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.NhanVienBO;

public class doiMatKhauNVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public doiMatKhauNVServlet() {
        super();
    }

    NhanVienBO nhanVienBO;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		nhanVienBO = new NhanVienBO();
		
		String taiKhoan = request.getParameter("taiKhoan");
		String mKCu = request.getParameter("mKCu");
		String mKMoi1 = request.getParameter("mKMoi1");
		String mKMoi2 = request.getParameter("mKMoi2");
		
		try {
			if(nhanVienBO.ktMKCu(taiKhoan, mKCu)) {
			} else {
				request.setAttribute("thongBao", "Mật khẩu cũ không chính xác!");
				
			} if (nhanVienBO.kTraMK(mKMoi1, mKMoi2)) {
				try {
					nhanVienBO.thayDoiMatKhauNV(taiKhoan, mKMoi1);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("thongBao", "Mật khẩu mới không trùng nhau!");
				RequestDispatcher rd = request.getRequestDispatcher("thayDoiMatKhauNV.jsp");
				rd.forward(request, response);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
