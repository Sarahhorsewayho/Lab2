<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>何彦男'书库</title>
 <style type="text/css">
h1{color:#FFFFFF;backgroud-color:#008080;}
h4{letter-spacing:7px; color:#FFFFFF;backgroud-color:#008080;}
h6{text-indent:30px;color:#5F9EA0;}
lable{color:#FFFFFF;}
.tou{
	backgroud-color:#008080; 
	margin-left:auto;
	margin-right:auto;
	width:100%;
 	padding:10px; 
	text-indent:20px;
	border-style:solid;
	border-color:#5F9EA0;
	}
.inp{padding:5px;   width:30%;padding-left:20px}
.new{padding:20px;}
body {background-color:#008080;}
</style> 
</head>
<body >
	<div class="tou">
		<h1>何彦男的书库</h1>
		<h4>开/卷/有/益</h4>
	</div>
	<h6>推荐查询：赫尔曼·黑塞、卡勒德·胡赛尼、金庸、村上春树......</h6>
	<div class="inp">
		<form action="checkauthor" >
	        <lable>请输入作者：</lable>
	        <input type="text" name="authorname">
	        <input type="submit" value="查询">
	    </form>
    </div>
    <div class="new">
    <form action="addbook"> 
		<input type="submit" value="点击这里新增一本图书">  
	</form>
	</div>
</body>
</html>
