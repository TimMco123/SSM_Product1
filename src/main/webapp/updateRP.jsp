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
        <li><span>修改奖惩</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/rp/updateRP">
        <input type="hidden" name="id" value="${rp.id}"/>
        <input type="hidden" name="name" value="${rp.user.username}"/>
        <table width="500px">
            <tr>
                <td>职员姓名：</td>
                <td>${rp.user.username}</td>
            </tr>
            <tr>
                <td>奖惩类型：</td>
                <td>
                    <select name="type" class="in">
                        <option value="0">请选择</option>
                        <c:forEach items="${rpTypeList}" var="rpList">
                            <option value="${rpList.id}" <c:if test="${rp.type==rpList.id}">selected="selected"</c:if>>${rpList.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>详情：</td>
                <td><input type="text" name="detail" value="${rp.detail}" class="in"/></td>
            </tr>
            <tr>
                <td>时间：</td>
                <td><input type="date" name="date" value='<fmt:formatDate value="${rp.time}" pattern="yyyy-MM-dd"/>' class="in"/></td>
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
