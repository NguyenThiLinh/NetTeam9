 <jsp:include page="/templates/header.jsp" />
<%@page import="model.bean.KhachHang"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>


 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	KhachHang khachHang = (KhachHang)request.getAttribute("khachHang");
	DecimalFormat formatter = new DecimalFormat("###,###,###");
%>
<div class="container">
<br/>
    <h3>Thông tin tài khoản</h3>
    <br>
    <form action="ChiTietKhachHangServlet" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mã khách hàng</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="iDKhach" readonly = "readonly" value = <%=khachHang.getIdKhach()%>>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Họ tên</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="hoTen" readonly = "readonly" value = "<%=khachHang.getHoTen()%>" >
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="userName" readonly = "readonly" value = "<%=khachHang.getUserName()%>">
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Mật khẩu</label>
            <div class="col-lg-3">
                <input type="password" class="form-control" name="password" readonly = "readonly" value = <%=khachHang.getPassword() %>>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số tiền trong tài khoản</label>
            <div class="col-lg-3">
                <input type="text"  class="form-control" name="soTienTrongTK" readonly = "readonly" value = "<%out.print(formatter.format(khachHang.getTaiKhoan()));%> VND">
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