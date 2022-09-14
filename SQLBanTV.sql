
USE [BanHang2]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 9/30/2021 8:58:50 AM ******/

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](1000) NULL,
	[icon] [nvarchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Information]    Script Date: 9/30/2021 8:58:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Information](
	[description] [nvarchar](max) NULL,
	[address] [nvarchar](max) NULL,
	[email] [nvarchar](max) NULL,
	[phone] [nvarchar](max) NULL,
	[fax] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 9/30/2021 8:58:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](1000) NULL,
	[Description] [nvarchar](2000) NULL,
	[Price] [int] NULL,
	[imageLink] [nvarchar](1000) NULL,
	[CategoryID] [int] NULL,
	[SellerID] [int] NULL,
	[Amount] [int] NULL,
	[Stoke] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Ship](
	[CityName] [nvarchar](1000) NOT NULL,
	[ShipPrice] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[CityName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[Users](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](500) NULL,
	[Password] [nvarchar](1000) NULL,
	[isSeller] [int] NULL,
	[isAdmin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[Cart](
 [id] [varchar](50) NOT NULL,
 [u_id] [int] NOT NULL,
 [buyDate] [date] NULL,
 CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED 
(
 [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CartItem](
 [id] [varchar](50) NOT NULL,
 [quantity] [int] NULL,
 [unitPrice] [float] NULL,
 [pro_id] [int] NOT NULL,
 [cat_id] [varchar](50) NOT NULL,
 CONSTRAINT [PK_CartItem] PRIMARY KEY CLUSTERED 
(
 [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (1, N'Quần Áo Nam', N'<i class="fa fa-check-circle"></i>')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (2, N'Quần Áo Nữ', N'<i class="fa fa-check-circle"></i>')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (3, N'Quần Áo Trẻ Em', N'<i class="fa fa-check-circle"></i>')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (4, N'Quần Áo Quá Cỡ', N'<i class="fa fa-check-circle"></i>')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (5, N'Quần Áo Thể Thao', N'<i class="fa fa-check-circle"></i>')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (6, N'Phụ Kiện Thời Trang', N'<i class="fa fa-check-circle"></i>')
INSERT [dbo].[Category] ([CategoryID], [CategoryName], [icon]) VALUES (7, N'Giầy Dép Thời Trang', N'<i class="fa fa-check-circle"></i>')
SET IDENTITY_INSERT [dbo].[Category] OFF
INSERT [dbo].[Information] ([description], [address], [email], [phone], [fax]) VALUES (N'© 2021 All Right', N'Số 8, Thủ Đức, Hồ Chí Minh', N'abc@gmail.com', N'1900 0000', N'1900 0000')
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (1, N'Quần nam thể thao ', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 649900, N'https://canary.contestimg.wish.com/api/webimage/6092b25f8dc7310066eea79c-large.jpg', 4, 1, 1,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (2, N'Bộ quần áo cá sấu', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 274990, N'https://canary.contestimg.wish.com/api/webimage/60ee87ac5f321f54b6515aa5-large.jpg', 1, 1, 90,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (3, N'Quần áo nam mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 206990, N'https://canary.contestimg.wish.com/api/webimage/5e0ef0cedcf6310abf715b17-5-large.jpg', 1, 1, 21,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (4, N'Áo nỉ nam Men2016hoodie', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 549900, N'https://canary.contestimg.wish.com/api/webimage/5ab073a32c3a2239348cba14-2-large.jpg', 1, 1, 50,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (5, N'Áo khoác Zipper Jumper Overcoat', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 136990, N'https://canary.contestimg.wish.com/api/webimage/5b9a2d4a46bc64663cb5126f-large.jpg', 2, 2, 68,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (6, N'Áo rời in hoa Áo ngoài', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 119000, N'https://canary.contestimg.wish.com/api/webimage/5d8ed5cc560ac82404ee7dbe-5-large.jpg', 4, 2, 20,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (7, N'Áo khoác bông dày dặn', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 104990, N'https://canary.contestimg.wish.com/api/webimage/5dbbcc952c5a280a8e910528-large.jpg', 2, 2, 20,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (8, N'Áo khoác dài tay', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 170990, N'https://canary.contestimg.wish.com/api/webimage/5d7e10301260da7f6e052af6-2-large.jpg', 2, 2, 80,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (9, N'Quần harem mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 171890, N'https://canary.contestimg.wish.com/api/webimage/5ecb237be281973f63794cd8-6-large.jpg', 1, 2, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (10, N'Áo khoác len Kẹo Màu', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 189890, N'https://canary.contestimg.wish.com/api/webimage/5d661b006732a72595dc376d-3-large.jpg', 1, 2, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (11, N'Bộ áo siêu nhân', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 189999, N'https://canary.contestimg.wish.com/api/webimage/6145e0e14cac6c51e7e7b863-3-large.jpg', 3, 2, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (12, N'Bộ đồ mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 169990, N'https://canary.contestimg.wish.com/api/webimage/5fc465efeddc46afcabffb3e-10-large.jpg', 3, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (13, N'Dress for Girls Summer', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 142890, N'https://canary.contestimg.wish.com/api/webimage/60e6a69fb1c252ccbb5d6b18-1-large.jpg', 3, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (14, N'Children''s Wear Printed Sports', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 162990, N'https://canary.contestimg.wish.com/api/webimage/61484e2803c2ea017374ecef-3-large.jpg', 3, 1, 99,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (15, N'Big and Tall t-shirt', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 112990, N'https://canary.contestimg.wish.com/api/webimage/60618cf215e17dc07c1b9e69-large.jpg', 1, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (16, N'Cà vạt mảnh, hạt', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 289990, N'https://canary.contestimg.wish.com/api/webimage/5b6314a8ce3cc813ca2cfb7a-large.jpg', 6, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (17, N'New Fashion Velvet Big Bowties for Women', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 177990, N'https://canary.contestimg.wish.com/api/webimage/5e9f993edf74d40042a23860-large.jpg', 6, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (18, N'Áo rời in hoa Áo ngoài', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 122990, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 1, 1, 99,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (19, N'Áo khoác lông cừu', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 182890, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 1, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (20, N'Quần áo nam mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 179990, N'https://canary.contestimg.wish.com/api/webimage/5e0ef0cedcf6310abf715b17-5-large.jpg', 1, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (21, N'Quần áo nam mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 102990, N'https://canary.contestimg.wish.com/api/webimage/5e0ef0cedcf6310abf715b17-5-large.jpg', 1, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (22, N'Áo rời in hoa Áo ngoài', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 140990, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 2, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (23, N'Bộ đồ mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 199990, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 2, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (24, N'Bộ đồ mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 159990, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 2, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (25, N'Áo khoác len Kẹo Màu', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 129990, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 2, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (26, N'Wedding Shoes Sandals', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 789990, N'https://canary.contestimg.wish.com/api/webimage/5d82e0a88d8e1f4697a9506c-large.jpg', 7, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (27, N'Quần harem mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 498900, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 2, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (28, N'Quần harem mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 269990, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 2, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (29, N'Áo khoác len Kẹo Màu', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 799900, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 2, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (75, N'Áo rời in hoa Áo ngoài', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 3000000, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 5, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (76, N'Quần harem mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 300000, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 5, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (77, N'Lace Flower Sandals', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 600000, N'https://canary.contestimg.wish.com/api/webimage/5d81e019ef464979cd3bed36-large.jpg', 7, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (78, N'Quần harem mùa hè', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 799900, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 5, 1, 100,50)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [Price], [imageLink], [CategoryID], [SellerID], [Amount],[Stoke]) VALUES (79, N'Áo khoác len Kẹo Màu', N'Chúng tôi luôn đưa đến cho khách hàng những sản phẩm nhập khẩu tốt nhất với quy trình sản xuất chuyên nghiệp:

 Hàng hóa nhập khẩu về VN được kiểm định chất lượng..', 159990, N'https://canary.contestimg.wish.com/api/webimage/601ecd5d51a0762d385a99fd-large.jpg', 5, 1, 100,50)
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

INSERT [dbo].[Users] ([UserID], [Username], [Password], [isSeller], [isAdmin]) VALUES (1, N'admin', N'123456', 1, 1)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [isSeller], [isAdmin]) VALUES (2, N'trungnh', N'123456', 1, 0)
INSERT [dbo].[Users] ([UserID], [Username], [Password], [isSeller], [isAdmin]) VALUES (3, N'trung', N'123456', 0, 0)
SET IDENTITY_INSERT [dbo].[Users] OFF


GO




USE [master]
GO
ALTER DATABASE [BanHang] SET  READ_WRITE 
GO
