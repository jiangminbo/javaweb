<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'p.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.3.3/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.3.3/themes/icon.css">
		<SCRIPT src="<%=basePath%>jquery-easyui-1.3.3/jquery-1.9.1.min.js"type="text/javascript"></SCRIPT>
		<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
		<style type="text/css">
		.south{
			clors:fuchsia;
			size:10px;
		}
		</style>
		<script type="text/javascript">
		function addtab(title,url){
			$("#tabs").tabs('add',{
				title:title,
				selected:true,
				closable:true,
				content :"<iframe height='100%' width='100%' scrolling='auto' frameborder='0' src='"+ url +"'></iframe>"
				
			});
		}
		</script>
	</head>
	<body class="easyui-layout">   
	    <div data-options="region:'north',split:true" style="height:100px;background-image:url(<%=basePath%>view/images/loginbeij.jpg);">
	    	<h1 style="text-align: center;">欢迎来到铜雀台整形医院后台管理系统</h1>
	    </div>   
	    <div data-options="region:'west',title:'系統菜單',split:true" style="width:180px;">
	    	<ul id="tt" class="easyui-tree">   
				<c:forEach items="${menuList}" var ="m2">
					<c:if test="${m2.level==2}">
						<li>
							<span>${m2.name}</span>
							<ul>
								<c:forEach items="${menuList}" var ="m3">
									<c:if test="${m3.parentid==m2.mid}">
										<li><a href ="javascript:addtab('${m3.name}','${m3.url}');" onclick="">${m3.name}</a></li>
									</c:if>
								</c:forEach>
							</ul>
						</li>
					</c:if>
				</c:forEach>
			</ul>
		</div>   
	    <div data-options="region:'center'" style="padding:5px;background:#eee;">
	    	<div id="tabs" class="easyui-tabs" data-options="fit:true">   
			    <div title="欢迎" style="padding:40px;">   
			       	欢迎   
			    </div>  
			</div>
	    </div>   
	</body>  
<html>