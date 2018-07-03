<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html lang="zxx">

<head>
	<title>Home</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content=""/>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="<%=path%>/log/css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="<%=path%>/log/css/fontawesome-all.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="http://maxcdn.bootstrapcdn.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
	<link href="http://maxcdn.bootstrapcdn.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //web-fonts -->
</head>

<body>
	<!-- bg effect -->
	<div id="bg">
		<canvas></canvas>
		<canvas></canvas>
		<canvas></canvas>
	</div>
	<!-- //bg effect -->
	<!-- title -->
	<h1>Login </h1>
	<!-- //title -->
	<!-- content -->
	<div class="sub-main-w3">
		<div id="form1">
			<h2>Login Now
				<i class="fas fa-level-down-alt"></i>
			</h2>
			<div class="form-style-agile">
				<label>
					<i class="fas fa-user"></i>
					Username
				</label>
				<input placeholder="Username" name="loginName" id="loginName" type="text" required="">
			</div>
			<div class="form-style-agile">
				<label>
					<i class="fas fa-unlock-alt"></i>
					Password
				</label>
				<input placeholder="Password" name="password" id="password" type="password" required="">
			</div>
			<!-- checkbox -->
			<div class="wthree-text">
				<ul>
					<li>
						<label class="anim">
							<input type="checkbox" class="checkbox" required="">
							<span>Stay Signed In</span>
						</label>
					</li>
					<li>
						<a href="#">Forgot Password?</a>
					</li>
				</ul>
			</div>
			<!-- //checkbox -->
			<input type="submit" onclick="login() " value="Log In">
		</div>
	</div>


	<script src="<%=path%>/log/js/jquery-3.3.1.min.js"></script>

	<script src="<%=path%>/log/js/canva_moving_effect.js"></script>


</body>
<script src="<%=path%>/assets/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/assets/user/layer/layer.js"></script>
<script type="text/javascript">

    //登陆页面
    //判断当前窗口是否有顶级窗口，如果有就让当前的窗口的地址栏发生变化，
    function loadTopWindow() {
        if (window.top != null && window.top.document.URL != document.URL) {
            window.top.location = document.URL; //这样就可以让登陆窗口显示在整个窗口了
        }
    }

    // 登录
    function login() {
        $.post('<%=path%>/loginJson.do', {
            "loginName": $('#loginName').val(),
            "password": $('#password').val()
        }, function (data) {
            debugger;

            if (data.code == 1) {
                location.href = data.obj;
            } else {
                layer.msg(data.msg);
            }
        }, 'json');
    }

    //为keyListener方法注册按键事件
    document.onkeydown = keyListener;

    function keyListener(e) {
        // 当按下回车键，执行我们的代码
        if (e.keyCode == 13) {
            login();
        }
    }
</script>


</html>