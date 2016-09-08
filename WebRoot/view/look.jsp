<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Object[]> list = (List<Object[]>)request.getAttribute("alterList");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h3>用户列表</h3>
      <table border="1" width="100%" bordercolor="chartreuse" cellpadding="0" cellspacing="0" height="50px">
          <tr height="40px">
              <td>编号</td>
              <td>用户名</td>
              <td>性别</td>
              <td>学历</td>
              <td>邮箱</td>
              <td>爱好</td>
              <td>个人简介</td>
              <td>操作</td>
          </tr>
          <c:forEach items="${alterList}" var="o">
          	  <tr>
		          <td>${o.uid}</td>
		          <td>${o.userName}</td>
		          <td>
		          	  <c:if test="${o.sex==1}">男</c:if>
		          	  <c:if test="${o.sex==2}">女</c:if>
		          </td>
		          <td>
		          	  <c:if test="${o.diploma==1}">高中及以上</c:if>
		          	  <c:if test="${o.diploma==2}">高及以下</c:if>
		          </td>
		          <td>${o.email}</td>
		          <td>${o.hobby}</td>
		          <td>${o.description}</td>
		          <td><a href="<%=basePath%>showUser.do?methodName=showUser">返回</a></td>
	          </tr>
          </c:forEach>
         
      </table>
  </body>
</html>
