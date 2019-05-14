package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhongBean;
import model.bo.PhongBO;

public class QuanLyPhongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuanLyPhongServlet() {
        super();
    }

    
    PhongBO phongBO;
    ArrayList<PhongBean> list;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		phongBO = new PhongBO();
		if ("dSPhong".equals(request.getParameter("act"))) {
			try {
				
				list = phongBO.getPhong();
			 
				 request.setAttribute("dsPhong", list);
				 
				 RequestDispatcher rd = request.getRequestDispatcher("danhSachPhong.jsp");
				 rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("themPhong".equals(request.getParameter("act"))) {
			request.setAttribute("nutThem", request.getParameter("act"));
			try {
				phongBO.themPhong(request.getParameter("iDPhong"), request.getParameter("diaChi"),Integer.parseInt(request.getParameter("soLuongMay")));
				
				list = phongBO.getPhong();
				 
				request.setAttribute("dsPhong", list);
				 
				RequestDispatcher rd = request.getRequestDispatcher("danhSachPhong.jsp");
				rd.forward(request, response);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} else if ("sua".equals(request.getParameter("act"))) {
			request.setAttribute("nutSua", request.getParameter("act"));
			PhongBean phongBean = new PhongBean();
			try {
					//get phong theo id
					phongBean = phongBO.getPhong_iD(request.getParameter("iDPhong"));
					
					// truyen id vao
					request.setAttribute("iDPhong", request.getParameter("iDPhong"));
					
					// truyen phong vao
					request.setAttribute("phong_iD", phongBean);
					
					// sua phong
					
					//phongBO.thayDoiThongTinPhong(request.getParameter("iDPhong"), request.getParameter("diaChi"),Integer.parseInt(request.getParameter("soLuongMay")));
					
					RequestDispatcher rd = request.getRequestDispatcher("themPhong.jsp");
					rd.forward(request, response);
				} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} 
		} else if ("nutSuaTuTrangThem".equals(request.getParameter("act"))) {
			try {
					// sua phong
					phongBO.thayDoiThongTinPhong(request.getParameter("iDPhong"), request.getParameter("diaChi"),Integer.parseInt(request.getParameter("soLuongMay")));
					
					list = phongBO.getPhong();
					 
					request.setAttribute("dsPhong", list);
					
					RequestDispatcher rd = request.getRequestDispatcher("danhSachPhong.jsp");
					rd.forward(request, response);
				} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} 
		} else if ("xoa".equals(request.getParameter("act"))) {
			
			try {
				
				phongBO.xoaPhong(request.getParameter("iDPhong"));
				
				list = phongBO.getPhong();
				 
				request.setAttribute("dsPhong", list);
				 
				RequestDispatcher rd = request.getRequestDispatcher("danhSachPhong.jsp");
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
