<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JquerDemo</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery/jquery-1.9.1.js"></script>
<style type="text/css">
.st1 {
	background: yellow;
}
.st0 {
	
}
.st2 {
	background: red;
}

.st3 {
	background: #ff6600;
}

.focus {
	border: 1px solid #f00;
	background: #fcc
}
</style>
</head>
<body>
	<h1>Load html hello world</h1>
	
	<form id="addForm" action="">
		<table border="1" width="800" height="400">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="uname" value=""></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="upwd" value=""></td>
			</tr>
			<tr>
				<td><select id="sel1" multiple="multiple"
					style="width: 100px; height: 160px">
						<option value="1">apple</option>
						<option value="2">banner</option>
						<option value="3">milk</option>
						<option value="4">jinagzi</option>
						<option value="5">boluo</option>
				</select>
					<div>
						<div id="add">add to right&gt;&gt;</div>
						<div id="addAll">add All&gt;&gt;</div>
					</div></td>
				<td><select id="sel2" multiple="multiple"
					style="width: 100px; height: 160px">
						<option value="1">1</option>

				</select></td>

			</tr>

			<tr>
				<td>邮箱</td>
				<td><input type="mail" name="uemail" value=""></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit"></td>
				<td><input type="reset" value="reset">
				<input id="loadBut" type="button" value="load">
				</td>
			</tr>

		</table>

	</form>
	<div class="tabMenu">
		<ul>
			<li  style="display:inline-block">时事</li>
			<li  style="display:inline-block">体育</li>
			<li  style="display:inline-block">杂志</li>
		</ul>
	</div>
	
	<div class="tabBox">
		
			<div id="1" class="tabBoxDiv" >时事
			<div id="lcon"></div>
			</div>
			<div id="2" class="tabBoxDiv" style="display:none">体育</div>
			<div id="3" class="tabBoxDiv" style="display:none">杂志</div>
		
	</div>

	

</body>
</html>