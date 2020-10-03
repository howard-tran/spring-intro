** Một số quy ước **

Project: 
  - toàn bộ các package cần đã được include trong file pom.xml
  - chạy lệnh 'mvn clean compile' để get các package về  r import vào ide, ko cần setup
  - chạy lệnh 'mongorestore {yourProjectPath}/data' để backup data

Project được chia làm 3 lớp:
  - Lớp DAO:
    + tập hợp những class đảm nhiệm vai trò giao tiếp với database 
    + một class trong DAO xử lý trên một collection trong dtb
  - Lớp Service
    + tập hợp các class để xử lý nghiệp vụ cho front-end
    + không nên chứa code có thể query dữ liệu
    + nếu cần lấy dữ liệu của 1 bảng thì gọi class DAO của bảng đó
  - Lớp Controller
    + xử lý các request từ client, lấy xử liệu đã đc xử lý từ lớp service, trả về cho client

MongoDB:
  - một bảng dữ liệu đc gọi là collection 
  - từng dòng trong bảng gọi là document
  - sử dụng driver 'mongo-java-driver' bản 3.12.7 (có trong pom.xml)
  - cách truy vấn (tham khảo source code, lớp DAO)

Cơ chế Logging:
  - ứng dụng chạy trên servẻ có thể gặp lỗi
  - Logging là cơ chế để lưu lỗi lại vào một file, cụ thể trong project là '/src/main/resources/logs/project.log'
  - Log lại lỗi để nếu server sập, ta có thể truy vết để tìm lỗi
  - Sử dụng thư việc Log4J để làm
  - Trong project, tập trung bắt lỗi và log ở lớp Service
  - cách Log error (tham khảo source code, lớp Service)

Lỗi port server:
  - server mặc định mở port 5000 trên máy
  - nếu port bận, chỉnh lại port khác trong file application.yml

Deadline:
  - 2 tuần nữa :)))

** ========================= **
