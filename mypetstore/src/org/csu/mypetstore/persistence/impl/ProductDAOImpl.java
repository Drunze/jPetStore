package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.ProductDAO;
import org.csu.mypetstore.persistence.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class ProductDAOImpl implements ProductDAO {
    private static final String getProductListByCategoryString = "SELECT PRODUCTID, NAME,DESCN as description,CATEGORY as categoryId FROM PRODUCT WHERE CATEGORY = ?";
    private static final String getProductString = " SELECT PRODUCTID,  NAME, DESCN AS description,CATEGORY as categoryId FROM PRODUCT WHERE PRODUCTID = ?";
    private static final String searchProductListString = " SELECT PRODUCTID,  NAME, DESCN AS description,CATEGORY as categoryId FROM PRODUCT WHERE lower(name) like ?";

    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> Products = new ArrayList<Product>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(getProductListByCategoryString);
            pStatement.setString(1, categoryId);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Product Product = new Product();
                Product.setProductId(resultSet.getString(1));
                Product.setName(resultSet.getString(2));
                Product.setDescription(resultSet.getString(3));
                Product.setCategoryId(resultSet.getString(4));

                Products.add(Product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Products;

    }

    @Override
    public Product getProduct(String ProductId) {
        Product Product = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(getProductString);
            pStatement.setString(1, ProductId);
            ResultSet resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                Product = new Product();
                Product.setProductId(resultSet.getString(1));
                Product.setName(resultSet.getString(2));
                Product.setDescription(resultSet.getString(3));
                Product.setCategoryId(resultSet.getString(4));


            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        List<Product> ProductList = new ArrayList<Product>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(searchProductListString);
            pStatement.setString(1, keywords);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));

                ProductList.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ProductList;

    }


    public List<Product> searchAutoProductList(String keywords) {
        List<Product> ProductList = new ArrayList<Product>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(" SELECT PRODUCTID , NAME, FROM PRODUCT WHERE lower(name) like ?");
            pStatement.setString(1, keywords);
            ResultSet resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getString(1));
                product.setName(resultSet.getString(2));
                product.setDescription(resultSet.getString(3));
                product.setCategoryId(resultSet.getString(4));

                ProductList.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ProductList;

    }
}
