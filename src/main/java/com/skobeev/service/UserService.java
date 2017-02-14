package com.skobeev.service;

import com.skobeev.exceptions.MyException;
import com.skobeev.exceptions.ValidationException;
import com.skobeev.model.User;

import java.util.List;

public interface UserService {

    List<User> listUser() throws MyException;

    List<User> listDepUser(Long depId)throws MyException;

    void saveUser(User user) throws MyException, ValidationException;

    void deleteUser(Long id) throws MyException;

    User getUserById(Long id)throws MyException;
}
