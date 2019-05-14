
<jsp:include page="/templates/header.jsp" />
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
<%DecimalFormat formatter = new DecimalFormat("###,###,###");%>
	<header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">THỐNG KÊ KHÁCH HÀNG NẠP TIỀN</h2>
            </div>
</header>


	<div class="content">
		<div class="animated fadeIn">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<strong>CHỌN KHOẢNG THỜI GIAN CẦN THỐNG KÊ</strong>
						</div>
						<div class="card-body card-block">
							<form action="ThongKeNapTienServlet" method="get"
								enctype="application/x-www-form-urlencoded"
								class="form-horizontal">
								<div class="row">
									<div class="col-md-2"></div>
									<div class="col-md-3">
										<div >
											<label>Từ ngày</label> <input
												type="date" placeholder="Chọn ngày" class="form-control"
												name="tungay" required data-msg="Vui lòng chọn ngày"
												id="tungay" value="">
										</div>
									</div>

									<div class="col-md-3">
										<div class="form-group">
											<label >Đến ngày</label> <input
												type="date" placeholder="Chọn ngày" class="form-control"
												name="denngay" required data-msg="Vui lòng chọn  ngày"
												id="denngay" value="">
										</div>
									</div>
									<div class="col-md-2">
										<label >Thống kê</label><br/>
											<button type="submit" value="thongKeNapTien"
												name="thongKeNapTien"
												class="btn btn-success ">Thống kê</button>
										
									</div>
								</div>
								<%
									Float total = (Float) request.getAttribute("total");
									if (total != null) {
								%>
								<div class="row">
									<div class="card-footer">
										<label class="form-control-label"><h3>Tổng số :</h3></label>
										<input class="float-center" type="text" placeholder="<%out.print(formatter.format(total)); %> VND"
											readonly="readonly"></div>
									</div>
									<%
										}
									%>
								
							</form>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
</div>


<jsp:include page="/templates/footer.jsp" />
