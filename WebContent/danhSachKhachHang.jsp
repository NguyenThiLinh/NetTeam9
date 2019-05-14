<jsp:include page="/templates/header.jsp" />
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


 <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">Danh sách khách hàng</h2>
            </div>
</header>

<div class="container">
<%DecimalFormat formatter = new DecimalFormat("###,###,###");%>
    <div class="row">
   
        <form action="DanhSachKhachHangServlet" method="get">
                              
            <div class="col-lg-12 pull-right"><br/>
                <a class="btn btn-primary" href="themKhachHang.jsp" role="button">Thêm mới</a>
            </div>
        </form>
    </div>
    <br>
    <div class="card-body">
		<table id="bootstrap-data-table"
			class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Mã khách hàng</th>
                <th>Họ và tên</th>
                <th>Tên đăng nhập</th>
                <th>Tài khoản</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%
            	ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>)request.getAttribute("listKhachHang");
            	for(KhachHang kh:listKhachHang){
            %>
            <tr>
                <th scope="row"><%=kh.getIdKhach() %></th>
                <td><%=kh.getHoTen() %></td>
                <td><%=kh.getUserName() %></td>
                <td align="right"><%out.print(formatter.format( kh.getTaiKhoan())); %> VND</td>
                <td>
                     <a class="btn btn-default" href="NapTienVaoTKServlet?iDKhach=<%=kh.getIdKhach()%>">Nạp tiền</a>
                    <a class="btn btn-warning" href="SuaThongTinKhachHangServlet?iDKhach=<%=kh.getIdKhach()%>">Sửa</a>
                    <a class="btn btn-danger" href="XoaKhachHangServlet?iDKhach=<%=kh.getIdKhach()%>">Xóa</a>
                </td>
            </tr>
            <%
            	}
            %>
            </tbody>
        </table>
    </div>
</div>
<script src="admin/lib/assets/js/lib/data-table/datatables.min.js"></script>
	<script
		src="admin/lib/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
	<script
		src="admin/lib/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
	<script
		src="admin/lib/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
	<script src="admin/lib/assets/js/lib/data-table/jszip.min.js"></script>
	<script src="admin/lib/assets/js/lib/data-table/vfs_fonts.js"></script>
	<script src="admin/lib/assets/js/lib/data-table/buttons.html5.min.js"></script>
	<script src="admin/lib/assets/js/lib/data-table/buttons.print.min.js"></script>
	<script src="admin/lib/assets/js/lib/data-table/buttons.colVis.min.js"></script>
	<script src="admin/lib/assets/js/init/datatables-init.js"></script>

	<script src="admin/lib/bower_components/alertifyjs/alertify.js"></script>
	<script>
	$('body').addClass("open");
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#bootstrap-data-table-export').DataTable();
		});
	</script>
			
<jsp:include page="/templates/footer.jsp" />