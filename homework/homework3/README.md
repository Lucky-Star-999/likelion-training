# Một số khái niệm
## Persistence layer
Persistence layer là tập hợp các class đại diện cho các thực thể dưới database. Giả sử dưới database có table Student thì ở Persistence layer, ta sẽ tạo ra 1 class có tên là Student, và nó sẽ đại diện cho table Student dưới database.

## JDBC
JDBC (Java Database Connectivity) là một API dùng để kết nối và thực thi các câu lệnh SQL xuống database. JDBC thuở xa xưa khá cực khổ và khô khan. Ngày nay Spring có JDBC dành cho Spring, gọi là Spring JDBC, cũng tiện lợi hơn một chút. JDBC quan trọng đến nỗi dù ta có sử dụng Hibernate, Spring Data JPA thì sau cùng code JDBC vẫn được tạo ra thôi.

## JPA
JPA (Java Persistence API) là giải pháp cho việc config cồng kềnh, các kiểu relationship giữa các table trong database và nhiều thứ khác. Hibernate lúc trước khi có JPA ứng dụng ORM, Hibernate ngày này ứng dụng thêm JPA và cả ORM trước đó.

## Spring Data JPA
Spring Data JPA là sự trừu tượng của JPA Data Access, là giải pháp cung cấp Generic DAO, được tạo ra với tiêu chí "No More DAO Implementations". Nó cung cấp các phương thức cho CRUD.

# Workflow từ Service đến Database

![Service to Database](https://terasolunaorg.github.io/guideline/5.1.0.RELEASE/en/_images/dataaccess_jpa.png).

Giả sử ta muốn lấy ra tất cả sinh viên từ table Student ở Database. <br/><br/>
Trong hình trên, Service gọi method từ Repository, ví dụ StudentRepository. StudentRepository là một interface do ta định nghĩa, nó kế thừa từ JpaRepository. Interface StudentRepository sẽ được implement bởi một thứ bí ẩn được cung cấp bởi Spring Data JPA. <br/><br/>
Spring Boot JPA nó wrapper Hibernate nên luồng tiếp theo chắc chắn sẽ đi đến Hibernate. Hoặc nói cụ thể hơn là Spring Data JPA tạo ra code Hibernate. Hibernate sau đó sẽ tạo ra code JDBC và sinh ra thêm mấy cái config. Sau đó nữa tụi nó sẽ truyền đến JDBC Driver và query của chúng ta sẽ được truyền xuống database và lấy dữ liệu từ bảng Student lên.