<%@ include file="../common/IncludeTop.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<link rel="StyleSheet" href="../css/jpetstore.css" type="text/css"
		  media="screen" />

	<meta name="generator"
		  content="HTML Tidy for Linux/x86 (vers 1st November 2002), see www.w3.org" />
	<title>MyPetStore</title>
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

	<div id="Catalog">


		<form action="editAccountFoem" method="post">

			<h3>User Information</h3>

			<table>
				<tbody>
				<tr>
					<td>User ID:</td>
					<td>${sessionScope.account.username}</td>
				</tr>
				<tr>
					<td>New password:</td>
					<td>
						<input id="stripes--517137302" name="password"
							   type="text">
						<script type="text/javascript">
						setTimeout(
								function() {
									try {
										var z = document
												.getElementById('stripes--517137302');
										z.focus();
										z.select();
									} catch (e) {
									}
								}, 1);
					</script>
					</td>
				</tr>
				<tr>
					<td>Repeat password:</td>
					<td><input name="repeatedPassword" type="text" ></td>
				</tr>
				</tbody>
			</table>
			<h3>Account Information</h3>

			<table>
				<tbody>
				<tr>
					<td>First name:</td>
					<td><input name="account.firstName" value="${sessionScope.account.firstName}" type="text"></td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td><input name="account.lastName" value="${sessionScope.account.lastName}"  type="text"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input name="account.email"
							   value="${sessionScope.account.email}" type="text" size="40"></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input name="account.phone" value="${sessionScope.account.phone}"
							   type="text"></td>
				</tr>
				<tr>
					<td>Address 1:</td>
					<td><input name="account.address1"
							   value="${sessionScope.account.address1}" type="text" size="40"></td>
				</tr>
				<tr>
					<td>Address 2:</td>
					<td><input name="account.address2" value="${sessionScope.account.address2}"
							   type="text" size="40"></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input name="account.city" value="${sessionScope.account.city}" type="text"></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><input name="account.state" value="${sessionScope.account.state}" type="text"
							   size="4"></td>
				</tr>
				<tr>
					<td>Zip:</td>
					<td><input name="account.zip" value="${sessionScope.account.zip}" type="text"
							   size="10"></td>
				</tr>
				<tr>
					<td>Country:</td>
					<td><input name="account.country" value="${sessionScope.account.country}" type="text"
							   size="15"></td>
				</tr>
				</tbody>
			</table>

			<h3>Profile Information</h3>

			<table>
				<tbody>
				<tr>
					<td>Language Preference:</td>
					<td><select name="account.languagePreference">
						<option selected="selected" value="${sessionScope.account.languagePreference}">english</option>
						<option value="japanese">japanese</option>
					</select></td>
				</tr>
				<tr>
					<td>Favourite Category:</td>
					<td><select name="account.favouriteCategoryId">
						<option value="FISH">FISH</option>
						<option selected="selected" value="${sessionScope.account.favouriteCategoryId}">DOGS</option>
						<option value="REPTILES">REPTILES</option>
						<option value="CATS">CATS</option>
						<option value="BIRDS">BIRDS</option>
					</select></td>
				</tr>
				<tr>
					<td>Enable MyList</td>
					<td><input name="account.listOption" value="1"
							   type="checkbox" checked="checked"></td>
				</tr>
				<tr>
					<td>Enable MyBanner</td>
					<td><input name="account.bannerOption" value="1"
							   type="checkbox" checked="checked"></td>
				</tr>

				</tbody>
			</table>


			<input name="editAccount" value="Save Account Information"
				   type="submit">

		</form>
		<a href="myOrder">My Orders</a>

	</div>

</div>



</body>
</html>

<%@ include file="../common/IncludeBottom.jsp"%>
