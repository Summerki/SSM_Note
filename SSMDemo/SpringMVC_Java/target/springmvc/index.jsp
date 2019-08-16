<%--
  Created by IntelliJ IDEA.
  User: Summerki
  Date: 2019/8/16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    请选择文件:
    <input type="file" name="files"><br>
    <input type="file" name="files"><br>
    <input type="file" name="files"><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
