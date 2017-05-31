<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-26
  Time: 上午10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${msgMan}</h2>
<form action="<c:url value="/ManServlet?method=manLogin"/> " method="post">
    用户名<input type="text" name="username" ><br>
    密码<input type="text" name="password" ><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>

</body>
</html>
