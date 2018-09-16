<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>购物车页面</title>

	<!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/dashboard/dashboard.css" rel="stylesheet">

</head>
<body style="text-align: center;">
<h2 class="page-header">购物车</h2>
	<table class="table table-striped">
	<thead>
		<tr>
			<th>商品名</th>
			<th>商品图片</th>
			<th>单价</th>
			<th>数量</th>
			<th>小计</th>
			<th>操作</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach var="me" items="${cart.map}">
			<tr>
				<td>${me.value.book.name }</td>
				<td>
					<img alt="${me.value.book.name }" src="${pageContext.request.contextPath }/${me.value.book.image}" width="30px"/>
				</td>
				<td>${me.value.book.price }</td>
				<td>${me.value.num }</td>
				<td>${me.value.sum }</td>
				<td>
					<a href="#">删除</a>
					<a href="#">增加</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
		<tfoot>
		<tr>
			<td colspan="6" style="text-align: right;">
				<a href="${pageContext.request.contextPath }/client/MakeOrdersServlet" class="btn btn-primary" role="button">总计：${cart.totalprice }，确认下单</a>
			</td>
		</tr>
		</tfoot>
	</table>
	
	
</body>
</html>