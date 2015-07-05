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
<title>springLearnDemo</title>
</head>
<body>
<form action="<%=basePath %>UserController/user" method="post" enctype="multipart/form-data" name="form1" id="form1" >
  <table width="600" border="1">
    <tr>
      <td colspan="2">用户信息</td>
    </tr>
    <tr>
      <td>姓名：</td>
      <td><label for="name"></label>
      <input type="text" name="name" id="name" /></td>
    </tr>
    <tr>
      <td>性别：</td>
      <td><input type="text" name="sex" id="sex" /></td>
    </tr>
    <tr>
      <td>年龄：</td>
      <td><input type="text" name="age" id="age" /></td>
    </tr>
    <tr>
      <td>照片：</td>
      <td>
      <input type="file" name="photo" id="photo" /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" name="button" id="button" value="提交" /></td>
    </tr>
  </table>
</form>
</body>
</html>