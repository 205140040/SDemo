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
	<h1>hello world</h1>
	<script>
		$(function() {
					//alert("hello world");

					// 					$(".level1>a").click(
					// 							function() {
					// 								$(this).addClass("current").next().show()
					// 										.parent().siblings().children("a")
					// 										.removeClass("current").next().hide();

					// 								return false;
					// 							});

					// 					//jquery 对象和dom对象
					// 					var cb1=$("#cb1").get(0);
					// 					$("#cb1").click(function(){
					// 						alert(cb1.checked);
					// 						if(cb1.checked){
					// 							alert("感谢支持");
					// 						}
					// 						if($("#cb1").is(":checked")){//jquery方法判断
					// 							alert("感谢支持");
					// 						}
					// 					});

					// 					//基本选择器
					// 					//id选择器
					// 					var $cb1=$("#cb1");
					// 					alert("cb1:"+$cb1.is(":checked"));
					// 					var $level1=$(".level1");
					// 					var $li=$("li");
					// 					alert("class为level1："+$level1.length);
					// 					alert("元素选择器为li："+$li.length);
					// 					$("li").css("background","yellow");
					// 					//层次选择器
					// 					alert("选取后代元素："+$("div span"));
					// 					alert("选取父元素下的子元素："+$("div>span"));
					// 					alert("选取next元素："+$("box+menu"));

					// 					//过滤选择器
					// 					alert($("div:first"));
					// 					alert($("div:last"));
					// 					//内容过滤选择器
					// 					alert($("div:contains('我')"));
					// 					alert($("div:empty"));
					//可见性选择器
					// 					alert("hidden"+$("div:hidden"));
					// 					alert("visible"+$("div:visible"));
					//属性过滤选择器
					// 					alert("attribute:"+$("div:[id]"));
					//表单对象属性过滤选择器
					// 					alert($("input:checked"));
					//表单选择器
					// 					alert("input:"+$(":input"));
					// 					alert("text:"+$(":text"));
					// 					alert("radio:"+$(":radio"));
					// 					alert("password:"+$(":password"));
					// 					alert("button:"+$(":button"));
					// 					alert("button:"+$(":file"));
					// 					$("#hidden1").click(function(){
					// 						//alert("hide");
					// 						$("#box").hide(2000);
					// 					});
					// 					$("#show1").click(function(){
					// 						//alert("show");
					// 						$("#box").show(2000);
					// 					});
					//第三章jquery中的dom操作
					// 					alert("获取属性："+$("#dxcs1").attr("title"));
					// 					$("#append1").click(function(){
					// 						$("#ul1").append('<li id="appli1" class="level1"><a href="#none">短袖T屑append</a></li>');
					// 					});
					// 					$("#remove1").click(function(){
					// 						$("#appli1").remove();
					// 					});

					// 					$("#box").click(function(){
					// 						//克隆
					// 						$("#box").clone("true").appendTo("body");
					// 					});
					// 					//替换
					// 					$("#th1").click(function(){
					// 						$("#xy1").replaceWith('<div>我不同意协议了</div>');
					// 					});
					// 					//移除属性
					// 					$("#removeattr1").click(function(){
					// 						$("#dxcs1").removeAttr("title");
					// 					});
					// 					$("#szys1").click(function(){
					// 						$("#dxcs1").attr("class","st1");
					// 					});
					// 					$("#zjys1").click(function(){
					// 						$("#dxcs1").addClass("st2");
					// 					});
					// 					$("#ycys1").click(function(){
					// 						$("#dxcs1").removeClass("st1 st2");
					// 					});
					// 					alert("hasClass:"+$("#ul1").hasClass("menu"));
					//设置和获取html
					// 					alert($("#href1").html());
					// 					alert("next():"+$("#href1").next());
					// 					alert("prev():"+$("#href1").prev());
					// 					alert("parent():"+$("#href1").parent());
					//css
					// 					$("#box").css("backgroundColor","yellow");
					// 					alert("height():"+$("#box").height());
					// 					alert("width():"+$("#box").width());
					// 					$("#href1").hover(function(){
					// 						alert("1");
					// 					},function(){
					// 						alert("2");
					// 					});
					// 					$("#bc1").toggle(function(){
					// 						alert("b1");
					// 					},function(){
					// 						alert("b2");
					// 					});
					$(":input").focus(function() {
						$(this).addClass("focus");
					}).blur(function() {
						$(this).removeClass("focus");
					});
					$("#add").click(function() {//添加选中的给对方
						var $selecteds = $("#sel1 option:selected");
						$selecteds.appendTo("#sel2");
					});
					$("#sel1").dblclick(function() {//添加选中的给对方
						var $selecteds = $("#option:selected", this);
						$selecteds.appendTo("#sel2");
					});
					$("#addAll").click(function() {//添加all的给对方
						var $selecteds = $("#sel1 option");
						$selecteds.appendTo("#sel2");
					});
					$("div.tabMenu ul li").click(function() {
						//同辈元素移除css
						$(this).addClass("st2");
						$(this).siblings().removeClass("st2");
						var index = $("div.tabMenu ul li").index(this);
						//alert($(".tabBoxDiv").length);
						$(".tabBoxDiv").eq(index).show().siblings().hide();

					});
					//jquery中的ajax
					$("#loadBut").click(
							function() {
								$("#lcon").load(
										"lhtml.jsp",
										"",
										function(res, textStatus,
												XMLHttpRequest) {
											alert("success");
											
										})
							});
					$("#getBut").click(function(){
						alert("get");
						$.get("ReqController/addUser.sw",
								{uname:$("#uname").val()},
								function(res,textStaus){
									alert(res.uname);
									$("#lcon").html(res.uname);
								});
					});
				});
	</script>


	<form id="addForm" action="ReqController/addUser">
		<table border="1" width="800" height="400">
			<tr>
				<td>用户名</td>
				<td><input id="uname" type="text" name="uname" value="55"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="upwd" value="66"></td>
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
				<input
					id="loadBut" type="button" value="load">
				<input
					id="getBut" type="button" value="get">
				<input
					id="postBut" type="button" value="post">
					</td>
			</tr>

		</table>

	</form>
	<div class="tabMenu">
		<ul>
			<li style="display: inline-block">时事</li>
			<li style="display: inline-block">体育</li>
			<li style="display: inline-block">杂志</li>
		</ul>
	</div>

	<div class="tabBox">

		<div id="1" class="tabBoxDiv">
			时事
			<div id="lcon"></div>
		</div>
		<div id="2" class="tabBoxDiv" style="display: none">体育</div>
		<div id="3" class="tabBoxDiv" style="display: none">杂志</div>

	</div>

	<!-- 	<div class="box" id="box"><div id="bc1">box1</div> -->
	<!-- 		<ul id="ul1" class="menu"> -->
	<!-- 			<li class="level1"><a id="href1" href="#none">衬衫</a> -->
	<!-- 				<ul id="ul1" class="level2"> -->
	<!-- 					<li id="dxcs1" class="st3" title="短袖衬衫" class="level1"><a href="#none"><span>短袖衬衫</span></a></li> -->
	<!-- 					<li class="level1"><a href="#none"><span>长袖衬衫</span></a></li> -->
	<!-- 					<li class="level1"><a href="#none">短袖T屑</a></li> -->
	<!-- 				</ul></li> -->
	<!-- 			<li class="level1"><a href="#none">衬衫2</a> -->
	<!-- 				<ul class="level2"> -->
	<!-- 					<li class="level1"><a href="#none">短袖衬衫</a></li> -->
	<!-- 					<li class="level1"><a href="#none">长袖衬衫</a></li> -->
	<!-- 					<li class="level1"><a href="#none">短袖T屑</a></li> -->
	<!-- 				</ul></li> -->
	<!-- 			<li class="level1"><a href="#none">衬衫3</a> -->
	<!-- 				<ul class="level2"> -->
	<!-- 					<li class="level1"><a href="#none">短袖衬衫</a></li> -->
	<!-- 					<li class="level1"><a href="#none">长袖衬衫</a></li> -->
	<!-- 					<li class="level1"><a href="#none">短袖T屑</a></li> -->
	<!-- 				</ul></li> -->
	<!-- 		</ul> -->
	<!-- 	</div> -->

	<!-- 	<div id="box2"> -->
	<!-- 	</div> -->
	<!-- 	<input type="checkbox" id="cb1"><div id="xy1">我同意该协议</div><br> -->
	<!-- 	text1<input type="text" value="text1"> -->
	<!-- 	text2<input type="password" value="text2"><br> -->
	<!-- 	file<input type="file" value="file1"> -->
	<!-- 	radio<input type="radio" value="text3"><br> -->
	<!-- 	button<input type="button" value="button"> -->
	<!-- 	submit<input type="submit" value="submit"><br> -->
	<!-- 	hide<input id="hidden1" type="button" value="hide"> -->
	<!-- 	show<input id="show1" type="button" value="show"><br> -->
	<!-- 	append<input id="append1" type="button" value="append"> -->
	<!-- 	remove<input id="remove1" type="button" value="remove"> -->
	<!-- 	<br> -->
	<!-- 	替换<input id="th1" type="button" value="替换"> -->
	<!-- 	已出属性<input id="removeattr1" type="button" value="移除属性"> -->
	<!-- 	<br> -->
	<!-- 	设置样式<input id="szys1" type="button" value="设置样式"> -->
	<!-- 	追加样式<input id="zjys1" type="button" value="追加样式"> -->
	<!-- 	移除样式<input id="ycys1" type="button" value="移除样式"> -->
	<!-- 	<br> -->


</body>
</html>