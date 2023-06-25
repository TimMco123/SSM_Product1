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

    <title>My JSP 'left.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link href="<%=request.getContextPath() %>/css/left.css" rel="stylesheet" type="text/css">

    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("h3").click(topic, topic);

            function topic() {
                $(this).next("ul").slideToggle(200);
                $(this).next("ul").siblings("ul").slideUp(200);
            }
        });
    </script>
</head>

<body>
<div>
    <h3 id="con"></h3>
    <h3 class="h1"><span>职员管理</span></h3>
    <ul>
        <c:if test="${user1.role_id==1}">
            <li><a href="/AddUser.jsp" target="con">--职员添加</a></li>
        </c:if>
        <li><a href="/user/getAllUser" target="con">--职员列表</a></li>
        <li><a href="/userInfo/getAllUserInfo" target="con">--职员详情列表</a></li>
    </ul>
    <h3 class="h2"><span>职员奖惩</span></h3>
    <ul>
        <c:if test="${user1.role_id==1}">
            <li><a href="/AddRP.jsp" target="con">--添加奖惩</a></li>
        </c:if>
        <li><a href="/rp/getAllRP" target="con">--奖惩列表</a></li>
    </ul>
    <c:if test="${user1.role_id==1}">
        <h3 class="h3"><span>部门管理</span></h3>
        <ul>
            <li><a href="/AddDept.jsp" target="con">--部门添加</a></li>
            <li><a href="/dept/getAllDept" target="con">--部门列表</a></li>
        </ul>
    </c:if>
    <h3 class="h4"><span>职务管理</span></h3>
    <ul>
        <c:if test="${user1.role_id==1}">
            <li><a href="/AddJob.jsp" target="con">--职务添加</a></li>
        </c:if>
        <li><a href="/job/getAllJob" target="con">--职务列表</a></li>
    </ul>


</div>
</body>
</html>
