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
    
    <title>My JSP 'addMenu.jsp' starting page</title>
    
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
       <form action="<%= basePath %>addMenu.do?methodName=addMenu" method="post" >
          <table border="0" bgcolor="" cellpadding="0" cellspacing="0" class="table_top">
  	          <tr>
  	              <td> <label for="name">菜单名称：</label></td>
  	              <td>
  	              	  <input type="text" name="name" class="name" />
  	              </td>
  		      </tr>
  		      <tr>
  	              <td><label for="url">菜单URL：</label></td>
  	              <td><input type="text" name="url" class="url"/></td>
  		      </tr>
  		      <tr>
  	              <td><label for="isshow">是否展示：</label></td>
  	              <td>
  	              	<input type="radio" name="isshow" value="1"  id="isshow"/>展示
					<input type="radio" name="isshow" value="0" id="isshow" />不展示
				  </td>
  		      </tr>
  		      <tr>
  	              <td><label for="parentid">父级菜单：</label></td>
  	              <td>
  	              	  <select name="parentid" id="parentid">
  	              	  	  <c:forEach items="${menuList}" var="m">
  	              	  	  	  <option value="${m.mid }">
  	              	  	  	  	  <c:if test="${m.level==1}">一级-${m.name}</c:if>
  	              	  	  	  	  <c:if test="${m.level==2}">二级-${m.name}</c:if>
  	              	  	  	  </option>
  	              	  	  </c:forEach>
					  </select>
  	              </td>
  		      </tr>
  		      <tr>
  	              <td colspan="2">
  	              	  <input type="submit" value="提交" class=""/>
  	              </td>
  		      </tr>
          </table>
      </form>
  </body>
</html>
