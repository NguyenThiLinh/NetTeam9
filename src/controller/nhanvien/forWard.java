package controller.nhanvien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class forWard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public forWard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("tenNhanVien") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("thayDoiMatKhauNV.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
