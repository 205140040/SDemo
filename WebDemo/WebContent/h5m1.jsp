<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 设置移动设备虚拟屏幕 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>h5m1</title>

<style type="text/css">
ul>li {
	display: inline;
}

a {
	text-decoration: none;
}
</style>
<link rel="stylesheet"
	href="<%=BasePath%>/jquery.mobile-1.4.5/jquery.mobile-1.4.5.css">
</head>
<body>
	<!-- 	<header>
		<nav>
			<ul>
				<li><a>主页</a></li>
				<li><a>好友</a></li>
				<li><a>应用</a></li>

			</ul>
		</nav>
	</header>
	<section>
		<article>
			<h3>Html5移动应用</h3>
			搜索：<input type="search">
			<p>欢迎小朋友，哈哈哈哈哈哈</p>
		</article>
		<form action="">
			<label>姓名</label><input placeholder="姓名" autofocus="autofocus"
				type="text"><br> <label>性别</label><input type="text"><br>
			<label>年龄</label><input type="number" min="0"><br> <label>电话</label><input
				type="tel"> <br> <input type="submit" value="提交">
		</form>
	</section>
	<footer>
		<nav>
			<ul>
				<li><a>主页</a></li>
				<li><a>好友</a></li>
				<li><a>应用</a></li>
			</ul>
		</nav>
	</footer> -->

	<section data-role="page" id="jmpageHome" data-title="Home">
		<header data-role="header">
			<nav>
				<ul>
					<li><a data-icon="home" href="#jmpageHome">主页</a></li>
					<li><a>好友</a></li>
					<li><a>应用</a></li>
					<li><a href="#jmpage2" data-rel="dialog" data-transition="pop">第二页</a></li>
				</ul>
			</nav>
		</header>
		<article data-role="content">类容</article>
		<footer data-role="footer">页脚</footer>
	</section>

	<section data-role="page" id="jmpage2">
		<header data-role="header">
			<nav>
				<ul>
					<li><a href="#jmpageHome">主页</a></li>
					<li><a>好友</a></li>
					<li><a>应用</a></li>
				</ul>
			</nav>
		</header>
		<article data-role="content">类容,第二页</article>
		<footer data-role="footer">页脚</footer>
	</section>
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
	<!-- jqueryMoblie -->
	<script type="text/javascript"
		src="<%=BasePath%>/jquery.mobile-1.4.5/jquery.mobile-1.4.5.js"></script>
	<script type="text/javascript">
		//获取地理位置
		// 		navigator.geolocation.getCurrentPosition(function(pos) {
		// 			alert("weidu:" + pos.coords.latitude);
		// 		});
	</script>
</body>
</html>