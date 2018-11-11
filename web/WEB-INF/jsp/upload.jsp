<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/11
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <form method="post" action="/user/doUpload" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" name="upload"/>
    </form>
</body>
</html>
