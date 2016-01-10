<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl演示</title>
</head>
<body>
	<%
		String uname = "露露啦啦啦啦啦";
		request.setAttribute("uname", uname);
		List<String> nList = new ArrayList();
		nList.add("one");
		nList.add("two");
		nList.add("three");
		nList.add("four");
		nList.add("five");
		nList.add("six");
		request.setAttribute("nList", nList);
		String cName=this.getClass().getClassLoader().getClass().getName();
	%>
	<h3 align="center">
		c:out <font color="blue"> <c:out value="${uname }"
				default="none"></c:out>
		</font>
	</h3>
<h3 align="center">
		类装载器名称 <font color="blue"> <c:out value="<%=cName %>"
				default="none"></c:out>
		</font>
	</h3>
	<h3 align="center">
		foreach

		<ul>
			<c:forEach items="${nList }" var="l" begin="0" end="3">
				<li><font color="blue"> ${l }</font></li>
			</c:forEach>
		</ul>

	</h3>
	<h3 align="center">
		<%
			Integer n = 3;
			request.setAttribute("n", n);
		%>
		choose
		<c:choose>
			<c:when test="${1==n }">
				<c:out value="1等于n"></c:out>
			</c:when>
			<c:when test="${2==n }">
				<c:out value="2等于n"></c:out>
			</c:when>
			<c:otherwise>
				<c:out value="1和2都不等于n"></c:out>
			</c:otherwise>
		</c:choose>
	</h3>
	<h3 align="center">
		cset:
		<c:set var="setName" value="啦啦啦 " scope="request"></c:set>
		<font color="blue"> <c:out value="${setName }"></c:out></font>

	</h3>
	<h3 align="center">
		cimport导入不同服务器的页面:
<%-- 		<c:import url="http://www.baidu.com/"></c:import> --%>
	</h3>
	<h3 align="center">
		credirect导入不同服务器的页面:
<%-- 		<c:redirect url="http://www.baidu.com">重定向到百度</c:redirect> --%>
	</h3>
</body>
</html>