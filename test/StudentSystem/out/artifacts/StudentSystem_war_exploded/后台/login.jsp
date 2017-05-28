<%--
  Created by IntelliJ IDEA.
  User: zzp
  Date: 2017/3/6
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="<c:url value='/LoginServlet'/>" method="post">
    <input type="hidden" name="method" value="login">
    用户名：<input type="text" name="username" value="${user.username }"/><br/>
    密　码：<input type="password" name="password" value="${user.password }"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
