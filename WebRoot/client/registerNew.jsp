<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://v3.bootcss.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://v3.bootcss.com/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form action="${pageContext.request.contextPath }/client/RegisterServlet" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <!-- placeholder:提示信息 required:提交前必须输入  autofocus:获得焦点-->
        <label for="username" class="sr-only">Input UserName</label>
        <input type="text" name="username" id="username" class="form-control" placeholder="Input UserName" required autofocus>
        
        <label for="password" class="sr-only">Input Password</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Input Password" required autofocus>
        
        <label for="phone" class="sr-only">Input PhoneNumber</label>
        <input type="tel" name="phone" id="phone" class="form-control" placeholder="Inport PhoneNumber" required autofocus>
        
        <label for="address" class="sr-only">Input Address</label>
        <input type="text" name="address" id="address" class="form-control" placeholder="Input Address" required autofocus>
        
        <label for="email" class="sr-only">Input Email</label>
        <input type="email" name="email" id="email" class="form-control" placeholder="Input Email" required autofocus>
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="https://v3.bootcss.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>