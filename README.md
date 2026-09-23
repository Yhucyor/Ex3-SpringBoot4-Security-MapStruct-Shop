Nguyễn Trọng Thức 
2411349
## Đường dẫn truy cập

Ứng dụng mặc định chạy tại:
- User có quyền thêm và chỉnh sủa Product
- Admin có quyền chỉnh sửa Category và Product và Users
- Trang chủ: http://localhost:8080/
- Đăng nhập: http://localhost:8080/login
- Đăng ký: http://localhost:8080/register
- Xác thực OTP: http://localhost:8080/verify-otp
- Quên mật khẩu: http://localhost:8080/forgot-password
- Đặt lại mật khẩu: http://localhost:8080/reset-password

## Đường dẫn quản lý

Yêu cầu đăng nhập bằng tài khoản có quyền `ROLE_ADMIN`:

- Quản lý người dùng: http://localhost:8080/users
- Thêm người dùng: http://localhost:8080/users/create
- Quản lý sản phẩm: http://localhost:8080/products
- Thêm sản phẩm: http://localhost:8080/products/create

## Tài khoản kiểm tra

### Tài khoản quản trị viên

- Username: `admin`
- Password: `123456`
- Role: `ROLE_ADMIN`

Sau khi đăng nhập bằng tài khoản ADMIN, truy cập:

- http://localhost:8080/users
- http://localhost:8080/products

## Cơ sở dữ liệu

File khởi tạo cơ sở dữ liệu:

- `database/shop_database.sql`

Các bước thực hiện:

1. Mở SQL Server Management Studio.
2. Mở file `database/shop_database.sql`.
3. Nhấn **Execute** để tạo cấu trúc và dữ liệu mẫu.
4. Sao chép `.env.example` thành `.env`.
5. Cập nhật tài khoản kết nối SQL Server trong `.env`.
6. Khởi động ứng dụng.
7. Truy cập http://localhost:8080/login để đăng nhập.

## Chạy ứng dụng

### Windows PowerShell

```powershell
.\mvnw.cmd spring-boot:run