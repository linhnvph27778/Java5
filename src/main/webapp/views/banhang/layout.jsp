<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
    <header class="row text-center">
        <img src="https://insieutoc.vn/wp-content/uploads/2021/02/mau-banner-quang-cao-khuyen-mai.jpg " style="width:available;height: 300px">
    </header>
    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">IT17321</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/mua-hang/hien-thi">Sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a href="/mua-hang/cart/view" class="d-flex btn btn-primary">Xem giỏ hàng</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
    <div class="row">
        <aside class="col-2 bg-secondary">
            <ul class="list-group">
                <li class="list-group-item m-3">Mới nhất</li>
                <li class="list-group-item m-3">Bán chạy nhất</li>
                <li class="list-group-item m-3">A third item</li>
                <li class="list-group-item m-3">A fourth item</li>
                <li class="list-group-item m-3">And a fifth one</li>
            </ul>

        </aside>

        <article class="col-10" style="min-height: 500px;">
            <div class="" >
                <div>
                    <c:if test="${ not empty sessionScope.error }">
                        <div class="alert alert-danger text-center">${sessionScope.error}</div>
                        <c:remove var="error" scope="session"/>
                    </c:if>
                </div>
                <div>
                    <c:if test="${ not empty sessionScope.message }">
                        <div class="alert alert-success text-center">${sessionScope.message}</div>
                        <c:remove var="message" scope="session"/>
                    </c:if>
                </div>

                <jsp:include page="${ view }"/>
            </div>
        </article>
    </div>

    <footer class="row bg-dark text-white text-center" style="min-height: 200px;">
        <div class="text-light">Nguyễn văn Lịnh PH27778</div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
            integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
            crossorigin="anonymous"></script>
</body>
</html>
