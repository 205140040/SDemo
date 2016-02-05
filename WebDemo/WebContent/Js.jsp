<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyJs</title>
</head>
<body id="bd1">
	<h2 align="center" title="这是h标签">
		<font color="blue">MyJs</font>
	</h2>
	<p id="p1" title="p标签" data-name="p1自定义属性name">这是p1</p>
	<iframe src=""> </iframe>
	<form id="form1" action="http://localhost:8080/FileWebDemo/FileServlet">
		姓名：<input id="sname" name="sname"> <br> <input type="submit"
			value="提交">
			<br><input id="btn1" value="事件按钮" type="button">
			<br><a id="href1" href="no.jsp">跳转了哈哈哈</a>
			<div id="fdiv1">fdiv1</div>
	</form>
	<img id="img1" alt="" src="<%=BasePath%>/images/t1.png">
	lala:<input id="ki1" name="ki1">
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="myjs.js"></script>
</body>
</html>