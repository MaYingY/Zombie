<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-5-23
  Time: 下午7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
  <title>首页</title>
  <link href="biaodan.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="total">
  <div id="header">
    <div id="header_top">
      <br /><br />
      <span>山东理工大学图书管理系统</span>
    </div>
    <div id="header_bottom">
      <div id="kong"></div>
      <div id="logo">
        <img src="images/header5.jpg" />
        <div id="logo_word">
          <br /><br />
          <h1>山东理工大学美丽的风景</h1>
          <p>理工图书的风光更加美丽	！				</p>
        </div>
      </div>
    </div>
  </div>
  <div id="main_top">
    <div id="main_logo">
      <ul>

        <li><a href="index.jsp" target="_blank">返回首页</a></li>
      </ul>
    </div>
  </div>
  <div id="main">
    <div id="main_table">
      <div id="main_table1">
        <span>理工大</span>
      </div>
      <img src="images/1.jpg" />
    </div>
    <form>
      <div id="main_name">
        <br />
        <div id="main_table2">

          <form>
            <table style="left-spacing: 200px">
              <tr>
                <td>
                  <br><br><br>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><a href="manLogin.jsp">管理员登录</a></td>
              </tr>
              <tr>
                <td>
                  <br><br><br>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><a href="stuLogin.jsp">学生登录</a></td>
              </tr>
              <tr>
                <td>
                  <br><br><br>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><a href="regist.jsp">学生注册</a></td>
              </tr>
            </table>
          </form>
        </div>
      </div>
    </form>
  </div>
    <p align="center"><font size="+4"><b>厚德 博学  笃行 至善</b></font></p>
  </div>
</body>
</html>


