<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/20
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>软件添加</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>图书添加</legend>
    </fieldset>
    <form method="post"  action="../Book/AddBookServlet"  >
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">图书名</label>
                <div class="layui-input-inline">
                    <input type="text" name="b_name"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">提供者</label>
                <div class="layui-input-inline">
                    <input type="text" name="b_provide"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
            <input name="u_id" value="${sessionScope.u_id}" hidden >

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            </div>
        </div>
    </form>

    <input type="hidden" id="result" value="${result}">
</div>
<script type="text/javascript" src="../plugins/layui/layui.js"></script>

<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
            layer = layui.layer,
            layedit = layui.layedit,
            laydate = layui.laydate;
    });

    layui.use('layer',function(){
        var layer=layui.layer,$=layui.jquery;

        var res=$("#result").attr("value");
        if(res=="true"){
            layer.msg("添加成功!");
        }else if(res=="false"){
            layer.msg("添加失败，请稍后再试！")
        }

    });

</script>
</body>
</html>
