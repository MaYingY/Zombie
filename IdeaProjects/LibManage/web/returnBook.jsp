<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-27
  Time: 下午8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<c:url value="/StuServlet?method=returnBook"/>" method="post">
        用户名<input type="text" name="stuName"><br>
        图书名称<input type="text" name="bookName"><br>
        <input type="submit" value="确定">
        <input type="reset" value="重置">
    </form>
</body>
</html>
