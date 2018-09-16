<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>未发货订单</title>

	<!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/dashboard/dashboard.css" rel="stylesheet">

</head>
<body >
	<h1 class="page-header">未发货订单信息</h1>
	<table class="table table-striped">
	<thead>
		<tr>
			<th>订单号</th>
			<th>下单时间</th>
			<th>总价</th>
			<th>订单状态</th>
			<th>客户名</th>
			<th>订单明细</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="order" items="${orders }">
			<tr>
				<td>${order.id }</td>
				<td>${order.orderTime }</td>
				<td>${order.totalprice}</td>
			
				<c:choose>
					<c:when test="${order.state==false}">
						<td>未发货</td>
					</c:when>
					<c:otherwise>
						<td>已发货</td>
					</c:otherwise>
				</c:choose>
				
				
				<td>${order.user.username }</td>
				<td>
					<a href="${pageContext.request.contextPath }/manager/OrderServlet?method=listOrderItems&order_id=${order.id}">订单明细</a>
				</td>
			</tr>
		
		</c:forEach>
		</tbody>
	</table>
	

	<h1 class="page-header">客户信息</h1>
	<table class="table table-striped">
	<thead>
		<tr>
			<th>客户名</th>
			<th>手机号</th>
			<th>地址</th>
			<th>订单号</th>
			<th>操作</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="order" items="${orders }">
			<tr>
				<td>${order.user.username }</td>
				<td>${order.user.phone }</td>
				<td>${order.user.address}</td>
				<td>${order.id }</td>
				<td>
					<a href="${pageContext.request.contextPath }/manager/OrderServlet?method=updateState&state=true&order_id=${order.id}">确认发货</a>
				</td>
			</tr>
		
		</c:forEach>
	</tbody>
	</table>


</body>
</html>