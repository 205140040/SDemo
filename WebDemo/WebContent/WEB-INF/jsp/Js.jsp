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
	文件:<input id="f1" type="file" name="f1">
	选择的文件：<img id="fi1" alt="" src="data:image/png;base64,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…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"><br>
	<input type="submit" value="提交">
		姓名：<input id="sname" name="sname"> <br> <br>
		<input id="btn1" value="事件按钮" type="button"> <br>
		<a id="href1" href="no.jsp">跳转了哈哈哈</a>
		<div id="fdiv1">fdiv1</div>

		<img id="img1" alt="" src="<%=BasePath%>/images/t1.png"> lala:<input
			id="ki1" name="ki1"> 自动获取焦点:<input type="text" name="bb"
			autofocus> 
			
			<input type="text" name="email" required>
			
		<canvas id="can1" width="200" height="50" >666</canvas>	
		<img id="img2" alt="" src="">
	</form>
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="myjs.js"></script>
</body>
</html>