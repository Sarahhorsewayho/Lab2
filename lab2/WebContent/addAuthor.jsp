<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加'作者</title>
<style type="text/css">
.blist{padding:20px;}
h3{color:#FFFFFF;}
s{color:#FFFFFF;}
body {background-color:#008080;}
</style> 
</head>
	<body>
		<div class="blist">
		<h3>该作者不存在，请添加：</h3>
		<s:form action="addauthor">
			 <s:textfield name="authorID" label="请输入作者ID编码"></s:textfield>
			 <s:textfield name="name" label="请输入作者姓名"></s:textfield>
			 <s:textfield name="age" label="请输入作者年龄"></s:textfield>
			 <s:textfield name="country" label="请输入作者国籍"></s:textfield>
			<s:submit value="提交"/>
    </s:form>
    </div>
	</body>
</html>