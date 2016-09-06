<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
		  body{background-image: url(<%= basePath %>view/images/s001.gif);}
		  .table_top{
		      margin: auto;
		      height: 130px;
		  	  width: 400px;
		  }
		  
		  .table_bottom{
		      margin: auto;
		      height: 160px;
		  	  width: 400px;
		  }
		  form{ padding-top: 190px;}
		  
		  .enroll{
		      float: left;
		      display: block;
		      height:36px;
		      width: 125px;
		      font-size: 18px;
		      text-align: center;
		      text-decoration:none;
		      background-color: rgb(0, 142, 173);
		      border-radius: 5px;
			  padding-top: 5px;
			  padding-bottom: 7px;
			  box-shadow: 5px 5px 5px gray;
		  }
		  .enroll:hover{
		      background-color: blueviolet;
		   }
		  .name{
		      display: block;
		      height:30px;
		      width: 200px;
		      border: 1px solid blue;
		      box-shadow: 5px 5px 5px gray;
		      border-radius: 5px;
			  padding-top: 5px;
			  padding-bottom: 7px;
		      
		  
		  }
		  .name:hover{
		      width: 220px;
		      border: 3px solid blueviolet;
		  }
		  .return a{
		      display: block;
		      height:21px;
		      width: 120px;
		      float: right;
		      font-size: 18px;
		      text-align: center;
		      text-decoration:none;
		      color: black;
		      border:2px solid #eaeaea;
		      background-color: rgb(0, 142, 173);
		      border-radius: 5px;
			  padding-top: 5px;
			  padding-bottom: 7px;
			  box-shadow: 5px 5px 5px gray;
		  }
		  .return a:hover{
		      background-color: blueviolet;
		   }
		   #des{
		   	  height:32px;
		      width: 200px;
		   }
		   .tishi{
		       padding-left: 30%;
		       font-size: 13px;
		       color: red;
		       padding-left: 899px;
		   }
	</style>

  </head>
  
  <body>
    <form action="<%= basePath %>enroll.do?methodName=enroll" method="post" >
          <table border="0" bgcolor="" cellpadding="0" cellspacing="0" class="table_top">
              <span class="tishi"> ${re}</span>
  	          <tr>
  	              <td>账号：</td>
  	              <td>
  	              	  <input type="text" name="userName" class="name" />
  	              </td>
  		      </tr>
  		      <tr>
  	              <td>密码：</td>
  	              <td><input type="password" name="userPass" class="name"/></td>
  		      </tr>
  		      <tr>
  	              <td>邮箱：</td>
  	              <td><input type="text" name="Email" class="name"/></td>
  		      </tr>
  		      </table>
  		       <table border="0" bgcolor="" cellpadding="0" cellspacing="0"class="table_bottom" >
  		      <tr>
  	              <td>性别：</td>
  	              <td>
  	              	<input type="radio" name="sex" value="1"  id=""/>男
					<input type="radio" name="sex" value="2" id="" />女
				  </td>
  		      </tr>
  		      <tr>
  	              <td>学历：</td>
  	              <td>
  	              	  <select name="diploma" id="">
					      <option value="1">高中及以上</option>
					      <option value="2">高中及以下</option>
					  </select>
  	              </td>
  		      </tr>
  		      <tr>
  	              <td>爱好：</td>
  	              <td>
  	              	  <input type="checkbox" name="hobbys" value="1" id="" />篮球
					  <input type="checkbox" name="hobbys" value="2" id="" />足球
					  <input type="checkbox" name="hobbys" value="3" id="" />乒乓球
					  <input type="checkbox" name="hobbys" value="4" id="" />羽毛球
					  <input type="checkbox" name="hobbys" value="5" id="" />排球
  	              </td>
  		      </tr>
  		      <tr>
  	              <td>个人简介：</td>
  	              <td><textarea name="description" rows="" cols="44" id="des"></textarea></td>
  		      </tr>
  		      <tr>
  	              <td colspan="2" style="text-align: center;">
  	              <input type="submit" value="注册" class="enroll"/>
  	              <span class="return"><a href="<%= basePath %>view/login.jsp">返回登录</a></span>
  	              </td>
  		      </tr>
          </table>
      </form>
      
      
      
  </body>
</html>
