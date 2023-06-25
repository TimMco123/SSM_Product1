<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
   	
   	<link href="<%=request.getContextPath() %>/css/update.css" type="text/css" rel="stylesheet">

  </head>
  
  <body>
	<div id="up">
	   <ul>
	    	<li><span><a href="admin/welcome">平台首页 </a>&gt; 类别管理 &gt; 类别修改</span></li>
	   </ul>
	</div>
	<div id="down">
	    <form action="category/update" method="post" modelAttribute="category">
	    	<input type="hidden" name="_method" value="PUT">
	    	<input type="hidden" name="id" value="">
	   		<table width="500px">
	   			<tr>
	   				<td>类别名称</td>
	   				<td><input type="text" class="in"/></td>
	   			</tr>
	   			<tr>
	   				<td>类别描述</td>
	   				<td><textarea cols="49" rows="3"></textarea></td>
	   			</tr>
	   			<tr>
	   				<td></td>
	   				<td>
	   					<input type="submit" value="修&nbsp;&nbsp;&nbsp;改" class="su">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   					<input type="reset" value="清&nbsp;&nbsp;&nbsp;空" class="su">
	   				</td>
	   			</tr>
	   		</table>
	    </form>
    </div>
  </body>
</html>
