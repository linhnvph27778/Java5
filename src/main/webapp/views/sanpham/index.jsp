<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

<div class="col-6 offset-3 mt-3" >
    <form action="/san-pham/search" method="get" class="container">

        <div class="mb-3">
            <label class="form-label">Mã hoặc Ten</label>
            <input type="text" class="form-control" name="keyword" placeholder=" Nhập mã hoặc tên">
        </div>

        <button type="submit" class="btn btn-primary">Search</button>
        <a class="btn btn-success" href="/san-pham/viewAdd">Add</a>
    </form>


    <table class="table table-bordered bordered-dark mt-3 text-center">
        <thead class="bg-info">
        <tr>

            <td>Mã</td>
            <td>Tên</td>
            <td colspan="2">Action</td>
        </tr>
        </thead>
        <tbdoy>
            <c:forEach items="${list.content}" var="nv" >
                <tr>

                    <td>${nv.ma}</td>
                    <td>${nv.ten}</td>
                    <td>
                        <a onclick="xacNhan(event)" href="/san-pham/delete/${nv.id}" class="btn btn-danger">Xoa</a>
                        <a href="/san-pham/viewUpdate/${nv.id}" class="btn btn-primary">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbdoy>
    </table>
    <div class="mt-3">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:forEach begin="0" end="${ list.totalPages -1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/san-pham/hien-thi?page=${loop.begin + loop.count - 1}">
                            ${loop.begin + loop.count }
                    </a>
                </li>
            </c:forEach>
        </ul>
    </nav>
    </div>
</div>

</body>

<script>
    function xacNhan(event){
        var mes= confirm("Ban có chắc muốn xóa không");
        if (!mes){
            event.preventDefault();
        }
    }
</script>
</html>
