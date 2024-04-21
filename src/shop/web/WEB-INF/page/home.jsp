<%@ page import="com.xwj.service.User" %><%--
  Created by IntelliJ IDEA.
  User: player
  Date: 2024/04/10
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User activeUser = (User) session.getAttribute("activeUser");
%>
用户:<%=activeUser.getNickname()%>
</body>
</html>
