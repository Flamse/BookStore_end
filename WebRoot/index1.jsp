<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link type="text/css" href="resource/css/public.css"/>
    <title>首页</title>
  </head>

 	<frameset rows="10%,*,20%" >
 		<frame src="${pageContext.request.contextPath }/client/head.jsp" noresize="noresize" name="head">
 		<frame src="${pageContext.request.contextPath }/client/IndexServlet" noresize="noresize" name="body">
 		<frame src="${pageContext.request.contextPath }/client/foot.jsp" noresize="noresize" name="foot">
 	</frameset>
	
	
</html>
