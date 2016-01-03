<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="mytag" uri="/WEB-INF/mytags/tag1.tld"%>
<%@taglib prefix="headTag" uri="/WEB-INF/mytags/tag2.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tagDemo</title>
</head>
<body>
	<h2>自定义标签</h2>
	<mytag:tag1 userName="张三三"/>
	<headTag:headingTag align="left" 
	bgColor="CYAN" border="5" fontColor="rgb(206, 0, 255)" 
	font="Arial Black" size="78">让我带上思考帽</headTag:headingTag>
</body>
</html>