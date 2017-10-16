<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>该作者'书目列表</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
function details(e)
{
	var BookTitle = document.getElementById("BookTitle");
	window.location.href = "getDetail?BookTitle="+e.innerHTML;
}
</script>
 <style type="text/css">
table{
border:1px solid lightgray;
border-spacing:5px;
}
th,td{
padding:3px;
border:thin dashed lightblue;
color:#FFFFFF;
}
h3{color:#FFFFFF;	border-style:solid;
	border-color:#5F9EA0; border-right-width:0px;border-left-width:0px;padding:10px;width:12%;}
.blist{padding:20px;}
a{color:#800000;}
body {background-color:#008080;}
</style> 
</head>
	<body>
		<div class="blist">
		<h3>该作者所著书籍</h3>
		<table>
			<s:iterator value="BookList" var="tt" status = "status">
			<tr>
			<td>
				<p id="BookTitle"><p clickable="clickable" onclick="details(this);"><s:property value="tt"/></p></p>  
			</td>
			<td>
				<a href="deletebook?id=<s:property value="tt"/>">删除</a>
			</td>
			<td>
				<a href="upup?id=<s:property value="tt"/>">更新</a>
			</td>
			</tr>
			</s:iterator>
		</table>
		</div>
	</body>
</html>