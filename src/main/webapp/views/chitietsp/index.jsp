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
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
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

<div class="col-10 offset-1 mt-3">
    <a class="btn btn-success" href="/chi-tiet-san-pham/viewAdd">Add</a>

    <table class="table table-bordered bordered-dark mt-3 text-center">
        <thead class="bg-info">
        <tr>
            <td>Năm BH</td>
            <td>Mô tả</td>
            <td> Số lượng tồn</td>
            <td>Giá nhập</td>
            <td>Giá bán</td>
            <td>Tên sản phẩm</td>
            <td>Màu sắc</td>
            <td>Dòng SP</td>
            <td>NSX</td>
            <td colspan="3">Action</td>
        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${list}" var="ctsp" >
                <tr>
                    <td>${ctsp.namBH}</td>
                    <td>${ctsp.moTa}</td>
                    <td>${ctsp.soLuongTon}</td>
                    <td>${ctsp.giaNhap}</td>
                    <td>${ctsp.giaBan}</td>
                    <td>${ctsp.sanPham.ten}</td>
                    <td>${ctsp.mauSac.ten}</td>
                    <td>${ctsp.dongSanPham.ten}</td>
                    <td>${ctsp.nhaSanXuat.ten}</td>
<%--                    <td><a href="/cart/add?ctspId=${ctsp.id}" class="btn btn-primary">Add giỏ hàng session</a></td>--%>

                    <td>
                        <a href="/chi-tiet-san-pham/delete/${ctsp.id}" onclick="xacNhan(event)" class="btn btn-danger">Xoa</a>
                        <a href="/chi-tiet-san-pham/viewUpdate/${ctsp.id}" class="btn btn-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbdoy>
    </table>
<%--    <a href="/cart/view" class="btn btn-primary"> Xem giỏ hàng session</a>--%>
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
