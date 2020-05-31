<%--
  Created by IntelliJ IDEA.
  User: IDEA3C
  Date: 2020/5/31
  Time: 下午 02:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>update emp info</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/emp" method="post">
        <input type="hidden" name="id" value="${emp.id}" />
        <input type="hidden" name="_method" value="PUT" />
        <table>
            <tr>
                <th colspan="2">修改員工訊息</th>
            </tr>
            <tr>
                <td>LASTNAME</td>
                <td>
                    <input type="text" name="lastName" value="${emp.lastName}" />
                </td>
            </tr>
            <tr>
                <td>EMAIL</td>
                <td>
                    <input type="text" name="email" value="${emp.email}"/>
                </td>
            </tr>
            <tr>
                <td>GENDER</td>
                <td>
                    <input type="radio" name="gender" value="1" <c:if test="${emp.gender == 1}">checked="checked"</c:if>/>男
                    <input type="radio" name="gender" value="0" ${emp.gender == 0 ? 'checked' : ''}/>女
                </td>
            </tr>
            <tr>
                <td>DEPARTMENT</td>
                <td>
                    <select name="department.id">
                        <option>-SELECT DEPARTMENT-</option>
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.id}" ${dept.id == emp.department.id ? 'selected' : ''}>${dept.departmentName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td COLSPAN="2">
                    <input type="submit" name="Update" />
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
