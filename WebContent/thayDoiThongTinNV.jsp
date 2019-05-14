<%@page import="model.bean.NhanVienBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/templates/header.jsp" />

<div class="container">
    
    <%NhanVienBEAN nhanVienBEAN = (NhanVienBEAN) request.getAttribute("thongTinNV");
	%>
    <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">Thông tin nhân viên: <%= nhanVienBEAN.getHoTen() %></h2>
            </div>
</header>
    <br>
	<form action="QuanLyNhanVienController?act=nutThayDoiThongTinBenTrangThayDoi&&iDNV=<%=nhanVienBEAN.getiDNV()%>&&taiKhoan=<%= nhanVienBEAN.getTaiKhoan()%>"
	 method="post" class = "form-validate">
        <div class="row form-group">
            <label class="col-lg-2">Tài khoản</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="taiKhoan" readonly="readonly" value="<%=nhanVienBEAN.getTaiKhoan()%>"/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Họ tên</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="hoTen" value="<%=nhanVienBEAN.getHoTen()%>" required data-msg="Vui lòng nhập tên"/>
            </div>
           <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số điện thoại</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="sdt" value="<%=nhanVienBEAN.getSdt()%>" required data-msg = "Vui lòng nhập số điện thoại"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Địa chỉ</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="diaChi" value="<%=nhanVienBEAN.getDiaChi()%>" required data-msg="Vui lòng nhập địa chỉ"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
     <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-primary" type="submit" value="submit" name="submit">Lưu lại</button>
                <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
            </div>
        </div>
       
            <!-- <div class="col-lg-1 ">
                <a href="QuanLyNhanVienController?act=nutHuyThayDoiThongTinBenTrangThayDoi"><button class="btn btn-primary" type="submit">Hủy</button></a>
            </div> -->
        </div>
    </form>
    
</div>

<jsp:include page="/templates/footer.jsp" /> 