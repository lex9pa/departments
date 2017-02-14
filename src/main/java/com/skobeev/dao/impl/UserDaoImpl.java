package com.skobeev.dao.impl;

import com.skobeev.dao.UserDao;
import com.skobeev.dataBase.DataBaseWorker;
import com.skobeev.exceptions.MyException;
import com.skobeev.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.skobeev.constants.ErrorConstants.*;
import static com.skobeev.constants.QueryConstants.*;

public class UserDaoImpl implements UserDao {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public List<User> listUsers(Long id)throws MyException {

        List<User> users = new ArrayList<User>();
        connection = DataBaseWorker.getConn();
        ResultSet rs;
        try {
            if (id != 0) {
                preparedStatement = connection.prepareStatement(SELECT_USER_DEPARTMENT_ID_QUERY);
                preparedStatement.setLong(1, id);
                rs = preparedStatement.executeQuery();
            } else {
                rs = connection.createStatement().executeQuery(SELECT_ALL_USER_QUERY);
            }
            while (rs.next()) {
                User user1 = new User();
                user1.setId(rs.getLong(1));
                user1.setFirstName(rs.getString(2));
                user1.setLastName(rs.getString(3));
                user1.setMail(rs.getString(4));
                user1.setBirthDay(rs.getDate(5));
                user1.setSalary(rs.getLong(6));
                user1.setDepId(rs.getLong(7));
                users.add(user1);

            }
        } catch (Exception e) {
            throw new MyException(SELECT_USER_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }
        return users;

    }

    public void createUser(User user) throws MyException {

        connection = DataBaseWorker.getConn();

        if (user.getId() == null)
            try {
                preparedStatement = connection.prepareStatement(INSERT_USER_QUERY);
                preparedStatement.setString(1, user.getFirstName());
                preparedStatement.setString(2, user.getLastName());
                preparedStatement.setString(3, user.getMail());
                preparedStatement.setObject(4, user.getBirthDay());
                preparedStatement.setLong(5, user.getSalary());
                preparedStatement.setLong(6, user.getDepId());
                preparedStatement.executeUpdate();
            } catch (Exception e) {
                throw new MyException(CREATE_USER_ERR);
            } finally {
                DataBaseWorker.connClose(connection);
            }

    }



    public void updateUser(User user) throws MyException {

        connection = DataBaseWorker.getConn();
        try {

            preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setDate(4, (Date) user.getBirthDay());
            preparedStatement.setLong(5, user.getSalary());
            preparedStatement.setLong(6, user.getDepId());
            preparedStatement.setLong(7, user.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new MyException(UPDATE_USER_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }
    }

    public User getUserById(Long id) throws MyException {
        connection = DataBaseWorker.getConn();
        User user1 = new User();
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_ID_QUERY);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user1.setId(rs.getLong(1));
                user1.setFirstName(rs.getString(2));
                user1.setLastName(rs.getString(3));
                user1.setMail(rs.getString(4));
                user1.setBirthDay(rs.getDate(5));
                user1.setSalary(rs.getLong(6));
                user1.setDepId(rs.getLong(7));
            }
        } catch (Exception e) {
            throw new MyException(GET_BY_ID_USER_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }
        return user1;
    }

    public User getUserByMail(String mail) throws MyException {
        connection = DataBaseWorker.getConn();
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(SELECT_USER_MAIL_QUERY);
            preparedStatement.setString(1, mail);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}