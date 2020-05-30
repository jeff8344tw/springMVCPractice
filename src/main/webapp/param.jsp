<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/5/30
  Time: 下午 07:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="param" method="post">
        username:<input type="text" name="username" /><br />
        password:<input type="text" name="password" /><br />
        age:<input type="text" name="age" /><br />
        province:<input type="text" name="address/province" /><br />
        city:<input type="text" name="address.city" /><br />
        country:<input type="text" name="address.country" /><br />
        <input type="submit" value="add" />
    </form>
</body>
</html>
