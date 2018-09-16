<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link type="text/css" href="resource/css/public.css"/>
    <title>首页</title>
	<script type="text/javascript">
	//var temp='<jsp:include page="/client/IndexServlet"/>';//刷新的内容
	//清空
	//document.getElementById('bodyer').innerHTML="";
	 
	//赋值
	document.getElementById("#header").innerHTML=' <c:import url="/client/head.jsp" /> ';
	document.getElementById('#bodyer').innerHTML='<jsp:include page="/client/IndexServlet"/>';
	
	document.getElementById('#footer').innerHTML='<jsp:include page="/client/foot.jsp" />';

	</script>
  </head>
<!-- 
 	<frameset rows="10%,*,20%" >
 		<frame src="${pageContext.request.contextPath }/client/head.jsp" noresize="noresize" name="head">
 		<frame src="${pageContext.request.contextPath }/client/IndexServlet" noresize="noresize" name="body">
 		<frame src="${pageContext.request.contextPath }/client/foot.jsp" noresize="noresize" name="foot">
 	</frameset>
	  -->
	 <body>
		<div id="header"></div>
		<% System.out.println("1");%>
		<div id="bodyer"></div>
		<% System.out.println("2");%>
		<div id="footer"></div>
	</body>
</html>
