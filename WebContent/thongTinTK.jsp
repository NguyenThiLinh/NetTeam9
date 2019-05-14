<%@page import="model.bean.NhanVienBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/templates/header.jsp" />

<table class="table table-hover">
<%NhanVienBEAN nhanVienBEAN = (NhanVienBEAN) request.getAttribute("thongTinNV");
%>

 <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">Thông tin nhân viên: <%= nhanVienBEAN.getHoTen() %></h2>
            </div>
</header>

  <thead>
    <tr>
      <th scope="col">Họ tên</th>
      <th scope="col">Số điện thoại</th>
      <th scope="col">Địa chỉ</th>
      <th scope="col">Tên tài khoản</th>
    </tr>
  </thead>
  <tbody>
	    <tr>
	      <td><%=nhanVienBEAN.getHoTen() %></td>
	      <td><%=nhanVienBEAN.getSdt() %></td>
	      <td><%=nhanVienBEAN.getDiaChi()%></td>
	      <td><%=nhanVienBEAN.getTaiKhoan()%></td>
	    </tr>
  </tbody>
</table>

<jsp:include page="/templates/footer.jsp" /> 