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
	
}

.dchild {
	display: inline-block;
	width: 100px;
	height: 1.5em;
	text-align: center;
	vertical-align: middle;
	border-style: solid;
	border-width: 1px;
	border-color: black;
	margin: 0px;
	padding: 0px;
	border-style: solid;
}
            .cur{color:red;font-weight:700;font-size:30px;}<!--选中状态--> 
</style>
</head>
<body>
	<span onclick="getAward();">go</span>
	<!--点击开始抽奖-->
	<span onclick="stopAward();">stop</span>
	<br />
	<!--点击停止抽奖-->
	<span id="a0" class="cur">0</span>
	<br />
	<span id="a1">1</span>
	<br />
	<span id="a2">2</span>
	<br />
	<span id="a3">3</span>
	<br />
	<span id="a4">4</span>
	<br />
	<span id="a5">5</span>
	<br />
	<span id="a6">6</span>
	<br />
	<span id="a7">7</span>
	<br />
	<span id="a8">8</span>
	<br />
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>
	<script type="text/javascript">
		var start = 0;
		//第一个奖品代号0 
		var end = 8;
		//最后一个奖品代后是8 
		var cur = 0;
		//当前被选中（高亮）的奖品 
		var distance = 0;
		//从后台得到中奖代后滚动过的格数 
		var time = 300;
		//没0.3秒转盘滚动一格 
		var go;
		//声明用来让转盘滚动的定时器 
		var stop = -1;
		//应该停下来的奖品代码，默认为-1，即开始无奖品 

		var getAward = function() {
			clearInterval(go);
			//清除定时器，防止多次开始按钮造成混乱 
			go = setInterval("change()", time);
			//每隔time毫秒换一个格子 
		};

		var change = function() {
			if (stop == cur && distance > 5) {
				//判断中奖代后与当前是否一致，且滚动格数是否大于5步（为了让转盘多滚动几下，避免马上停下） 
				showAward(stop);
				//如果中奖，则提示用户，停止抽奖程序 
				return;
			}
			$("#a" + cur).removeClass("cur");
			//把当前奖品设置为常态 
			if (cur == 8) {
				$("#a" + start).addClass("cur");
				//把第一个奖品设置为高亮cur=0;//让cur指向第一个奖品 
			} else {
				$("#a" + (cur + 1)).addClass("cur");
				//把下一个奖品设置为高亮 
				cur++;
				//让cur指向下一个奖品 
			}
			(stop >= 0) && (time = time + 100);
			//如果stop>=0，即受到中奖信息后，把定时器时间加长，目的是让转盘越转越慢 
			(stop >= 0) && distance++;
			//中奖后，每滚动一次给distance加1，可以让转盘多滚几下，不至于马上停止 
			clearInterval(go);
			getAward();
		};
		var stopAward = function(award) {
			//后台获取中奖代号award 
			stop = award;
			//把中奖信息传递给stop 
		}
		var showAward = function(award) {
			alert(award);
			//提示用户的奖项 
			clearInterval(go);
			//清除定时器 
		}
	</script>
</body>
</html>