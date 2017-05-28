<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>学生信息</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css">
	<script type="text/javascript" src="bootstrap.js"></script>
	<script type="text/javascript" src="jquery-min.js"></script>
	<style type="text/css">
		.a_con{
			/*border: 1px solid black;*/
			text-align: center;
		}
	</style>
</head>
<body>
	<nav>
		<div class="container">	
			<h1>学生信息 <small class="pull-right"><a href="add.jsp"  class='btn btn-default'>添加学生</a></small></h1>
			<div class="rows">	

				<table class="table table-striped">
					<thead>
						<tr>
							<th>SID</th>
							<th>学生姓名</th>
							<th>出生日期</th>
							<th>电话</th>
							<th>地址</th>
							<th>管理</th>
						</tr>
					</thead>
					<tbody>


					<c:forEach items="${stuList}" var="stu">
						<tr>
							<td>${stu.name}</td>
							<td>${stu.birthday}</td>
							<td>${stu.phone}</td>
							<td>${stu.address}</td>
							<td>
								<a href="<c:url value='/StudentServlet?method=preEdit&id=${stu.id}'/>">编辑</a>
								<a href="<c:url value='/StudentServlet?method=delete&id=${stu.id}'/>">删除</a>
							</td>
						</tr>
					</c:forEach>
						</tbody>
					</table>	

					<div class="a_con"> 
							<nav aria-label="Page navigation">
							  <ul class="pagination">						 	
								 <li>
								      <a href="#" aria-label="Previous">
								        <span aria-hidden="true">&laquo;</span>
								      </a>
								    </li>

						    <li><a href="#">1</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">1</a></li>
						    <li><a href="#">1</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">1</a></li>
						    <li><a href="#">1</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">1</a></li>
							  
							<li>
							      <a href="#" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							  </ul>
							</nav>
					</div>
				
			</div>
		</div>
	</nav>
</body>
</html>