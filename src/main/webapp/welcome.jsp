<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎页面</title>
  	<link href="css/welcome.css" type="text/css" rel="stylesheet">
  </head>
  
  <body>
    <div id="up">
    	<ul>
    		<li><span>平台首页</span></li>
    	</ul>
    </div>
    <div id="down">
    	<div id="d1">
    		<span class="s1">热烈欢迎：${user1.username}</span>
    		<span class="s2">访问本系统！！！</span>
    	</div>
    	<div id="d2"></div>
    </div>
  </body>
</html>
