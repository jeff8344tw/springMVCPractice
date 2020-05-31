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
                    <a href="emp">DELETE</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
