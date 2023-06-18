<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
<div class="text-center fs-2 fw-bold">
    <p>${tieuDe}</p>
</div>
<div class="col-6 offset-3 mt-5 border bordered-dark ">
    <form method="post"  action="${action}">
        <div class="col-6 offset-3 ">
            <div class="mt-3">
                <label class="">Tên</label>
                <input name="ten" class="form-control "/>
            </div>
            <div class="mt-3">
                <label class="">Mật khẩu</label>
                <input name="matKhau" class="form-control "/>
            </div>
            <div class="text-danger">
                ${mes}
            </div>
        </div>


        <button class="btn mt-3 offset-5 text-white bg-dark " type="submit">Đăng nhập</button>
    </form>
</div>
</body>
</html>
