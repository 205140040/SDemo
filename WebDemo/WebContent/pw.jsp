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
					href="https://farm6.staticflickr.com/5591/15008867125_b61960af01_h.jpg"
					data-size="1600x1068"
					data-med="https://farm6.staticflickr.com/5591/15008867125_68a8ed88cc_b.jpg"
					data-med-size="1024x683" data-author="Samuel Rohl"> <img
					src="https://farm6.staticflickr.com/5591/15008867125_68a8ed88cc_m.jpg"
					alt="" />
					<figure>h.jpg
					</figure>
				</a> <a href="<%=BasePath%>/images/t1.png" data-size="1600x1068"
					data-med="https://farm6.staticflickr.com/5591/15008867125_68a8ed88cc_b.jpg"
					data-med-size="1024x683" data-author="t1"> <img
					src="<%=BasePath%>/images/t1.png" alt="" />
					<figure>t1
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

	<!-- Root element of PhotoSwipe. Must have class pswp. -->
	<div class="pswp" tabindex="-1" role="dialog" aria-hidden="true">

		<!-- Background of PhotoSwipe. 
         It's a separate element as animating opacity is faster than rgba(). -->
		<div class="pswp__bg"></div>

		<!-- Slides wrapper with overflow:hidden. -->
		<div class="pswp__scroll-wrap">

			<!-- Container that holds slides. 
            PhotoSwipe keeps only 3 of them in the DOM to save memory.
            Don't modify these 3 pswp__item elements, data is added later on. -->
			<div class="pswp__container">
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
				<div class="pswp__item"></div>
			</div>

			<!-- Default (PhotoSwipeUI_Default) interface on top of sliding area. Can be changed. -->
			<div class="pswp__ui pswp__ui--hidden">

				<div class="pswp__top-bar">

					<!--  Controls are self-explanatory. Order can be changed. -->

					<div class="pswp__counter"></div>

					<button class="pswp__button pswp__button--close"
						title="Close (Esc)"></button>

					<button class="pswp__button pswp__button--share" title="Share"></button>

					<button class="pswp__button pswp__button--fs"
						title="Toggle fullscreen"></button>

					<button class="pswp__button pswp__button--zoom" title="Zoom in/out"></button>

					<!-- Preloader demo http://codepen.io/dimsemenov/pen/yyBWoR -->
					<!-- element will get class pswp__preloader--active when preloader is running -->
					<div class="pswp__preloader">
						<div class="pswp__preloader__icn">
							<div class="pswp__preloader__cut">
								<div class="pswp__preloader__donut"></div>
							</div>
						</div>
					</div>
				</div>

				<div
					class="pswp__share-modal pswp__share-modal--hidden pswp__single-tap">
					<div class="pswp__share-tooltip"></div>
				</div>

				<button class="pswp__button pswp__button--arrow--left"
					title="Previous (arrow left)"></button>

				<button class="pswp__button pswp__button--arrow--right"
					title="Next (arrow right)"></button>

				<div class="pswp__caption">
					<div class="pswp__caption__center"></div>
				</div>

			</div>

		</div>

	</div>
	<script type="text/javascript"
		src="<%=BasePath%>/jquery/jquery-2.1.1.js"></script>

	<script type="text/javascript">
		(function() {

			var initPhotoSwipeFromDOM = function(gallerySelector) {

				var parseThumbnailElements = function(el) {
					var thumbElements = el.childNodes, numNodes = thumbElements.length, items = [], el, childElements, thumbnailEl, size, item;

					for (var i = 0; i < numNodes; i++) {
						el = thumbElements[i];

						// include only element nodes 
						if (el.nodeType !== 1) {
							continue;
						}

						childElements = el.children;

						size = el.getAttribute('data-size').split('x');

						// create slide object
						item = {
							src : el.getAttribute('href'),
							w : parseInt(size[0], 10),
							h : parseInt(size[1], 10),
							author : el.getAttribute('data-author')
						};

						item.el = el; // save link to element for getThumbBoundsFn

						if (childElements.length > 0) {
							item.msrc = childElements[0].getAttribute('src'); // thumbnail url
							if (childElements.length > 1) {
								item.title = childElements[1].innerHTML; // caption (contents of figure)
							}
						}

						var mediumSrc = el.getAttribute('data-med');
						if (mediumSrc) {
							size = el.getAttribute('data-med-size').split('x');
							// "medium-sized" image
							item.m = {
								src : mediumSrc,
								w : parseInt(size[0], 10),
								h : parseInt(size[1], 10)
							};
						}
						// original image
						item.o = {
							src : item.src,
							w : item.w,
							h : item.h
						};

						items.push(item);
					}

					return items;
				};

				// find nearest parent element
				var closest = function closest(el, fn) {
					return el && (fn(el) ? el : closest(el.parentNode, fn));
				};

				var onThumbnailsClick = function(e) {
					e = e || window.event;
					e.preventDefault ? e.preventDefault()
							: e.returnValue = false;

					var eTarget = e.target || e.srcElement;

					var clickedListItem = closest(eTarget, function(el) {
						return el.tagName === 'A';
					});

					if (!clickedListItem) {
						return;
					}

					var clickedGallery = clickedListItem.parentNode;

					var childNodes = clickedListItem.parentNode.childNodes, numChildNodes = childNodes.length, nodeIndex = 0, index;

					for (var i = 0; i < numChildNodes; i++) {
						if (childNodes[i].nodeType !== 1) {
							continue;
						}

						if (childNodes[i] === clickedListItem) {
							index = nodeIndex;
							break;
						}
						nodeIndex++;
					}

					if (index >= 0) {
						openPhotoSwipe(index, clickedGallery);
					}
					return false;
				};

				var photoswipeParseHash = function() {
					var hash = window.location.hash.substring(1), params = {};

					if (hash.length < 5) { // pid=1
						return params;
					}

					var vars = hash.split('&');
					for (var i = 0; i < vars.length; i++) {
						if (!vars[i]) {
							continue;
						}
						var pair = vars[i].split('=');
						if (pair.length < 2) {
							continue;
						}
						params[pair[0]] = pair[1];
					}

					if (params.gid) {
						params.gid = parseInt(params.gid, 10);
					}

					return params;
				};

				var openPhotoSwipe = function(index, galleryElement,
						disableAnimation, fromURL) {
					var pswpElement = document.querySelectorAll('.pswp')[0], gallery, options, items;

					items = parseThumbnailElements(galleryElement);

					// define options (if needed)
					options = {

						galleryUID : galleryElement
								.getAttribute('data-pswp-uid'),

						getThumbBoundsFn : function(index) {
							// See Options->getThumbBoundsFn section of docs for more info
							var thumbnail = items[index].el.children[0], pageYScroll = window.pageYOffset
									|| document.documentElement.scrollTop, rect = thumbnail
									.getBoundingClientRect();

							return {
								x : rect.left,
								y : rect.top + pageYScroll,
								w : rect.width
							};
						},

						addCaptionHTMLFn : function(item, captionEl, isFake) {
							if (!item.title) {
								captionEl.children[0].innerText = '';
								return false;
							}
							captionEl.children[0].innerHTML = item.title
									+ '<br/><small>Photo: ' + item.author
									+ '</small>';
							return true;
						},

					};

					if (fromURL) {
						if (options.galleryPIDs) {
							// parse real index when custom PIDs are used 
							// http://photoswipe.com/documentation/faq.html#custom-pid-in-url
							for (var j = 0; j < items.length; j++) {
								if (items[j].pid == index) {
									options.index = j;
									break;
								}
							}
						} else {
							options.index = parseInt(index, 10) - 1;
						}
					} else {
						options.index = parseInt(index, 10);
					}

					// exit if index not found
					if (isNaN(options.index)) {
						return;
					}

					var radios = document.getElementsByName('gallery-style');
					for (var i = 0, length = radios.length; i < length; i++) {
						if (radios[i].checked) {
							if (radios[i].id == 'radio-all-controls') {

							} else if (radios[i].id == 'radio-minimal-black') {
								options.mainClass = 'pswp--minimal--dark';
								options.barsSize = {
									top : 0,
									bottom : 0
								};
								options.captionEl = false;
								options.fullscreenEl = false;
								options.shareEl = false;
								options.bgOpacity = 0.85;
								options.tapToClose = true;
								options.tapToToggleControls = false;
							}
							break;
						}
					}

					if (disableAnimation) {
						options.showAnimationDuration = 0;
					}

					// Pass data to PhotoSwipe and initialize it
					gallery = new PhotoSwipe(pswpElement, PhotoSwipeUI_Default,
							items, options);

					// see: http://photoswipe.com/documentation/responsive-images.html
					var realViewportWidth, useLargeImages = false, firstResize = true, imageSrcWillChange;

					gallery
							.listen(
									'beforeResize',
									function() {

										var dpiRatio = window.devicePixelRatio ? window.devicePixelRatio
												: 1;
										dpiRatio = Math.min(dpiRatio, 2.5);
										realViewportWidth = gallery.viewportSize.x
												* dpiRatio;

										if (realViewportWidth >= 1200
												|| (!gallery.likelyTouchDevice && realViewportWidth > 800)
												|| screen.width > 1200) {
											if (!useLargeImages) {
												useLargeImages = true;
												imageSrcWillChange = true;
											}

										} else {
											if (useLargeImages) {
												useLargeImages = false;
												imageSrcWillChange = true;
											}
										}

										if (imageSrcWillChange && !firstResize) {
											gallery.invalidateCurrItems();
										}

										if (firstResize) {
											firstResize = false;
										}

										imageSrcWillChange = false;

									});

					gallery.listen('gettingData', function(index, item) {
						if (useLargeImages) {
							item.src = item.o.src;
							item.w = item.o.w;
							item.h = item.o.h;
						} else {
							item.src = item.m.src;
							item.w = item.m.w;
							item.h = item.m.h;
						}
					});
					
					//hyc
					gallery.listen('shareLinkClick', function(e, target) { 
					    // e - original click event
					    // target - link that was clicked

					    // If `target` has `href` attribute and 
					    // does not have `download` attribute - 
					    // share modal window will popup
					    event.preventDefault();
					    console.log(e,target);
					});

					gallery.init();
				};

				// select all gallery elements
				var galleryElements = document
						.querySelectorAll(gallerySelector);
				for (var i = 0, l = galleryElements.length; i < l; i++) {
					galleryElements[i].setAttribute('data-pswp-uid', i + 1);
					galleryElements[i].onclick = onThumbnailsClick;
				}

				// Parse URL and open gallery if it contains #&pid=3&gid=1
				var hashData = photoswipeParseHash();
				if (hashData.pid && hashData.gid) {
					openPhotoSwipe(hashData.pid,
							galleryElements[hashData.gid - 1], true, true);
				}
			};

			initPhotoSwipeFromDOM('.demo-gallery');

		})();
	</script>










	<!-- analytics -->
	<script>
		(function() {

			var url = window.location.href.toLowerCase();
			if (url.indexOf('photoswipe') === -1) {
				return;
			}

			(function(i, s, o, g, r, a, m) {
				i['GoogleAnalyticsObject'] = r;
				i[r] = i[r] || function() {
					(i[r].q = i[r].q || []).push(arguments)
				}, i[r].l = 1 * new Date();
				a = s.createElement(o), m = s.getElementsByTagName(o)[0];
				a.async = 1;
				a.src = g;
				m.parentNode.insertBefore(a, m)
			})(window, document, 'script',
					'//www.google-analytics.com/analytics.js', 'ga');

			ga('create', 'UA-49016964-1', 'photoswipe.com');
			ga('send', 'pageview');

			function trackJavaScriptError(e) {
				e = e || window.event;
				if (!e || !e.message || !e.lineno) {
					return true;
				}
				var errMsg = e.message;
				var errSrc = e.filename + ': ' + e.lineno;
				ga('send', 'event', 'JavaScript Error', errMsg, errSrc, {
					'nonInteraction' : 1
				});
			}

			if (window.addEventListener) {
				window.addEventListener('error', trackJavaScriptError, false);
			} else if (window.attachEvent) {
				window.attachEvent('onerror', trackJavaScriptError);
			} else {
				window.onerror = trackJavaScriptError;
			}

			(function(d, w, c) {
				(w[c] = w[c] || []).push(function() {
					try {
						w.yaCounter24301471 = new Ya.Metrika({
							id : 24301471,
							webvisor : false,
							clickmap : false
						});
					} catch (e) {
					}
				});

				var n = d.getElementsByTagName("script")[0], s = d
						.createElement("script"), f = function() {
					n.parentNode.insertBefore(s, n);
				};
				s.type = "text/javascript";
				s.async = true;
				s.src = (d.location.protocol == "https:" ? "https:" : "http:")
						+ "//mc.yandex.ru/metrika/watch.js";

				if (w.opera == "[object Opera]") {
					d.addEventListener("DOMContentLoaded", f, false);
				} else {
					f();
				}
			})(document, window, "yandex_metrika_callbacks");

		})();
	</script>
</body>
</html>