<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://v3.bootcss.com/favicon.ico">

    <title>index 3-0</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://v3.bootcss.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/offcanvas/offcanvas.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://v3.bootcss.com/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <%if(request.getAttribute("category") == null) {%>
	  <jsp:forward page="/client/IndexServlet" ></jsp:forward>
    <% }%>
    <script type="text/javascript">
		function showContent(target,content){$(target).load(content)};
	</script>
  </head>
 <!-- 主页初始化 -->
  <body>
    <nav class="navbar navbar-fixed-top navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">BookStore</a>
        </div>
        <!-- 导航条 -->
        <div id="navbar" class="collapse navbar-collapse">
        	<!-- 导航区 -->
          <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath }/client/IndexServlet">AllBook</a></li>
            <li><a href="javascript:showContent('#body','${pageContext.request.contextPath }/client/listCart.jsp')">Cart</a></li>
            <li><a href="javascript:showContent('#body','${pageContext.request.contextPath }/client/OrdersServlet?method=listOrders')">Orders</a></li>
 <!-- 	    <li><a href="${pageContext.request.contextPath }/managerNew.jsp" target="_blank">Manager</a></li> -->
          </ul>
          <!-- 登录区 -->
            <c:choose>
          	  <c:when test="${user!=null }">
          		<ul class="nav navbar-nav navbar-right">
          		  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.username } <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="${pageContext.request.contextPath }/managerNew.jsp" target="_blank">new Manager</a></li>
                      <li><a href="${pageContext.request.contextPath }/manager.jsp" target="_blank">old Manager</a></li>
                      <li><a href="#">Something else here</a></li>
                      <li role="separator" class="divider"></li>
                      <li class="dropdown-header">Nav header</li>
                      <li><a href="#">Separated link</a></li>
                      <li><a href="${pageContext.request.contextPath }/client/LogoutServlet">Sign out</a></li>
                    </ul>
                  </li>
          		</ul>
          	</c:when>
          	<c:otherwise>
          	  <form class="navbar-form navbar-right" action="${pageContext.request.contextPath }/client/LoginServlet" method="post">
            	<div class="form-group">
            	  <input type="text" placeholder="Name" class="form-control" name="username">
            	</div>
            	<div class="form-group">
            	  <input type="password" placeholder="Password" class="form-control" name="password">
            	</div>
            	<button type="submit" class="btn btn-primary">Sign in</button>
<!--           	<button type="button" class="btn btn-success" onclick="javascript:window.parent.body.location.href='/client/registerNew.jsp'">Sign up</button> -->
				<button type="button" class="btn btn-success" onclick="javascript:window.open('${pageContext.request.contextPath }/client/registerNew.jsp')">Sign up</button>
          	  </form>
          	</c:otherwise>
          	</c:choose>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </nav><!-- /.navbar -->

    <div class="container" id="body">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <!-- 活动推荐 -->
<!--           <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron">
            <h1>Hello, world!</h1>
            <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
          </div> -->
          <!-- 图书展示 -->
          <div class="bs-example" data-example-id="thumbnails-with-custom-content">
            <div class="row">
      		  <c:forEach var="book" items="${page.list }">
        	    <div class="col-sm-6 col-md-4">
          	      <div class="thumbnail">
<!--                <img data-src="holder.js/100%x200" alt="100%x200" style="height: 200px; width: 100%; display: block;" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTY0NDA0NmU0M2UgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNjQ0MDQ2ZTQzZSI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS42NDk5OTk2MTg1MzAyNyIgeT0iMTA1Ljc2MDAwMDIyODg4MTg0Ij4yNDJ4MjAwPC90ZXh0PjwvZz48L2c+PC9zdmc+" data-holder-rendered="true">  --> 
                    <img data-src="holder.js/100%x200" data-holder-rendered="true" alt="100%x200" style="height: 200px; display: block;" src="${pageContext.request.contextPath }/${book.image}" />
                    <div class="caption">
              	  	  <h3>${book.name }</h3>
              		  <p>作者：${book.author }</p>
              		  <p>价格：${book.price } RMB</p>
            	    <p><a href="${pageContext.request.contextPath }/client/BuyServlet?bookId=${book.id}" class="btn btn-primary" role="button">加入购物车</a>
            	    <a href="#" class="btn btn-default" role="button">Button</a></p>
            	    </div>
          		  </div>
        	    </div>
      		  </c:forEach>
    	    </div>
    	  </div>
    	  <div id="page">
				<%@ include file="/client/page.jsp" %>
			</div>
        </div><!--/.col-xs-12.col-sm-9-->

		<!-- 分类列表 -->
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
          <div class="list-group">
            <a href="${pageContext.request.contextPath }
					/client/IndexServlet" class="list-group-item active">find</a>
            <c:forEach var="c" items="${requestScope.category }">
              <a href="${pageContext.request.contextPath }
					/client/IndexServlet?category_id=${c.id}" class="list-group-item">${c.name }</a>
            </c:forEach>
          </div>
        </div><!--/.sidebar-offcanvas-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; Company 2018</p>
      </footer>

    </div><!--/.container-->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="https://v3.bootcss.com/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="https://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="https://v3.bootcss.com/examples/offcanvas/offcanvas.js"></script>
  </body>
</html>