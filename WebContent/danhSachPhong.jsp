<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.PhongBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/templates/header.jsp" />

<table class="table table-bordered">
<%ArrayList<PhongBean> list = (ArrayList<PhongBean>) request.getAttribute("dsPhong");
int i = 1;
%>
  <thead>
    <tr>
      <th scope="col">Stt</th>
      <th scope="col">ID Phong</th>
      <th scope="col">Địa chỉ</th>
      <th scope="col">Số lượng máy</th>
      <th scope="col">Tùy chọn</th>
    </tr>
  </thead>
  <tbody>
  	<%
  		for(PhongBean phongBean : list){
  			%>
	    <tr>
	      <th scope="row"><%=i ++ %></th>
	      <td><%=phongBean.getiDPhong() %></td>
	      <td><%=phongBean.getDiaChi() %></td>
	      <td align="right"><%=phongBean.getSoLuong()%></td>
	      <td><a href="QuanLyPhongServlet?act=sua&&iDPhong=<%=phongBean.getiDPhong()%>"><button class="btn btn-primary">Sửa</button></a></td>
	      <td><a href="QuanLyPhongServlet?act=xoa&&iDPhong=<%=phongBean.getiDPhong()%>"><button class="btn btn-danger">Xóa</button></a></td>
	    </tr>
    <%
  		}
  	%>
  </tbody>
</table>

<jsp:include page="/templates/footer.jsp" /> 