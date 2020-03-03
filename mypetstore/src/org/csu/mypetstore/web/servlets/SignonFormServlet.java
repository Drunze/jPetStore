package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.impl.AccountDAOImpl;
import org.csu.mypetstore.persistence.impl.CategoryDAOImpl;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SignonFormServlet")
public class SignonFormServlet extends HttpServlet {
    private static final String SIGNON = "/WEB-INF/jsp/account/SignonForm.jsp";
    private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private static final String NEW_ACCOUNT = "/WEB-INF/jsp/account/NewAccountForm.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";

    private String username;
    private String password;
    private Account account;
    private String piccode;
    private String checkcode;
    private boolean authenticated;
    private List<Product> myList;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset =UTF-8");
        PrintWriter out = response.getWriter();
        AccountService accountService = new AccountService();
        CatalogService catalogService = new CatalogService();
        HttpSession session = request.getSession();

        username = request.getParameter("username");
        password = request.getParameter("password");
        piccode = (String)session.getAttribute("piccode");
        checkcode = request.getParameter("checkcode");

        account = accountService.getAccount(username,password);

        if (account == null) {

            session.setAttribute("message","Invalid username or password.  Signon failed.");
            account = new Account();
            myList = null;
            authenticated = false;
            request.getRequestDispatcher(ERROR).forward(request,response);
        } else if(!checkcode.equals(piccode))
        {
            session.setAttribute("message","Invalid code.  Signon failed.");
            request.getRequestDispatcher(ERROR).forward(request,response);
        }
        else {
            account.setPassword(null);
            //myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
            authenticated = true;
            ;
            // this bean is already registered as /actions/Account.action
            session.setAttribute("account", account);
            //session.setAttribute("myList",myList);
            request.getRequestDispatcher(MAIN).forward(request,response);

        }







    }
}
