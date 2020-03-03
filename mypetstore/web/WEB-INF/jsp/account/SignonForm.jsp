<%@ include file="../common/IncludeTop.jsp"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<link rel="StyleSheet" href="../../../css/jpetstore.css" type="text/css" media="screen" />

	<meta name="generator"
		  content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
	<title>JPetStore Demo</title>
	<meta content="text/html; charset=windows-1252"
		  http-equiv="Content-Type" />
	<meta http-equiv="Cache-Control" content="max-age=0" />
	<meta http-equiv="Cache-Control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
	<meta http-equiv="Pragma" content="no-cache" />

	<base href="<%=basePath%>">
	<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
	<script type="text/javascript">
		//reloadCode方法：实现"点击看不清刷新"的功能
		function reloadCode(){
			//time变量的功能是强制刷新，忽略浏览器的缓存机制
			var time = new Date().getTime();
			document.getElementById("btn").disabled=true;
			document.getElementById("imagecode").src="code?d="+time;//传进的time变量，因为time在变化，所以url也在变化，因此可以说是强制刷新
		}
	</script>


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		function checkName() {
				var name = $("#username").val();
				$.ajax({
					type: 'post',
					url: 'checkName',
					data: {
						val: name
					},
					dataType: 'text',
					success: function (data) {
						if (data == "1") {
							//存在
							$('#ret-msg').html("用户已存在");
						} else {
							//不存在
							$('#ret-msg').html("用户不存在");
						}
// 				window.console.log('成功回调函数');
					},
					error: function () {
						window.console.log('失败回调函数');
					}

				});

		}

	</script>

</head>

<body>




<div id="Content">

	<script>
		function reloadImage() {
			//document.getElementById("btn").disabled=true;
			document.getElementById("imgservlet").src = 'validation';
		}
	</script>


	<div id="Catalog">
		<form action="signonForm" method="post">
			<p>Please enter your username and password.</p>
			</p>
			<p>
				Username:<input type="text" name="username" id = "username" onblur="checkName();" /><span id="ret-msg"></span><br />
				Password:<input type="password" name="password" vertical-align:bottom/><br />
				<!--  Validation Code:<input type="text" name="validationCode"/>
        <img src="validation" id="imgservlet" onclick="reloadImage()"/>
        -->
				<!--  <input type="button" value="changeImage" onclick="reloadImage()" id="btn">-->


			<!--表单的方式跳转到loginservlet-->

				Code          :<input type="text" name="checkcode" vertical-align:bottom/><br /><br />
				<img alt="Code" id="imagecode" src="code"><!--src的方式实现链接到servletImage-->
				<a href="javascript: reloadCode();"id="btn">change</a><br />


			</p>
			<input type="submit" name="signon" value="Login" />
		</form>

		Need a user name and password?
		<a href="register">Register Now!</a>

	</div>

</div>






</body>
</html>

<%@ include file="../common/IncludeBottom.jsp"%>

