<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    保存商品<br>
    <form action="/goods/savegoods.servlet" method="post">
    	商品名称：<input type="text" value="" name="goodsName"><br>
    	商品价格：<input type="text" value="" name="goodsPrice"><br>
    	商品数量：<input type="text" value="" name="goodsNum"><br>
   		商品状态：<input type="radio" value="1" name="goodsStatus" checked="checked">上架
   						<input type="radio" value="0" name="goodsStatus">下架<br>
   		商品图片：<input type="file" value="" name="goodsImg"><br>
   		验证码：<input type="text" value="" name="code"  size="4" maxlength="4">
   		<img src="/goods/checkcode.servlet"><br>
   		<input type="submit" value="保存商品">
    </form>
  </body>
</html>
