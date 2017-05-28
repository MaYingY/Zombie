<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
	<html>
	<head>
		<meta charset="utf-8">
		<title>学生管理</title>
	<link rel="stylesheet" type="text/css" href="bootstrap.css">
	<script type="text/javascript" src="bootstrap.js"></script>
	<script type="text/javascript" src="jquery-min.js"></script>	
	</head>
	<body>
		<nav>
			<div class="container">	
				<h1>添加学生 <small class="pull-right"><a href="auser.php" class='btn btn-default'>返回</a></small></h1>
				<br><br>
				<form class="form-horizontal" action="<c:url value="/StudentServlet"/> " method="post">
					<input type="hidden" name="method" value="add">
					<div class="form-group">
						<label class="col-sm-2 control-label" >学生名：</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" placeholder="sname" name="name"">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >出生日期：</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" placeholder="date" name="birthday">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >电话：</label>
						<div class="col-sm-3">
							<input type="phone" class="form-control" placeholder="phone" name="phone">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" >地址：</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputuser" placeholder="add" name="address" >
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">确定</button>
						</div>
					</div>
				</form>
			</div>
		</nav>
	</body>
	</html>
