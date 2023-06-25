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

    <title>My JSP 'list.jsp' starting page</title>

    <link href="<%=request.getContextPath() %>/css/content.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        #down table {
            position: relative;
            left: 50%;
            margin-left: -500px;
            top: 50px;
            border-top: 1px #999 solid;
            border-right: 1px #999 solid;
        }

        #down tr {
            height: 60px;
        }

        #down tr td {
            text-align: center;
            border-left: 1px #999 solid;
            border-bottom: 1px #999 solid;
        }

        #up a:VISITED, #up a:LINK {
            color: #4C8FBD;
            text-decoration: none;
        }

        #up a:HOVER {
            color: #4C8FBD;
            text-decoration: none;
        }

        .head {
            background: #438EB9;
            color: #fff;
        }

        tbody tr:nth-child(odd) {
            background: #e5e5e5;
        }

        tbody tr:nth-child(even) {
            background: #d5d5d5;
        }
    </style>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">

    </script>
</head>

<body>
<div id="up">
    <ul>
        <li><span>此职员个人信息</span></li>
    </ul>
</div>
<div id="down">
    <table width="1000px" cellpadding="0" cellspacing="0">
        <thead>
        <tr class="head">
            <td>职员主键</td>
            <td>职员姓名</td>
            <td>职员电话</td>
            <td>职员所在省市</td>
            <td>职员最高学历</td>
            <td>职员前任工作</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${userInfo.id}</td>
            <td>${userInfo.user.username}</td>
            <td>${userInfo.telephone}</td>
            <td>${userInfo.address}</td>
            <td>${userInfo.education}</td>
            <td>${userInfo.work}</td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
