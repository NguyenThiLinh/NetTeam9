<jsp:include page="/templates/header.jsp" />
<%@page import="model.bean.DichVuBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
<table class="table table-bordered">
	<%
	DecimalFormat formatter = new DecimalFormat("###,###,###");
		ArrayList<DichVuBean> list = (ArrayList<DichVuBean>) request.getAttribute("dSDV");
		int i = 1;
	%>
	<thead>
		<tr>
			<th scope="col">Stt</th>
			<th scope="col">ID DV</th>
			<th scope="col">Tên dịch vụ</th>
			<th scope="col">Giá</th>
			<th scope="col">Đơn vị tính</th>
			<th scope="col">Tùy chọn</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (DichVuBean dichVuBean : list) {
		%>
		<tr>
			<th scope="row"><%=i++%></th>
			<td><%=dichVuBean.getiDDV()%></td>
			<td><%=dichVuBean.getTenDV()%></td>
			<td align="right"><%out.print(formatter.format(dichVuBean.getGia()));%>VND</td>
			<td><%=dichVuBean.getDonViTinh()%></td>
			<td><a
				href="QuanLyDichVuServlet?act=sua&&iDDV=<%=dichVuBean.getiDDV()%>"><button
						class="btn btn-primary">Sửa</button></a></td>
			<td><a
				href="QuanLyDichVuServlet?act=xoa&&iDDV=<%=dichVuBean.getiDDV()%>"><button
						class="btn btn-danger">Xóa</button></a></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
</div>
<jsp:include page="/templates/footer.jsp" />
