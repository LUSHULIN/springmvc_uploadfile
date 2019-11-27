<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/27
  Time: 10:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <h3>传统文件上传案例</h3>
    <form action="/upload/fileupload" method="post" enctype="multipart/form-data">
        <input type="file" name="请选择上传的文件"><br>
        <input type="submit" value="上传">

    </form>
    <br>

    <h3>springmvc 文件上传案例</h3>
    <form action="/upload/fileupload2" method="post" enctype="multipart/form-data">
        <input type="file" name="upload"><br>
        <input type="submit" value="上传">

    </form>
</body>
</html>
