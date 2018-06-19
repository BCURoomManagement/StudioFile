<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/17
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<link rel="stylesheet" href="../plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="../css/global.css" media="all">
<link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../css/table.css" />
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>比赛列表</legend>
</fieldset>
<div class="layui-form">
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="200">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>项目名</th>
            <th>文档</th>
            <th>源代码</th>
            <th>视频</th>
            <th>证书</th>
            <th>提供者</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cpList}" var="cp" >
            <tr>
                <th>${cp.c_name}</th>
                <th>
                    <c:choose>
                        <c:when test="${cp.c_word ==''}">
                            无
                        </c:when>
                        <c:otherwise>
                            <a style="color:#ff5722" href="<%=basePath%>upload/${cp.c_word}">${cp.c_word}</a>
                        </c:otherwise>
                    </c:choose>
                </th>
                <th>
                    <c:choose>
                        <c:when test="${cp.c_code ==''}">
                            无
                        </c:when>
                        <c:otherwise>
                            <a style="color:#ff5722" href="<%=basePath%>upload/${cp.c_code}">${cp.c_code}</a>
                        </c:otherwise>
                    </c:choose>
                </th>
                <th>
                    <c:choose>
                        <c:when test="${cp.c_video ==''}">
                            无
                        </c:when>
                        <c:otherwise>
                            <a style="color:#ff5722" href="<%=basePath%>upload/${cp.c_video}">${cp.c_video}</a>
                        </c:otherwise>
                    </c:choose>
                </th>
                <th>
                    <c:choose>
                        <c:when test="${cp.c_certificate ==''}">
                            无
                        </c:when>
                        <c:otherwise>
                            <a style="color:#ff5722" href="<%=basePath%>upload/${cp.c_certificate}">${cp.c_certificate}</a>
                        </c:otherwise>
                    </c:choose>
                </th>
                <%--提供者--%>
                <th>${cp.c_username}</th>
                <th>${cp.c_time}</th>
                <th id="layer">
                    <button  id="edit" data-method="edit" data-type="${cp.c_id}" data-path="<%=basePath%>" class="layui-btn layui-btn-mini">编辑</button>
                    <button  id="deletee" data-method="deletee" data-type="${cp.c_id}" class="layui-btn layui-btn-mini">删除</button>
                </th>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<input type="hidden" id="message" value="${message}">
<input type="hidden" id="result" value="${result}">
<script type="text/javascript" src="../plugins/layui/layui.js"></script>
</body>
<script>

    layui.use('layer', function() { //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
//触发事件
        var active = {

            deletee: function (othis) {
                var type = othis.data('type');

                text = othis.text();
                layer.open({
                    type: 1
                    , offset: '100px'
                    , content: '<form class="layui-form" action="CPdeleteServlet" method="get">' +
                    '<p style="position:absolute;top:90px;left:95px;font-size:18px;">确定要删除此比赛文件么？</p>' +
                    '<input type="text" name="c_id" hidden="hidden" value="' + type + '"></input>' +
                    '<div style="position:absolute;top:120px;left:160px;"><button type="submit" class="layui-btn layui-btn-normal">确定</button></div></form>'
                    , btnAlign: 'c' //按钮居中
                    , shade: [0.8, '#393D49'] //显示遮罩
                    , area: ['400px', '300px']
                });
            },
            edit: function(othis){
                var type = othis.data('type');
                var path=othis.data('path');

                layer.open({
                    type: 2
                    ,offset:'20px'
                    ,content:''+path+'Competition/CompetitionEditServlet?c_id='+type+''
                    ,shade: [0.8, '#393D49'] //显示遮罩
                    ,area: ['800px', '500px']
                });
            }
        };

        $('#layer .layui-btn').on('click', function () {
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';

        });

        var error=$("#message").attr("value");
        if(error!=null && error!=""){
            layer.msg(error);
        }

        var res=$("#result").attr("value");
        if(res=="true"){
            layer.msg("删除成功!");
        }else if(res=="false"){
            layer.msg("删除失败，请稍后再试！")
        }
    })
</script>
</html>
