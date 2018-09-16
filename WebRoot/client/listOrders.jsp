<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>客户订单</title>

	<!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/dashboard/dashboard.css" rel="stylesheet">

</head>
<body style="text-align: center;">
	
	<h2 class="page-header">客户订单</h2>
	<table class="table table-striped">
	<thead>
		<tr>
			<th>订单号</th>
			<th>下单时间</th>
			<th>订单状态</th>
			<th>总价</th>
			<th>操作</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td>${order.id }</td>
				<td>${order.orderTime }</td>
				
				<c:choose>
					<c:when test="${order.state==false }">
						<td>未发货</td>
					</c:when>
					<c:otherwise>
						<td>已发货</td>
					</c:otherwise>
				</c:choose>
				
				
				<td>${order.totalprice }</td>
				<td>
					<a href="${pageContext.request.contextPath }/client/OrdersServlet?method=listOrderItems&order_id=${order.id}">订单明细</a>
				</td>
			</tr>
		
		</c:forEach>
		</tbody>
	
	
	</table>
	
</body>
</html>