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
       <%--@elvariable id="ctsp" type=""--%>
       <sf:form method="post" action="/chi-tiet-san-pham/add" modelAttribute="ctsp">
           <div class="mt-3">
               <label class="">Năm BH</label>
               <sf:input path="namBH" type="number" cssClass="form-control"/>
               <sf:errors element="span" path="namBH" cssClass="text-danger"/>
               <h4 class="text-danger">${mes}</h4>
           </div>
           <div class="mt-3">
               <label class="">moTa</label>
               <sf:input path="moTa" cssClass="form-control"/>
               <sf:errors element="span" path="moTa" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Số lượng tồn</label>
               <sf:input path="soLuongTon" cssClass="form-control"/>
               <sf:errors element="span" path="soLuongTon" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Giá nhập</label>
               <sf:input path="giaNhap" cssClass="form-control"/>
               <sf:errors element="span" path="giaNhap" cssClass="text-danger"/>
           </div>

           <div class="mt-3">
               <label class="">Giá bán</label>
               <sf:input path="giaBan" cssClass="form-control"/>
               <sf:errors element="span" path="giaBan" cssClass="text-danger"/>
           </div>
           <div class="mt-3">
               <label class="">Sản phẩm</label>
               <sf:select path="sanPham.id" class="form-select form-select-lg mb-3">
                   <c:forEach items="${sanPham}" var="sp">
                       <sf:option value="${sp.id}">${sp.ten}</sf:option>
                   </c:forEach>
               </sf:select>
           </div>
           <div class="mt-3">
               <label class="">Màu sắc</label>
               <sf:select path="mauSac.id" class="form-select form-select-lg mb-3">
                   <c:forEach items="${mauSac}" var="ms">
                       <sf:option value="${ms.id}">${ms.ten}</sf:option>
                   </c:forEach>
               </sf:select>
           </div>
           <div class="mt-3">
               <label class="">Nhà sản xuất</label>
               <sf:select path="nhaSanXuat.id" class="form-select form-select-lg mb-3">
                   <c:forEach items="${nsx}" var="nxs">
                       <sf:option value="${nxs.id}">${nxs.ten}</sf:option>
                   </c:forEach>
               </sf:select>
           </div>
           <div class="mt-3">
               <label class="">Dòng SP</label>
               <sf:select path="dongSanPham.id" class="form-select form-select-lg mb-3">
                   <c:forEach items="${dongSP}" var="dsp">
                       <sf:option value="${dsp.id}">${dsp.ten}</sf:option>
                   </c:forEach>
               </sf:select>
           </div>
           <div>
               <button type="submit" class="btn btn-success mt-3">Add</button>
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