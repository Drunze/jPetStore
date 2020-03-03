<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019/10/19
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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
    <script type="text/javascript">
        //reloadCode方法：实现"点击看不清刷新"的功能
        function reloadCode(){
            //time变量的功能是强制刷新，忽略浏览器的缓存机制
            var time = new Date().getTime();
            document.getElementById("imagecode").src="<%=request.getContextPath() %>CodeServlet?d="+time;//传进的time变量，因为time在变化，所以url也在变化，因此可以说是强制刷新
        }
    </script>

</head>

<body>
<!--表单的方式跳转到loginservlet-->
<form action="<%=request.getContextPath() %>LoginServlet" method = "get">
    验证码：<input type="text" name="checkcode"/>
    <img alt="验证码" id="imagecode" src="<%=request.getContextPath() %>Codeservlet"><!--src的方式实现链接到servletImage-->
    <a href="javascript: reloadCode();">看不清楚，换一张！</a>
    <input type="submit" value="提交" />
</form>
</body>
</html>

