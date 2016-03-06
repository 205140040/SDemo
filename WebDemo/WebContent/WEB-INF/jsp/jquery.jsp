<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jqueryStudy</title>
<style type="text/css">
nav ul li {
	display: inline;
}

.li-css {
	color: blue;
}
</style>
</head>
<body>
	<section>
		<header>
			<nav>
				<ul>
					<li class="li-css">Home</li>
					<li class="li-css">menu1</li>
					<li>menu2</li>
				</ul>
			</nav>
		</header>
		<article>
			<div class="p-panel-div">
				<div class="c-panel-div">
					<h3>HOME</h3>
					<p id="p1">这是网站类容，ppppppppppp</p>
					<p style="display: none">这是隐藏的p</p>
					<select id="sel1">
						<option value="1">Flowers</option>
						<option value="2" selected="selected">Gardens</option>
						<option value="3">Trees</option>
					</select> <br> Weekly<input type="checkbox" name="newsletter"
						value="Weekly" /> Monthly<input type="checkbox" name="newsletter"
						checked="checked" value="Monthly" />
				</div>

				<div class="c-panel-div" style="display: none">
					<h3>MENU1</h3>
					<p id="p1">这是menu1网站类容，1111</p>
				</div>

				<div class="c-panel-div" style="display: none">
					<h3>MENU2</h3>
					<p id="p1">这是menu2网站类容，2222</p>
				</div>
			</div>

		</article>
		<footer>
			<address>打击正版@666</address>
		</footer>
	</section>
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
	<script>
		/*jquery选择器*/
		$(function() {
			// 			alert("id选择器：" + $("#p1").html());
			// 			//元素选择器
			// 			alert("元素选择器;" + $("address").html());
			//类选择器
			// 			alert("类选择器"+$(".li-css").size());
			//后代选择器
			// 			alert("后代选择器"+$("article h3").html());
			//子元素选择器
			// 			alert("子元素选择器;" + $("ul>li").size());
			$.each($("ul>li"), function(i, d) {
				// 				console.log(d);
			});

			//:eq匹配一个给定索引值的元素
			// 			console.log("匹配给定的索引:" + $("ul>li:eq(2)"));
			//:hidden匹配所有不可见元素，或者type为hidden的元素
			// 			alert("匹配隐藏的元素：" + $("article p:hidden").html());
			// 			alert("匹配显示的元素：" + $("article p:visible").html());
			//匹配选中的select
			// 			alert(":selected:" + $("#sel1 option:selected").text());
			//匹配checked
			// 			alert(":checked:"+$("input:checked").val());

			/*筛选*/
			//eq()
			// 			alert("eq()方法筛选匹配下标的元素:"+$("ul li").eq(0).html());
			//hasClass()筛选是否含有某个样式
			// 			alert("hasClass()筛选是否含有某个样式:"+$("ul li").eq(0).hasClass("li-css"));
			//find()
			alert("find方法搜索;" + $("article").find("#p1").html());
			//修改css
			$("ul li").eq(2).css("color", "green");
			//click事件
			// 			$("ul li").eq(2).click(function() {
			// 				alert($(this).html());
			// 			});

			//绑定菜单tab
			$("ul li").click(function() {
				//获取当前选中的index
				var index = $(this).index();
				//获取当前index匹配的panel
				$(".c-panel-div").eq(index).show();
				//同辈元素隐藏
				$(".c-panel-div").eq(index).siblings().hide();
			});
		});
	</script>
</body>
</html>