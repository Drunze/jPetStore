<%--<jsp:useBean id="cartItem" scope="request" type="org.csu.mypetstore.domain.CartItem"/>--%>
<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink">
    <a href="main">Return to Main Menu</a>
</div>

<div id="Catalog">

<div id="Cart">

<h2>Shopping Cart</h2>

<form action="#" method="post">
	<table>
		<tr>
			<th><b>Item ID</b></th>
			<th><b>Product ID</b></th>
			<th><b>Description</b></th>
			<th><b>In Stock?</b></th>
			<th><b>Quantity</b></th>
			<th><b>List Price</b></th>
			<th><b>Total Cost</b></th>
			<th>&nbsp;</th>
		</tr>

		<c:if test="${sessionScope.cart.numberOfItems == 0}">
			<tr>
				<td colspan="8"><b>Your cart is empty.</b></td>
			</tr>
		</c:if>

		<c:forEach var="cartItem" items="${sessionScope.cart.cartItems}" varStatus="status">
			<tr>
				<td>
				<a href="viewItem?itemId=${cartItem.item.itemId}">${cartItem.item.itemId}</a>
				</td>
				<td>${cartItem.item.product.productId}</td>
				<td>${cartItem.item.attribute1} ${cartItem.item.attribute2}
				${cartItem.item.attribute3} ${cartItem.item.attribute4}
				${cartItem.item.attribute5} ${cartItem.item.product.name}</td>
				<td>${cartItem.inStock}</td>
				<td>
					<form action="updateCartQuantities" method="post">



					<input id="min${status.index}" name="" type="button" value="-" />
					<span id="ret-msg"><input type="text" id = "idBox${status.index}" name="${cartItem.item.itemId}" value="${cartItem.quantity}" onblur="upDate()"/></span>
					<input id="add${status.index}" name="" type="button" value="+" />

				</td>

				<td>
					<fmt:formatNumber value="${cartItem.item.listPrice}"
					pattern="$#,##0.00" />

					<input type="hidden" id = "price${status.index}" value="${cartItem.item.listPrice}">
				</td>
				<td>
					<label id="total${status.index}"><fmt:formatNumber value="${cartItem.total}"
					pattern="$#,##0.00" /></label>
				</td>
				<td>
				<a href="removeItemFormCart?workingItemId=${cartItem.item.itemId}"class = "Button" >Remove</a>
				</td>
			</tr>




		</c:forEach>

		<script>
			 var i= 0;
			<%--for(var i=${status.index};i<10;i++) {--%>

			$(function(){

				var t = $("#idBox"+[i] );
				$("#add"+[i]).click(function () {
					t.val(parseInt(t.val()) + 1)
					setTotal();
				})
				$("#min"+[i]).click(function () {
					t.val(parseInt(t.val()) - 1)
					if (t.val() >= 1) {
						setTotal();
					} else {
						alert("You should buy at least one commodity.")
					}

				})

				function setTotal() {
					$("#total"+[i]).html("$" + (parseInt(t.val()) * $("#price"+[i]).val()).toFixed(2));
				}

				setTotal();


			})

		</script>

		<script>

		<%--for(var i=${status.index};i<10;i++) {--%>

		$(function(){

			var t = $("#idBox1");
			$("#add1").click(function () {
				t.val(parseInt(t.val()) + 1)
				setTotal();
			})
			$("#min1").click(function () {
				t.val(parseInt(t.val()) - 1)
				if (t.val() >= 1) {
					setTotal();
				} else {
					alert("You should buy at least one commodity.")
				}

			})

			function setTotal() {
				$("#total1").html("$" + (parseInt(t.val()) * $("#price1").val()).toFixed(2));
			}

			setTotal();


		})

	</script>

		<script>

			<%--for(var i=${status.index};i<10;i++) {--%>

			$(function(){

				var t = $("#idBox2");
				$("#add2").click(function () {
					t.val(parseInt(t.val()) + 1)
					setTotal();
				})
				$("#min2").click(function () {
					t.val(parseInt(t.val()) - 1)
					if (t.val() >= 1) {
						setTotal();
					} else {
						alert("You should buy at least one commodity.")
					}

				})

				function setTotal() {
					$("#total2").html("$" + (parseInt(t.val()) * $("#price2").val()).toFixed(2));
				}

				setTotal();

			})

		</script>
   <script>
		function upDate() {
		var name = $("#idbox0" ).val();
			$.ajax({
		type: 'post',
		url: 'updateCartQuantities',
		data: {
		val: name

		},
		dataType: 'text',
		success: function (data) {

		$('#ret-msg').html(data);
		// 				window.console.log('成功回调函数');
		},
		error: function () {
		window.console.log('失败回调函数');
		}

		});

		}

   </script>


		<tr>
			<td colspan="7">
				<input type = "submit" value="Update Cart" style="text-align: center;"/>
</form>

			</td>
			<td>&nbsp;</td>
		</tr>
	</table>


	</form>>


	<c:if test="${sessionScope.cart.numberOfItems > 0}">

		<a href="newOrderForm"class = "Button">Proceed to Checkout</a>
</c:if>



</div>


<div id="Separator">&nbsp;</div>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>