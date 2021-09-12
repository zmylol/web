<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2021/9/9
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>upload.jsp</h1>
   <form action="uploadtest" method="post" enctype="multipart/form-data">
       图片：<input type="file" name="pic">
       <input type="submit" value="上传">
   </form>
</body>
</html>
