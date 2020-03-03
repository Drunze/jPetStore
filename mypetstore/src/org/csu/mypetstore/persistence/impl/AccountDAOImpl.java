package org.csu.mypetstore.persistence.impl;
import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import  org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.persistence.ItemDAO;
import org.csu.mypetstore.domain.Product;

import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class AccountDAOImpl implements AccountDAO {
    private static final String getAccountByUsername = " SELECT SIGNON.USERNAME,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String getAccountByUsernameAndPassword ="SELECT SIGNON.USERNAME,ACCOUNT.EMAIL,ACCOUNT.FIRSTNAME,ACCOUNT.LASTNAME,ACCOUNT.STATUS,ACCOUNT.ADDR1 AS address1,ACCOUNT.ADDR2 AS address2,ACCOUNT.CITY,ACCOUNT.STATE,ACCOUNT.ZIP,ACCOUNT.COUNTRY,ACCOUNT.PHONE,PROFILE.LANGPREF AS languagePreference,PROFILE.FAVCATEGORY AS favouriteCategoryId,PROFILE.MYLISTOPT AS listOption,PROFILE.BANNEROPT AS bannerOption,BANNERDATA.BANNERNAME FROM ACCOUNT, PROFILE, SIGNON, BANNERDATA WHERE ACCOUNT.USERID = ? AND SIGNON.PASSWORD = ? AND SIGNON.USERNAME = ACCOUNT.USERID AND PROFILE.USERID = ACCOUNT.USERID AND PROFILE.FAVCATEGORY = BANNERDATA.FAVCATEGORY";
    private static final String insertAccount ="INSERT INTO ACCOUNT (USERID,EMAIL, FIRSTNAME, LASTNAME, STATUS, ADDR1, ADDR2, CITY, STATE, ZIP, COUNTRY, PHONE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String insertProfile ="INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID) VALUES (?, ?, ?)";
    private static final String insertSignon = "INSERT INTO SIGNON (PASSWORD,USERNAME) VALUES (?, ?)";
    private static final String updateAccount = "UPDATE ACCOUNT SET EMAIL = ?,FIRSTNAME = ?,LASTNAME = ?,STATUS = ?,ADDR1 = ?,ADDR2 = ?,CITY = ?,STATE = ?,ZIP = ?,COUNTRY = ?,PHONE = ? WHERE USERID = ?";
    private static final String updateProfile ="INSERT INTO PROFILE (LANGPREF, FAVCATEGORY, USERID)  VALUES (?, ?, ?)" ;
    private static final String updateSignon = "UPDATE SIGNON SET PASSWORD = ?  WHERE USERNAME = ?";


    public Account getAccountByUsername(String username) {
        Account account = null;
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(getAccountByUsername);
            pStatement.setString(1,username);
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next())
            {
                account = new Account();
                account.setUsername(resultSet.getString(1));
                account.setPassword(resultSet.getString(2));
                account.setAddress1(resultSet.getString(3));
                account.setAddress2(resultSet.getString(4));
                account.setCity(resultSet.getString(5));
                account.setState(resultSet.getString(6));
                account.setZip(resultSet.getString(7));
                account.setCountry(resultSet.getString(8));
                account.setPhone(resultSet.getString(9));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return account;}


    public Account getAccountByUsernameAndPassword(Account account)
    {    Account accountId = null;
        try{
            Connection conn = DBUtil.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(getAccountByUsernameAndPassword);
            pStatement.setString(1, account.getUsername());
            pStatement.setString(2, account.getPassword());
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next())
            {
                accountId = new Account();
                accountId.setUsername(resultSet.getString(1));
                accountId.setEmail(resultSet.getString(2));
                accountId.setFirstName(resultSet.getString(3));
                accountId.setLastName(resultSet.getString(4));
                accountId.setStatus(resultSet.getString(5));
                accountId.setAddress1(resultSet.getString(6));
                accountId.setAddress2(resultSet.getString(7));
                accountId.setCity(resultSet.getString(8));
                accountId.setState(resultSet.getString(9));
                accountId.setZip(resultSet.getString(10));
                accountId.setCountry(resultSet.getString(11));
                accountId.setPhone(resultSet.getString(12));
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return accountId;

    }


    public void insertAccount(Account account) {
        PreparedStatement pStatement = null;
        try{
            Connection conn = DBUtil.getConnection();
            pStatement = conn.prepareStatement(insertAccount);
                        pStatement.setString(1, account.getUsername());
                        pStatement.setString(2, account.getEmail());
                        pStatement.setString(3, account.getFirstName());
                        pStatement.setString(4, account.getLastName());
                        pStatement.setString(5, account.getStatus());
                        pStatement.setString(6, account.getAddress1());
                        pStatement.setString(7, account.getAddress2());
                        pStatement.setString(8, account.getCity());
                        pStatement.setString(9, account.getState());
                        pStatement.setString(10, account.getZip());
                        pStatement.setString(11, account.getCountry());
                        pStatement.setString(12, account.getPhone());
                  pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);}
        catch(Exception e){
            e.printStackTrace();
        }

    }

   public void insertProfile(Account account){
       PreparedStatement pStatement = null;
       try{
           Connection conn = DBUtil.getConnection();
           pStatement = conn.prepareStatement(insertProfile);
           pStatement.setString(1, account.getLanguagePreference());
           pStatement.setString(2, account.getFavouriteCategoryId());
           pStatement.setString(3, account.getUsername());

           pStatement.executeUpdate();
           DBUtil.closePreparedStatement(pStatement);
           DBUtil.closeConnection(conn);}

       catch(Exception e){
           e.printStackTrace();
       }

    }


    public void insertSignon(Account account){
        PreparedStatement pStatement = null;
        try{
            Connection conn = DBUtil.getConnection();
            pStatement = conn.prepareStatement(insertSignon);


            pStatement.setString(1, account.getPassword());

            pStatement.setString(2, account.getUsername());

            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);}

        catch(Exception e){
            e.printStackTrace();
        }

    }


    public void updateAccount(Account account) {
        PreparedStatement pStatement = null;
        try{
            Connection conn = DBUtil.getConnection();
            pStatement = conn.prepareStatement(updateAccount);
            pStatement.setString(1, account.getEmail());
            pStatement.setString(2, account.getFirstName());
            pStatement.setString(3, account.getLastName());
            pStatement.setString(4, account.getStatus());
            pStatement.setString(5, account.getAddress1());
            pStatement.setString(6, account.getAddress2());
            pStatement.setString(7, account.getCity());
            pStatement.setString(8, account.getState());
            pStatement.setString(9, account.getZip());
            pStatement.setString(10, account.getCountry());
            pStatement.setString(11, account.getPhone());
            pStatement.setString(12,account.getUsername());
            pStatement.executeUpdate();

            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);}

        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void updateProfile(Account account) {
        PreparedStatement pStatement = null;
        try{
            Connection conn = DBUtil.getConnection();
            pStatement = conn.prepareStatement(updateProfile);



            pStatement.setString(1, account.getLanguagePreference());
            pStatement.setString(2, account.getFavouriteCategoryId());
            pStatement.setString(3, account.getUsername());

            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);}

        catch(Exception e){
            e.printStackTrace();
        }

    }


    public void updateSignon(Account account) {
        PreparedStatement pStatement = null;
        try{
            Connection conn = DBUtil.getConnection();
            pStatement = conn.prepareStatement(updateSignon);
            pStatement.setString(1, account.getPassword());
            pStatement.setString(2, account.getUsername());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);}

        catch(Exception e){
            e.printStackTrace();
        }

    }
}