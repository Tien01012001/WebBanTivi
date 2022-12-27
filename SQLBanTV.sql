create database BanHang
go
USE [BanHang]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](1000) NULL,
	[icon] [nvarchar](1000) NULL,
	PRIMARY KEY CLUSTERED ([CategoryID] ASC)
);
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](1000) NULL,
	[Description] [nvarchar](2000) NULL,
	[Price] [float] NULL,
	[imageLink] [nvarchar](1000) NULL,
	[CategoryID] [int] NULL,
	[Amount] [int] NULL,
	[Stoke] [int] NULL,
    PRIMARY KEY CLUSTERED ([ProductID] ASC),
    FOREIGN KEY ([CategoryID]) REFERENCES [dbo].[Category] ([CategoryID])
);
GO

CREATE TABLE [dbo].[Ship](
	[CityName] [nvarchar](1000) NOT NULL,
	[ShipPrice] [int] NULL)
	
Go
CREATE TABLE [dbo].[Users](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](500) NULL,
	[Password] [nvarchar](1000) NULL,
	[isAdmin] [int] NULL,
	PRIMARY KEY CLUSTERED ([UserID] ASC)
);
GO

CREATE TABLE [dbo].[Orders](
 [id] [int]  NOT NULL,
 [u_id] [int] NULL,
 [total] [float] NULL,
 [phuong_thuc_thanh_toan] [nvarchar](50) NULL,
 [so_dien_thoai] [varchar] (50) NULL,
 [dia_chi_nhan] [nvarchar](50) NOT NULL,
 [ngay_mua] [date] NOT NULL,
 [trang_thai] [nvarchar] (50) Not null
 PRIMARY KEY CLUSTERED ([id] ASC),
 FOREIGN KEY ([u_id]) REFERENCES [dbo].[Users] ([UserID])
);

go
CREATE TABLE [dbo].[OrderItem](
 [id] [int] IDENTITY(1,1) NOT NULL,
 [quantity] [int] NULL,
 [unitPrice] [float] NULL,
 [pro_id] [int] NOT NULL,
 [order_id] [int] NOT NULL,
 PRIMARY KEY CLUSTERED ([id] ASC),
 FOREIGN KEY ([pro_id]) REFERENCES [dbo].[Product] ([ProductID]),
 FOREIGN KEY ([order_id]) REFERENCES [dbo].[Orders] ([id])
);

go
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (1, N'LG', N'https://cdn.tgdd.vn/Products/Images/1942/236884/tv-led-lg-55up7550ptc-2.jpg')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (2, N'Panasonic', N'https://cdn.tgdd.vn/Products/Images/1942/73541/tivi-panasonic-th-40c400v-1-org-1.jpg')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (3, N'SamSung', N'https://cdn.tgdd.vn/Products/Images/1942/235792/led-4k-samsung-ua55au8100-2.jpg')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (4, N'TCL', N'https://cdn.tgdd.vn/Products/Images/1942/238554/led-tcl-l43s5200-1-org.jpg')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (5, N'Sony', N'https://cdn.tgdd.vn/Products/Images/1942/238884/led-sony-kd-55x85j-2.jpg')

SET IDENTITY_INSERT [dbo].[Category] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID],[Amount],[Stoke]) VALUES (1, N'Smart Tivi LG 4K 55 inch 55UP7550PTC ', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 13900, N'https://cdn.tgdd.vn/Products/Images/1942/236884/tv-led-lg-55up7550ptc-2.jpg', 1, 1,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (2, N'Smart Tivi LG 4K 43 inch 43UP7750PTB', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 10900, N'https://cdn.tgdd.vn/Products/Images/1942/236886/led-lg-43up7750ptb-2.jpg', 1, 90,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (3, N'Smart Tivi LG 4K 55 inch 55UP7750PTB', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 14700, N'https://cdn.tgdd.vn/Products/Images/1942/236888/1-1-org-org.jpg', 1, 21,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (4, N'Smart Tivi NanoCell LG 4K 55 inch 55NANO75TPA', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 174000, N'https://cdn.tgdd.vn/Products/Images/1942/236895/nanocell-lg-55nano75tpa-2.jpg', 1, 50,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID],[Amount],[Stoke]) VALUES (5, N'Smart Tivi LG 4K 43 inch 43UP7550PTC', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 9900, N'https://cdn.tgdd.vn/Products/Images/1942/236882/tv-led-lg-43up7550ptc-1-1.jpg', 1,68,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (6, N'Tivi Panasonic 40 inch TH-40C400V', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 11900, N'https://cdn.tgdd.vn/Products/Images/1942/73541/tivi-panasonic-th-40c400v-1-org-1.jpg',2, 20,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (7, N'Tivi Panasonic 32 inch TH-32E400V', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 13000, N'https://cdn.tgdd.vn/Products/Images/1942/146061/panasonic-th-32e400v-1-550x340.jpg', 2, 20,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID],  [Amount],[Stoke]) VALUES (8, N'Tivi Panasonic 49 inch TH-49E410V', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 1270, N'https://cdn.tgdd.vn/Products/Images/1942/101529/tivi-panasonic-th-49e410v-org-1-org.jpg', 2, 80,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (9, N'Smart Tivi Panasonic 43 inch TH-43DS630V', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 11000, N'https://cdn.tgdd.vn/Products/Images/1942/75566/tivi-panasonic-th-43ds630v-1-org-1.jpg', 2, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (10, N'Smart Tivi Panasonic 55 inch TH-55DS630V', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 8700, N'https://cdn.tgdd.vn/Products/Images/1942/75571/tivi-panasonic-55-inch-th-55ds630v-2-org-1.jpg', 2,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (11, N'Smart Tivi Samsung 4K Crystal UHD 55 inch UA55AU8100', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 15300, N'https://cdn.tgdd.vn/Products/Images/1942/235792/led-4k-samsung-ua55au8100-2.jpg', 3, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID],[Amount],[Stoke]) VALUES (12, N'Smart Tivi QLED 4K 55 inch Samsung QA55Q65A', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 17600, N'https://cdn.tgdd.vn/Products/Images/1942/235642/qled-4k-samsung-qa55q65a-2.jpg', 3,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (13, N'Smart Tivi QLED 4K 43 inch Samsung QA43Q65A', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 13800, N'https://cdn.tgdd.vn/Products/Images/1942/235640/qled-4k-samsung-qa43q65a-2.jpg', 3,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (14, N'Smart Tivi Samsung 32 inch UA32T4500', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 7900, N'https://cdn.tgdd.vn/Products/Images/1942/219392/ua32t4500-org.jpg', 3,99,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (15, N'Smart Tivi QLED 4K 55 inch Samsung QA55Q60B', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 19100, N'https://cdn.tgdd.vn/Products/Images/1942/273925/qa65q60bakxxd_001_front1_black_above.jpg', 3, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (16, N'Google Tivi QLED TCL 4K 43 inch 43Q636 ', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 10990, N'https://cdn.tgdd.vn/Products/Images/1942/276068/google-tcl-4k-43-inch-43q636-1.jpg', 4, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (17, N'Android Tivi TCL 43 inch L43S5200', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 7290, N'https://cdn.tgdd.vn/Products/Images/1942/238554/led-tcl-l43s5200-1-org.jpg', 4,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (18, N'Google Tivi TCL 4K 43 inch 43P635', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 8590, N'https://cdn.tgdd.vn/Products/Images/1942/281934/google-tcl-4k-43-inch-43p635-01.jpg', 4, 99,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (19, N'Google Tivi QLED TCL 4K 55 inch 55Q636', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 17490, N'https://cdn.tgdd.vn/Products/Images/1942/276071/google-tcl-4k-55-inch-55q636-1.jpg', 4, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (20, N'Android Tivi TCL 4K 65 inch 65P615 ', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 15990, N'https://cdn.tgdd.vn/Products/Images/1942/225956/tcl-65p615-1-1-org.jpg', 4, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (21, N'Google Tivi TCL 4K 75 inch 75P635', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 25990, N'https://cdn.tgdd.vn/Products/Images/1942/285049/google-tcl-4k-75-inch-75p635.jpg', 4,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (22, N'Google Tivi Sony 4K 55 inch KD-55X75K', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 15900, N'https://cdn.tgdd.vn/Products/Images/1942/275512/untitled-1-1.jpg', 5, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (23, N'Google Tivi Sony 4K 43 inch KD-43X75K', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 12900, N'https://cdn.tgdd.vn/Products/Images/1942/275517/google-sony-4k-43-inch-kd-43x75k-1.jpg', 5,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (24, N'Google Tivi Sony 32 inch KD-32W830K ', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 8200, N'https://cdn.tgdd.vn/Products/Images/1942/277446/sony-2k-32inch-kd-32w830k-1.jpg', 5,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (25, N'Android Tivi Sony 4K 55 inch KD-55X85J', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 15900, N'https://cdn.tgdd.vn/Products/Images/1942/238884/led-sony-kd-55x85j-2.jpg', 5,100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [Amount],[Stoke]) VALUES (26, N'Android Tivi Sony 4K 50 inch KD-50X75', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 13400, N'https://cdn.tgdd.vn/Products/Images/1942/238721/Slider/vi-vn-vi-vn-led-sony-kd-50x75.jpg', 5, 100,50)


SET IDENTITY_INSERT [dbo].[Product] OFF
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'Biên Hòa', 45000)
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'Cần Thơ', 80000)
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'Đà Nẵng', 70000)
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'Hà Nội', 90000)
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'Hải Phòng', 40000)
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'Nha Trang', 90000)
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'TP Hồ Chí Minh', 50000)
INSERT [dbo].[Ship] ([CityName], [ShipPrice]) VALUES (N'Việt Trì', 20000)
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([UserID], [Username], [Password],  [isAdmin]) VALUES (1, N'admin', N'123456', 1)
INSERT [dbo].[Users] ([UserID], [Username], [Password],  [isAdmin]) VALUES (2, N'user', N'123456', 0)
SET IDENTITY_INSERT [dbo].[Users] OFF


GO

USE [master]
GO
ALTER DATABASE [BanHang] SET  READ_WRITE 
GO
