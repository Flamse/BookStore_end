<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>所有图书</title>
	
	<!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/dashboard/dashboard.css" rel="stylesheet">
	
</head>
		<h1 class="page-header">图书管理</h1>
		<table class="table table-striped">
			
			<thead>
				<tr>
					<th>图书名称</th>
					<th>作者</th>
					<th>价格</th>
					<th>描述</th>
					<th>图片</th>
					<th>操作</th>
				</tr>
				</thead>
				
				<tbody>
				<c:forEach var="book" items="${page.list }">
					<tr>
						<td>${book.name }</td>
						<td>${book.author }</td>
						<td>${book.price }</td>
						<td>${book.description }</td>
						<td>
							<img alt="100%x200" style="height: 100px; display: block;" src="${pageContext.request.contextPath }/${book.image}" />
							<a href="${pageContext.request.contextPath}${book.image}" >查看图片(更改图片)</a>
						</td>
						<td>
							<a href="${pageContext.request.contextPath }/manager/BookServlet?method=updateBookUI&id=${book.id }" class="btn btn-primary" role="button">修改图书</a>
							<a href="${pageContext.request.contextPath }/manager/BookServlet?method=deleteBook&id=${book.id }" class="btn btn-default" role="button">删除图书</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
		</table>
		<hr>
		
		<%@ include file="/client/page.jsp"%>
		
</html>