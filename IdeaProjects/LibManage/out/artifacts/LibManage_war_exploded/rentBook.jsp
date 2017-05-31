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
    <form action="<c:url value="/StuServlet?method=rentBook"/>" method="post">
        用户名<input type="text" name="stuName"><br>
        图书名称<input type="text" name="bookName"><br>
        借阅天数<input type="text" name="days"><br>
        <input type="submit" value="确定">
        <a href="rentBook.jsp">继续借阅</a>
    </form>
</body>
</html>
