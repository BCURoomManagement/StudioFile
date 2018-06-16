<%@ page import="com.server.dao.UserDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongcheng
  Date: 2018/6/15
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <legend>默认表格</legend>
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
            <th>提供者</th>
            <th>时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pfList}" var="pf">
            <tr>
                <td>${pf.p_name}</td>
                <td><c:choose>
                    <c:when test="${pf.p_word}==''">
                        无
                    </c:when>
                    <c:otherwise>
                        ${pf.p_word}
                    </c:otherwise>
                </c:choose></td>
                <td><c:choose>
                    <c:when test="${pf.p_code}==''">
                        无
                    </c:when>
                    <c:otherwise>
                        ${pf.p_code}
                    </c:otherwise>
                </c:choose></td>
                <td><c:choose>
                    <c:when test="${pf.p_video}==''">
                        无
                    </c:when>
                    <c:otherwise>
                        ${pf.p_video}
                    </c:otherwise>
                </c:choose></td>
                <td> <c:out value="new UserDao().getOneUser(${pf.u_id}).getU_name" /></td>
                <td>${pf.p_time}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
