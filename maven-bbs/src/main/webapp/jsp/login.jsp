<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<form id="loginForm" method="post" action="">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName"></td>
				<td>密码:</td>
				<td><input type="password" name="password"></td>
				<td><input id="btn1" type="button" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>

		</table>
	</form>
	<script type="text/javascript"
		src="<%=BasePath%>/js/jquery/jquery-2.1.1.js"></script>

	<script type="text/javascript">
		$("#btn1").click(function() {
			$.ajax({
				type : "post",
				url : "/maven-bbs/login/login",
				data : $("#loginForm").serialize(),
				success : function(res) {
					res=JSON.parse(res);
					console.log(res);
					console.log(res.msg);
					if (res.flag) {
						window.location.href = "/maven-bbs/login/toUser";
					} else {
						alert(res.msg);
					}
				}
			});
		});
	</script>
</body>
</html>