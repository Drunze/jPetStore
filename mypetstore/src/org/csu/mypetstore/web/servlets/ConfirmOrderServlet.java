package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Order;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {

    private static final String CONFIRM_ORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    String billToFirstName;
    String billToLastName;
    String billAddress1;
    String billAddress2;
    String billCity;
    String billState;
    String billZip;
    String billCountry;
    String cardType;
    String creditCard;
    String expiryDate;

    String shipToFirstName;
    String shipToLastName;
    String shipAddress1;
    String shipAddress2;
    String shipCity;
    String shipState;
    String shipZip;
    String shipCountry;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();
        Order order=new Order();


        cardType = request.getParameter("order.cardType");
        order.setCardType(cardType);

        creditCard = request.getParameter("order.creditCard");
        order.setCreditCard(creditCard);

        expiryDate = request.getParameter("order.expiryDate");
        order.setExpiryDate(expiryDate);

        billToFirstName=request.getParameter("order.billToFirstName");
        order.setBillToFirstName(billToFirstName);

        billToLastName = request.getParameter("order.billToLastName");
        order.setBillToLastName(billToLastName);

        billAddress1 = request.getParameter("order.billAddress1");
        order.setBillAddress1(billAddress1);

        billAddress2 = request.getParameter("order.billAddress2");
        order.setBillAddress2(billAddress2);

        billCity = request.getParameter("order.billCity");
        order.setBillCity(billCity);

        billState = request.getParameter("order.billState");
        order.setBillState(billState);

        billZip = request.getParameter("order.billZip");
        order.setBillZip(billZip);

        billCountry = request.getParameter("order.billCountry");
        order.setBillCountry(billCountry);

         shipToFirstName= request.getParameter("order.shipToFirstName");
        order.setShipToFirstName(shipToFirstName);
        shipToLastName= request.getParameter("order.shipToLastName");
        order.setShipToLastName(shipToLastName);

         shipAddress1= request.getParameter("order.shipAddress1");
        order.setShipAddress1(shipAddress1);
        shipAddress2= request.getParameter("order.shipAddress2");
        order.setShipAddress2(shipAddress2);
       shipCity= request.getParameter("order.shipCity");
        order.setShipCity(shipCity);
         shipState= request.getParameter("order.shipState");
        order.setShipState(shipState);
         shipZip= request.getParameter("order.shipZip");
        order.setShipZip(shipZip);
         shipCountry= request.getParameter("order.shipCountry");
        order.setShipCountry(shipCountry);



        session.setAttribute("order",order);

        request.getRequestDispatcher(CONFIRM_ORDER).forward(request,response);
    }
}
