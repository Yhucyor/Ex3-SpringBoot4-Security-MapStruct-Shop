-- Seed data cho bảng categories
SET IDENTITY_INSERT [dbo].[categories] ON;
GO

INSERT INTO [dbo].[categories] ([id], [name], [description], [image_url], [image_public_id], [enabled])
VALUES 
(101, N'Điện thoại', N'Các loại điện thoại thông minh mới nhất', 'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?q=80&w=800', NULL, 1),
(102, N'Laptop', N'Laptop văn phòng và gaming', 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?q=80&w=800', NULL, 1),
(103, N'Máy tính bảng', N'Máy tính bảng chính hãng', 'https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?q=80&w=800', NULL, 1),
(104, N'Phụ kiện', N'Tai nghe, cáp sạc, ốp lưng', 'https://images.unsplash.com/photo-1583394838336-acd977736f90?q=80&w=800', NULL, 1),
(105, N'Đồng hồ thông minh', N'Đồng hồ theo dõi sức khỏe', 'https://images.unsplash.com/photo-1508685096489-7aacd43bd3b1?q=80&w=800', NULL, 1);
GO

SET IDENTITY_INSERT [dbo].[categories] OFF;
GO

-- Seed data cho bảng products
-- Giả sử user_id = 1 đã tồn tại trong bảng users (Admin hoặc User test)
SET IDENTITY_INSERT [dbo].[products] ON;
GO

INSERT INTO [dbo].[products] ([id], [name], [description], [price], [image_url], [user_id], [category_id], [created_at])
VALUES 
(101, N'iPhone 15 Pro Max', N'Apple iPhone 15 Pro Max 256GB Titanium', 34990000, 'https://images.unsplash.com/photo-1696446701796-da61225697cc?q=80&w=800', 1, 101, GETDATE()),
(102, N'Samsung Galaxy S24 Ultra', N'Samsung Galaxy S24 Ultra 5G 256GB', 33990000, 'https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?q=80&w=800', 1, 101, GETDATE()),
(103, N'MacBook Pro 14 inch M3', N'Apple MacBook Pro 14 M3 8-core CPU 10-core GPU 8GB 512GB', 39990000, 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8?q=80&w=800', 1, 102, GETDATE()),
(104, N'Dell XPS 15 9530', N'Dell XPS 15 9530 Core i7-13700H / 16GB / 512GB', 45990000, 'https://images.unsplash.com/photo-1593642632823-8f785ba67e45?q=80&w=800', 1, 102, GETDATE()),
(105, N'iPad Pro 11 inch M2', N'Apple iPad Pro 11 inch M2 Wi-Fi 128GB', 20990000, 'https://images.unsplash.com/photo-1588702545851-9366df041088?q=80&w=800', 1, 103, GETDATE()),
(106, N'AirPods Pro 2', N'Tai nghe Bluetooth Apple AirPods Pro 2 MagSafe (USB-C)', 6190000, 'https://images.unsplash.com/photo-1600294037681-c80b4cb5b434?q=80&w=800', 1, 104, GETDATE()),
(107, N'Cáp sạc Anker Type-C', N'Cáp sạc Anker 322 Type-C to Type-C 60W Dài 1.8m', 150000, 'https://images.unsplash.com/photo-1583863788434-e58a36330cf0?q=80&w=800', 1, 104, GETDATE()),
(108, N'Apple Watch Series 9', N'Apple Watch Series 9 GPS 41mm Viền nhôm', 9890000, 'https://images.unsplash.com/photo-1434493789847-2f02dc6ca35d?q=80&w=800', 1, 105, GETDATE());
GO

SET IDENTITY_INSERT [dbo].[products] OFF;
GO
