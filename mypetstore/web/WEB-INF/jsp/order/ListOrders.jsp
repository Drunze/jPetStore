<%@ include file="../common/IncludeTop.jsp"%>

<h2>My Orders</h2>

<table>
	<tr>
		<th>Order ID</th>
		<th>Quantity</th>
		<th>Total Price</th>

	</tr>


		<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}" varStatus="status">

		<tr>

			<td>
				<a href="viewOrder?orderId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
			 </td>
			<td>${cartItem.quantity}</td>

			<td><fmt:formatNumber value="${cartItem.total}"
				pattern="$#,##0.00" /></td>
		</tr>
		</c:forEach>
<%--<c:forEach var="order" items="${sessionScope.orderList}">--%>
<%--			<fmt:formatDate value="${order.orderDate}"--%>
<%--			pattern="yyyy/MM/dd hh:mm:ss" />--%>
<%--</c:forEach>--%>
</table>

<%@ include file="../common/IncludeBottom.jsp"%>


