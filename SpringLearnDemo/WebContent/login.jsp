<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>

<s:url var="authUrl" value="/static/j_spring_security_check"></s:url>
<form id="form1" name="form1" method="post" action="${authUrl}">
  <table width="600" border="1">
    <tr>
      <td colspan="2">login</td>
    </tr>
    <tr>
      <td>username:</td>
      <td><label for="username"></label>
      <input type="text" name="username" id="username" /></td>
    </tr>
    <tr>
      <td>password:</td>
      <td><input type="text" name="password" id="password" /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" name="button" id="button" value="提交" />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="reset" name="button2" id="button2" value="重置" />
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="checkbox" id="remember-me" name="_spring_security_remeber_me" />remember-me
      
      </td>
    </tr>
  </table>
</form>
</body>
</html>