<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<html>
<head>
<title>head</title>
<!-- <link rel="stylesheet" type="text/css" href="WebRoot/resource/css/public.css"/> -->
</head>
<body style="text-align:center; margin:0;">
<div style="background-color: #24292e; color: rgba(255,255,255,0.75);">
<header role="banner" style="padding-top: 18px; padding-bottom: 18px;">
	<div style="display:flex; max-width: 980px; margin-right: auto; margin-left: auto; justify-content: space-between !important;">
		<div style="display:flex; justify-content: space-between !important;">午后书院</div>
		<div style="display:flex; flex: 1 1 auto !important; justify-content: space-between !important;">
			<div style="display:flex;">
				<div style="display: flex"><!-- 搜索框 --></div>
				<div style="display: flex">
					<ul style="display:flex; list-style: none; margin-top: 0; margin-bottom: 0;">
						<li><a style="padding-left:10px; padding-right:10px; color: rgba(255,255,255,0.75);text-decoration: none;" href="${pageContext.request.contextPath }/client/IndexServlet" target="body">首页</a></li>
						<li><a style="padding-left:10px; padding-right:10px; color: rgba(255,255,255,0.75);text-decoration: none;" href="${pageContext.request.contextPath }/client/listCart.jsp" target="body">查看购物车</a></li>
						<li><a style="padding-left:10px; padding-right:10px; color: rgba(255,255,255,0.75);text-decoration: none;" href="${pageContext.request.contextPath }/client/OrdersServlet?method=listOrders" target="body">查看订单</a></li>
						<li><a style="padding-left:10px; padding-right:10px; color: rgba(255,255,255,0.75);text-decoration: none;" href="${pageContext.request.contextPath }/manager.jsp" target="_blank">后台1</a></li>
						<li><a style="padding-left:10px; padding-right:10px; color: rgba(255,255,255,0.75);text-decoration: none;" href="${pageContext.request.contextPath }/managerNew.jsp" target="_blank">后台2</a></li>
					</ul>
				</div>
			</div>
			<div style="display:flex; ">
				<c:if test="${user!=null }">
					欢迎您：${user.username }
				</c:if>
		
				<c:if test="${user==null }">
				<form action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
					用户名：<input type="text" name="username" size="7%">
					密码:<input type="password" name="password" size="7%">
					<input type="submit" value="登录">
					<input type="button" value="注册" onclick="javascript:window.parent.body.location.href='register.jsp'">
				</form>
				</c:if>
			</div>
		</div>
	</div>
</header>
</div>
<!-- 	<h1>午后书院</h1>
	
	<div style="position:absolute; left:400px;">
		<a href="${pageContext.request.contextPath }/client/IndexServlet" target="body">首页</a>
		<a href="${pageContext.request.contextPath }/client/listCart.jsp" target="body">查看购物车</a>
		<a href="${pageContext.request.contextPath }/client/OrdersServlet?method=listOrders" target="body">查看订单</a>
		<a href="${pageContext.request.contextPath }/manager.jsp" target="body">后台</a>
	</div>
	
	<div style="position:absolute; right:400px;">
		<c:if test="${user!=null }">
		欢迎您：${user.username }
		</c:if>
		
		<c:if test="${user==null }">
			<form action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
				用户名：<input type="text" name="username" size="7%">
				密码:<input type="password" name="password" size="7%">
				<input type="submit" value="登录">
				<input type="button" value="注册" onclick="javascript:window.parent.body.location.href='register.jsp'">
			</form>
		</c:if>
	</div> -->
</body>
</html>