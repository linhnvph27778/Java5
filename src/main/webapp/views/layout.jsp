<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
    <header class="row text-center">
        <img src="https://intphcm.com/data/upload/mau-banner-noi-bat.jpg" style="width:available;height: 300px">
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
                        <a class="nav-link" href="/san-pham/hien-thi">Sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/mau-sac/hien-thi">Màu sắc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/nha-san-xuat/hien-thi">NSX</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/dong-san-pham/hien-thi">Dòng Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/chi-tiet-san-pham/hien-thi">Chi tiết sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/khach-hang/hien-thi">Khách hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/chuc-vu/hien-thi">Chức vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cua-hang/hien-thi">Cửa hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/nhan-vien/hien-thi">Nhân viên</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <article class="row mt-2" style="min-height: 500px;" >
        <div class="col-10 offset-1" >
            <jsp:include page="${ view }"/>
        </div>
    </article>

    <footer class="row bg-dark text-white text-center" style="min-height: 200px;">Footer</footer>

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
