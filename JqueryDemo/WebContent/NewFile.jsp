<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String BasePath=request.getContextPath(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码</title>
<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" 
data-appid="APPID" data-redirecturi="REDIRECTURI" charset="utf-8"></script>
</head>
<body>
验证码:<img alt="" src="<%=BasePath %>/GM/generateImage.spring"><br>
<span id="qqLoginBtn" >
<img alt="" src="<%=request.getContextPath()%>/image/Connect_logo_7.png"> 
</span>
<script type="text/javascript">
    QC.Login({
       btnId:"qqLoginBtn"    //插入按钮的节点id
	});
</script>
</body>
</html>