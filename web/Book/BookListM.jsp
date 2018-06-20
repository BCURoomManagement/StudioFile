<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/20
  Time: 20:35
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
    <legend>图书列表</legend>
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
            <th>书名</th>
            <th>提供者</th>
            <th>借阅状态</th>
            <th>借阅者</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bkList}" var="bk" >
            <th>${bk.b_name}</th>
            <th>${bk.b_provide}</th>
            <th>
                <c:choose>
                    <c:when test="${bk.b_status==0}">
                        未借阅
                    </c:when>
                    <c:otherwise>
                        已借阅
                    </c:otherwise>
                </c:choose>
            </th>
            <th>${bk.username}</th>
            <th id="layer">
                <button  id="edit" data-method="edit" data-path="<%=basePath%>" data-b_id="${bk.b_id}" class="layui-btn layui-btn-mini">编辑</button>
                <button  id="deletee" data-method="deletee"  data-b_id="${bk.b_id}" class="layui-btn layui-btn-mini">删除</button>
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

            edit: function(othis){
                var b_id=othis.data('b_id');
                var path=othis.data('path');

                layer.open({
                    type: 2
                    ,offset:'20px'
                    ,content:''+path+'Book/BookEditServlet?b_id='+b_id+''
                    ,shade: [0.8, '#393D49'] //显示遮罩
                    ,area: ['800px', '500px']
                });
            },
            deletee: function(othis){
                var b_id=othis.data('b_id');
                layer.open({
                    type: 1
                    , offset: '100px'
                    , content: '<form class="layui-form" action="BKdeleteServlet" method="get">' +
                    '<p style="position:absolute;top:90px;left:95px;font-size:18px;">确定要删除此图书么？</p>' +
                    '<input type="text" name="b_id" hidden="hidden" value="' + b_id + '"></input>' +
                    '<div style="position:absolute;top:120px;left:160px;"><button type="submit" class="layui-btn layui-btn-normal">确定</button></div></form>'
                    , btnAlign: 'c' //按钮居中
                    , shade: [0.8, '#393D49'] //显示遮罩
                    , area: ['400px', '300px']
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
            layer.msg("操作成功!");
        }else if(res=="false"){
            layer.msg("操作失败，请稍后再试！")
        }
    })
</script>
</html>