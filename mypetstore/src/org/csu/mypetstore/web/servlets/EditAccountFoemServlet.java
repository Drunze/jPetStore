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

@WebServlet(name = "EditAccountFoemServlet")
public class EditAccountFoemServlet extends HttpServlet {
    private static final String EDIT_ACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";

//    private String password;
//    private String Firstname;
//    private String Lastname;
//    private String Emali;
//    private String Phone;
//    private String Address1;
//    private String Address2;
//    private String City;
//    private String State;
//    private String Zip;
//    private String Country;
//    private String LanguagePerference;
//    private String FavouriteCategory;
    Account account;
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private List<Product> myList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        CatalogService catalogService = new CatalogService();

        HttpSession session = request.getSession();
        account = (Account) session.getAttribute("account");
                if(account!=null){
                    accountService.updateAccount(account);
                }


            account.setPassword(request.getParameter("password"));
            account.setFirstName(request.getParameter("account.firstName"));
            account.setLastName(request.getParameter("account.lastName"));
            account.setEmail(request.getParameter("account.email"));
            account.setPhone(request.getParameter("account.phone"));
            account.setAddress1(request.getParameter("account.address1"));
            account.setAddress2(request.getParameter("account.address2"));
            account.setCity(request.getParameter("account.city"));
            account.setState(request.getParameter("account.state"));
            account.setZip(request.getParameter("account.zip"));
            account.setCountry(request.getParameter("account.country"));
            account.setLanguagePreference(request.getParameter("account.languagePerference"));
            account.setFavouriteCategoryId(request.getParameter("account.favouriteCatagoryId"));
            account.setListOption(request.getParameter("account.listOption"));
            account.setBannerOption(request.getParameter("account.bannerOption"));
            accountService.updateAccount(account);
            //myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
            session.setAttribute("account",account);
            // session.setAttribute("myList",myList);
            request.getRequestDispatcher(MAIN).forward(request,response);


        }


    }

