<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE    html PUBLIC    "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>贵美商城</title>
    <link rel="stylesheet" type="text/css" href="css/global.css"/>
    <link rel="stylesheet" type="text/css" href="css/error.css"/>
    <link rel="stylesheet" type="text/css" href="css/layout.css"/>
    <script type="text/JavaScript" src="js/func.js"></script>

    <script type="text/javascript" src="script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        // form1表单验证，验证登录名，密码，再次输入密码不能为空。用户名只包含字母、数字、下划线或连字符，并且长度在4到16个字符之间。再次输入密码应该与密码一致，密码长度在6到16个字符之间。验证电子邮箱格式。
        $(function () {
            $("#form1").submit(function () {
                var username = $("#username").val();
                if (username == "") {
                    $(".errorMsg").html("用户名不能为空");
                    return false;
                }
                if (!/^[a-zA-Z0-9_-]{4,16}$/.test(username)) {
                    $(".errorMsg").html("用户名只包含字母、数字、下划线或连字符，并且长度在4到16个字符之间");
                    return false;
                }

                var password = $("#password").val();
                if (password == "") {
                    $(".errorMsg").html("密码不能为空");
                    return false;
                }
                if (!/^[a-zA-Z0-9_-]{6,16}$/.test(password)) {
                    $(".errorMsg").html("密码长度在6到16个字符之间");
                    return false;
                }
                var repassword = $("#repassword").val();
                if (repassword == "") {
                    $(".errorMsg").html("再次输入密码不能为空");
                    return false;
                }

                if (password != repassword) {
                    $(".errorMsg").html("两次输入的密码不一致");
                    return false;
                }
                var email = $("#email").val();
                if (email == "") {
                    $(".errorMsg").html("电子邮箱不能为空");
                    return false;
                }
                if (!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(email)) {
                    $(".errorMsg").html("电子邮箱格式不正确");
                    return false;
                }
                return true;
            });
        });


    </script>
</head>
<body>
<div id="container">
    <iframe id="header" src="header.jsp" width="980" height="136" frameborder="0" scrolling="no"></iframe>
    <%--注册表单，发送到java/com/xwj/controller的register方法，注册成功后跳转到register_success.jsp页面--%>
    <form id="form1" method="post" action="http://localhost:8080/shop_system/userController?action=register">
        <table class="reg" cellspacing="0px" cellpadding="0px">
            <tbody>
            <tr>
                <td>
                    <!--错误信息显示地方 -->
                    <span class="errorMsg"></span>
                </td>
            </tr>
            <tr>
                <td class="a_r"><label for="username">登录名：</label></td>
                <td><input name="username" id="username" type="text"/>（用户名只包含字母、数字、下划线或连字符，并且长度在4到16个字符之间）
                </td>
            </tr>
            <tr>
                <td class="a_r"><label for="password">密码：</label></td>
                <td><input name="password" id="password" type="password"/>（要求密码的长度在6到16个字符之间）</td>
            </tr>
            <tr>
                <td class="a_r"><label for="repassword">再次输入密码：</label></td>
                <td><input name="repassword" id="repassword" type="password"/></td>
            </tr>
            <tr>
                <td class="a_r"><label for="email">电子邮箱：</label></td>
                <td><input name="email" id="email" type="text"/>（必须包含 @ 字符）</td>
            </tr>
            <tr>
                <td class="a_r"><label for="gender">性别：</label></td>
                <td>
                    <input name="gender" id="gender" class="b0" type="radio" value="男" checked="checked"/>
                    <img src="img/Male.gif" alt="alt"/>男&nbsp;
                    <input name="gender" class="b0" type="radio" value="女"/>
                    <img src="img/Female.gif" alt="alt"/>女

                </td>
            </tr>
            <tr>
                <td class="a_r"><label for="hobby">爱好：</label></td>
                <td>
                    <input class="b0" type="checkbox" name="hobby" id="hobby" value="运动"/>&nbsp;运动&nbsp;&nbsp;
                    <input class="b0" type="checkbox" name="hobby2" value="聊天"/>&nbsp;聊天&nbsp;&nbsp;
                    <input class="b0" type="checkbox" name="hobby3" value="玩游戏"/>&nbsp;玩游戏
                </td>
            </tr>
            <tr>
                <td colspan="2" class="pl150"><input id="sub_resp" type="image" name="submit" class="b0"
                                                     src="img/submit.gif"/></td>
            </tr>
            </tbody>
        </table>
    </form>

    <iframe id="footer" src="footer.jsp" width="980" height="150" frameborder="0" scrolling="no"></iframe>
</div><!--container	end-->
</body>
