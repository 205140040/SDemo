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
	href="<%=BasePath%>/bootstrap-3.3.5/dist/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="<%=BasePath%>/bootstrap-3.3.5/dist/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=BasePath%>/jquery/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=BasePath%>/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>


<!-- jquery-fancybox -->
<!-- Add mousewheel plugin (this is optional) -->
<script type="text/javascript"
	src="<%=BasePath%>/fancyBox-master/lib/jquery.mousewheel.pack.js"></script>

<!-- Add fancyBox main JS and CSS files -->
<script type="text/javascript"
	src="<%=BasePath%>/fancyBox-master/source/jquery.fancybox.pack.js?v=2.1.5"></script>
<link rel="stylesheet" type="text/css"
	href="<%=BasePath%>/fancyBox-master/source/jquery.fancybox.css?v=2.1.5"
	media="screen" />

<!-- Add Button helper (this is optional) -->
<link rel="stylesheet" type="text/css"
	href="<%=BasePath%>/fancyBox-master/source/helpers/jquery.fancybox-buttons.css?v=1.0.5" />
<script type="text/javascript"
	src="<%=BasePath%>/fancyBox-master/source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>

<!-- Add Thumbnail helper (this is optional) -->
<link rel="stylesheet" type="text/css"
	href="<%=BasePath%>/fancyBox-master/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" />
<script type="text/javascript"
	src="<%=BasePath%>/fancyBox-master/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>

<!-- Add Media helper (this is optional) -->
<script type="text/javascript"
	src="<%=BasePath%>/fancyBox-master/source/helpers/jquery.fancybox-media.js?v=1.0.6"></script>


<!-- webUploader -->
<link rel="stylesheet" type="text/css"
	href="<%=BasePath%>/webuploader-0.1.5/css/webuploader.css" />
<link rel="stylesheet" type="text/css"
	href="<%=BasePath%>/webuploader-0.1.5/examples/image-upload/style.css" />
<script type="text/javascript"
	src="<%=BasePath%>/webuploader-0.1.5/dist/webuploader.js"></script>
<script type="text/javascript"
	src="<%=BasePath%>/webuploader-0.1.5/examples/image-upload/upload.js"></script>

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

.bsig-del-panel span.bsig-del-cancel {
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
						<a id="uploadimgbtn">上传图片</a> <a>上传文件</a>
					</h4>
				</div>
				<div class="modal-body">

					<div class="row">
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg2.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg4.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/5_s.jpg" class="thumbnail"
								data-fancybox-group="button" title="5_s"> <img
								src="<%=BasePath%>/images/5_s.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg4.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg2.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg4.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg2.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg4.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg2.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="bsig-del-panel">
								<span class="bsig-del-cancel">删除</span>
							</div>
							<a href="<%=BasePath%>/images/timg4.jpg" class="thumbnail"
								data-fancybox-group="button" title="timg2"> <img
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

	<!-- webUploaderModal图片上传modal -->
	<div class="element-invisible" id="webUploaderModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
		style="">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" style="font-size: 1.2em;">关闭</button>

				</div>
				<div class="modal-body">
					<!--头部，相册选择和格式选择-->

					<div id="uploader">
						<div class="queueList">
							<div id="dndArea" class="placeholder">
								<div id="filePicker"></div>
								<p>或将照片拖到这里，单次最多可选300张</p>
							</div>
						</div>
						<div class="statusBar" style="display: none;">
							<div class="progress">
								<span class="text">0%</span> <span class="percentage"></span>
							</div>
							<div class="info"></div>
							<div class="btns">
								<div id="filePicker2"></div>
								<div class="uploadBtn">开始上传</div>
							</div>
						</div>
					</div>

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
				//隐藏所有的deldiv
				var $allDelDiv = $(".bsig-del-panel").css("height", "0px");
				//显示当前的deldiv
				var $deldiv = $(this).prev();
				$deldiv.css("height", "20px");
			});

			/*鼠标从删除panle移走时消失*/
			$(".bsig-del-panel").mouseout(function() {
				var $deldiv = $(this);
				$deldiv.css("height", "0px");
			});

			$(".bsig-del-panel").on("click", function() {
				//删除
				$(this).parent().remove();
			});

			/*加载jqueryFancybox，轮播*/
			$('.thumbnail').fancybox(
					{
						openEffect : 'none',
						closeEffect : 'none',

						prevEffect : 'none',
						nextEffect : 'none',

						closeBtn : false,

						helpers : {
							title : {
								type : 'inside'
							},
							buttons : {}
						},

						afterLoad : function() {
							this.title = 'Image ' + (this.index + 1) + ' of '
									+ this.group.length
									+ (this.title ? ' - ' + this.title : '');
						}
					});

			//为使webUploader点击选择图片有效，需延迟隐藏div
			setTimeout(function() {
				$("#webUploaderModal").attr("class", "modal fade");
				$("#webUploaderModal").attr("style", "display: none;");
			}, 300);

			//绑定上传图片显示model
			$("#uploadimgbtn").on("click", function() {
				$("#webUploaderModal").modal("show");
			});
		});
	</script>
</body>
</html>