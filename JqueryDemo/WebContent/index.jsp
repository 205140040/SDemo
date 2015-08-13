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
	.st1{
	background:yellow;
	}
	.st2{
	background:red;
	}
	.st3{
	background:#ff6600;
	}
	</style>
</head>
<body>
	<h1>hello world</h1>
	<script>
		$(document).ready(
				function() {
					//alert("hello world");

					$(".level1>a").click(
							function() {
								$(this).addClass("current").next().show()
										.parent().siblings().children("a")
										.removeClass("current").next().hide();

								return false;
							});
					
					//jquery 对象和dom对象
					var cb1=$("#cb1").get(0);
					$("#cb1").click(function(){
						alert(cb1.checked);
						if(cb1.checked){
							alert("感谢支持");
						}
						if($("#cb1").is(":checked")){//jquery方法判断
							alert("感谢支持");
						}
					});
					
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
					$("#hidden1").click(function(){
						//alert("hide");
						$("#box").hide();
					});
					$("#show1").click(function(){
						//alert("show");
						$("#box").show();
					});
					//第三章jquery中的dom操作
					alert("获取属性："+$("#dxcs1").attr("title"));
					$("#append1").click(function(){
						$("#ul1").append('<li id="appli1" class="level1"><a href="#none">短袖T屑append</a></li>');
					});
					$("#remove1").click(function(){
						$("#appli1").remove();
					});
					
					$("#box").click(function(){
						//克隆
						$("#box").clone("true").appendTo("body");
					});
					//替换
					$("#th1").click(function(){
						$("#xy1").replaceWith('<div>我不同意协议了</div>');
					});
					//移除属性
					$("#removeattr1").click(function(){
						$("#dxcs1").removeAttr("title");
					});
					$("#szys1").click(function(){
						$("#dxcs1").attr("class","st1");
					});
					$("#zjys1").click(function(){
						$("#dxcs1").addClass("st2");
					});
					$("#ycys1").click(function(){
						$("#dxcs1").removeClass("st1 st2");
					});
				});
	</script>
	<div class="box" id="box">box1
		<ul class="menu">
			<li class="level1"><a href="#none">衬衫</a>
				<ul id="ul1" class="level2">
					<li id="dxcs1" class="st3" title="短袖衬衫" class="level1"><a href="#none"><span>短袖衬衫</span></a></li>
					<li class="level1"><a href="#none"><span>长袖衬衫</span></a></li>
					<li class="level1"><a href="#none">短袖T屑</a></li>
				</ul></li>
			<li class="level1"><a href="#none">衬衫2</a>
				<ul class="level2">
					<li class="level1"><a href="#none">短袖衬衫</a></li>
					<li class="level1"><a href="#none">长袖衬衫</a></li>
					<li class="level1"><a href="#none">短袖T屑</a></li>
				</ul></li>
			<li class="level1"><a href="#none">衬衫3</a>
				<ul class="level2">
					<li class="level1"><a href="#none">短袖衬衫</a></li>
					<li class="level1"><a href="#none">长袖衬衫</a></li>
					<li class="level1"><a href="#none">短袖T屑</a></li>
				</ul></li>
		</ul>
	</div>
	
	<div id="box2">
	</div>
	<input type="checkbox" id="cb1"><div id="xy1">我同意该协议</div><br>
	text1<input type="text" value="text1">
	text2<input type="password" value="text2"><br>
	file<input type="file" value="file1">
	radio<input type="radio" value="text3"><br>
	button<input type="button" value="button">
	submit<input type="submit" value="submit"><br>
	hide<input id="hidden1" type="button" value="hide">
	show<input id="show1" type="button" value="show"><br>
	append<input id="append1" type="button" value="append">
	remove<input id="remove1" type="button" value="remove">
	<br>
	替换<input id="th1" type="button" value="替换">
	已出属性<input id="removeattr1" type="button" value="移除属性">
	<br>
	设置样式<input id="szys1" type="button" value="设置样式">
	追加样式<input id="zjys1" type="button" value="追加样式">
	移除样式<input id="ycys1" type="button" value="移除样式">
	<br>
</body>
</html>