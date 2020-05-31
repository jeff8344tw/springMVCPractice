<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/5/31
  Time: 下午 02:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>edit emp info</title>
</head>
<body>
    <%--modelAttribute自定義回顯對象的屬性名--%>
    <form:form action="${pageContext.servletContext.contextPath}/emp" method="post" modelAttribute="command">
        <c:if test="${empty emp.id}" var="flag"></c:if>
        <c:if test="${!flag}" >
            <form:hidden path="id" />
            <input type="hidden" name="_method" value="PUT" />
        </c:if>

        <table>
            <tr>
                <th colspan="2">
                    <c:if test="${flag}">添加員工訊息</c:if>
                    <c:if test="${!flag}">修改員工訊息</c:if>
                </th>
            </tr>
            <tr>
                <td>LASTNAME</td>
                <td>
                    <form:input path="lastName" />
                </td>
            </tr>
            <tr>
                <td>EMAIL</td>
                <td>
                    <form:input path="email" />
                </td>
            </tr>
            <tr>
                <td>GENDER</td>
                <td>
                    <form:radiobuttons path="gender" items="${genders}"/>
                </td>
            </tr>
            <tr>
                <td>DEPARTMENT</td>
                <td>
                    <form:select path="department.id" items="${depts}" itemLabel="departmentName" itemValue="id"></form:select>
                </td>
            </tr>
            <tr>
                <td COLSPAN="2">
                    <c:if test="${flag}">
                        <input type="submit" name="Add" />
                    </c:if>
                    <c:if test="${!flag}">
                        <input type="submit" name="UPDATE" />
                    </c:if>

                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>
