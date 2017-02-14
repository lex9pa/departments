package com.skobeev.controller.processor.impl;

import com.skobeev.controller.processor.Processor;
import com.skobeev.exceptions.MyException;
import com.skobeev.service.UserService;
import com.skobeev.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.constants.CommonConstants.ID;
import static com.skobeev.constants.ErrorConstants.ERROR;
import static com.skobeev.constants.ErrorConstants.PAGE_ERROR;
import static com.skobeev.constants.PathConstants.USERS;

public class UserDelete implements Processor {

    private UserService userService = new UserServiceImpl();

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        try {
            userService.deleteUser(Long.parseLong(req.getParameter(ID)));
            resp.sendRedirect(USERS);
        } catch (MyException e) {
            req.setAttribute(ERROR,e.getError());
            req.getRequestDispatcher(PAGE_ERROR).forward(req,resp);
        }
    }
}

