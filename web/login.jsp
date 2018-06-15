<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/12
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>登录</title>
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="css/login.css" />
</head>

<body class="beg-login-bg">
<div class="beg-login-box">
    <header>
        <h1>登录</h1>
    </header>
    <div class="beg-login-main">
        <form action="LoginServlet" class="layui-form" method="post"><input name="__RequestVerificationToken" type="hidden" value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe612;</i>
                </label>
                <input type="text" name="u_account" lay-verify="userName" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="beg-login-icon">
                    <i class="layui-icon">&#xe642;</i>
                </label>
                <input type="password" name="u_password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
            </div>
            <div class="layui-form-item">
                <div class="beg-pull-left beg-login-remember">
                    <button class="layui-btn layui-btn-primary" type="submit">
                        <i class="layui-icon">&#xe650;</i> 登录
                    </button>
                </div>
                <div class="beg-pull-right">
                    <button class="layui-btn layui-btn-primary" type="button" onclick="register()">
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
            layer.msg("登录成功！！");
            var t=setTimeout("window.location.href='index.jsp'",500)
        }else if(error=="false"){
            layer.msg("登录失败！！")
        }

    });

    function register() {
        window.location.href="GetAllWorkroomServlet"
    }
</script>
</body>

</html>