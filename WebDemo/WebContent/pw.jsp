<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 设置移动设备虚拟屏幕 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>photoSwipe</title>

<!-- Core CSS file -->
<link rel="stylesheet"
	href="<%=BasePath%>/PhotoSwipe-master/dist/photoswipe.css">

<!-- Skin CSS file (styling of UI - buttons, caption, etc.)
     In the folder of skin CSS file there are also:
     - .png and .svg icons sprite, 
     - preloader.gif (for browsers that do not support CSS animations) -->
<link rel="stylesheet"
	href="<%=BasePath%>/PhotoSwipe-master/dist/default-skin/default-skin.css">

<!-- Core JS file -->
<script src="<%=BasePath%>/PhotoSwipe-master/dist/photoswipe.min.js"></script>

<!-- UI JS file -->
<script
	src="<%=BasePath%>/PhotoSwipe-master/dist/photoswipe-ui-default.min.js"></script>

<style type="text/css">
.section {
	width: 100%;
	margin-top: 176px;
}

.section--head {
	margin: 0;
	/* 	background: #EEE; */
	/*background: linear-gradient(180deg, #eee 0%,#fff 100%);*/
	padding: 20px 0;
}

.row {
	max-width: 800px;
	margin: 24px auto;
	padding: 0 30px;
	position: relative;
}

.row--heading {
	margin-top: 0;
	margin-bottom: 0;
}

.demo-gallery {
	width: 100%;
	height: auto;
	float: left;
}

.demo-gallery a {
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	-webkit-touch-callout: none;
	display: block;
	float: left;
	margin: 0 12px 12px 0;
	width: 171px;
	line-height: 0;
}

a.demo-gallery__img--main {
	width: auto;
	height: auto;
}

.demo-gallery figure {
	display: none;
}

img {
	/* 	width: auto; */
	max-width: 100%;
	/* 	height: auto; */
	border: 0;
	width: 171px;
	height: 113.281px;
}

/*qq  */
.photo-op-item {
	float: left;
	margin-right: 10px;
}

.gb-btn {
	color: #fff;
	border: 1px solid #8fb347;
	background-color: #ac6;
	background-position: 0 0 !important;
}

.photo-op-item .gb-btn {
	float: left;
	height: 23px;
	font-size: 16px;
	padding: 5px 20px;
	_padding: 7px 20px 3px;
	border-radius: 2px;
}

/*删除*/
.del-pdiv {
	position: relative;
}

.del-css {
	position: relative;
	z-index: 100;
	left: 200px;
	top: 100px;
}
</style>
</head>
<body>
	<div class="section section--head">

		<div class="row row--heading">
			<h3>相册管理</h3>
			<p>
			<div class="photo-op-item">
				<a href="javascript:;" class="gb-btn" id="js-oper-upload"
					data-hottag="operationbar.upload"><i
					class="icon-m icon-upload-m"></i>上传照片</a>
			</div>
			</p>

		</div>

		<div class="row">
			<div id="demo-test-gallery" class="demo-gallery">

				<a
					href="https://farm4.staticflickr.com/3894/15008518202_c265dfa55f_h.jpg"
					data-size="1600x1600"
					data-med="https://farm4.staticflickr.com/3894/15008518202_b016d7d289_b.jpg"
					data-med-size="1024x1024" data-author="Folkert Gorter"
					class="demo-gallery__img--main"> <img
					src="https://farm4.staticflickr.com/3894/15008518202_b016d7d289_m.jpg"
					alt="" />
					<figure>This is dummy caption.
					</figure>
				</a> <a
					href="https://farm6.staticflickr.com/5591/15008867125_b61960af01_h.jpg"
					data-size="1600x1068"
					data-med="https://farm6.staticflickr.com/5591/15008867125_68a8ed88cc_b.jpg"
					data-med-size="1024x683" data-author="Samuel Rohl"> <img
					src="https://farm6.staticflickr.com/5591/15008867125_68a8ed88cc_m.jpg"
					alt="" />
					<figure>This is dummy caption. It has been placed here
						solely to demonstrate the look and feel of finished, typeset text.
					</figure>
				</a> <a
					href="https://farm4.staticflickr.com/3902/14985871946_24f47d4b53_h.jpg"
					data-size="1600x1067"
					data-med="https://farm4.staticflickr.com/3902/14985871946_86abb8c56f_b.jpg"
					data-med-size="1024x683" data-author="Ales Krivec"> <img
					src="https://farm4.staticflickr.com/3902/14985871946_86abb8c56f_m.jpg"
					alt="" />
					<figure>This is dummy caption. It is not meant to be read.
					</figure>
				</a> <a
					href="https://farm6.staticflickr.com/5584/14985868676_b51baa4071_h.jpg"
					data-size="1600x1067"
					data-med="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_b.jpg"
					data-med-size="1024x683" data-author="Michael Hull"> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>Dummy caption. It's Greek to you. Unless, of
						course, you're Greek, in which case, it really makes no sense.
					</figure>
				</a> <a
					href="https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg"
					data-size="1600x1067"
					data-med="https://farm4.staticflickr.com/3920/15008465772_383e697089_b.jpg"
					data-med-size="1024x683" data-author="Thomas Lefebvre"> <img
					src="https://farm4.staticflickr.com/3920/15008465772_383e697089_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a> <a> <img src="<%=BasePath%>/images/t1.png" alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a> <a
					href="https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg"
					data-size="1600x1067"
					data-med="https://farm4.staticflickr.com/3920/15008465772_383e697089_b.jpg"
					data-med-size="1024x683" data-author="Thomas Lefebvre"> <img
					src="https://farm4.staticflickr.com/3920/15008465772_383e697089_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a> <a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a><a> <img
					src="https://farm6.staticflickr.com/5584/14985868676_4b802b932a_m.jpg"
					alt="" />
					<figure>It's a dummy caption. He who searches for meaning
						here will be sorely disappointed.
					</figure>
				</a>

			</div>
			<!-- <figure class="demo-gallery__title">Demo gallery &middot; 5 photos</figure> -->

			<!-- 			<div class="style-select">
				<p style="margin: 24px 0 12px; color: #444;">Demo gallery style</p>

				<div class="radio">
					<input type="radio" name="gallery-style" value="all"
						id="radio-all-controls" checked /> <label
						for="radio-all-controls"> All controls<br /> <span>caption,
							share and fullscreen buttons, tap to toggle controls</span>
					</label>
				</div>

				<div class="radio">
					<input type="radio" name="gallery-style" value="minimal"
						id="radio-minimal-black" /> <label for="radio-minimal-black">

						Minimal<br /> <span>no caption, transparent background, tap
							to close</span>
					</label>
				</div>

			</div> -->

		</div>

	</div>
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>

</body>
</html>