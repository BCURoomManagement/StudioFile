<%@ page import="com.server.dao.UserDao" %>
<%@ page import="com.server.pojo.ProjectFile" %>
<%@ page import="java.util.List" %>
<%@ page import="com.server.dao.ProjectFileDao" %>
<%@ page import="com.server.pojo.Workroom" %>
<%@ page import="com.server.dao.WorkroomDao" %>
<%@ page import="com.server.pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/15
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="css/global.css" media="all">
<link rel="stylesheet" href="plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/table.css" />
<head>
    <title>Title</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend><%=new WorkroomDao().getName(Integer.parseInt(session.getAttribute("w_id").toString()))%></legend>
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
            <th>姓名</th>
            <th>学号</th>
            <th>班级</th>
            <th>年级</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> uList=new UserDao().getOneWRUser(Integer.parseInt(session.getAttribute("w_id").toString()));
            if (uList!=null){
                for(User us:uList){
        %>
            <td><%=us.getU_name()%></td>
            <td><%=us.getU_account()%></td>
            <td><%=us.getU_class()%></td>
            <td><%=us.getU_grade()%></td>
        <%
                }}
        %>

        </tbody>
    </table>
</div>
<input type="hidden" id="message" value="${message}">
<script type="text/javascript" src="plugins/layui/layui.js"></script>
</body>
<script>

</script>
</html>
