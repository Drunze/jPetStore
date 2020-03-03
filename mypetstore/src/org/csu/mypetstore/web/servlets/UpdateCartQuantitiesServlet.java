package org.csu.mypetstore.web.servlets;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "UpdateCartQuantitiesServlet")
public class UpdateCartQuantitiesServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private String itemId;
    Cart cart;
    private String quantity;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        cart = (Cart) session.getAttribute("cart");
//        HttpServletRequest request = context.getRequest();
//        quantity = request.getParameter("${cartItem.item.itemId}");
        int id =Integer.parseInt( request.getParameter("val"));
        Iterator<CartItem> cartItems = cart.getAllCartItems();
        int Quantity = 0;
        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
               // int quantity = Integer.parseInt(request.getParameter(itemId));
                cart.setQuantityByItemId(itemId, id);
                Quantity = cartItem.getQuantity();
                if (id < 1) {
                    cartItems.remove();
                }
            } catch (Exception e) {
                //ignore parse exceptions on purpose
            }
        }


        response.getWriter().write(id);
        //request.getRequestDispatcher(VIEW_CART).forward(request,response);
    }
}
