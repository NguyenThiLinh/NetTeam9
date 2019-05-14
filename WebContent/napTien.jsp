 <jsp:include page="/templates/header.jsp" />
<%@page import="model.bean.KhachHang"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>

 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

	KhachHang khachHang = (KhachHang)request.getAttribute("khachHang");
%>
<div class="container">
<%DecimalFormat formatter = new DecimalFormat("###,###,###");%>
    <h3>Nạp tiền vào tài khoản</h3>
    <br>
     <script type="text/javascript">
	
	function validate() {
		var napthem = document.getElementById("napthem").value;
		var so = parseInt(napthem);
		var rs;
		if (so < 0) {
			
			alert('Số tiền nạp thêm phải lớn hơn 0!!!');
			rs = false;
			}else{
				rs = true
			}
		
		return rs;
	}
</script> 
    <form onsubmit="return validate()" action="NapTienVaoTKServlet" method="post" class="form-validate">
        <div class="row form-group">
            <label class="col-lg-2">Mã khách hàng</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="iDKhach" readonly = "readonly" value = <%=khachHang.getIdKhach()%>>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Họ tên</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="hoTen" readonly = "readonly" value = "<%=khachHang.getHoTen()%>" >
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="userName" readonly = "readonly" value = <%=khachHang.getUserName()%>>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Mật khẩu</label>
            <div class="col-lg-3">
                <input type="password" class="form-control" name="password" readonly = "readonly" value = <%=khachHang.getPassword() %>>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số tiền trong tài khoản</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="soTien" readonly = "readonly" value = "<%out.print(formatter.format( khachHang.getTaiKhoan())); %>VND">
            </div>
        </div>
         <div class="row form-group" hidden="hidden">
            <label class="col-lg-2">Số tiền trong tài khoản</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="soTienTrongTK" hidden="hidden" value = <%=khachHang.getTaiKhoan() %>>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số tiền nạp thêm</label>
            <div class="col-lg-3">
                <input id="napthem" type="text" class="form-control" name="napThem" required data-msg="Vui lòng nhập số tiền nạp thêm">
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
       
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-primary" type="submit" value="submit" name="submit">Nạp tiền</button>
                <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
            </div>
        </div>
    </form>
    <br>
</div>
<jsp:include page="/templates/footer.jsp" /> 