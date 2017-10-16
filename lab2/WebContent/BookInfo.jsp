<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>该书目'介绍</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<style type="text/css">
table{
border:1px solid lightgray;
border-spacing:5px;
}
td{
padding:3px;
border:thin dashed lightblue;
color:#FFFFFF;
}
th{
padding:3px;
border:thin dashed lightblue;
background-color:lightblue;
color:#008080;
}
.blist{padding:20px;}
body {background-color:#008080;}
</style> 
</head>
	<body>
		<div class="blist">
		<table>
		<tr>
			<th>该图书详细信息</th>
			<th>作者详细信息</th>
		</tr>
		<tr>
			<td>ISBN : <s:property value = "ISBN"/></td>
			<td>作者 : <s:property value = "Name"/></td>
		</tr>
		<tr>
			<td>书名 : <s:property value = "Title"/></td>
			<td>年龄 : <s:property value = "Age"/></td>
		</tr>
		<tr>
			<td>作者编码 : <s:property value = "AuthorID"/></td>
			<td>国家 : <s:property value = "Country"/></td>
		</tr>
		<tr>
			<td>出版社 : <s:property value = "Publisher"/></td>
		</tr>
		<tr>
			<td>出版日期 : <s:property value = "PublishDate"/></td>
		</tr>
		<tr>
			<td>价格 : <s:property value = "Price"/></td>
		</tr>			
	</table>
	</div>
	</body>
</html>