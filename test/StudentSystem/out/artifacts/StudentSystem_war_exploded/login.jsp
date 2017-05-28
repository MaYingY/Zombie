<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

    <head>
        <title>login</title>
        <meta charset="utf-8">
        <style>
        *{
             box-sizing: border-box;
             font-family: "微软雅黑","Helvetica Neue",Helvetica,Arial,sans-serif;
        }
        body{
            background-color: #f7f6f2;
        }
            .login{
                width: 450px;
                height: 300px;
                margin: 130px auto;
               
                border-radius: 10px;
                background-color:#fff;
            }
            
            .p1{
                font-size: 25px;
                text-align: center;
                font-weight: 400;
                color: #323a45;
                margin: 0 0 14px;
                font-family: inherit;
                line-height: 1.1;
                line-height: 80px;
            }
            input[type=text]{
                height: 48px;
                width: 370px;
                padding-left:15px;
                padding-right: 15px;
                font-size: 16px;
                margin-bottom: 15px;
                border:1px solid rgba(50,58,69,.2);
                border-radius: 5px;
                font: inherit;
                color: inherit;
                margin-left: 40px;
            }
            input[type=submit]{
                height:48px;
                width: 380px;
                border: none;
                background-color:#323a45;
                color: #fff;
                border-radius: 24px;
                cursor: pointer;  
                margin-left: 40px;
                font-size: 20px;
                transition:background-color .2s ease;
            }
            input[type=submit]:hover{
                background-color:#499DD6;
            }
        </style>
    </head>
    <body>
           <div class="login">
                <div>
                <p class="p1">管理员登录</p>
                    <div class="content">
                        <form action="<c:url value="/StudentServlet?method=findAll"/> " method="post">
                            <input type="text" placeholder="username" name="">
                            <input type="text" placeholder="pass" name="">
                            <input type="submit">
                        </form>
                    </div>
                </div>
           </div> 
    </body>
</html>