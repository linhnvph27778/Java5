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
<div class="col-4 offset-4">
    <form action="/nhan-vien/search" method="get" class="container">

        <div class="mb-3">
            <label class="form-label">Ho Ten</label>
            <input type="text" class="form-control" name="keyword" placeholder="Tìm theo tên hoặc mã">
        </div>
        <div class="mt-3">
            <label>Chức vụ</label>
            <select name="chucVu" class="form-select form-select-lg mb-3">
                <c:forEach items="${chucVu}" var="cv">
                    <option value="${cv.ma}">${cv.ten}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
        <a class="btn btn-success" href="/nhan-vien/viewAdd">Add</a>
    </form>
</div>

<div class="mt-3">
    <table class="table table-bordered bordered-dark mt-3 text-center">
        <thead class="bg-info">
        <tr>
            <td>Mã</td>
            <td>Họ và tên</td>
            <td>Gioi Tinh</td>
            <td>Ngày sinh</td>
            <td>Địa chỉ</td>
            <td>SDT</td>
            <td>Mật khẩu</td>
            <td>Trạng thái</td>
            <td>Tên chức vụ</td>
            <td>Tên cửa hàng</td>
            <td>Action</td>
        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${list.content}" var="nv" >
                <tr>
                    <td>${nv.ma}</td>
                    <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
                    <td>${nv.gioiTinh}</td>
                    <td>
                        <f:formatDate value="${nv.ngaySinh}" pattern="dd-MM-yyyy"/>
                    </td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.sdt}</td>
                    <td>${nv.matKhau}</td>
                    <td>${nv.trangThai==1?"Đang hoạt động":"Không hoạt động"}</td>
                    <td>${nv.chucVu.ten}</td>
                    <td>${nv.cuaHang.ten}</td>
                    <td>
                        <a onclick="xacNhan(event)"  href="/nhan-vien/delete/${nv.id}" class="btn btn-danger">Xoa</a>
                        <a href="/nhan-vien/viewUpdate/${nv.id}" class="btn btn-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbdoy>
    </table>
    <div class="mt-3">
<%--        <nav class="navbar navbar-expand-lg bg-light">--%>
<%--            <div class="container-fluid">--%>
<%--                <c:forEach begin="0" end="${list.totalPages-1}" varStatus="dem">--%>
<%--                    <a href="/nhan-vien/hien-thi?page=${dem.begin + dem.count-1}">${dem.begin + dem.count}</a>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </nav>--%>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${ list.totalPages -1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/nhan-vien/hien-thi?page=${loop.begin + loop.count - 1}">
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
