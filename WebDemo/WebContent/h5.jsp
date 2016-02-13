<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>H5</title>
</head>
<body>
	<header>这是页眉,666</header>
	<video width="400px" height="200px" controls="controls">
		<source src="m.ogg">
		<source src="b.ogg">
		你的浏览器不支持video标签
	</video>
	<br>
	<audio src="bb.mp3" controls="controls">
		<source src="m.mp3">
		<source src="b.mpe">
		你的浏览器不支持audio标签
	</audio>
	<form id="h5f" action="">
		邮箱：<input type="email" name="email" placeholder="邮箱"><br>
		URL:<input type="url" required="required"><br> 数字:<input
			type="number" min="0" max="100"><br> 范围数值：<input
			type="range" min="0" max="100"><br> 日期:<input
			type="datetime-local"><br> 搜索:<input type="search"
			list="slist">
		<datalist id="slist">
			<option label="提莫" value="提莫" />
			<option label="蘑菇" value="蘑菇" />
		</datalist>
		<br> 自动compelte:<input type="text" autocomplete="on"
			autofocus="autofocus"><br> <input type="image"
			width="100px" height="100px" src="<%=BasePath%>/images/t1.png"><br>
		文件多选:<input type="file" multiple="multiple"><br> <input
			type="submit" value="提交">
	</form>
	<hr color="red">
	<h3>标签</h3>
	<a href="#">提莫队长网址</a>
	<br> 哇哈哈哈
	<abbr title="abbr缩写">PRc</abbr>666
	<br>
	<address>
		姓名：提莫<br> 手机:8888<br> 地址:约德尔
	</address>
	<article>
		<a href="art.jsp">来之外部</a><br> 这是文章哈哈哈
	</article>
	<br>
	<table width="600px" height="200px" border="1" cellpadding="0"
		cellspacing="0">
		<caption>这是表格的标题</caption>
		<thead>
			<tr>
				<td colspan="3">表格头</td>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<td colspan="3">表格foot</td>
			</tr>
		</tfoot>
		<tbody>
			<!-- 表格第一列title -->
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
			</tr>
			<tr>
				<td>提莫</td>
				<td>13</td>
				<td>蘑菇</td>
			</tr>
		</tbody>
	</table>

	<hr color="blue">
	<command type="command" label="这是命令">点击我执行命令</command>
	<br> 111
	<del>这个删除了</del>
	66
	<br> 9999999999999999999
	<details>这是详情啦啦啦啦啦
	</details>
	<br>
	<label for="sname">姓名</label>
	<input id="sname">
	<br> mmmmm
	<mark>这是mark突出显示</mark>
	ppp
	<br>

	<nav>
		<a href="#">home</a> <a href="#">商品</a> <a href="#">其他</a>
	</nav>

	下载进度：
	<progress>
		<span id="objprogress">76</span>%
	</progress>
	<section>
		<h2>区段section</h2>
		<p>这是区段一，66666666666666</p>
	</section>

	我在早上
	<time>9:00</time>
	起床
	<br>

	<footer>这是页脚，打击正版</footer>
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
</body>
</html>