package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewOrderFormServlet")
public class NewOrderFormServlet extends HttpServlet {
    private Order order = new Order();
    private boolean shippingAddressRequired;
    private boolean confirmed;
    private List<Order> orderList;
    private static final String NEW_ORDERFORM = "/WEB-INF/jsp/order/NewOrderForm.jsp";
    private static final String EDIT_ACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private  Account account;
    private  Cart cart;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
       account = (Account) session.getAttribute("account");
        cart = (Cart) session.getAttribute("cart");
        order = new Order();
        shippingAddressRequired = false;
        confirmed = false;
        orderList = null;
        if (account == null  ) {
            session.setAttribute("message","You must sign on before attempting to check out.  Please sign on and try checking out again.");
            request.getRequestDispatcher(EDIT_ACCOUNT).forward(request,response);
        } else if (cart != null) {
            order.initOrder(account, cart);
        request.getRequestDispatcher(NEW_ORDERFORM).forward(request,response);

    } else {
            session.setAttribute("message","An order could not be created because a cart could not be found.");
            request.getRequestDispatcher(ERROR).forward(request,response);
        }

    }
}
