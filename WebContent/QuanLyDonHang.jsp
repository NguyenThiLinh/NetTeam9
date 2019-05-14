 <jsp:include page="/templates/header.jsp" />
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.bean.ChiTietDonHangBEAN"%>
<%@page import="model.bean.ThanhToanBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	
	<div class="container" class ="row" align="left"  style="margin-bottom: 2%">
		<form action="QuanLyDonHang" method="post">
			<div class="col-lg-4">
				<div align="right">
					<select class="form-control" name="tinhTrangDonHang">
					  <option value="0">Đơn hàng đang xử lý</option>
					  <option value="1">Đơn hàng chờ thanh toán</option>
					  <option value="2">Đơn hàng đã thanh toán</option>
					  <option value="-1">Đơn hàng đã hủy</option>
					</select>
				</div>
			</div>
			<div class="col-lg-2">
				<button type="submit" class="btn btn-primary">Lọc</button>
			</div>
		</form>
	</div>
	<div class="container" align="center" style="width: 1099px;">
	<%if(request.getAttribute("listTT") != null){ %>
		<%DecimalFormat formatter = new DecimalFormat("###,###,###");
		ArrayList<ThanhToanBEAN> listTT = (ArrayList<ThanhToanBEAN>)request.getAttribute("listTT");%>
		
		<h2>Chi tiết thanh toán</h2> <br>
		<table class="table table-bordered">
	    <thead>
	      <tr>
	        <th>ID đơn hàng</th>
	        <th>Tên khách hàng</th>
	        <th>Tổng tiền</th>
	        <th>Chức năng</th>
	        <th>Tên dịch vụ</th>
	        <th>Giá</th>
	        <th>Đơn vị tính</th>
	        <th>Số lượng</th>
	        <th>Thành tiền</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <%for(ThanhToanBEAN ttBean : listTT){ %>
	    <%ArrayList<ChiTietDonHangBEAN> listChiTiet =  ttBean.getList();
	    	int soDV = listChiTiet.size();
	    	
	    	int trangThai = ttBean.getTrangThaiXuLy();%>
	    	<tr>
	    		<td rowspan= "<%=soDV+1%>"><%=ttBean.getIdDonHang()%></td>
	    		<td rowspan= "<%=soDV+1%>"><%=ttBean.getHoTenKh()%></td>
	    		<td rowspan= "<%=soDV+1%>" align="right"><%out.print(formatter.format(ttBean.getTongTien())); %> VND</td>
	    		<td rowspan= "<%=soDV+1%>">
	    			<%if(trangThai == 0){ %>
	    				<button type="button" class="btn btn-default"><a href="XuLyDonHang?id=0&&maDH=<%=ttBean.getIdDonHang()%>">Xử lý</a></button>
	    				<button type="button" class="btn btn-default"><a href="XuLyDonHang?id=huy&&maDH=<%=ttBean.getIdDonHang()%>">Huỷ</a></button>
	    			<%} else if(trangThai == 1){%>
	    				<button type="button" class="btn btn-default"><a href="XuLyDonHang?id=1&&maDH=<%=ttBean.getIdDonHang()%>&&maKH=<%=ttBean.getiDKhach()%>">Thanh toán</a></button>
	    			<%} else if(trangThai == 2){%>
	    				<p>Đã thanh toán</p>
	    			<%} else{%>
	    				<p>Đã huỷ</p>
	    				<button type="button" class="btn btn-default"><a href="XuLyDonHang?id=hoiPhuc&&maDH=<%=ttBean.getIdDonHang()%>">Hồi phục</a></button>
	    			<%} %>
	    		</td>
	    		<%for(ChiTietDonHangBEAN ctdh : listChiTiet){%>
		    			<tr>
			    		<td><%=ctdh.getTenDV() %></td>
			    		<td align="right"><%out.print(formatter.format(ctdh.getGia())); %> VND</td>
			    		<td><%=ctdh.getDonViTinh() %></td>
			    		<td align="right"><%=ctdh.getSoLuong() %></td>
			    		<td align="right"><%out.print(formatter.format(ctdh.getThanhTien())); %> VND</td>
			    		</tr>
	    		<%} %>
	    	
	    <%} %>
	    </tbody>
	    </table><br>
	<%} %>
</div>
 <jsp:include page="/templates/footer.jsp" />