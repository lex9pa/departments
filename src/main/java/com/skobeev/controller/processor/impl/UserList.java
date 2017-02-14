package com.skobeev.controller.processor.impl;

import com.skobeev.controller.processor.Processor;
import com.skobeev.exceptions.MyException;
import com.skobeev.model.User;
import com.skobeev.service.UserService;
import com.skobeev.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.skobeev.constants.CommonConstants.*;
import static com.skobeev.constants.ErrorConstants.*;
import static com.skobeev.constants.PathConstants.*;

public class UserList implements Processor {
    private UserService userService = new UserServiceImpl();

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (req.getParameter(ID));
        List<User> users = new ArrayList<User>();
        try {
            if (id == null) {
                users = userService.listUser();
            } else
                users = userService.listDepUser(Long.parseLong(id));
        } catch (MyException e) {
            req.setAttribute(ERROR,e.getError());
            req.getRequestDispatcher(PAGE_ERROR).forward(req,resp);
        }
        req.setAttribute(USER_LIST, users);
        req.getRequestDispatcher(PAGES_USERS_JSP).forward(req, resp);
    }
}