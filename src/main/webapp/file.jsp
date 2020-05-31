<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/5/31
  Time: 下午 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="down">下載圖片</a>

    <form action="up" method="post" enctype="multipart/form-data">
        頭像: <input type="file" name="uploadFile" />
        描述: <input type="text" name="desc" />
        <input type="submit" value="upload" />
    </form>
</body>
</html>
