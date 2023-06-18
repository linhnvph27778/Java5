<%--
  Created by IntelliJ IDEA.
  User: nguyenvv4
  Date: 22/01/2023
  Time: 11:31
  To change this template use File | Settings | File Templates.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<form action="/khach-hang/search" method="get" class="container">

    <div class="mb-3">
        <label class="form-label">Ten hoặc mã</label>
        <input type="text" class="form-control" name="keyword">
    </div>

    <button type="submit" class="btn btn-primary">Search</button>
    <a class="btn btn-success" href="/khach-hang/viewAdd">Add</a>
</form>
<div class="col-10 offset-1 mt-3">
    <table class="table table-bordered bordered-dark mt-3 text-center">
        <thead class="bg-info">
        <tr>
            <td>Mã</td>
            <td>Họ và tên</td>
            <td>Ngày sinh</td>
            <td>SDT</td>
            <td>Địa chỉ</td>
            <td>Thành phố</td>
            <td>Quấc gia</td>
            <td>Mật khẩu</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${list.content}" var="kh" >
                <tr>
                    <td>${kh.ma}</td>
                    <td>${kh.ho} ${kh.tenDem} ${kh.ten}</td>

                    <td>
                        <f:formatDate value="${kh.ngaySinh}" pattern="dd-MM-yyyy"/>
                    </td>
                    <td>${kh.sdt}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.thanhPho}</td>
                    <td>${kh.quacGia}</td>
                    <td>${kh.matKhau}</td>

                    <td>
                        <a onclick="xacNhan(event)"  href="/khach-hang/delete/${kh.id}" class="btn btn-danger">Xoa</a>
                        <a href="/khach-hang/viewUpdate/${kh.id}" class="btn btn-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbdoy>
    </table>
    <div class="mt-3">

    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end ="${ list.totalPages -1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/khach-hang/hien-thi?page=${loop.begin + loop.count - 1}">
                            ${loop.begin + loop.count }
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
    </div>
</div>

<script>
    function xacNhan(event){
        var mes= confirm("Ban có chắc muốn xóa không");
        if (!mes){
            event.preventDefault();
        }
    }
</script>
</body>
</html>
