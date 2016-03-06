<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>css</title>
<link rel="stylesheet" type="text/css" href="<%=BasePath%>/mycss.css" />
</head>
<body>
	<h2>css元素选择器</h2>
	<p>这是段落1</p>
	<p class="warning">
		这是段落警告<strong>这是strong</strong>
	</p>
	<p id="pi1">这是id选择器</p>
	<p class="pi1">这是属性选择器</p>
	<ul>
		<li>小学生</li>
		<li>初中生</li>
		<li>高中生</li>
		<li>大学生</li>
	</ul>
	<a href="#">露露</a> 姓名选择器：
	<input name="sname">
	<br>
	<p>abcd
		dddee小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.小明放学了，去吃饭，喝水.</p>
	<div class="bcla">我是一个div，拥有边框，边距</div>
	<div class="bcla">
		我是一个div2，hhhhhh拥有边框，边距
		<%-- <img class="fi1" alt=""
			src="<%=BasePath%>/images/t1.png"> --%>
		<div class="fp1">浮动段落333<br>3333333333333333,9999</div>
	</div>
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
</body>
</html>