<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-24
  Time: 下午3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高级搜索</title>

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
    <h3 align="center">高级搜索</h3>
        <form action="<c:url value='/BookServlet'/>" method="get">
            <input type="hidden" name="method" value="query">
            <table border="0" align="center" width="40%" style="margin-left: 100px;">
                <tr>
                    <td width="100px">图书名称</td>
                    <td width="40%">
                        <input type="text" name="name"/>
                    </td>
                </tr>
                <%--<tr>
                    <td>图书名称</td>
                    <td>
                        <input type="text" name="name" id="name"/>
                    </td>
                </tr>
                <tr>
                    <td>图书类型</td>
                    <td>
                        <input type="text" name="type" id="type"/>
                    </td>
                </tr>
                <tr>
                    <td>图书价格</td>
                    <td>
                        <input type="text" name="price" id="price"/>
                    </td>
                </tr>
                <tr>
                    <td>出版地址</td>
                    <td>
                        <input type="text" name="publishingHouse" id="publishingHouse"/>
                    </td>
                </tr>
                <tr>
                    <td>图书作者</td>
                    <td>
                        <input type="text" name="author" id="author"/>
                    </td>
                </tr>
                <tr>
                    <td>每日租金</td>
                    <td>
                        <input type="text" name="dayMoney" id="dayMoney"/>
                    </td>
                </tr>
--%>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <input type="submit" value="搜索"/>
                        <input type="reset" value="重置"/>
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
        </form>
</body>
</html>