package com.skobeev.util;

import com.skobeev.dao.UserDao;
import com.skobeev.dao.impl.UserDaoImpl;
import com.skobeev.exceptions.MyException;
import com.skobeev.model.User;
import net.sf.oval.constraint.CheckWithCheck;

public class CheckUserMail implements CheckWithCheck.SimpleCheck{
    public boolean isSatisfied(Object validatedObject, Object value) {
        UserDao userDao=new UserDaoImpl();
        User user=null;
        try {
            user=userDao.getUserByMail(value.toString());
        } catch (MyException e) {
            e.printStackTrace();
        }
        return (user != null ? user.getId() : null) == null;
    }
}
