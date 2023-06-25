<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <li><span>修改职员信息</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/dept/updateDept">
        <input type="hidden" name="id" value="${dept.id}"/>
        <table width="800px">
            <tr>
                <td>部门名：</td>
                <td><input type="text" id="deptName" value="${dept.name}" name="name" class="in"/></td>
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
