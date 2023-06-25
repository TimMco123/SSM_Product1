<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>人事管理系统 - 登录</title>

    <link rel="stylesheet" media="screen" href="<%=request.getContextPath() %>/css/style.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/reset.css"/>
    <script type="text/javascript">
        if (window != top) {
            top.location.href = location.href;//session失效跳出frameset
        }
    </script>
</head>
<body>

<div id="particles-js">
    <div class="login">
        <div class="login-top">
            人事管理系统登录
        </div>
        <form action="<%=request.getContextPath() %>/user/login" method="post" id="form">
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="<%=request.getContextPath() %>/img/name.png"/></div>
                <div class="login-center-input">
                    <input type="text" name="username" value="" placeholder="请输入您的用户名" onfocus="this.placeholder=''"
                           onblur="this.placeholder='请输入您的用户名'"/>
                    <div class="login-center-input-text">用户名</div>
                </div>
            </div>
            <div class="login-center clearfix">
                <div class="login-center-img"><img src="<%=request.getContextPath() %>/img/password.png"/></div>
                <div class="login-center-input">
                    <input type="password" name="password" value="" placeholder="请输入您的密码" onfocus="this.placeholder=''"
                           onblur="this.placeholder='请输入您的密码'"/>
                    <div class="login-center-input-text">密码</div>
                </div>
            </div>

            <div class="login-center clearfix">
                <div class="login-center-img"><img src="<%=request.getContextPath() %>/img/password.png"/></div>
                <div class="login-center-input">
                    <select name="role_id" style="width:200px; background: #13E8E9;">
                        <option value="10" disabled selected>请选择</option>
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </c:forEach>
                    </select>
                    <div class="login-center-input-text">密码</div>
                </div>
            </div>
            <div class="login-button">
                登录
                <p style="color:red;font-size:12px">${msg}</p>
            </div>
        </form>
    </div>
    <div class="sk-rotating-plane"></div>
</div>

<!-- scripts -->
<script src="<%=request.getContextPath() %>/js/particles.min.js"></script>
<script src="<%=request.getContextPath() %>/js/app.js"></script>
<script type="text/javascript">
    function hasClass(elem, cls) {
        cls = cls || '';
        if (cls.replace(/\s/g, '').length == 0) return false; //当cls没有参数时，返回false
        return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
    }

    function addClass(ele, cls) {
        if (!hasClass(ele, cls)) {
            ele.className = ele.className == '' ? cls : ele.className + ' ' + cls;
        }
    }

    function removeClass(ele, cls) {
        if (hasClass(ele, cls)) {
            var newClass = ' ' + ele.className.replace(/[\t\r\n]/g, '') + ' ';
            while (newClass.indexOf(' ' + cls + ' ') >= 0) {
                newClass = newClass.replace(' ' + cls + ' ', ' ');
            }
            ele.className = newClass.replace(/^\s+|\s+$/g, '');
        }
    }

    document.querySelector(".login-button").onclick = function () {
        addClass(document.querySelector(".login"), "active")
        setTimeout(function () {
            addClass(document.querySelector(".sk-rotating-plane"), "active")
            document.querySelector(".login").style.display = "none"
        }, 800)
        setTimeout(function () {
            removeClass(document.querySelector(".login"), "active")
            removeClass(document.querySelector(".sk-rotating-plane"), "active")
            document.querySelector(".login").style.display = "block"

            //表单提交
            document.getElementById("form").submit();

        }, 0)
    }
</script>
<div style="text-align:center;">
</div>
</body>
</html>