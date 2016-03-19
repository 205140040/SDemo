<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>jiangzi</title>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!--sui  -->
<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
<link rel="stylesheet"
	href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
<style type="text/css">
.infinite-scroll-preloader {
	margin-top: -20px;
}
/**
zj
*/
.recordDetails {
	width: 100%;
	height: auto;
}

.detailsForm {
	width: 73%;
	float: left;
	position: absolute;
	left: 15%;
	height: auto;
}
</style>
</head>
<body>
	<!-- page集合的容器，里面放多个平行的.page，其他.page作为内联页面由路由控制展示 -->
	<div class="page-group">
		<!-- 单个page ,第一个.page默认被展示-->
		<div class="page">
			<div class="buttons-tab">
				<a href="#tab1" class="tab-link button">首页</a> <a href="#tab2"
					class="tab-link button">我要投资</a> <a href="#tab3"
					class="tab-link active button">我的账户</a>
			</div>
			<div class="buttons-tab"
				style="background-color: #F6F6F6; text-align: center; z-index: 2;">
				<a href="#" class="button">交易记录</a>
			</div>

			<!-- 这里是页面内容区 -->



			<!-- 添加 class infinite-scroll 和 data-distance  向下无限滚动可不加infinite-scroll-bottom类，这里加上是为了和下面的向上无限滚动区分-->
			<div class="content infinite-scroll infinite-scroll-bottom"
				style="margin-top: 57px;" data-distance="100">
				<div class="list-block">
					<ul class="list-container recordDetails">
					</ul>
				</div>
				<!-- 加载提示符 -->
				<div class="infinite-scroll-preloader">
					<div class="preloader"></div>
				</div>
			</div>

		</div>

	</div>

	<!--sui  -->
	<script type='text/javascript'
		src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
	<script type='text/javascript'
		src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>

	<script type="text/javascript">
		$(function() {
			'use strict';
			// 加载flag
			var loading = false;
			// 最多可加载的条目
			var maxItems = 100;

			// 每次加载添加多少条目
			var itemsPerLoad = 20;

			function addItems(number, lastIndex) {
				// 生成新条目的HTML
				var html = '';
				var cta = '<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">'
						+ '<tr>'
						+ '<td>18日</td>'
						+ '<td rowspan="2"><img src="http://m.vstate.cn/images/investmentDatetails/TuBiao-JiaoYiJiLu-HuoQiShouYi@3x.png" style="height:30px;width:30px;"></td>'
						+ '<td>+666,666,66.66</td>'
						+ '<td rowspan="2"><span style="font-size:12px;">成功</span></td>'
						+ '</tr>'
						+ ' <tr>'
						+ '<td>16:42</td>'
						+ '<td><span style="font-size:12px;">投资活期·V计划第005期(锁定180天)</span></td>'
						+ '</tr>' + '</table>';
				for (var i = lastIndex + 1; i <= lastIndex + number; i++) {
					html += '<li class="item-content"><div class="item-inner"><div class="item-title" >'
							+ cta + '</div></div></li>';
				}
				// 添加新条目
				$('.infinite-scroll-bottom .list-container').append(html);

			}
			//预先加载20条
			addItems(itemsPerLoad, 0);

			// 上次加载的序号

			var lastIndex = 20;

			// 注册'infinite'事件处理函数
			$(document).on('infinite', '.infinite-scroll-bottom', function() {

				// 如果正在加载，则退出
				if (loading)
					return;

				// 设置flag
				loading = true;

				// 模拟1s的加载过程
				setTimeout(function() {
					// 重置加载flag
					loading = false;

					if (lastIndex >= maxItems) {
						// 加载完毕，则注销无限加载事件，以防不必要的加载
						$.detachInfiniteScroll($('.infinite-scroll'));
						// 删除加载提示符
						$('.infinite-scroll-preloader').remove();
						return;
					}

					// 添加新条目
					addItems(itemsPerLoad, lastIndex);
					// 更新最后加载的序号
					lastIndex = $('.list-container li').length;
					//容器发生改变,如果是js滚动，需要刷新滚动
					$.refreshScroller();
				}, 1000);
			});

			$.init();
		});
	</script>
</body>
</html>