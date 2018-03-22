<!DOCTYPE html>
<%@page language="java" contentType="text/html;charset=UTF-8"

        pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
    <link href="css/style.css" rel='stylesheet' type='text/css' />

</head>
<body>
<script>$(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.login-form').fadeOut('slow', function(c){
            $('.login-form').remove();
        });
    });
});
</script>
<!--SIGN UP-->
<h1>klasikal Login Form</h1>
<div class="login-form">
    <div class="close"> </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="images/avtar.png" />
    </div>
    <%--<form  action="http://127.0.0.1:8008/cityinfo/login" method="post">--%>
        <%--<input type="text" class="text" name="name" value="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}" >--%>
        <%--<div class="key">--%>
            <%--<input type="password" name="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">--%>
        <%--</div>--%>
        <%--<div class="signin">--%>
            <%--<input type="submit" value="Login" >--%>
        <%--</div>--%>
    <%--</form>--%>
    <form enctype="multipart/form-data" method="post" action="/catalog/addPic">
        图片<input type="file" name="file"/>
        <input type="submit" value="上传"/>
    </form>
</div>
<div class="copy-rights">
    <p> zhongruaqnguoji</p>
</div>

</body>
</html>