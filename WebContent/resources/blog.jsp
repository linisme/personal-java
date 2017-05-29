<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blog</title>
<style>
.box-shadow-1{  
  -webkit-box-shadow: 3px 3px 6px  rgba(0, 0, 0, 。9);  
  -moz-box-shadow: 3px 3px 6px rgba(0, 0, 0, 。9);  
  box-shadow: 3px 3px 6px  rgba(100, 100, 100, 0.9);  
}  
.obj{  
    width:100px;  
    height:100px;  
    margin:50px auto;  
    background:#eee;      
}  
#picture{				
		width:100px;
		height:80px;		
		background-image:url('${pageContext.request.contextPath }/resources/1234abc.jpg');
		background-size:cover;
}
#music{				
		width:100px;
		height:80px;		
		background-image:url('${pageContext.request.contextPath }/resources/1234abc.jpg');
		background-size:cover;
}
</style>

</head>
<body> 

<div>
	<image src="${pageContext.request.contextPath }/resources/1234abc.jpg"  width="100" height="60"/><input name="image" type="file"/><br/>
	博主（用户名）<br>
	签名：但行善事，莫问前程！（可编辑）<br/>
	访问量：1000（查询数据库）
</div>
<br/>
<hr/>

<div id=thumbnail>
	<div id=picture class="obj box-shadow-1">
		<p>picture</p>
	</div>
	<div id=music>
		<p>music</p>
	</div>
	<div>
	</div>
	<div>
	</div>
</div>

<form action="${pageContext.request.contextPath }/submit" method="post" enctype="multipart/form-data">

商品列表：
<table width="100%" border="1">
<tr>
	<td border="1" marginwidth="1" marginheight="1" width=330 height=86 color=blue>摄影</td>
	<td>音乐</td>
	<td>简历</td>
	<td>博客</td>
</tr>

<c:forEach items="${LIST }" var="item">
<tr>
	<td>${item.user_id }</td>
	<td>${item.username }</td>	
	<td>${item.username }</td>	
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