package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewAccountFormServlet")
public class NewAccountFormServlet extends HttpServlet {
    private static final String NEW_ACCOUNT = "/WEB-INF/jsp/account/NewAccountForm.jsp";
    private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    Account account = new Account();
    private List<Product> myList;
    private boolean authenticated;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        CatalogService catalogService = new CatalogService();

        HttpSession session = request.getSession();
        account.setUsername(request.getParameter("username"));
        account.setPassword(request.getParameter("password"));
        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));
        account.setEmail(request.getParameter("email"));
        account.setPhone(request.getParameter("phone"));
        account.setAddress1(request.getParameter("address1"));
        account.setAddress2(request.getParameter("address2"));
        account.setCity(request.getParameter("city"));
        account.setState(request.getParameter("state"));
        account.setZip(request.getParameter("zip"));
        account.setCountry(request.getParameter("country"));
        account.setLanguagePreference(request.getParameter("languagePreference"));
        account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
        account.setListOption(request.getParameter("listOption"));
        account.setBannerOption(request.getParameter("bannerOption"));

        accountService.insertAccount(account);


        authenticated = true;
        session.setAttribute("account",account);

        request.getRequestDispatcher(MAIN).forward(request,response);
    }
}
