<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body> 
<form action="${pageContext.request.contextPath }/submit" method="post" enctype="multipart/form-data">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1 >
<tr>
	<td>商品代号</td>
	<td>用户名</td>
	<td>地址</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${LIST }" var="item">
<tr>
	<td>${item.user_id }</td>
	<td>${item.username }</td>	
	<td>${item.password }</td>
	
	<td><a href="${pageContext.request.contextPath }/item/editItem.action?id=${item.user_id}">修改</a></td>

</tr>
</c:forEach>
<tr>
	<td><image src="${pageContext.request.contextPath }/resources/1234abc.jpg"  width="100" height="60" ></td>
	<td><input name="image" type="file"></td>
	<td><input name="提交" type="submit"></td>
	<td><iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86 src="//music.163.com/outchain/player?type=2&id=5233049&auto=0&height=66"></iframe></td>
</tr>
</table>
</form>
</body>

</html>