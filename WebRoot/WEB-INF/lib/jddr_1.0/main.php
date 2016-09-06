<?php
//简单管理页面范例，在你的管理页面引用checkA.php就OK，当然，不要忘了添加注销登录的链接
include_once 'checkA.php';
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>简单管理登陆系统-管理主页面</title>
</head>
<body>
管理员，欢迎你！<a href='loginout.php'>注销登录</a>
</body>
</html>