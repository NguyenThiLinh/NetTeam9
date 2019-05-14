 <jsp:include page="/templates/header.jsp" />
<%@page import="model.bean.KhachHang"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page import= "java.util.Date"%>
<%@ page import= " java.text.SimpleDateFormat"%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

DecimalFormat formatter = new DecimalFormat("###,###,###");
	KhachHang khachHang = (KhachHang)request.getAttribute("khachHang");
	Date gioBD = (Date) session.getAttribute("gioBD");
	SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd hh:mm:ss");
	Date gioKT = new Date();
	String bd = sdf2.format(gioBD).toString();
	
	
	String kt = sdf2.format(gioKT).toString();
	int d = Integer.parseInt(kt.substring(4, 6)) - Integer.parseInt(bd.substring(4, 6));
	float h = Integer.parseInt(kt.substring(7, 9)) - Integer.parseInt(bd.substring(7, 9));
	int m = Integer.parseInt(kt.substring(10, 12)) - Integer.parseInt(bd.substring(10, 12));
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
	String maMay  = (String) session.getAttribute("maMay");
	
%>
<div class="container">
<br/>
    <h3>Phiên sử dụng máy</h3>
    <br>
    <form action="KhachHangSDMayServlet" method="post">
        
        <div class="row form-group">
            <label class="col-lg-2">Họ tên</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="hoTen" readonly = "readonly" value = "<%=khachHang.getHoTen()%>" >
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên đăng nhập</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="userName" readonly = "readonly" value = "<%=khachHang.getUserName()%>">
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Mã máy</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="maMay" readonly = "readonly" value = "<%=maMay%>" >
            </div>
        </div>
         <div class="row form-group">
            <label class="col-lg-2">Giờ bắt đầu</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="gioBD" readonly = "readonly" value = "<%=bd%>" >
            </div>
        </div>
         <div class="row form-group">
            <label class="col-lg-2">Số dư tài khoản</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="taiKhoan" readonly = "readonly" value = "<%out.print(formatter.format(khachHang.getTaiKhoan()-5000*h));%>VND" >
            </div>
        </div>
        
       
       
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
               <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
            </div>
        </div>
    </form>
    <br>
</div>
<jsp:include page="/templates/footer.jsp" /> 