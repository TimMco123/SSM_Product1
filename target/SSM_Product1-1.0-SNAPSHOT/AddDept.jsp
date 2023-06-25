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
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function (){
            //用户名触发事件
            $("#deptName").blur(function (){
                var value = $("#deptName").val();
                $.ajax({
                    url:"/dept/checkDeptName",
                    data:{"name":value},
                    type:"post",
                    dataType:"json",
                    success:function (data){
                        if(data){//true用户名可用
                            $("#span1").html("部门名可用");
                        }else{//false用户名不可用
                            $("#span1").html("部门名有重复，请重试");
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
        <li><span>添加部门</span></li>
    </ul>
</div>
<div id="down">
    <form method="post" action="/dept/addDept">
        <table width="800px">
            <tr>
                <td>部门名：</td>
                <td><input type="text" id="deptName" value="${returnDeptName}" name="name" class="in"/><span id="span1"></span></td>
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
