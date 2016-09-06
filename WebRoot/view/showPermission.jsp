<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'alterPermission.jsp' starting page</title>
    
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
  	  <form action="<%= basePath %>affirm.do?methodName=affirm&rid=${role.rid}" method="post" >
  	  	  <p>${msg}</p>
  	  	  <p>角色:<b>${role.name}</b>,编辑角色权限：</p>
  	  	  <table border="0" bgcolor="" cellpadding="0" cellspacing="0" class="table_top">
  	  	  	  <c:forEach items="${showRolePermission}" var="a">
  	  	  	  	  <input type="checkbox" name="mids" value="${a[0]}"  <c:if test="${a[3]==1}">checked</c:if> />${a[1]}<br/>
  	  	  	  </c:forEach>
  	  	  </table> 
  	  	  <input type="submit" value="确认修改" />
  	  </form>
  </body>
</html>
