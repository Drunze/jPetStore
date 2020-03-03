package org.csu.mypetstore.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONArray;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.ProductDAO;
import org.csu.mypetstore.persistence.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

public class AotoSearchServlet extends HttpServlet {
    private static final String searchProductListString = " SELECT PRODUCTID,  NAME, DESCN AS description,CATEGORY as categoryId FROM PRODUCT WHERE lower(name) like ?";
    private String keyword;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doGet(request,response);
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//          keyword = request.getParameter("val");
//        JSONArray jsonArray = new JSONArray();
//        CatalogService catalogService = new CatalogService();
//         List<Product> productList = catalogService.searchAutoProductList(keyword);
//        String[] names =new String[productList.size()];
//        for (int i=0;i<productList.size();i++) {
//            names[i]=productList.get(i).getName();
//        }
//
//        String json4=  JSONArray.fromObject(names).toString();
//        System.out.println(json4);
//        response.getWriter().print(json4);
    }
    }
