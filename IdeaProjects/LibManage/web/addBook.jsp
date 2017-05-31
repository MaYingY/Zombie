<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-24
  Time: 下午3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/BookServlet?method=addBook"/>" method="post">
    图书编号<input type="text" name="id"><br>
    图书名称<input type="text" name="name"><br>
    图书型号<input type="text" name="type"><br>
    图书价格<input type="text" name="price"><br>
    出版地址<input type="text" name="publishingHouse"><br>
    图书作者<input type="text" name="author"><br>
    图书数量<input type="text" name="bookCount"><br>
    每日租金<input type="text" name="dayMoney"><br>
    当前库存<input type="text" name="agoCount"><br>
    <input type="submit" value="添加">
    <input type="reset" value="重置">
</form>

</body>
</html>
