<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>所有分类</title>

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/dashboard/dashboard.css" rel="stylesheet">


</head>
<body >
<!-- 	<table  style="text-align: center;" align="center" frame="border" border="1" width="60%"> -->
	<!-- <h1 class="sub-header">Section title</h1> -->
	<h1 class="page-header">Section title</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>分类名称</th>
				<th>分类描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="category" items="${requestScope.list}">
			<tr>
				<td>${category.name }</td>
				<td>${category.description }</td>
				<td>
					<a href="${pageContext.request.contextPath }/manager/updateCategory.jsp?id=${category.id }&name=${category.name}&description=${category.description}" class="btn btn-primary" role="button">修改分类</a>
					<!-- ${requestScope.category} -->
					<a href="${pageContext.request.contextPath }/manager/CategoryServlet?method=deleteCategory&id=${category.id }&name=${category.name}" class="btn btn-default" role="button">删除分类</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>