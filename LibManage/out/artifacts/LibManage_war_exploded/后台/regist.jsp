<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-24
  Time: 下午6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value='/StuRegist'/>" method="post">
    <input type="hidden" name="method" value="addUser">
    用户名<input type="text" name="name" value="${user.username}">${errors.name}<br>
    密码<input type="text" name="password" value="${user.password}">${errors.password}<br>
    <input type="submit" value="注册">
    <input type="reset" value="重置">
</form>

</body>
</html>
