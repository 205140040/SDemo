<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>
	<table border="1" width="600px" cellpadding="0" cellspacing="0">
		<tbody>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>教师</th>
			</tr>
			<tr style="text-align: center">
				<td>${student.id }</td>
				<td>${student.sname }</td>
				<td>${student.ssex }</td>
				<td>${student.sage }</td>
				<td>${student.tname }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>