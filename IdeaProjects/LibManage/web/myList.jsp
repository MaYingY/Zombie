<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-30
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的列表</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<h3 align="center">我的列表</h3>
<table border="1" width="70%" align="center">
    <tr>
        <th>我的帐户</th>
        <th>图书名称</th>
        <th>借阅天数</th>
    </tr>
    <c:forEach items="${stu_bookList}" var="stu_book">
        <tr>
            <td>${stu_book.stuName}</td>
            <td>${stu_book.bookName}</td>
            <td>${stu_book.days}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
