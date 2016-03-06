<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form提交</title>
</head>
<body>
	<form id="form1" name="form1" method="post" action="/WebDemo/GetParameter">
		<table width="600" border="1">
			<tr>
				<td>姓名</td>
				<td><label for="textfield"></label> <input type="text"
					name="name" id="textfield" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="sex" id="textfield2" /></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age" id="textfield3" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="button" id="button"
					value="提交" /> <input type="reset" name="button2" id="button2"
					value="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>