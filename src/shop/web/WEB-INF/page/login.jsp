<%--
  Created by IntelliJ IDEA.
  User: player
  Date: 2024/04/10
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.xwj.dal.UserDao" %>
<%@ page import="com.xwj.service.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String inputUsername = request.getParameter("username");
    String inputPassword = request.getParameter("password");
    User user = UserDao.getUserByUserNameAndPassword(inputUsername,inputPassword);
    String msg = "";
    if (user!=null){
        session.setAttribute("activeUser",user);
        msg = user.getNickname()+"登陆成功";
    }else {
        msg = "登陆失败";
    }
%>
<%=msg%>

</body>
</html>
