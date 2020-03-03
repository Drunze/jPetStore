package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MyAccountServlet extends HttpServlet {
    private static final String EDIT_ACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private Account account;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        account = (Account) session.getAttribute("account");
        if(account != null){
          session.setAttribute("account",account);
        request.getRequestDispatcher(EDIT_ACCOUNT).forward(request,response);}
        else{
           session.setAttribute("message","Please Sign on your ID");
            request.getRequestDispatcher(ERROR).forward(request,response);

        }
    }
}
