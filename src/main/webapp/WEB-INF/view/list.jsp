<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/5/31
  Time: 下午 02:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示員工訊息</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/index_work.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/jquery-3.5.1.min.js" >
        $(function (){
            $(".del").click(function(){
                // submit()將所獲得的form元素提交
                if(confirm("確認刪除嗎?")) {
                    $("form").attr("action", $(this).attr("href")).submit();
                    return false;
                }
                // $("form").attr("action", this.herf).submit();
                return false; // 將超連結的默認行為取消
            });
        }); //預加載函數或文檔就緒函數
    </script>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>LASTNAME</th>
            <th>EMAIL</th>
            <th>GENDER</th>
            <th>DEPARTMENT_NAME</th>
            <th>OPTION(<a href="emp">add</a>)(<a href="editEmp">add2</a>)</th>
        </tr>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender == 0 ? 'female' : 'male'}</td>
                <td>${emp.department.departmentName}</td>
                <td>
                    <a href="emp/${emp.id}">UPDATE</a>
                    <a href="editEmp/${emp.id}">UPDATE2</a>
                    <a class = "del" href="emp/${emp.id}">DELETE</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form method = "POST" >
        <input type="hidden" name="_method" value="DELETE" />
    </form>
</body>
</html>
