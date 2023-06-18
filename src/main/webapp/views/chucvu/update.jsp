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
       <%--@elvariable id="nhanvien" type=""--%>
       <sf:form method="post" action="/chuc-vu/update" modelAttribute="chucVu">
           <div class="mt-3">
               <label class="">ID</label>
               <sf:input path="id" cssClass="form-control"/>
               <sf:errors element="span" path="id" cssClass="text-danger" />
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