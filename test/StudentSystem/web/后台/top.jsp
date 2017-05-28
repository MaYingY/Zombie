<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base target="main">
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <style type="text/css">
          .user{
              float: right;
          }
      </style>

  </head>
  
  <body style="text-align: center;">
  	<div align="center">
        <h1>成绩信息管理系统</h1>
    </div>
    <div align="right" class="user">
        <c:choose>
            <c:when test="${empty sessionScope.sessionUser}">
                <button onclick="showModalDialog('login.jsp')">登录</button>
            </c:when>
            <c:otherwise>
                <button onclick="<c:url value='/LoginServlet'/> " name="method" value="logout">退出登录</button>
            </c:otherwise>
        </c:choose>

        <button onclick="showModalDialog('register.jsp')">注册</button>
    </div>
    <a href="<c:url value='/add.jsp'/>">添加学生</a> 　|　
    <a href="<c:url value='/StudentServlet?method=findAll'/>">查询</a> 　|　
    <a href="<c:url value='/query.jsp'/>">高级搜索</a>
  </body>
</html>
