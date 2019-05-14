 <jsp:include page="/templates/header.jsp" />
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.bean.DichVuBean"%>
<%@page import="model.bean.LoaiDichVuBean"%>
<%@page import="java.util.ArrayList"%>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
 
 <div class="container">
<br/>
	<%if(request.getAttribute("listLoai") != null){
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	ArrayList<LoaiDichVuBean> listLoaiDV = (ArrayList<LoaiDichVuBean>)request.getAttribute("listLoai"); %>
	<div class="container" style="margin-top: 7%;">
		<div class="row content">
			<div class="col-md-3 list">
				<ul class="list-group">
				<%if( listLoaiDV!=null){ %>
				<%for(LoaiDichVuBean lb : listLoaiDV){ %>
					<li class="list-group-item"><a href="DichVuChoKhachHang?maLoai=<%=lb.getIdLoaiDV() %>"><%=lb.getTenLoaiDV() %></a></li>
			    <%}} %>
			</ul>
			</div>
			<div class="col-md-9">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Tên dịch vụ</th>
							<th>Giá</th>
							<th>Đơn vị tính</th>
							<th>Số lượng đặt</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%if(request.getAttribute("listDV") != null){ 
							ArrayList<DichVuBean> listDV = (ArrayList<DichVuBean>)request.getAttribute("listDV");
							for(DichVuBean dvBean : listDV){%>
							<tr>
								<td><%=dvBean.getTenDV() %></td>
								<td align="right"><%out.print(formatter.format(dvBean.getGia())); %> VND</td>
								<td><%=dvBean.getDonViTinh() %></td>
								<td align="right">1</td>
  								<td><button type="button" class="btn btn-success"> 
								<a href="ThemVaoGioHang?maDV=<%=dvBean.getiDDV()%>&&tenDV=<%=dvBean.getTenDV()%>&&giaDV=<%=dvBean.getGia()%>&&dvTinh=<%=dvBean.getDonViTinh()%>&&soLuong=1"><p style="color: white;">Thêm</p></a></button></td>
							</tr>
							<%}
						}%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%} %>
</div>
 <jsp:include page="/templates/footer.jsp" />