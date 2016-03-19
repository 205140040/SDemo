<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<section>
		<article>
			<form action="/SpringDeep/login/doLogin" method="post">
				姓名<input type="text" name="userName"><br> 密码<input
					type="password" name="password"> <br> <input
					type="submit" value="提交">
			</form>
		</article>
	</section>
</body>
</html>