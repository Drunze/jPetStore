<%@ include file="../common/IncludeTop.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<link rel="StyleSheet" href="../css/jpetstore.css" type="text/css"
		  media="screen" />

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
</head>

<body>

<div id="Content">

	<script type="text/javascript">
		var xmlHttpRequest;
		function createXMLHttpRequest()
		{
			if (window.XMLHttpRequest) //非IE浏览器
			{
				xmlHttpRequest = new XMLHttpRequest();
			}
			else if (window.ActiveObject)//IE6以上浏览器
			{
				xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
			}
			else //IE6及以下浏览器
			{
				xmlHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
			}
		}

		function usernameIsExist()
		{
			var username = document.userInfo.username.value;
			sendRequest("usernameValidation?username="+username);
		}

		function sendRequest(url){
			createXMLHttpRequest();
			xmlHttpRequest.open("GET", url, true);
			xmlHttpRequest.onreadystatechange = processResponse;
			xmlHttpRequest.send(null);
		}

		function processResponse(){
			if(xmlHttpRequest.readyState == 4){
				if(xmlHttpRequest.status == 200){
					var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("info")[0].firstChild.data;
					var div1 = document.getElementById("usernameInfo");
					if(responseInfo == "Exist"){
						div1.innerHTML="<font color='red'>The User ID is Exist</font>";
					}
					else{
						div1.innerHTML="<font color='green'>The User ID is Available</font>";
					}
				}
			}
		}

	</script>

	<div id="Catalog">

		<form action="newAccountForm" method="post" name="userInfo" id="userInfo">

			<h3>User Information</h3>

			<table>
				<tr>
					<td>User ID:</td>
					<td>
						<input type="text" name="username" id="username" onblur="usernameIsExist();"/>
						<div id="usernameInfo"></div>
					</td>
				</tr>
				<tr>
					<td>New password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Repeat password:</td>
					<td><input type="password" name="repeatedPassword"/></td>
				</tr>
			</table>

			<h3>Account Information</h3>

				<table>
					<tr>
						<td>First name:</td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td>Last name:</td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Phone:</td>
						<td><input type="text" name="phone" /></td>
					</tr>
					<tr>
						<td>Address 1:</td>
						<td><input type="text" name="address1" /></td>
					</tr>
					<tr>
						<td>Address 2:</td>
						<td><input type="text" name="address2" size="40" /></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><input type="text" name="city" /></td>
					</tr>
					<tr>
						<td>State:</td>
						<td><input type="text" name="state" size="4" /></td>
					</tr>
					<tr>
						<td>Zip:</td>
						<td><input type="text" name="zip" size="10" /></td>
					</tr>
					<tr>
						<td>Country:</td>
						<td><input type="text" name="country" size="15" /></td>
					</tr>
				</table>

				<h3>Profile Information</h3>

				<table>
					<tr>
						<td>Language Preference:</td>
						<td><select name="languagePreference">

							<option selected="selected" value="${sessionScope.account.languagePreference}">english</option>
							<option value="japanese">japanese</option>
						</select></td>
							<!-- 循环 -->


						</select></td>
					</tr>
					<tr>
						<td>Favourite Category:</td>
						<td><select name="favouriteCategoryId">
							<option value="FISH">FISH</option>
							<option selected="selected" value="${sessionScope.account.favouriteCategoryId}">DOGS</option>
							<option value="REPTILES">REPTILES</option>
							<option value="CATS">CATS</option>
							<option value="BIRDS">BIRDS</option>
						</select></td>
					</tr>
					<tr>
						<td>Enable MyList</td>
						<td><input type="checkbox" name="listOption" value="1" /></td>
					</tr>
					<tr>
						<td>Enable MyBanner</td>
						<td><input type="checkbox" name="bannerOption" value="1" /></td>
					</tr>

				</table>

			<include file="IncludeAccountFields.jsp"/>


				<input type="submit" name="newAccount" value="Save Account Information"/>

		</form>
	</div>

</div>



</body>
</html>

<%@ include file="../common/IncludeBottom.jsp"%>