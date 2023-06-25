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
        <li><span>添加奖惩</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/rp/addRP">
        <table width="500px">
            <tr>
                <td>职员姓名：</td>
                <td>
                    <select name="user_id" class="in">
                        <option value="0">请选择</option>
                        <c:forEach items="${userList}" var="user">
                            <option value="${user.id}">${user.username}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>奖惩类型：</td>
                <td>
                    <select name="type" class="in">
                        <option value="0">请选择</option>
                        <c:forEach items="${rpTypeList}" var="rp">
                            <option value="${rp.id}">${rp.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>详情：</td>
                <td><input type="text" name="detail" class="in"/></td>
            </tr>
            <tr>
                <td>时间：</td>
                <td><input type="date" name="date" class="in"/></td>
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
