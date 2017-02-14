package com.skobeev.dao.impl;

import com.skobeev.dao.CommonDeleteDao;
import com.skobeev.dataBase.DataBaseWorker;
import com.skobeev.exceptions.MyException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.skobeev.constants.ErrorConstants.DELETE_ERR;

public class CommonDeleteDaoImpl implements CommonDeleteDao {

    public void delete(String query, Long id) throws MyException {
        Connection connection = DataBaseWorker.getConn();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new MyException(DELETE_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }
    }
}

