<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/15
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>表单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>项目文件添加</legend>
    </fieldset>
    <form method="post"  action="AddProjectFileServlet" >
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">项目名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="p_name"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">上传日期</label>
                <div class="layui-input-block">
                    <input type="text" name="p_time"  id="date" lay-verify="date" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" onclick="layui.laydate({elem: this})">
                </div>
            </div>
            <input name="u_id" value="${sessionScope.u_id}" hidden >
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            </div>
        </div>
    </form>
  <%--word--%>
<c:if test="${result=='true'}">

    <form action="Pro_upfileServlet" method="post" enctype="multipart/form-data">
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文档</label>
            <div class="layui-input-inline">
                <input type="file" id="chooseImage" name="file">
                <button class="layui-btn layui-btn-normal" onclick="deal(this.form)">上传</button>
            </div>
        </div>
        <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo">
            <div class="layui-progress-bar layui-bg-red" id="progressPercent" lay-percent="${progressBar}"></div>

        </div>
    </form>
</c:if>
     <%--code--%>
    <c:if test="${result=='true'}">

        <form action="Pro_upfileServlet" method="post" enctype="multipart/form-data">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">文档</label>
                <div class="layui-input-inline">
                    <input type="file"  name="file">
                    <button class="layui-btn layui-btn-normal" onclick="deal(this.form)">上传</button>
                </div>
            </div>
            <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo">
                <div class="layui-progress-bar layui-bg-red"  lay-percent="${progressBar}"></div>

            </div>
        </form>
    </c:if>
    <%--video--%>
    <c:if test="${result=='true'}">

        <form action="Pro_upfileServlet" method="post" enctype="multipart/form-data">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">文档</label>
                <div class="layui-input-inline">
                    <input type="file" name="file">
                    <button class="layui-btn layui-btn-normal" onclick="deal(this.form)">上传</button>
                </div>
            </div>
            <div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo">
                <div class="layui-progress-bar layui-bg-red"  lay-percent="${progressBar}"></div>

            </div>
        </form>
    </c:if>

    <input type="hidden" id="message" value="${message}">
</div>
<script type="text/javascript" src="plugins/layui/layui.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form(),
            layer = layui.layer,
            layedit = layui.layedit,
            laydate = layui.laydate;
    });

    layui.use('layer',function(){
        var layer=layui.layer,$=layui.jquery;

        var error=$("#message").attr("value");
        if(error!=null && error!=""){
            layer.msg(error);
        }
        var res=$("#result").attr("value");
        if(res=='true'){
            layer.msg("添加成功！继续上传文件。");
        }else if(res=='false'){
            layer.msg("添加失败，请稍后再试！")
        }
    });

    layui.use('element', function(){
        var $ = layui.jquery
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

    });

    var request = false;
    var xhr = createXHR();

    function getProgress(){
        var url="GetProgressServlet";                         //服务器地址
        var param ="nocache="+new Date().getTime();                  //每次请求URL参数都不同 ，避免上传时进度条不动
        // request=httpRequest("post",url,true,callbackFunc,param);   //调用请求方法
        xhr.open('post',url,true);
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4) {
                if( request.status == 200 ){                //判断响应是否成功
                    var h = request.responseText;  //获得返回的响应数据，该数据位上传进度百分比
                    h=h.replace(/\s/g,"");            //去除字符串中的Unicode空白符
                    // document.getElementById("progressPercent").style.display="";     //显示百分比
                    // progressPercent.innerHTML=h+"%+++++++++++++++++";                                  //显示完成的百分比
                    // document.getElementById("progressBar").style.display="block";   //显示进度条
                    // document.getElementById("imgProgress").width=h*(235/100);     //显示完成的进度
                    console.log("成功回调！");
                }
            }else{
                console.log("xhr.readyState"+xhr.readyState);
            }
        }

        xhr.setRequestHeader("Content-Type","text/plain");
        xhr.send(param);

    }

    function createXHR(){
        var xhr;
        if (window.XMLHttpRequest){
// code for IE7+, Firefox, Chrome, Opera, Safari
            xhr=new XMLHttpRequest();
        }else{
// code for IE6, IE5
            xhr=new ActiveXObject("Microsoft.XMLHTTP");
        }
        return xhr;
    }

    function deal(form){
        form.submit();                       //提交表单
        var timer=window.setInterval("getProgress()",8000);    //每隔500毫秒获取一次上传进度
    }

</script>
</body>
</html>
