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
<!-- Bootstrap Core CSS -->
<link
	href="<%=BasePath%>/sb-admin/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<%=BasePath%>/sb-admin/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="<%=BasePath%>/sb-admin/dist/css/timeline.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=BasePath%>/sb-admin/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<%=BasePath%>/sb-admin/bower_components/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<%=BasePath%>/sb-admin/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<style type="text/css">
.pdeldiv {
	position: relative;
}

.deldiv {
	position: absolute;
	margin-top: 0px;
	margin-left: 10px;
	/* 	font-size: 10px; */
	width: 64px;
	text-align: center;
	font-weight: bold;
	cursor: pointer;
}

.deldiv>a {
	color: #66FFFF;
	background-color: black;
}

.thumbnail>img {
	width: 171px;
	height: 113px;
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
						<div class="col-xs-6 col-md-3 pdeldiv">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg4.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
							</div>
							<a href="#" class="thumbnail"> <img
								src="<%=BasePath%>/images/timg2.jpg" alt="...">
							</a>
						</div>
						<div class="col-xs-6 col-md-3">
							<div class="deldiv">
								<a>删除</a>
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





	<!-- jQuery -->
	<script
		src="<%=BasePath%>/sb-admin/bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<%=BasePath%>/sb-admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<%=BasePath%>/sb-admin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="<%=BasePath%>/sb-admin/bower_components/raphael/raphael-min.js"></script>
	<script
		src="<%=BasePath%>/sb-admin/bower_components/morrisjs/morris.min.js"></script>
	<script src="<%=BasePath%>/sb-admin/js/morris-data.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=BasePath%>/sb-admin/dist/js/sb-admin-2.js"></script>
</body>
</html>