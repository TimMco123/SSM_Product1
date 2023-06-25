<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
        <li><span>添加职务</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/job/addJob">
        <table width="800px">
            <tr>
                <td>职务名：</td>
                <td><input type="text" id="jobName" value="${returnJob.name}" name="name" class="in"/><span id="span1"></span></td>
            </tr>
            <tr>
                <td>月薪：</td>
                <td><input type="text" value="${returnJob.salary}" name="salary" class="in"/></td>
            </tr>
            <tr>
                <td>职务等级：</td>
                <td>
                    <select name="level" class="in">
                        <option value="0">请选择</option>
                        <c:forEach items="${job_levelList}" var="level1">
                            <option value="${level1.id}" <c:if test="${returnJob.level==level1.id}">selected="selected"</c:if>>${level1.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td></td>
                <td><p style="color:red;font-size:12px">${msg}</p></td>
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
