<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<title>图片管理</title>


<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style type="text/css">
/*基于bootstrap的imgGallary,thumbnail中的img图片样式*/
.thumbnail img {
	vertical-align: middle;
	width: 110px;
	height: 110px;
}
/*基于bootstrap的imgGallary,del-panel*/
.bsig-del-panel {
	position: absolute;
	filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,
		startColorstr='#80000000', endColorstr='#80000000') \0;
	background: rgba(0, 0, 0, 0.5);
	top: 0;
	left: 0;
	overflow: hidden;
	z-index: 300;
	height: 0px;
	width: 30px;
	margin-left: 18px;
}

.bsig-del-panel span.cancel {
	width: 20px;
	height: 20px;
	color: #FFFFFF;
}
</style>

</head>
<body>

	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">图片管理</button>


	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						<a>上传图片</a> <a>上传文件</a>
					</h4>
				</div>
				<div class="modal-body">

					<div class="row">
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="cancel">删除</span>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

	<script type="text/javascript">
		$(function() {
			/*当鼠标移到图片上时显示删除，移走后消失*/
			$(".thumbnail").mouseover(function() {
				var $deldiv = $(this).prev();
				$deldiv.css("height", "20px");
			});

			$(".thumbnail").mouseout(function() {
				var $deldiv = $(this).prev();
				$deldiv.css("height", "0px");
			});
		});
	</script>
</body>
</html>