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
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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

<div class="mt-3 container">
    <div class="row offset-1">
        <c:forEach items="${list}" var="ctsp" varStatus="index">
            <div class="col-3 m-3">
                <div class="card text-center">
                    <h5 class="card-header">${ctsp.sanPham.ten}</h5>
                    <div class="card-body">
                        <img src="/image/${ctsp.sanPham.images}" class="card-img-top" alt="">
                        <p class="card-text ">${ctsp.giaBan} $</p>
                    </div>
                    <div class="card-footer ">
                        <a href="/mua-hang/cart/add?ctspId=${ctsp.id}" class="btn btn-primary">Thêm giỏ hàng</a>
                    </div>
                </div>
            </div>

        </c:forEach>
    </div>

</div>

</body>
</html>
