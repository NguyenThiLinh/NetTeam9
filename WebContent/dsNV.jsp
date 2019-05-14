<%@page import="model.bean.NhanVienBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/templates/header.jsp" />



<table class="table table-bordered">
<%ArrayList<NhanVienBEAN> listNV = (ArrayList<NhanVienBEAN>) request.getAttribute("dsNV");
int i = 1;
%>
  <thead>
    <tr>
      <th scope="col">Stt</th>
      <th scope="col">ID NV</th>
      <th scope="col">Tên</th>
      <th scope="col">ID phòng</th>
    </tr>
  </thead>
  <tbody>
  	<%
  		for(NhanVienBEAN nhanVienBEAN : listNV){
  			%>
	    <tr>
	      <th scope="row"><%=i ++ %></th>
	      <td><%=nhanVienBEAN.getiDNV() %></td>
	      <td><%=nhanVienBEAN.getHoTen() %></td>
	      <td><%=nhanVienBEAN.getiDPhong()%></td>
	    </tr>
    <%
  		}
  	%>
  </tbody>
</table>

<jsp:include page="/templates/footer.jsp" /> 