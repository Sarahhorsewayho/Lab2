<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增'图书</title>
<style type="text/css">
.blist{padding:20px;}
h3{color:#FFFFFF;}
lable{color:#FFFFFF;}
body {background-color:#008080;}
</style> 
</head>
<body>
		<div class="blist">
		<h3>请输入图书信息：</h3>
		<s:form action="addbooksubmit">
 			 <s:textfield name="isbn" label="请输入图书ISBN码"></s:textfield> 
			 <s:textfield name="title" label="请输入书名"></s:textfield> 
			 <s:textfield name="name" label="请输入作者姓名"></s:textfield> 
 			 <s:textfield name="publisher" label="请输入出版社"></s:textfield> 
			 <s:textfield name="publishdate" label="请输入出版日期" placeholder="输入格式务必为xxxx-月-日"></s:textfield> 
 			 <s:textfield name="price" label="请输入价格"></s:textfield> 
		<s:submit value="提交"/>
    </s:form>
    </div>

</body>
</html>