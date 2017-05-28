<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生列表</title>
    
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
  <c:choose>
  <c:when test="${empty sessionScope.sessionUser}">请先登录！</c:when>
  <c:otherwise>
<h3 align="center">学生列表</h3>
<table border="1" width="70%" align="center">
	<tr>
		<th>学生姓名</th>
		<th>语文成绩</th>
		<th>数学成绩</th>
		<th>英语成绩</th>
        <th>操作</th>
	</tr>
	<c:forEach items="${stuList.beanList}" var="stu">
		<tr>
			<td>${stu.name}</td>
			<td>${stu.chinese}</td>
			<td>${stu.maths}</td>
			<td>${stu.english}</td>
			<td>
				<a href="<c:url value='/StudentServlet?method=preEdit&id=${stu.id}'/>">编辑</a>
				<a href="<c:url value='/StudentServlet?method=delete&id=${stu.id}'/>">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
  <br>
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
  </div>
  </body>
  </c:otherwise>
  </c:choose>
</html>