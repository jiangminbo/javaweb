<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link type="text/css" rel="stylesheet" href="<%=basePath%>view/css/login.css">
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
	</head>
	<body class="login_bj">
		<div class="zhuce_body">
			<div class="logo">
				<a href="#"><img src="<%=basePath%>/view/images/logo.png" width="114" height="54"
						border="0">
				</a>
			</div>
			
			<div class="zhuce_kong login_kuang">
				<div class="zc">
					<div class="bj_bai">
						<h3>
							登录
						</h3>
						<form action="login.do?methodName=login" method="post" class="form">
							<input type="hidden" name="methodName" value="login">
							<input name="userName" type="text" class="kuang_txt" placeholder="手机号">
							<input name="userPass" type="password" class="kuang_txt" placeholder="密码">
							<div>
								<a href="#">忘记密码？</a>
								<input name="" type="checkbox" value="" checked>
								<span>记住我</span>
							</div>
							<input type="submit" class="btn_zhuce" value="登录">
						</form>
					</div>
					<div class="bj_right">
						<p>
							使用以下账号直接登录
						</p>
						<p>
							没有账号？
							<a href="index.jsp">请注册</a>
						</p>
						<a href="#" class="zhuce_qq">QQ注册</a>
						<a href="#" class="zhuce_wb">微博注册</a>
						<a href="#" class="zhuce_wx">微信注册</a>
					</div>
				</div>
				<P>
					
				</P>
			</div>

		</div>

	</body>
</html>