<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改图书</title>
</head>
<body >
<br>
	<form action="${pageContext.request.contextPath }/manager/BookServlet?method=updateBook&id=${requestScope.book.id}" method="post" enctype="multipart/form-data">
		
		<table  style="text-align: center;" align="center" frame="border" border="1" width="60%">
			<tr>
				<td>图书名称：
				<td>
					<input type="text" name="name" value="${requestScope.book.name}"/>
				</td>
			</tr>
			
			<tr>
				<td>图书作者：
				<td>
					<input type="text" name="author" value="${requestScope.book.author}"/>
				</td>
			</tr>
			
			<tr>
				<td>图书价格：
				<td>
					<input type="text" name="price" value="${requestScope.book.price}"/>
				</td>
			</tr>
			
	<!-- 	<tr>
				<td>图书图片：
				<td>
					<img alt="100%x200" style="height: 200px; display: block;" src="${pageContext.request.contextPath }/${book.image}" />
					<input type="file" name="image" value="${requestScope.book.image}"/>
				</td>
			</tr> -->	
			
			<tr>
				<td>图书描述：
				<td>
					<textarea rows="5" cols="30" name="description">${requestScope.book.description}</textarea>
				</td>
			</tr>
			
			<tr>
				<td>图书分类：</td>
				<td>
					<!-- 选择当前book对象的默认项 -->
					<select name="category_id">
						<c:forEach var="b" items="${requestScope.book_category }">
							<c:choose>
								<c:when test="${b.id != requestScope.book.category_id }">
									<option value="${b.id }" /> ${b.name }
								</c:when>
								<c:otherwise>
									<option value="${b.id }" selected="selected"/> ${b.name } 
								</c:otherwise>
							</c:choose> 
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="修改"/><br>
				</td>
			</tr>
		</table>
		
	</form>
		
</body>
</html>