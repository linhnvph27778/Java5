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

<div class="col-10 offset-1 mt-3">

    <div class="text-center">
        <label>Giỏ hàng</label>
    </div>
    <table class="table table-bordered bordered-dark mt-3 text-center">
        <thead class="bg-info">
        <tr>
<%--            <td>ID</td>--%>
            <td>Tên SP</td>
            <td>Màu sắc</td>
            <td>Nhà Sản Xuất</td>
            <td>Dòng Sản Phẩm</td>
            <td>Số lượng</td>
            <td>Giá bán</td>
            <td>Thành tiền</td>
            <td>Hành động</td>

        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${gioHangChiTiet}" var="gh">
                <tr>
<%--                    <td>${gh.idCtsp}</td>--%>
                    <td>${gh.tenSanPham}</td>
                    <td>${gh.tenMau}</td>
                    <td>${gh.tenNSX}</td>
                    <td>${gh.tenDongSP}</td>
                    <td>${gh.soLuong}</td>
                    <td>${gh.giaBan}</td>
                    <td>${gh.soLuong * gh.giaBan}</td>
                    <td>
                        <a class="btn btn-primary" href="/mua-hang/mua-mot-sp?ctspId=${gh.idCtsp}">Mua hàng</a>
                    </td>
                </tr>
            </c:forEach>
<%--            <a class="btn btn-success" href="/hien-thi">Back</a>--%>
            <a class="btn btn-success" href="/mua-hang/mua-tat-ca">Mua hết</a>
        </tbdoy>
    </table>

</div>

</body>
</html>
