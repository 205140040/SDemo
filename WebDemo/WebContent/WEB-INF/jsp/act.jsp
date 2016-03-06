<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>activity</title>
<style type="text/css">
.active {
	color: #ED00FB;
}

.un-active {
	color: black;
}

.dp {
	margin-bottom: 0px;
	margin-left: 230px;
	margin-right: auto;
	margin-top: 0px;
}

.dchild {
	font-size: 16px;
	width: 200px;
	height: 100px;
	display: table-cell;
	text-align: center;
	vertical-align: middle;
	border-style: solid;
	border-width: 1px;
	border-color: black;
	background-color: #F1E7F1;
	margin: 0px;
	margin-right: 0px;
	margin-left: 0px;
}
</style>
</head>
<body>
	<div class="dp">
		<div id="d1" class="dchild">一等奖</div>
		<div id="d2" class="dchild">二等奖</div>
		<div id="d3" class="dchild">三等奖</div>
	</div>
	<div class="dp">
		<div id="d4" class="dchild">四等奖</div>
		<div id="dbtn" class="dchild">
			<input id="startBtn" type="button" value="抽奖">
		</div>
		<div id="d5" class="dchild">五等奖</div>
	</div>
	<div class="dp">
		<div id="d6" class="dchild">六等奖</div>
		<div id="d7" class="dchild">七等奖</div>
		<div id="d8" class="dchild">八等奖</div>
	</div>


	<!-- 	<table width="400" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td class="dchild">一等奖</td>
			<td class="dchild">二等奖</td>
			<td class="dchild">三等奖</td>
		</tr>
		<tr>
			<td>四等奖</td>
			<td><input id="startBtn" type="button" value="抽奖"></td>
			<td>五等奖</td>
		</tr>
		<tr>
			<td>六等奖</td>
			<td>七等奖</td>
			<td>八等奖</td>
		</tr>
	</table> -->
	<input type="button" value="停止" onclick="stopLottery()">
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
	<script type="text/javascript">
		//抽奖
		var clid;//定时器id
		var awardNo = 1;//抽奖开始的序号
		var luckNo = 1;//中奖号
		var rn = 0;//抽奖循环总次数,随机数

		function lottery() {
			rn = genRandom(9, 23);//随机数
			clid = setInterval("changeAward()", 500);
		}

		function changeAward() {
			// 			console.log("rn:" + rn);
			var did = "d" + awardNo;
			//选中高亮
			$("#" + did + "").attr("class", "active dchild");

			//获取所有的抽奖div,取消其他的高亮
			$(".dchild").each(function(i, d) {
				var $d = $(d);
				var did2 = $(d).attr("id");
				if (did != did2) {
					$d.attr("class", "un-active dchild");
				}
			});
			if (luckNo > rn) {//如果循环次数>抽奖总次数
				stopLottery();
				var lname = $("#" + did + "").html();
				alert("恭喜你抽中了：" + lname);
			}
			var modn = luckNo % 8;
			luckNo++;
			awardNo++;
			if (modn == 0) {//如果循环次数%奖品次数==0，重新循环抽奖
				awardNo = 1;
			}
		}

		//停止抽奖，并初始化
		function stopLottery() {
			awardNo = 1;//初始化抽奖开始的序号
			luckNo = 1;
			clearInterval(clid);//停止定时函数
		}

		$("#startBtn").bind("click", lottery);

		function genRandom(max, min) {
			return Math.floor(Math.random() * (max - min + 1) + min);
		}
	</script>
</body>
</html>