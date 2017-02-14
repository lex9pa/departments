package com.skobeev.service.impl;

import com.skobeev.dao.CommonDeleteDao;
import com.skobeev.dao.UserDao;
import com.skobeev.dao.impl.CommonDeleteDaoImpl;
import com.skobeev.dao.impl.UserDaoImpl;
import com.skobeev.exceptions.MyException;
import com.skobeev.exceptions.ValidationException;
import com.skobeev.model.User;
import com.skobeev.service.UserService;
import com.skobeev.util.ValidateModel;

import java.util.List;
import java.util.Map;

import static com.skobeev.constants.QueryConstants.DELETE_USER_QUERY;

public class UserServiceImpl implements UserService {
    private static final Long ZERO_ID = 0L;
    private UserDao userDaoImpl = new UserDaoImpl();
    private ValidateModel validator = new ValidateModel();
    private CommonDeleteDao commonDeleteDao= new CommonDeleteDaoImpl();

    public List<User> listUser() throws MyException {
        return userDaoImpl.listUsers(ZERO_ID);
    }

    public List<User> listDepUser(Long depId) throws MyException {
        List<User> users;
        users = userDaoImpl.listUsers(depId);
        return users;
    }

    public void saveUser(User user) throws MyException, ValidationException {
        Map<String, List<String>> map = validator.validateModel(user);
        if (map.isEmpty()) {
            if (user.getId() == null) {
                userDaoImpl.createUser(user);
            } else {
                userDaoImpl.updateUser(user);
            }
        } else {
            throw new ValidationException(map);
        }
    }

    public void deleteUser(Long id) throws MyException {
        commonDeleteDao.delete(DELETE_USER_QUERY,id);
    }

    public User getUserById(Long id) throws MyException {

        return userDaoImpl.getUserById(id);
    }
}

