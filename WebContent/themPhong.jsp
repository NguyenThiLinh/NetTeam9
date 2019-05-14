<%@page import="model.bean.PhongBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/templates/header.jsp" />

<div class="container">
    <h3>
		<%if("sua".equals(request.getAttribute("nutSua")))
                		out.print("Sửa phòng");
          	else
          		out.print("Thêm phòng");
          	%> 
	</h3>
    <br>
	<form action="QuanLyPhongServlet?act=<%="sua".equals(request.getAttribute("nutSua")) ? "nutSuaTuTrangThem" : "themPhong"%>" method="post" class="form-validate">
	
	<%PhongBean phongBean = (PhongBean) request.getAttribute("phong_iD"); %>
	
        <div class="row form-group">
            <label class="col-lg-2">ID phòng</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="iDPhong" required data-msg="Vui lòng nhập mã phòng" value="<%=request.getAttribute("nutSua") != null ? request.getAttribute("iDPhong") : ""%>"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Địa chỉ</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="diaChi" required data-msg="Vui lòng nhập địa chỉ" value="<%= request.getAttribute("iDPhong") != null ? phongBean.getDiaChi() : ""%>"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số lượng máy</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="soLuongMay" required data-msg="Vui lòng số lượng máy" value="<%= request.getAttribute("iDPhong") != null ? phongBean.getSoLuong() : ""%>"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
    
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-primary" type="submit" value="">
                	<%if("sua".equals(request.getAttribute("nutSua")))
                		out.print("Sửa");
                	else
                		out.print("Thêm");
                	%> 
                </button>
                <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
               <!-- <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />  --> 
            </div>
        </div>
    </form>
    
</div>

<jsp:include page="/templates/footer.jsp" /> 