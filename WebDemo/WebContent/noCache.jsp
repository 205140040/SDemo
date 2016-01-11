<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--通过jsp模拟respoonse禁用缓存  -->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Pragma" content="no-cache">
<!--refersh  -->
<!-- <meta http-equiv="Refresh" content="5"> -->

<title>通过jsp模拟response</title>
</head>
<body>
<h2><font color="red"><a href="/WebDemo/FileDownload">下载附件</a></font></h2>
	<form action="/NoServlet" method="post">
		用户名：<input name="uname" value="999"> <br> <input
			type="submit" value="提交">
	</form>
</body>
</html>