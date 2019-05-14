<%@page import="model.bean.NhanVienBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/templates/header.jsp" />

<header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">Đổi mật khẩu nhân viên: <%=session.getAttribute("tenNhanVien")%></h2>
            </div>
</header>
<div class="container">
<form action="doiMatKhauNVServlet" method="post" class="form-validate">


    
    <br>
	
    
        <div class="row form-group">
            <label class="col-lg-2">Tài khoản</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="taiKhoan" readonly="readonly" value="<%=session.getAttribute("tenNhanVien")%>"/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Nhập mật khẩu cũ</label>
            <div class="col-lg-3">
                <input type="password" class="form-control" name="mKCu" required data-msg="Vui lòng nhập mật khẩu cũ"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Nhập mật khẩu mới</label>
            <div class="col-lg-3">
                <input type="password" class="form-control" name="mKMoi1" required data-msg="Vui lòng nhập mật khẩu mới"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Nhập lại mật khẩu mới</label>
            <div class="col-lg-3">
                <input type="password" class="form-control" name="mKMoi2" required data-msg="Vui lòng nhập lại"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
      <h3><%=request.getAttribute("thongBao") != null ? request.getAttribute("thongBao") : "" %></h3>
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-primary" type="submit">Lưu lại</button>
               <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />  
            </div>
        </div>
    </form>
    
</div>

<jsp:include page="/templates/footer.jsp" /> 