<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-27
  Time: 下午2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书列表</title>

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
<h3 align="center">图书列表</h3>
<table border="1" width="70%" align="center">
    <tr>
        <th>图书编号</th>
        <th>图书名称</th>
        <th>图书型号</th>
        <th>图书价格</th>
        <th>出版地址</th>
        <th>图书作者</th>
        <th>图书数量</th>
        <th>每日租金</th>
        <th>借还标记</th>
        <th>当前库存</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.type}</td>
            <td>${book.price}</td>
            <td>${book.publishingHouse}</td>
            <td>${book.author}</td>
            <td>${book.bookCount}</td>
            <td>${book.dayMoney}</td>
            <td>${book.flag}</td>
            <td>${book.agoCount}</td>
            <td>
                <a href="modBook.jsp">修改</a>
                <a href="<c:url value='/BookServlet?method=delete&id=${book.id}'/>">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%--<br>
<div align="center">
    第${stuList.pageCode}页/共${stuList.totalPage}页  &nbsp;
    <a href="${stuList.url}&pageCode=1">首页</a>
    <c:if var="result" test="${stuList.pageCode > 1}">
        <a href="${stuList.url}&pageCode=${stuList.pageCode-1}">上一页</a>&nbsp;
    </c:if>
    <c:if test="${!result}">
        <a>上一页</a>
    </c:if>

    <c:choose>
        <c:when test="${stuList.totalPage <= 10}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${stuList.totalPage}"/>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${stuList.pageCode-5}"/>
            <c:set var="end" value="${stuList.pageCode+4}"/>
            <c:if test="${begin < 1}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="10"/>
            </c:if>
            <c:if test="${end > stuList.totalPage}">
                <c:set var="begin" value="${stuList.totalPage-9}"/>
                <c:set var="end" value="${stuList.totalPage}"/>
            </c:if>
        </c:otherwise>
    </c:choose>

    <c:forEach var="i" begin="${begin}" end="${end}">
        <c:choose>
            <c:when test="${stuList.pageCode == i}">
                [${i}]
            </c:when>
            <c:otherwise>
                <a href="${stuList.url}&pageCode=${i}">[${i}]</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if var="result" test="${stuList.pageCode < stuList.totalPage}">
        <a href="${stuList.url}&pageCode=${stuList.pageCode+1}">下一页</a>&nbsp;
    </c:if>
    <c:if test="${!result}">
        <a>下一页</a>
    </c:if>
    <a href="${stuList.url}&pageCode=${stuList.totalPage}">尾页</a>
</div>--%>
</body>
</html>
