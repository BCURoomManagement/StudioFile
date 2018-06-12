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
    <title>登录</title>
  </head>
  <body>
  <form action="LoginServlet" method="post">
      <input type="text" name="u_account">
      <input type="password" name="u_name">
      <input type="submit" value="登录">
      <input type="button" value="注册" onclick="register">
  </form>
  </body>
<script language="javascript" type="text/javascript" >
        function register() {
        window.location.herf=register.jsp;
    }
</script>
</html>
