<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>tmm只使用iframe上传的demo</title>
    <script src="http://g.tbcdn.cn/kissy/k/1.4.2/seed-min.js" charset="utf-8"></script>
</head>
<body>
<h2>imageUploader主题</h2>
<ul>
    <li><a href="https://github.com/KF-kissyForm/butterfly/tree/master/kg/uploader/2.0.2/themes/imageUploader" target="_blank">源码</a></li>
    <li>作者：明河</li>
    <li>设计：明河</li>
    <li>描述：图片上传专用主题，带图片统计</li>
    <li>版本：1.4</li>
    <li>兼容：chrome、firefox、IE9、IE8、IE6</li>
</ul>
<div class="grid">
    <input type="file" class="g-u" id="J_UploaderBtn" value="上传图片" name="Filedata" accept="image/*" >
    <input type="hidden" id="J_Urls" name="urls" value="" />
    <div class="g-u">还可以上传<span id="J_UploadCount">3</span>张图片</div>
</div>
<ul id="J_UploaderQueue" class="grid">

</ul>
<script>
    var S = KISSY;
    S.config({
        packages:[
            {
                name:"kg",
                path:"http://g.tbcdn.cn/kg/",
                charset:"utf-8",
                ignorePackageNameInUri:true
            }
        ]
    });

    if (S.Config.debug) {
        var srcPath = "../";
        S.config({
            packages:[
                {
                    name:"kg/uploader/2.0.2",
                    path:srcPath,
                    charset:"utf-8",
                    ignorePackageNameInUri:true
                }
            ]
        });
    }

    S.use('kg/uploader/2.0.2/index,kg/uploader/2.0.2/themes/imageUploader/index,kg/uploader/2.0.2/themes/imageUploader/style.css', function (S, Uploader,ImageUploader) {
        //上传组件插件
        var plugins = 'kg/uploader/2.0.2/plugins/auth/auth,' +
                'kg/uploader/2.0.2/plugins/urlsInput/urlsInput,' +
                'kg/uploader/2.0.2/plugins/proBars/proBars,' +
                'kg/uploader/2.0.2/plugins/filedrop/filedrop,' +
                'kg/uploader/2.0.2/plugins/preview/preview';

        S.use(plugins,function(S,Auth,UrlsInput,ProBars,Filedrop,Preview){
            var uploader = new Uploader('#J_UploaderBtn',{
                //处理上传的服务器端脚本路径
                action:"http://localhost:8005/upload",
                multiple:true
            });
            //使用主题
            uploader.theme(new ImageUploader({
                queueTarget:'#J_UploaderQueue'
            }))
                    //验证插件
                    uploader.plug(new Auth({
                        //最多上传个数
                        max:3,
                        //图片最大允许大小
                        maxSize:6000
                    }))
                    //url保存插件
                    .plug(new UrlsInput({target:'#J_Urls'}))
                    //进度条集合
                    .plug(new ProBars())
                    //拖拽上传
                    .plug(new Filedrop())
                    //图片预览
                    .plug(new Preview())
            ;
        });
    })

</script>
</body>
</html>