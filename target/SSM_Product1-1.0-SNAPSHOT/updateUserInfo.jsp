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
        <li><span>修改职员详情信息</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/userInfo/updateUserInfo">
        <input type="hidden" name="id" value="${userInfo.id}"/>
        <table width="800px">
            <tr>
                <td>职员姓名：</td>
                <td><input type="hidden" name="id">${userInfo.user.username}</td>
            </tr>
            <tr>
                <td>职员电话：</td>
                <td><input type="text" name="telephone" value="${userInfo.telephone}" class="in"/></td>
            </tr>
            <tr>
                <td>职员所在省市：</td>
                <td><input type="text" name="address" value="${userInfo.address}" class="in"/></td>
            </tr>
            <tr>
                <td>职员最高学历：</td>
                <td><input type="text" name="education" value="${userInfo.education}" class="in"/></td>
            </tr>
            <tr>
                <td>职员前任工作：</td>
                <td><input type="text" name="work" value="${userInfo.work}" class="in"/></td>
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
