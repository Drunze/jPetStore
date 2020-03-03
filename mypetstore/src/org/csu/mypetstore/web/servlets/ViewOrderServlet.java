package org.csu.mypetstore.web.servlets;


import org.csu.mypetstore.service.OrderService;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
    private Order order = new Order();
    Order Order;
    Account account;
    private static final String VIEW_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    String lineItems;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

         account = (Account) session.getAttribute("account");

         order = (Order) session.getAttribute("order") ;

         OrderService orderService = new OrderService();
        request.getRequestDispatcher(VIEW_ORDER).forward(request, response);
//
        // order = orderService.getOrder(order.getOrderId());
//
//        if (account.getUsername().equals(order.getUsername())) {
//
//        } else {
//            order = null;
//            session.setAttribute("message","You may only view your own orders.");
//            request.getRequestDispatcher(ERROR).forward(request, response);
//        }


    }
}
