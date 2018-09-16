<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>body</title>
<link rel="stylesheet" type="text/css" href="../resource/css/public.css"/>
</head>
<body>

		<div id="category" style="float: left;margin-left:230px;height:200px;width:120px;border:1px solid red;text-align: left">
			<div style="text-align:center">图书类别</div>
			<ul>
				<li><a href="${pageContext.request.contextPath }
					/client/IndexServlet" target="body">全部图书</a></li>
				<c:forEach var="c" items="${category }">
					<li><a href="${pageContext.request.contextPath }
					/client/IndexServlet?category_id=${c.id}" target="body">${c.name }<span></span></a></li>
				</c:forEach>
			</ul>
		</div>
		<div id="bookAndPage" style="float: left;margin-left: 180px;">
			<div id="books">
				
				<c:forEach var="book" items="${page.list }">
					<div id="book">
						<div id="bookImage"  style="float: left;">
<!-- 						<img alt="${book.name }" src="${pageContext.request.contextPath }/${book.image}" width="130px" height="200px" /> -->
							<img src="${pageContext.request.contextPath }/${book.image}" width="130px" height="180px" />
						</div>
						<div id="bookInfo" style="float: left;text-align: left;">
							<ul>
								<li>名称：《${book.name }》</li>
								<li>作者：${book.author }</li>
								<li>价格：${book.price } RMB</li>
								<li>
									<a href="${pageContext.request.contextPath }/client/BuyServlet?bookId=${book.id}">购买</a>
								</li>
							</ul>
						</div>
						<div style="clear:both;"></div>
						<br/>
					</div>
					</c:forEach>
					
			</div>
			<div id="page">
				<%@ include file="/client/page.jsp" %>
			</div>
		</div>
			
</body>
</html>