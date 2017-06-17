<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 17-6-16
  Time: 下午4:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript" src="JS/AiaxRequest.js"></script>
<html>
  <head>
    <body>
  <%--编写实例化用于异步获取省份和直辖市的Ajax对象的方法和回调方法--%>
    function getProvince() {
      var loader = new net.AjaxRequest("ZoneServlet?action=getProvince&nocache=" +
                                  new Date().getTime(), deal_getProvince, onerror,"GET");
    }

    function deal_getProvince() {
    //将获取的省份名称字符串分隔为数组
      provinceArr = this.req.responceText.split(",");
    //通过循环将数组中的省份名称添加到下拉列表中
      for(i = 0; i < provinceArr.length; i ++) {
        document.getElementByld("province").option[i] = new Option(provinceArr[i],provinceArr[i]);
      }
    //获取市县
      if(provinceArr[0] != "") {
        getCity(prvinceArr[0]);
      }
    }
    //获取省份和直辖市
    window.onload = function() {
      getProvince();
    }
  <%--编写实例化用于异步获取市县的Ajax对象的方法和回调函数，以及错误处理函数--%>
    function getCity(selProvince) {
      var loader = new net.AjaxRequest("ZoneServlet?action=getCity&parProvince=" +
                    selProvince + "&nocache=" + new Date().getTime(), deal_getCity, onerror, "GET");
    }
    function deal_getCity() {
      cityArr = this.req.responseText.split(",");
      //清空下拉列表
      document.getElementById("city").length = 0;
      //通过循环将数组中的市县名称添加到下拉列表中
      for(i = 0; i < cityArr.length; i ++) {
        document.getElementById("city").option[i] = new Option(cityArr[i], cityArr[i]);
      }
    }
    //错误处理函数
    function onerror() {}
  <select name="province" id="province" onchange="getCity(this.value)"></select>
  <select name="city" id="city"></select>
  
  
  </body>
  </head>
</html>
