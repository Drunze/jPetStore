package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.SequenceDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SequenceDAOlmpl implements SequenceDAO {
    private static final String getSequenceString = " SELECT name, nextid  FROM SEQUENCE WHERE NAME = ?";

    private static final String updateSequenceString = " UPDATE SEQUENCE SET NEXTID = ? WHERE NAME = ?";


    public Sequence getSequence(Sequence sequence){

        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement pStatement = connection.prepareStatement(getSequenceString);
            pStatement.setString(1,sequence.getName());
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next())
            {
                sequence = new Sequence();
                sequence.setName(resultSet.getString(1));
                sequence.setNextId(resultSet.getInt(2));

            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(connection);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sequence;
    }

    public void updateSequence(Sequence sequence){
        PreparedStatement pStatement = null;
        try{
            Connection conn = DBUtil.getConnection();
            pStatement = conn.prepareStatement(updateSequenceString);
            pStatement.setString(1, sequence.getName());
            pStatement.setInt(2, sequence.getNextId());
            pStatement.executeUpdate();
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);}

        catch(Exception e){
            e.printStackTrace();
        }


    }


    public javax.sound.midi.Sequence getSequence(javax.sound.midi.Sequence sequence) {
        return null;
    }


    public void updateSequence(javax.sound.midi.Sequence sequence) {

    }
}
