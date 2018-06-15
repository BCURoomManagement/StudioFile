<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/12
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.server.pojo.* "%>
<%@ page isELIgnored ="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>注册</title>
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css" />

</head>

<body class="beg-login-bg">
<div class="beg-login-box" style="height: 480px">
    <header>
        <h1>注册</h1>
    </header>
    <div class="beg-login-main">
        <form action="RegisterServlet" class="layui-form" method="post"><input name="__RequestVerificationToken" type="hidden" value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <input type="text" name="u_account"  autocomplete="off" placeholder="这里输入用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input type="password" name="u_password"  autocomplete="off" placeholder="这里输入密码" class="layui-input">
            </div>

            <div class="layui-form-item">
                <input type="text" name="u_name"  autocomplete="off" placeholder="这里输入姓名" class="layui-input">
            </div>

            <div class="layui-form-item">
                <input type="text" name="u_class"  autocomplete="off" placeholder="这里输入班级" class="layui-input">
            </div>


            <div class="layui-form-item">
                <div >
                    <select name="u_grade">
                        <option value="">请选择年级</option>
                        <c:forEach   var="i" begin="2015" end="2020">
                            <option  value="${i}" >${i}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <div >
                    <select name="workroom">
                        <option value="">请选择工作室</option>
                        <c:forEach items="${workroom }" var="wkList">
                        <option  value="${wkList.w_id}" >${wkList.w_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="beg-pull-left beg-login-remember">

                </div>
                <div class="beg-pull-right">
                    <button class="layui-btn layui-btn-primary" type="submit">
                        <i class="layui-icon">&#xe650;</i> 注册
                    </button>
                </div>
                <div class="beg-clear"></div>
            </div>
        </form>
    </div>
    <footer>
    </footer>
</div>
<input type="hidden" id="result" value="${result}">
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script>
    layui.use(['layer', 'form'], function() {
        var layer = layui.layer,
            $ = layui.jquery

        var error=$("#result").attr("value");
        if(error=="true"){
            layer.msg("注册成功！！");
            var t=setTimeout("window.location.href='login.jsp'",500)
        }else if(error=="false"){
            layer.msg("注册失败！！")
        }else if(error=="again"){
            layer.msg("用户名已存在！！")
        }
    });
</script>
</body>

</html>
