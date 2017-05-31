<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-24
  Time: 下午8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/StuLogin?method=stuLogin"/> " method="post">
    用户名<input type="text" name="name" ><br>
    密码<input type="text" name="password" ><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>

</body>
</html>
