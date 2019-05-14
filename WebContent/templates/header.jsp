<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Quản lý chuỗi NET</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="vendor/font-awesome/css/font-awesome.min.css">
<!-- Fontastic Custom icon font-->
<link rel="stylesheet" href="css/fontastic.css">
<!-- Google fonts - Poppins -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
<!-- theme stylesheet-->
<link rel="stylesheet" href="css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- Favicon-->

<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<div class="page">
		<!-- Main Navbar-->
		<header class="header">
			<nav class="navbar">
				<!-- Search Box-->
				<div class="search-box">
					<button class="dismiss">
						<i class="icon-close"></i>
					</button>
					<form id="searchForm" action="#" role="search">
						<input type="search" placeholder="Tìm kiếm..."
							class="form-control">
					</form>
				</div>
				<div class="container-fluid">
					<div
						class="navbar-holder d-flex align-items-center justify-content-between">
						<!-- Navbar Header-->
						<div class="navbar-header">
							<!-- Navbar Brand -->
							<a href="index.html"
								class="navbar-brand d-none d-sm-inline-block"></a>
							<div class="brand-text d-none d-lg-inline-block">
								<h2><span>NET </span><strong>chain</strong></h2>
							</div>

							<!-- Toggle Button-->
							<a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
						</div>
						<!-- Navbar Menu -->
						<ul
							class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
							<!-- Search-->
							<li class="nav-item d-flex align-items-center"><a
								id="search" href="#"><i class="icon-search"></i></a></li>
							<!-- Logout    -->
							<%
								String name = (String) session.getAttribute("tenDangNhap");
								String tenNhanVien = (String) session.getAttribute("tenNhanVien");
								String tenKhach = (String) session.getAttribute("tenKhach");
								String maMay = (String) session.getAttribute("maMay");
								
							%>
							<%if(maMay!=null) {%>
							<li class="nav-item"><a href="DongPhienSDServlet"
								class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i
									class="fa fa-sign-out"></i></a></li>
									<%}else{ %>
									<li class="nav-item"><a href="DangXuatServlet"
								class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i
									class="fa fa-sign-out"></i></a></li>
									<%} %>


						</ul>
					</div>
				</div>
			</nav>
		</header>
		<div class="page-content d-flex align-items-stretch">
			<!-- Side Navbar -->
			<nav class="side-navbar">
				<!-- Sidebar Header-->
				<div class="sidebar-header d-flex align-items-center">

					<div class="title">
						<h1 class="h4">TeamJava09</h1>
						<%if(name!=null) {%>
						<p>Xin chào: <%=name%></p>
						<%} %>
						<%if(tenKhach!=null) {%>
						<p>Xin chào: <%=tenKhach%></p>
						<%} %>
						<%if(maMay!=null) {%>
						<p>Máy <%=maMay %></p>
						<%} %>


					</div>
				</div>
				<!-- Sidebar Navidation Menus-->
				<span class="heading">Main</span>
				<ul class="list-unstyled">
					
					<%if(name!=null) {%>
					<li><a href="DanhSachKhachHangServlet"> <i
							class="icon-home"></i>Home
					</a></li>
					<li><a href="#exampledropdownDropdown" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>Quản
							lý khách hàng
					</a>
						<ul id="exampledropdownDropdown" class="collapse list-unstyled ">
							<li><a href="DanhSachKhachHangServlet">Danh sách khách
									hàng</a></li>
							<li><a href="themKhachHang.jsp">Thêm khách hàng</a></li>
							<li><a href="QuanLyDonHang">Quản lý đơn hàng</a></li>
						</ul></li>
						  <li><a href="#Phong" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Quản lý phòng </a>
		                      <ul id="Phong" class="collapse list-unstyled ">
		                        <li><a href="QuanLyPhongServlet?act=dSPhong">Danh sách phòng</a></li>
		                        <li><a href="themPhong.jsp">Thêm phòng</a></li>
		                      </ul>
                    </li>
                    <li><a href="#DichVu" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Quản lý dịch vụ </a>
		                      <ul id="DichVu" class="collapse list-unstyled ">
		                        <li><a href="QuanLyDichVuServlet?act=dSDV">Danh sách dịch vụ</a></li>
		                        <li><a href="themDichVu.jsp">Thêm dịch vụ</a></li>
		                      </ul>
                    </li>
                     <li><a href="#ThongKe" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Thống kê </a>
		                      <ul id="ThongKe" class="collapse list-unstyled ">
		                        <li><a href="ThongKeNapTienServlet">Doanh số khách hàng nạp tiền</a></li>
		                        <li><a href="ThongKeSuDungDVServlet">Doanh thu từ dịch vụ</a></li>
		                        
		                      </ul>
                    </li>
						<%} %>
						<%if(tenNhanVien!=null) {%>
						 <li><a href="#NhanVien" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>Xin chào <%=session.getAttribute("tenNhanVien")%> </a>
		                      <ul id="NhanVien" class="collapse list-unstyled ">
		                        <li><a href="QuanLyNhanVienController?act=xemThongTinTaiKhoan&&tk=<%=session.getAttribute("tenNhanVien")%>">Xem thông tin tài khoản</a></li>
		                        <li><a href="QuanLyNhanVienController?act=thayDoiThongTin&&tk=<%=session.getAttribute("tenNhanVien")%>">Thay đổi thông tin</a></li>
		                        <li><a href="forWard" >Đổi mật khẩu</a></li>
		                        <li><a href="QuanLyDonHang">Quản lý đơn hàng</a></li>
		                      </ul>
                    </li>
                  
                    <%} %>
						<%if(tenKhach!=null) {%>
					<li><a href="#khachHang" aria-expanded="false"
						data-toggle="collapse"> <i class="icon-interface-windows"></i>Thành viên: <%=tenKhach%>
					</a>
						<ul id="khachHang" class="collapse list-unstyled ">
							<li><a href="ChiTietKhachHangServlet">Xem thông tin tài khoản</a></li>
							<li><a href="KhachHangSDMayServlet">Phiên sử dụng</a></li>
							<li><a href="DichVuChoKhachHang">Gọi dịch vụ</a></li>
						</ul></li>
						<%} %>
				</ul>
			</nav>
			<div class="content-inner">
				<!-- Page Header-->