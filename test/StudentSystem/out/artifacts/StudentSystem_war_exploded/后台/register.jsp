<%--
  Created by IntelliJ IDEA.
  User: zzp
  Date: 2017/3/6
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="<c:url value='/RegisterServlet'/>" method="post">
        <input type="hidden" name="method" value="addUser">
        用户名<input type="text" name="username" value="${user.username}">${errors.username}<br>
        密码<input type="text" name="password" value="${user.password}">${errors.password}<br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
