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
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //用户名触发事件
            $("#username").blur(function () {
                var value = $("#username").val();
                $.ajax({
                    url: "/user/checkUsernameRepeat",
                    data: {"username": value},
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                        if (data) {//true用户名可用
                            $("#span1").html("用户名可用");
                        } else {//false用户名不可用
                            $("#span1").html("用户名有重复，请重试");
                        }
                    }
                });
            });
        });
    </script>

</head>

<body>
<div id="up">
    <ul>
        <li><span>添加职员</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/user/addUser">
        <table width="800px">
            <tr>
                <td>职员用户名：</td>
                <td><input type="text" id="username" value="${returnUser.username}" name="username" class="in"/><span id="span1"></span></td>
            </tr>
            <tr>
                <td>职员密码：</td>
                <td><input type="text" name="password" value="${returnUser.password}" class="in"/></td>
            </tr>
            <tr>
                <td>职员年龄：</td>
                <td><input type="text" name="age" value="${returnUser.age}" class="in"/></td>
            </tr>
            <tr>
                <td>入职时间：</td>
                <td><input type="date" name="date" value='<fmt:formatDate value="${returnUser.time}" pattern="yyyy-MM-dd"/>' class="in"/></td>
            </tr>
            <tr>
                <td>部门名：</td>
                <td>
                    <select name="dept_id" class="in">
                        <option value="0">请选择</option>
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.id}" <c:if test="${returnUser.dept_id==dept.id}">selected="selected"</c:if>>${dept.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>职务名：</td>
                <td>
                    <select name="job_id" class="in">
                        <option value="0">请选择</option>
                        <c:forEach items="${jobList}" var="job">
                            <option value="${job.id}" <c:if test="${returnUser.job_id==job.id}">selected="selected"</c:if>>${job.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>角色：</td>
                <td>
                    <select name="role_id" class="in">
                        <option value="">请选择</option>
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.id}" <c:if test="${returnUser.role_id==role.id}">selected="selected"</c:if>>${role.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td></td>
                <td><p style="color: red;font-size: 12px">${msg}</p></td>
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
