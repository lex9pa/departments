package com.skobeev.dao;

import com.skobeev.exceptions.MyException;
import com.skobeev.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers(Long id) throws MyException;

    void createUser(User user)throws MyException;

    void updateUser(User user)throws MyException;

    User getUserById(Long id)throws MyException;

    User getUserByMail(String mail) throws MyException;
}