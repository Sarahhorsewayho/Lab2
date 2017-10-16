<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新'信息</title>
<style type="text/css">
.blist{padding:20px;}
h3{color:#FFFFFF;}
s{color:#FFFFFF;}
body {background-color:#008080;}
</style> 
</head>
<body>
	<div class="blist">
	<h3>请输入新的信息：</h3>
		<s:form action="updatebook">
			 <s:textfield name="name" label="请输入作者姓名"></s:textfield>
			 <s:textfield name="publisher" label="请输入出版社"></s:textfield>
			 <s:textfield name="publishdate" label="请输入出版日期"></s:textfield>
			 <s:textfield name="price" label="请输入价格"></s:textfield>
			<s:submit value="提交"/>
    </s:form>
    </div>
</body>
</html>