<%@ include file="../common/IncludeTop.jsp" %>

<div id="BackLink">
	<a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">
	<form action="confirmOrder">

	<table>
		<tbody><tr>
			<th colspan="2">Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td><select name="order.cardType">
				<option selected="selected" value="${sessionScope.order.cardType}">Visa</option>
				<option value="MasterCard">MasterCard</option>
				<option value="American Express">American Express</option>
			</select></td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><input name="order.creditCard" value="${sessionScope.order.creditCard}" type="text"> * Use a fake
			number!</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><input name="order.expiryDate" value="${sessionScope.order.expiryDate}" type="text"></td>
		</tr>
		<tr>
			<th colspan="2">Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input name="order.billToFirstName" value="${sessionScope.order.billToFirstName}" type="text"></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input name="order.billToLastName" value="${sessionScope.order.billToLastName}" type="text"></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input name="order.billAddress1" value="${sessionScope.order.billAddress1}" type="text" size="40"></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input name="order.billAddress2" value="${sessionScope.order.billAddress2}" type="text" size="40"></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input name="order.billCity" value="${sessionScope.order.billCity}" type="text"></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input name="order.billState" value="${sessionScope.order.billState}" type="text" size="4"></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input name="order.billZip" value="${sessionScope.order.billZip}" type="text" size="10"></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input name="order.billCountry" value="${sessionScope.order.billCountry}" type="text" size="15"></td>
		</tr>

		<tr>
			<td colspan="2"><input name="shippingAddressRequired" value="true" type="checkbox">
			Ship to different address...</td>
		</tr>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><input type="text"  name="order.shipToFirstName" value="${sessionScope.order.shipToFirstName}" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><input type="text" name="order.shipToLastName" value="${sessionScope.order.shipToLastName}"/></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><input type="text" size="40" name="order.shipAddress1" value="${sessionScope.order.shipAddress1}"/></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><input type="text" size="40" name="order.shipAddress2"value="${sessionScope.order.shipAddress2}" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><input type="text" name="order.shipCity"value="${sessionScope.order.shipCity}" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><input type="text" size="4" name="order.shipState"value="${sessionScope.order.shipState}" /></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><input type="text" size="10" name="order.shipZip"value="${sessionScope.order.shipZip}" /></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" size="15" name="order.shipCountry" value="${sessionScope.order.shipCountry}"/></td>
		</tr>


		</tbody>
	</table>
<%--		<table>--%>
<%--			--%>

<%--		</table>--%>


		<input name="newOrder" value="Continue" type="submit">
	</form>
</div>

<%@ include file="../common/IncludeBottom.jsp" %>