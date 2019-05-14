"WebContent/WEB-INF" <jsp:include page="/templates/header.jsp" />
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.bean.ChiTietDonHangBEAN"%>
<%@page import="model.bean.ThanhToanBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


	<div class="container" align="center">
		<%if(request.getAttribute("listTT") != null){ %>
		<%DecimalFormat formatter = new DecimalFormat("###,###,###");
		ArrayList<ThanhToanBEAN> listTT = (ArrayList<ThanhToanBEAN>)request.getAttribute("listTT");%>
		<br/>
		<h2>Chi tiết đơn hàng</h2> <br>
		<table class="table table-bordered">
	    <thead>
	      <tr>
	        <th>ID đơn hàng</th>
	        <th>Tên khách hàng</th>
	        <th>Tổng tiền</th>
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
	    	
	    	%>
	    	<tr>
    		<td rowspan= "<%=soDV+1%>"><%=ttBean.getIdDonHang()%></td>
    		<td rowspan= "<%=soDV+1%>"><%=ttBean.getHoTenKh()%></td>
    		<td rowspan= "<%=soDV+1%>" align="right"><%out.print(formatter.format(ttBean.getTongTien())); %> VND</td>
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
	    </tr>
	    </tbody>
	    </table><br>
		<%} %>
		<div class="container" align="center" style="margin-top: 7%;">
			<%if(request.getAttribute("thongBao") != null){
			String thongbao = (String)request.getAttribute("thongBao");%>
			<h3><%=thongbao %></h3>
			<%}%>
		
		</div>
	</div>
</body>
</html>