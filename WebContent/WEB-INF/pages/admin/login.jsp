<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>Admin Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=basePath%>css/matrix-login.css"/>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-responsive.min.css"/>
<link rel="stylesheet" href="<%=basePath%>font-awesome/css/font-awesome.css" />
<link rel="stylesheet" href="<%=basePath%>css/AdminLogin.css" />
</head>
<body>
<div class="login-box">
		<h2>管理员登录</h2>
		<form id="loginform" class="form-vertical" action="<%=basePath%>admin/index" method="post" role="form">
			<div class="login-field">
				<input type="text"  name="phone" id="phone"  value=""  required="" />
				<label>Phone</label>
			</div>
			<div class="login-field">
				<input type="password"  name="password" id="password" required="" />
				<label>Password</label>
			</div>
			<div align="center">
			<button  type="submit"  value="Login" name="Login" >登录</button>
			</div>
		</form>
	</div>
	
	<script src="<%=basePath%>js/jquery.min.js"/></script>
	<script src="<%=basePath%>js/matrix.login.js" type="text/javascript" charset="utf-8"></script>
	<script src="<%=basePath%>js/jquery.validate.js"/></script>
	<script src="<%=basePath%>js/jquery.md5.js"/></script>
	<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
    $("#loginform").validate({
        rules: {
        	phone: "required",
            password: {
                required: true,
                minlength: 6
            },
        },
        messages: {
        	phone:  "请输入用户名",
            password: {
                required: "请输入密码",
                minlength: jQuery.format("密码不能小于{0}个字符")
            }
        }
    });
    function encrypt(){
    	/// var pwd = $.md5($("#password").val());
    	$("#password").val(pwd);
    	return true;
    };
</script>
</body>

</html>
