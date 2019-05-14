<jsp:include page="/templates/header.jsp" />
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container">
<br/>
  <script type="text/javascript">
	
	function validate() {
		var soTienTrongTK = document.getElementById("soTienTrongTK").value;
		var so = parseInt(soTienTrongTK);
		var rs;
		if (so < 0) {
			
			alert('Số tiền phải lớn hơn 0!!!');
			rs = false;
			}else{
				rs = true
				alert('Thêm khách hàng thành công!!!');
			}
		
		return rs;
	}
</script> 
    <h3>Thêm mới khách hàng</h3>
    <br>
    <form onsubmit="return validate()" action="ThemKhachHangServlet" method="post" class="form-validate">
        <div class="row form-group">
            <label class="col-lg-2">Mã khách hàng</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="iDKhach" required data-msg="Vui lòng nhập mã khách hàng" />
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Họ tên</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="hoTen" required data-msg="Vui lòng nhập tên khách hàng" />
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên đăng nhập</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="userName" required data-msg="Vui lòng nhập tên đăng nhập"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Mật khẩu</label>
            <div class="col-lg-3">
                <input type="password" class="form-control" name="password" required data-msg="Vui lòng nhập mật khẩu" />
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số tiền trong tài khoản</label>
            <div class="col-lg-3">
                <input id="soTienTrongTK" type="text" class="form-control" name="soTienTrongTK" required data-msg="Vui lòng nhập số tiền nạp vào tài khoản" />
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
       
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-primary" type="submit" value="submit" name="submit">Thêm mới</button>
                <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
            </div>
        </div>
    </form>
    <br>
</div>

<jsp:include page="/templates/footer.jsp" />