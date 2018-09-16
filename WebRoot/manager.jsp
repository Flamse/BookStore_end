<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/l ose.dtd">
<html>
<head>
<title>后台管理</title>
</head>

 	<frameset rows="15%,*">
 		<frame src="${pageContext.request.contextPath }/manager/head.jsp" noresize="noresize" name="head">
	 	<frameset cols="9%,*">
	 		<frame src="${pageContext.request.contextPath }/manager/left.jsp" noresize="noresize" name="left">
	 		<frame src="${pageContext.request.contextPath }/manager/body.jsp" noresize="noresize" name="body">
	 	</frameset>
 	</frameset>
</html>