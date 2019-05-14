 <jsp:include page="/templates/header.jsp" />
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.bean.GioHangBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<div class="container">
	<%if(request.getAttribute("listHangTrongGio") != null){
	ArrayList<GioHangBEAN> listHangTrongGio = (ArrayList<GioHangBEAN>)request.getAttribute("listHangTrongGio") ;
	float thanhTien = Float.parseFloat(request.getAttribute("thanhTien").toString());
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	int sl = Integer.parseInt(request.getAttribute("sl").toString());%>
	<div >
<header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">Giỏ hàng</h2>
            </div>
</header>

		<table id="giohang" class="table table table-striped">
			<thead>
				<tr>
					<th>Tên dịch cụ</th>
					<th>Giá</th>
					<th>Đơn vị tính</th>
					<th>Số lượng mua</th>
					<th>Thành tiền</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%if(listHangTrongGio != null){
					for(GioHangBEAN ghBean : listHangTrongGio){%>
					<tr>
						<td><%=ghBean.getTenDV() %></td>
						<td align="right"><%out.print(formatter.format(ghBean.getGia())); %> VND</td>
						<td><%=ghBean.getDonViTinh() %></td>
						<td>
						<div>
							<ul class="pagination">
								<li><a href="XuLyGioHang?id=giamSL&&maDV=<%=ghBean.getiDDichVu()%>">-</a></li>
								<li><a><%=ghBean.getSoLuongDat()%></a></li>
								<li><a href="XuLyGioHang?id=tangSL&&maDV=<%=ghBean.getiDDichVu()%>">+</a></li>
							</ul>
						</div>
						</td>
						<td><%out.print(formatter.format(ghBean.getThanhTien())); %> VND</td>
						<td><button class="btn btn-danger" ><a href="XuLyGioHang?id=xoa&&maDV=<%=ghBean.getiDDichVu()%>"><p style="color: white;"> Xoá</p></a></button></li></td>
					</tr>
						<%} 
					}%>
			</tbody>
		</table>
	</div>
	<div class="container">
		<h1>Tổng tiền :<span><%out.print(formatter.format(thanhTien)); %></span>VND</h1>
		<%} %>
		<div class="row">
			<a class="btn btn-danger" href="XuLyGioHang?id=xoaHet">Xoá hết </a>
			<a class="btn btn-primary" href="DichVuChoKhachHang">Mua hàng tiếp </a>
			<a class="btn btn-secondary" href="DatHang">Đặt hàng </a>
		</div>
	</div>
	</div>
	<br/>
 <jsp:include page="/templates/footer.jsp" />