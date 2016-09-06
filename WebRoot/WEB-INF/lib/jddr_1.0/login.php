<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>简单管理登陆系统-登陆</title>
<style type="text/css">
<!--
.input{
	width:170px;
	height:20px;
}
body,td,th {
	font-family: "微软雅黑";
	font-size: 14px;
	color: #333;
}
-->
</style>
</head>

<body>
<form id="loginform" name="loginform" method="post" action="logincheck.php">
	<table width="400" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="60" colspan="2" align="center" bgcolor="#00CCFF"><img src="images/button_logo.png" width="340" height="32" /></td>
		</tr>
		<tr>
			<td width="150" height="60" align="right" bgcolor="#00CCFF">用户名：</td>
			<td height="60" align="left" bgcolor="#00CCFF">
				<input name="username" type="text" class="input" id="username" />
			</td>
		</tr>
		<tr>
			<td width="150" height="60" align="right" bgcolor="#00CCFF">密　码：</td>
			<td height="60" align="left" bgcolor="#00CCFF">
				<input name="userpass" type="password" class="input" id="userpass" />
			</td>
		</tr>
		<tr>
			<td height="60" colspan="2" align="center" bgcolor="#00CCFF">
				<input type="image" src="images/button_login.png" name="submit" id='submit' onclick="" />
					　
				<img src="images/button_reset.png" onclick="document.loginform.reset();" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>