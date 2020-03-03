package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.persistence.CategoryDAO;
import org.csu.mypetstore.persistence.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CategoryDAOImpl implements CategoryDAO
{
    private static final String GET_CATEGORY_LIST = "SELECT CATID AS categoryId, NAME, DESCN AS description FROM CATEGORY";
    private static final String GET_CATEGORY = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID = ?";
    @Override
    public List<Category> getCategoryList(){
        List<Category> categoryList = new ArrayList<Category>();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(GET_CATEGORY_LIST);
            ResultSet resultSet = pStatement.executeQuery();
              while(resultSet.next())
                {
               Category category = new Category();
               category.setCategoryId(resultSet.getString(1));
               category.setName(resultSet.getString(2));
               category.setDescription(resultSet.getString(3));
               categoryList.add(category);
                }
                DBUtil.closeResultSet(resultSet);
                DBUtil.closePreparedStatement(pStatement);
                DBUtil.closeConnection(connection);
                }catch(Exception e){
            e.printStackTrace();
            }
        return categoryList;

    }

    @Override
    public Category getCategory(String categoryId) {
        Category category = null;
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(GET_CATEGORY);
            pStatement.setString(1,categoryId);
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next())
            {
                category = new Category();
                category.setCategoryId(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));

            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);
        }
         catch(Exception e){
            e.printStackTrace();
        }
        return category;
    }
}
