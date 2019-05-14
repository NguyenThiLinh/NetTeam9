package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DichVuBean;
import model.bo.DichVuBO;

public class QuanLyDichVuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyDichVuServlet() {
        super();
    }

    DichVuBO dichVuBO;
    ArrayList<DichVuBean> list;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		dichVuBO = new DichVuBO();
		if ("dSDV".equals(request.getParameter("act"))) {
			try {
				list = dichVuBO.getDichVu();
				
				request.setAttribute("dSDV", list);
				
				RequestDispatcher rd = request.getRequestDispatcher("danhSachDichVu.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("themDV".equals(request.getParameter("act"))) {
			try {
				dichVuBO.themDV(request.getParameter("iDDV"), request.getParameter("tenDV"),Float.parseFloat(request.getParameter("gia")), request.getParameter("donViTinh"));
				
				list = dichVuBO.getDichVu();
				
				request.setAttribute("dSDV", list);
				
				RequestDispatcher rd = request.getRequestDispatcher("danhSachDichVu.jsp");
				rd.forward(request, response);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("sua".equals(request.getParameter("act"))) {
			request.setAttribute("nutSua", request.getParameter("act"));
			DichVuBean dichVuBean = new DichVuBean(null, null, 0, null, null);
			try {
					//get dv theo id
					dichVuBean = dichVuBO.getDV_iD(request.getParameter("iDDV"));
					
					// truyen id vao
					request.setAttribute("iDDV", request.getParameter("iDDV"));
					
					// truyen doi tuong dv vao
					request.setAttribute("dichVu_iD", dichVuBean);
					
					RequestDispatcher rd = request.getRequestDispatcher("themDichVu.jsp");
					rd.forward(request, response);
				} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} 
		}else if ("nutSuaTuTrangThem".equals(request.getParameter("act"))) {
			try {
				// sua dv
				dichVuBO.thayDoiThongTinDV(request.getParameter("iDDV"), request.getParameter("tenDV"),Float.parseFloat(request.getParameter("gia")), request.getParameter("donViTinh"));
				
				// lấy ds để qua hiển thị noi trang jsp
				list = dichVuBO.getDichVu();
				request.setAttribute("dSDV", list);
				
				RequestDispatcher rd = request.getRequestDispatcher("danhSachDichVu.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	} else if ("xoa".equals(request.getParameter("act"))) {
			
			try {
				dichVuBO.xoaDV(request.getParameter("iDDV"));
				
				list = dichVuBO.getDichVu();
				
				request.setAttribute("dSDV", list);
				
				RequestDispatcher rd = request.getRequestDispatcher("danhSachDichVu.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
