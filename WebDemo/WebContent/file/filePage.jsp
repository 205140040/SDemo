<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>filePage</title>
</head>
<body>
	<form action="/WebDemo/file/upload" method="post" enctype="multipart/form-data">
		文件：<input type="file" name="file"> <br>
		<input value="提交" type="submit">
	</form>
</body>
</html>