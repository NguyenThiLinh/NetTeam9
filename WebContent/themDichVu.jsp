<%@page import="model.bean.DichVuBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="/templates/header.jsp" />

<div class="container">
    
    <h3>
    <%if("sua".equals(request.getAttribute("nutSua")))
            		out.print("Sửa dịch vụ");
      	else
      		out.print("Thêm dịch vụ");
      	%> </h3>
    <br>
	<form action="QuanLyDichVuServlet?act=<%="sua".equals(request.getAttribute("nutSua")) ? "nutSuaTuTrangThem" : "themDV"%>" method="post" class="form-validate">
        <%DichVuBean dichVuBean = (DichVuBean) request.getAttribute("dichVu_iD"); %>
        <div class="row form-group">
            <label class="col-lg-2">ID Dịch vụ</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name=" iDDV"required data-msg="Vui lòng nhập mã dịch vụ" value="<%=request.getAttribute("nutSua") != null ? request.getAttribute("iDDV") : ""%>"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên dịch vụ</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="tenDV" required data-msg="Vui lòng tên dịch vụ" value="<%=request.getAttribute("iDDV") != null ? dichVuBean.getTenDV() : ""%>"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Giá</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="gia" required data-msg="Vui lòng nhập giá" value="<%=request.getAttribute("iDDV") != null ? dichVuBean.getGia() : ""%>"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Đơn vị tính</label>
            <div class="col-lg-3">
                <input type="text" class="form-control" name="donViTinh" required data-msg="Vui lòng nhập đơn vị tính" value="<%=request.getAttribute("iDDV") != null ? dichVuBean.getDonViTinh() : ""%>"/>
            </div>
            <div class="col-lg-1">
            	<h4 style="color: red">(*)</h4>
            </div>
        </div>
    
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-primary" type="submit">
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