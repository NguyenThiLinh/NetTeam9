<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa;
        }
        
        .h1 {
            background-image: url('images/anhnet5.jpg');
            background-size: cover;
            background-position: center;
            height: 400px;
        }
        
        .h2 {
            background-image: url('images/anhnet4.jpg');
            background-size: cover;
            background-position: center;
            height: 400px;
        }
        
        .h3 {
            background-image: url('images/anh2.jpg');
            background-size: cover;
            background-position: center;
            height: 400px;
        }
        
        .h4 {
            background-image: url('images/xuhuong.jpg');
            background-size: cover;
            background-position: center;
            height: 400px;
        }
        
        img {
            transform: scale(1);
            border-radius: 50%;
            transition-duration: 0.5s;
        }
        
        img:hover {
            transform: scale(1.2);
            border-radius: 0px;
            transition-duration: 0.5s;
        }
    </style>
</head>

<body>
<br/>
    <div class="container  ">
        <div class="row">
            <div class="col-12 ">
                <div id="demo" class="carousel slide" data-ride="carousel">


                    <ul class="carousel-indicators">
                        <li data-target="#demo" data-slide-to="0" class="active"></li>
                        <li data-target="#demo" data-slide-to="1"></li>
                        <li data-target="#demo" data-slide-to="2"></li>
                    </ul>


                    <div class="carousel-inner">
                        <div class="carousel-item active h1">
                        </div>
                        <div class="carousel-item h2 ">

                        </div>
                        <div class="carousel-item h3">


                        </div>

                    </div>


                    <a class="carousel-control-prev" href="#demo" data-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </a>
                    <a class="carousel-control-next" href="#demo" data-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </a>
                </div>
            </div>
        </div>



    </div>


    <div class="container mt-3">
        <h2 class="text-center">Hệ thống có gì khác biệt ?</h2>
        <div class="row">

            <div class="col-5 h4">

            </div>
            <div class="col-6">
                <p>Với những web quản lý phòng net hiện nay, mỗi cơ sở sẽ có một hệ thống quản lý riêng . Nếu đơn giản là những phòng net có quy mô nhỏ thì sẽ phù hợp nhưng để quản lý với những chuỗi phòng net có quy mô lớn thì khó có thể áp dụng. Điểm mới
                    của hệ thống này là dễ dàng trong việc quản lý, thực hiện các công việc thống kê doanh thu một cách nhanh chóng hiệu quả thay vì phải đến từng cơ sở để thu thập dữ liệu.</p>

            </div>
        </div>
    </div>

    <div class="container border-top mt-3">
        <h4 class="text-center ">THÀNH VIÊN DỰ ÁN</h4>
        <br/>
        <div class="row d-flex justify-content-center  mx-2 text-center">


            <div class="col-2">
                <img src="images/tung.jpg" alt="Generic placeholder image" style="width: 150px; height: 150px"><br/><br/>
                <div class="mt-2">
                    <h6><b>Trần Thanh Tùng</b></h6>
                    <h6 class="text-muted">Fast Track</h6>
                </div>

            </div>
            <div class="col-2">
                <img  src="images/minh.jpg" alt="Generic placeholder image" style="width: 150px; height: 150px"><br/><br/>
                <div class="mt-2">
                    <h6><b>Trần Hồng Minh</b></h6>
                    <h6 class="text-muted">ĐH Khoa học Huế</h6>
                </div>


            </div>
            <div class="col-2">
                <img src="images/hien.jpg" alt="Generic placeholder image" style="width: 150px; height: 150px"><br/><br/>
                <div class="mt-2">
                    <h6><b>Phùng Thị Hiền</b></h6>
                    <h6 class="text-muted te">ĐH Khoa học Huế</h6>
                </div>

            </div>
            <div class="col-2">
                <img  src="images/vy.jpg" alt="Generic placeholder image" style="width: 150px; height: 150px"><br/><br/>
                <div class="mt-2">
                    <h6><b>Nguyễn Phương Vy</b></h6>
                    <h6 class="text-muted">ĐH Phạm Văn Đồng</h6>
                </div>
            </div>
            <div class="col-2">
                <img src="images/linh.jpg" alt="Generic placeholder image" style="width: 150px; height: 150px"><br/><br/>
                <div class="mt-2">
                    <h6><b>Nguyễn Thị Linh</b></h6>
                    <h6 class="text-muted">ĐH Sư phạm Đà Nẵng</h6>
                </div>
            </div>
        </div>

       
    </div>


