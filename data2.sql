USE [QlQuanNet_Team09]
GO
/****** Object:  Table [dbo].[ADMIN_]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ADMIN_](
	[taiKhoan] [nvarchar](50) NULL,
	[matKhau] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CHITIETDONHANG]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETDONHANG](
	[iDDonHang] [bigint] NOT NULL,
	[iDDV] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[thanhTien] [float] NULL,
 CONSTRAINT [PK_CHITIETDONHANG] PRIMARY KEY CLUSTERED 
(
	[iDDonHang] ASC,
	[iDDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DICHVU]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DICHVU](
	[iDDV] [nvarchar](50) NOT NULL,
	[tenDV] [nvarchar](50) NULL,
	[gia] [float] NULL,
	[iDLoaiDV] [nvarchar](50) NULL,
	[donViTinh] [nvarchar](50) NULL,
 CONSTRAINT [PK_DICHVU] PRIMARY KEY CLUSTERED 
(
	[iDDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[iDKhach] [nvarchar](50) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
	[userName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[soTienTrongTK] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KHNAPTIEN]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHNAPTIEN](
	[userName] [nvarchar](50) NULL,
	[soTien] [float] NULL,
	[ngayNap] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[LOAIDICHVU]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAIDICHVU](
	[iDLoaiDV] [nvarchar](50) NOT NULL,
	[loaiDichVu] [nvarchar](50) NULL,
 CONSTRAINT [PK_LOAIDICHVU] PRIMARY KEY CLUSTERED 
(
	[iDLoaiDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MAY]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAY](
	[iDMay] [nvarchar](50) NOT NULL,
	[iDPhong] [nvarchar](50) NOT NULL,
	[soGioSuDung] [float] NULL,
	[trangThaiHuHong] [nvarchar](50) NULL,
 CONSTRAINT [PK_MAY_1] PRIMARY KEY CLUSTERED 
(
	[iDMay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[iDNV] [nvarchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[iDPhong] [nvarchar](50) NOT NULL,
	[luong] [float] NULL,
	[sdt] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[taiKhoan] [nvarchar](50) NULL,
	[matKhau] [nvarchar](50) NULL,
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[iDNV] ASC,
	[iDPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PHONG]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONG](
	[iDPhong] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_PHONG] PRIMARY KEY CLUSTERED 
(
	[iDPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SDDV]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SDDV](
	[iDDonHang] [bigint] IDENTITY(1,1) NOT NULL,
	[tenKhach] [nvarchar](50) NOT NULL,
	[trangThaiXuLy] [nvarchar](50) NULL,
	[tongTien] [float] NULL,
	[iDPhong] [nvarchar](50) NULL,
	[ngaySuDung] [nvarchar](50) NULL,
 CONSTRAINT [PK_SDDV] PRIMARY KEY CLUSTERED 
(
	[iDDonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SDMAY]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SDMAY](
	[iDMay] [nvarchar](50) NULL,
	[userName] [nvarchar](50) NULL,
	[gioBatDau] [nvarchar](50) NULL,
	[gioKetThuc] [nvarchar](50) NULL,
	[soGio] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  View [dbo].[View_ChiTietDichVu]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_ChiTietDichVu]
AS
SELECT        dbo.CHITIETDONHANG.iDDV, dbo.DICHVU.tenDV, dbo.DICHVU.gia, dbo.DICHVU.donViTinh, dbo.CHITIETDONHANG.soLuong, dbo.CHITIETDONHANG.thanhTien, dbo.CHITIETDONHANG.iDDonHang
FROM            dbo.CHITIETDONHANG INNER JOIN
                         dbo.DICHVU ON dbo.CHITIETDONHANG.iDDV = dbo.DICHVU.iDDV

GO
/****** Object:  View [dbo].[View_ThanhToan]    Script Date: 5/3/2019 8:31:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_ThanhToan]
AS
SELECT        dbo.SDDV.iDDonHang, dbo.KHACHHANG.hoTen, dbo.SDDV.tongTien, dbo.SDDV.trangThaiXuLy, dbo.KHACHHANG.userName
FROM            dbo.SDDV INNER JOIN
                         dbo.KHACHHANG ON dbo.SDDV.tenKhach = dbo.KHACHHANG.userName

GO
INSERT [dbo].[ADMIN_] ([taiKhoan], [matKhau]) VALUES (N'Admin', N'123')
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (56, N'DV003', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (56, N'DV02', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (56, N'DV06', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (57, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (57, N'DV003', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (57, N'DV02', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (58, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (58, N'DV01', 1, 12000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (58, N'DV05', 1, 50000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (59, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (59, N'DV003', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (59, N'DV04', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (59, N'DV06', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (60, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (61, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (61, N'DV003', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (62, N'DV001', 2, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (62, N'DV003', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (62, N'DV05', 1, 50000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (63, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (63, N'DV05', 1, 50000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (63, N'DV06', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (64, N'DV002', 2, 24000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (64, N'DV01', 1, 12000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (65, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (66, N'DV03', 1, 12000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (66, N'DV05', 1, 50000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (67, N'DV05', 1, 50000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (68, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (68, N'DV05', 1, 50000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (69, N'DV002', 1, 12000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (69, N'DV06', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (70, N'DV003', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (70, N'DV05', 1, 50000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (71, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (72, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (72, N'DV003', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (73, N'DV02', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (74, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (75, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (75, N'DV01', 1, 12000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (75, N'DV03', 1, 12000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (75, N'DV04', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (76, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (76, N'DV01', 1, 12000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (76, N'DV04', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (76, N'DV06', 1, 20000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (77, N'DV001', 1, 10000)
INSERT [dbo].[CHITIETDONHANG] ([iDDonHang], [iDDV], [soLuong], [thanhTien]) VALUES (78, N'DV03', 1, 12000)
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV001', N'Nước suối', 10000, NULL, N'Chai')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV002', N'Nước ngọt', 12000, NULL, N'Lon')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV003', N'Thuốc lá', 20000, NULL, N'Gói')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV01', N'Coca', 12000, N'Loai1', N'lon')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV02', N'Coffee đen', 10000, N'Loai1', N'ly')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV03', N'Coffee sữa', 12000, N'Loai1', N'ly')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV04', N'Thuốc lá', 20000, N'Loai3', N'gói')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV05', N'Zing 50k', 50000, N'Loai4', N'thẻ')
INSERT [dbo].[DICHVU] ([iDDV], [tenDV], [gia], [iDLoaiDV], [donViTinh]) VALUES (N'DV06', N'Mì xào', 20000, N'Loai2', N'đĩa')
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH001', N'Trần Thanh Tùng', N'tung1234', N'232397', 385000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH002', N'Long Rô Phi', N'lollol', N'123123', 2030000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH004', N'Trần Tuấn Anh', N'tuananh123', N'123456', 220000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH007', N'Ngô Quyễn', N'quyenquyen', N'123456', 140000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH009', N'Trầm Tùng', N'tungtram', N'123456', 145000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH01', N'Nguyễn Văn A', N'nguyenvanA', N'123', 153000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH02', N'Nguyễn Văn B', N'nguyenvanB', N'456', 270000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH020', N'Chu Đạt', N'datchu', N'123456', 180000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH040', N'Nguyễn Tuấn Anh', N'tuanNguyen', N'123456', 60000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH041', N'David Copperfield', N'daphield', N'123456', 170000)
INSERT [dbo].[KHACHHANG] ([iDKhach], [hoTen], [userName], [password], [soTienTrongTK]) VALUES (N'KH111', N'Michel Owen', N'owen', N'123', 150000)
INSERT [dbo].[KHNAPTIEN] ([userName], [soTien], [ngayNap]) VALUES (N'daphield', 120000, N'2019-03-04')
INSERT [dbo].[KHNAPTIEN] ([userName], [soTien], [ngayNap]) VALUES (N'tuananh123', 120000, N'2019-03-04')
INSERT [dbo].[KHNAPTIEN] ([userName], [soTien], [ngayNap]) VALUES (N'quyenquyen', 60000, N'2019-03-04')
INSERT [dbo].[KHNAPTIEN] ([userName], [soTien], [ngayNap]) VALUES (N'tung1234', 120000, N'2019-03-04')
INSERT [dbo].[LOAIDICHVU] ([iDLoaiDV], [loaiDichVu]) VALUES (N'Loai1', N'Đồ uống')
INSERT [dbo].[LOAIDICHVU] ([iDLoaiDV], [loaiDichVu]) VALUES (N'Loai2', N'Đồ ăn')
INSERT [dbo].[LOAIDICHVU] ([iDLoaiDV], [loaiDichVu]) VALUES (N'Loai3', N'Thuốc lá')
INSERT [dbo].[LOAIDICHVU] ([iDLoaiDV], [loaiDichVu]) VALUES (N'Loai4', N'Thẻ game')
INSERT [dbo].[MAY] ([iDMay], [iDPhong], [soGioSuDung], [trangThaiHuHong]) VALUES (N'M001', N'P001', 0.5, N'Không')
INSERT [dbo].[MAY] ([iDMay], [iDPhong], [soGioSuDung], [trangThaiHuHong]) VALUES (N'M002', N'P001', 1.5, N'Không')
INSERT [dbo].[MAY] ([iDMay], [iDPhong], [soGioSuDung], [trangThaiHuHong]) VALUES (N'M003', N'P002', 2, N'Không')
INSERT [dbo].[NHANVIEN] ([iDNV], [ten], [iDPhong], [luong], [sdt], [diaChi], [taiKhoan], [matKhau]) VALUES (N'NV001', N'Tùng đẹp trai', N'P001', 2000, N'09087888432', N'Sơn Trà Đà Nẵng', N'tungtung', N'a')
INSERT [dbo].[NHANVIEN] ([iDNV], [ten], [iDPhong], [luong], [sdt], [diaChi], [taiKhoan], [matKhau]) VALUES (N'NV002', N'Minh', N'P002', 2000, N'123456789', N'Lào', NULL, NULL)
INSERT [dbo].[NHANVIEN] ([iDNV], [ten], [iDPhong], [luong], [sdt], [diaChi], [taiKhoan], [matKhau]) VALUES (N'NV003', N'Hiền', N'P003', 2000, N'234567890', N'Campuchia', NULL, NULL)
INSERT [dbo].[NHANVIEN] ([iDNV], [ten], [iDPhong], [luong], [sdt], [diaChi], [taiKhoan], [matKhau]) VALUES (N'NV004', N'Vy', N'P001', 2000, N'345678910', N'Quảng Ngãi', NULL, NULL)
INSERT [dbo].[NHANVIEN] ([iDNV], [ten], [iDPhong], [luong], [sdt], [diaChi], [taiKhoan], [matKhau]) VALUES (N'NV005', N'Linh', N'P001', 2000, N'456789101', N'Quảng Quảng', NULL, NULL)
INSERT [dbo].[PHONG] ([iDPhong], [diaChi], [soLuong]) VALUES (N'P001', N'Ðà N?ng', 19)
INSERT [dbo].[PHONG] ([iDPhong], [diaChi], [soLuong]) VALUES (N'P002', N'Hu?', 10)
INSERT [dbo].[PHONG] ([iDPhong], [diaChi], [soLuong]) VALUES (N'P003', N'Lào', 6)
INSERT [dbo].[PHONG] ([iDPhong], [diaChi], [soLuong]) VALUES (N'P090', N'Son Trà', 33)
SET IDENTITY_INSERT [dbo].[SDDV] ON 

INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (56, N'tung1234', N'2', 50000, N'P001', N'2019-03-01')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (57, N'tung1234', N'2', 40000, N'P001', N'2019-03-03')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (58, N'tung1234', N'2', 72000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (59, N'tung1234', N'2', 70000, N'P001', N'2019-03-04')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (60, N'tung1234', N'2', 10000, N'P001', N'2019-03-06')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (61, N'tung1234', N'2', 30000, N'P001', N'2019-03-02')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (62, N'tung1234', N'2', 90000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (63, N'tungtram', N'2', 80000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (64, N'tungtram', N'2', 36000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (65, N'tungtram', N'2', 10000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (66, N'tungtram', N'2', 62000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (67, N'tungtram', N'2', 50000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (68, N'tungtram', N'2', 60000, N'P001', NULL)
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (69, N'tungtram', N'2', 32000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (70, N'tungtram', N'2', 70000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (71, N'tungtram', N'2', 10000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (72, N'tungtram', N'2', 30000, N'P001', N'2019-03-03')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (73, N'tungtram', N'2', 10000, N'P001', N'2019-03-08')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (74, N'tungtram', N'2', 10000, N'P001', N'2019-03-01')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (75, N'tungtram', N'2', 54000, N'P001', N'2019-03-09')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (76, N'tungtram', N'2', 62000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (77, N'tungtram', N'2', 10000, N'P001', N'2019-03-05')
INSERT [dbo].[SDDV] ([iDDonHang], [tenKhach], [trangThaiXuLy], [tongTien], [iDPhong], [ngaySuDung]) VALUES (78, N'tung1234', N'2', 12000, N'P001', N'2019-03-05')
SET IDENTITY_INSERT [dbo].[SDDV] OFF
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M003', N'tungtram', N'Tue Mar 05 05:47:17 ICT 2019', N'Tue Mar 05 05:47:23 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M003', N'tuant', N'Sun Mar 03 16:48:47 ICT 2019', N'Sun Mar 03 16:49:18 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M001', N'tung1234', N'Mon Mar 04 00:56:01 ICT 2019', N'Mon Mar 04 00:57:43 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M001', N'tungtram', N'Tue Mar 05 00:38:16 ICT 2019', N'Tue Mar 05 00:44:45 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M002', N'tungtram', N'Tue Mar 05 01:02:46 ICT 2019', N'Tue Mar 05 01:05:03 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M001', N'tungtram', N'Tue Mar 05 08:23:00 ICT 2019', N'Tue Mar 05 08:25:44 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M003', N'tung1234', N'Mon Mar 04 05:40:39 ICT 2019', N'Mon Mar 04 05:48:15 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M003', N'tungtram', N'Tue Mar 05 01:55:05 ICT 2019', N'Tue Mar 05 01:56:08 ICT 2019', 0.5)
INSERT [dbo].[SDMAY] ([iDMay], [userName], [gioBatDau], [gioKetThuc], [soGio]) VALUES (N'M002', N'tung1234', N'Tue Mar 05 08:26:56 ICT 2019', NULL, NULL)
ALTER TABLE [dbo].[CHITIETDONHANG]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETDONHANG_DICHVU] FOREIGN KEY([iDDV])
REFERENCES [dbo].[DICHVU] ([iDDV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CHITIETDONHANG] CHECK CONSTRAINT [FK_CHITIETDONHANG_DICHVU]
GO
ALTER TABLE [dbo].[CHITIETDONHANG]  WITH CHECK ADD  CONSTRAINT [FK_CHITIETDONHANG_SDDV] FOREIGN KEY([iDDonHang])
REFERENCES [dbo].[SDDV] ([iDDonHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CHITIETDONHANG] CHECK CONSTRAINT [FK_CHITIETDONHANG_SDDV]
GO
ALTER TABLE [dbo].[DICHVU]  WITH CHECK ADD  CONSTRAINT [FK_DICHVU_LOAIDICHVU] FOREIGN KEY([iDLoaiDV])
REFERENCES [dbo].[LOAIDICHVU] ([iDLoaiDV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DICHVU] CHECK CONSTRAINT [FK_DICHVU_LOAIDICHVU]
GO
ALTER TABLE [dbo].[MAY]  WITH CHECK ADD  CONSTRAINT [FK_MAY_PHONG] FOREIGN KEY([iDPhong])
REFERENCES [dbo].[PHONG] ([iDPhong])
GO
ALTER TABLE [dbo].[MAY] CHECK CONSTRAINT [FK_MAY_PHONG]
GO
ALTER TABLE [dbo].[NHANVIEN]  WITH CHECK ADD  CONSTRAINT [FK_NHANVIEN_PHONG] FOREIGN KEY([iDPhong])
REFERENCES [dbo].[PHONG] ([iDPhong])
GO
ALTER TABLE [dbo].[NHANVIEN] CHECK CONSTRAINT [FK_NHANVIEN_PHONG]
GO
ALTER TABLE [dbo].[SDMAY]  WITH CHECK ADD  CONSTRAINT [FK_SDMAY_MAY] FOREIGN KEY([iDMay])
REFERENCES [dbo].[MAY] ([iDMay])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SDMAY] CHECK CONSTRAINT [FK_SDMAY_MAY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[30] 4[32] 2[21] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "SDDV"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 150
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "KHACHHANG"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 150
               Right = 416
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ThanhToan'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_ThanhToan'
GO
