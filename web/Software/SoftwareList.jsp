<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/20
  Time: 8:24
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
            <th>软件名</th>
            <th>软件</th>
            <th>版本号</th>
            <th>提供者</th>
            <th>上传日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${swList}" var="sw" >
            <tr>
                <th>${sw.s_name}</th>

                <th>
                    <c:choose>
                        <c:when test="${sw.s_software ==''}">
                            无
                        </c:when>
                        <c:otherwise>
                            <a style="color:#ff5722" href="<%=basePath%>upload/${sw.s_software}">${sw.s_software}</a>
                        </c:otherwise>
                    </c:choose>
                </th>
                <th>
                    <c:choose>
                        <c:when test="${sw.s_version ==''}">
                            无
                        </c:when>
                        <c:otherwise>
                            ${sw.s_version}
                        </c:otherwise>
                    </c:choose>
                </th>
                    <%--提供者--%>
                <th>${sw.s_username}</th>
                <th>${sw.s_time}</th>
                <th id="layer">
                    <button  id="edit" data-method="edit" data-type="${sw.s_id}" data-path="<%=basePath%>" class="layui-btn layui-btn-mini">编辑</button>
                    <button  id="deletee" data-method="deletee" data-type="${sw.s_id}" class="layui-btn layui-btn-mini">删除</button>
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
                    , content: '<form class="layui-form" action="SWdeleteServlet" method="get">' +
                    '<p style="position:absolute;top:90px;left:95px;font-size:18px;">确定要删除此软件文件么？</p>' +
                    '<input type="text" name="s_id" hidden="hidden" value="' + type + '"></input>' +
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
                    ,content:''+path+'Software/SoftwareEditServlet?s_id='+type+''
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
