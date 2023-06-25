<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
   	<link href="<%=request.getContextPath() %>/css/add.css" type="text/css" rel="stylesheet">
	
  </head>
  
  <body>
  	<div id="up">
	   <ul>
	    	<li><span><a href="#">用户管理 </a>&gt; 添加用户 &gt;</span></li>
	   </ul>
	</div>
	<div id="down">
	    <form method="post" action="/addCustomer">
	   		<table width="500px">
	   			<tr>
	   				<td>用户名称：</td>
	   				<td><input type="text" name="name" class="in"/></td>
	   			</tr>
	   			<tr>
	   				<td>用户密码：</td>
	   				<td><input type="text" name="password" class="in"/></td>
	   			</tr>
	   			<tr>
	   				<td>电话号码：</td>
	   				<td><input type="text" name="telephone" class="in"/></td>
	   			</tr>

	   			<tr>
	   				<td>商品类别</td>
	   				<td>
	   					<select name="cid" class="in">
							<c:forEach items="${list}" var="dept">
								<option value="${dept.did}">${dept.role}</option>
							</c:forEach>
	   					</select>
	   				</td>
	   			</tr>
	   			
	   			<tr>
	   				<td></td>
	   				<td>
	   					<input type="submit" value="提&nbsp;&nbsp;&nbsp;交" class="su">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   					<input type="reset" value="清&nbsp;&nbsp;&nbsp;空" class="su">
	   				</td>
	   			</tr>
	   		</table>
	    </form>
    </div>
  </body>
</html>
