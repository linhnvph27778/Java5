<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>It17321</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>

    <div class="col-4 offset-4 mt-3">
       <%--@elvariable id="nhanVien" type=""--%>
       <sf:form method="post" action="/nhan-vien/update" modelAttribute="nhanVien">
           <div class="mt-3">
               <label class="">ID</label>
               <sf:input path="id" cssClass="form-control" />
               <sf:errors element="span" path="id" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Mã</label>
               <sf:input path="ma" cssClass="form-control"/>
               <sf:errors element="span" path="ma" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Tên</label>
               <sf:input path="ten" cssClass="form-control"/>
               <sf:errors element="span" path="ten" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Tên đệm</label>
               <sf:input path="tenDem" cssClass="form-control"/>
               <sf:errors element="span" path="tenDem" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Họ</label>
               <sf:input path="ho" cssClass="form-control"/>
               <sf:errors element="span" path="ho" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Giới tính</label>
               <sf:radiobutton path="gioiTinh" value="nam" checked="true"/>Nam
               <sf:radiobutton path="gioiTinh" value="nu" />Nữ
               <sf:errors element="span" path="gioiTinh" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label>Ngày sinh</label>
               <sf:input path="ngaySinh" type="Date" name="ngaySinh" class="form-control" />
               <div>
                   <small><sf:errors path="ngaySinh" cssClass="text-danger"/></small>
               </div>
           </div>

           <div class="mt-3">
               <label class="">Địa chỉ</label>
               <sf:input path="diaChi" cssClass="form-control"/>
               <sf:errors element="span" path="diaChi" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">SDT</label>
               <sf:input path="sdt" cssClass="form-control"/>
               <sf:errors element="span" path="sdt" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Mật khẩu</label>
               <sf:input path="matKhau" cssClass="form-control"/>
               <sf:errors element="span" path="matKhau" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Trạng thái</label>
               <sf:select path="trangThai" cssClass="form-select">
                   <sf:option value="3" disabled="true">Mời bạn chọn</sf:option>
                   <sf:option value="1">Đang hoạt động</sf:option>
                   <sf:option value="0">Không hoạt động</sf:option>
               </sf:select>
           </div>
           <div class="mt-3">
               <label class="">Chức vụ</label>
               <sf:select path="chucVu.id" class="form-select form-select-lg mb-3">
                   <c:forEach items="${chucVu}" var="cv">
                       <sf:option value="${cv.id}">${cv.ten}</sf:option>
                   </c:forEach>
               </sf:select>

           </div>
           <div class="mt-3">
               <label class="">Cửa hàng</label>
               <sf:select path="cuaHang.id" class="form-select form-select-lg mb-3">
                   <c:forEach items="${cuaHang}" var="ch">
                       <sf:option value="${ch.id}">${ch.ten}</sf:option>
                   </c:forEach>
               </sf:select>

           </div>
           <div>
               <button type="submit" class="btn btn-success mt-3">Update</button>
           </div>
       </sf:form>
    </div>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</html>