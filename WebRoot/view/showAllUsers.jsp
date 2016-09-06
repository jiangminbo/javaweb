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

		<title>My JSP 'showMenus.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">
					function addtabls(title,url){
						$("#tabs").tabs('add',{
							title:title,
							selected:true,
							closable:true,
							content :"<iframe height='100%' width='100%' scrolling='auto' frameborder='0' src='"+ url +"'></iframe>"
							
						});
					}
		</script>
	</head>

	<body>
		 <h3>用户列表</h3>
      <table border="1" width="100%" bordercolor="chartreuse" cellpadding="0" cellspacing="0" height="50px">
          <tr height="40px">
              <td>员工工号</td>
              <td>部门主管编号</td>
              <td>用户登录名</td>
              <td>用户密码</td>
              
              <td>真实姓名</td>
              <td>手机号</td>
             
              <td>用户头像图片路径</td>
               <td>email</td>
              <td>QQ</td>
              <td>微信</td>
              <td>紧急联系人</td>
              <td>紧急联系人手机号</td>
              <td>所属部门ID</td>
              <td>入职时间</td>
              <td>是否有效</td>
          </tr>
          <c:forEach items="${userList}" var="o">
          	  <tr>
					<td>
						${o.uid}
					</td>
					<td>
						${o.number}
					</td>
					<td>
						${o.userName}
					</td>
					<td>
						${o.userPass}
					</td>
					<td>
						${o.realName }
					</td>
					<td>
						${o.phone}
					</td>
					<td>${o.picture}</td>
					<td>
						${o.email}
					</td>
					<td>
						${o.qq}
					</td>
					<td>
						${o.weChat}
					</td>
					<td>
						${o.emContact}
					</td>
					<td>
						${o.emPhone}
					</td>
					<td>
						${o.deptid}
					</td>
					<td>
						${o.intime}
					</td>
		        
		          <td>
		          	  <c:if test="${o.bol==1}">yes</c:if>
		          	  <c:if test="${o.bol==2}">NO</c:if>
		          </td>
		          <td><a href="<%=basePath%>showUser.do?methodName=showUser">返回</a></td>
	          </tr>
          </c:forEach>
         
      </table>
	</body>
</html>
