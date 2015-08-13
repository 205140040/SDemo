<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JquerDemo</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jquery/jquery-1.9.1.js"></script>
</head>
<body>
	<h1>hello world</h1>
	<script>
		$(document).ready(
				function() {
					alert("hello world");

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
					
					//基本选择器
					//id选择器
					var $cb1=$("#cb1");
					alert("cb1:"+$cb1.is(":checked"));
					var $level1=$(".level1");
					var $li=$("li");
					alert("class为level1："+$level1.length);
					alert("元素选择器为li："+$li.length);
					$("li").css("background","yellow");
					//层次选择器
					alert("选取后代元素："+$("div span"));
					alert("选取父元素下的子元素："+$("div>span"));
					alert("选取next元素："+$("box+menu"));
					
					//过滤选择器
					

				});
	</script>
	<div class="box" id="box">
		<ul class="menu">
			<li class="level1"><a href="#none">衬衫</a>
				<ul class="level2">
					<li class="level1"><a href="#none"><span>短袖衬衫</span></a></li>
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
	
	<input type="checkbox" id="cb1">我同意该协议
</body>
</html>