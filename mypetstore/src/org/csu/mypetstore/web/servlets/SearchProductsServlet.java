package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchProductsServlet")
public class SearchProductsServlet extends HttpServlet {
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";


    private String keyword;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        keyword = request.getParameter("keyword");
        CatalogService catalogService = new CatalogService();
        Product product = catalogService.getProduct(keyword);


        HttpSession session = request.getSession();

        if (keyword == null || keyword.length() < 1) {
           session.setAttribute("message","Please enter a keyword to search for, then press the search button.");
            request.getRequestDispatcher(ERROR).forward(request,response);
        }
        else{
            List<Product> productList = catalogService.searchProductList(keyword);
            session.setAttribute("productList",productList);
            request.getRequestDispatcher(SEARCH_PRODUCTS).forward(request,response);
        }


    }
}
