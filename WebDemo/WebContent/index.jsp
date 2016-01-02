<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
this is index.jsp
<br>
<h1>公司名称：${applicationScope.companyName }</h1>
hello wolrd!
<br>
<h2>当前sessionCount：${sessionCount.currentCount }</h2>
<h2>maxCount：${sessionCount.maxCount }</h2>
<h2>totalCount：${sessionCount.totalCount }</h2>

</body>
</html>